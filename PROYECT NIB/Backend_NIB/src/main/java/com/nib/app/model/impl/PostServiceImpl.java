package com.nib.app.model.impl;

import java.sql.SQLException;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nib.app.model.dao.usuario.PostDAO;
import com.nib.app.model.entity.Post;
import com.nib.app.model.entity.Tag;
import com.nib.app.model.entity.user.Usuario;
import com.nib.app.model.service.PostService;
import com.nib.app.model.service.TagService;
import com.nib.app.model.service.UsuarioService;
import com.nib.app.objects.BinaryFile;
import com.nib.app.objects.Image;
import com.nib.app.utils.sqLite.SLUtils;

/*
 * Implementacion de Post Service
 */
@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDAO post_dao;
	
	@Autowired
	private UsuarioService usuario_service;
	
	@Autowired
	private TagService tag_service;
	
	/*
	 * Pre:
	 * Post: Metodo para obtener la cantidad de post existentes
	 */
	@Override
	public long getPostCount() {
		return post_dao.count();
	}

	/*
	 * Pre:
	 * Post: Metodo el cual obtene las paginas de los posts
	 */
	@Override
	public Page<Post> getPaginasPosts(Pageable pageable) {
		return post_dao.findAll(pageable);
	}

	/*
	 * Pre:
	 * Post: Metodo el cual almacena un Post el las bases de datos
	 */
	@Override
	public boolean savePost(Image image) {
		String[] base64_str = image.getBase64Img().split("base64,");
		if(base64_str.length == 2) {
			//System.out.println(image.getToken());
			try {
				byte[] imageBytes = Base64.getDecoder().decode(base64_str[1]);
				Usuario u = usuario_service.findUsernameByToken(image.getToken());
				if(u != null) {
					Post p = new Post();
					p.setUsuario(u);
					p.setExtension(base64_str[0].replaceAll("data", "").replaceAll(":", "").replaceAll(";", ""));
					p.setImg_name(image.getTitle());
					p.setDate(new Date());
					p.setTaglist(new HashSet<Tag>());
					Post ps = savePostDatBBDD(p);
					if(ps != null) {
						String[] tags = image.getTags().split(",");
						for(String tag : tags) {
							tag = tag.replaceAll(" ", "").replaceAll(";", "").toLowerCase();
							Tag tg = tag_service.findByName(tag);
							if(tg != null) {
								ps.getTaglist().add(tg);
							}else {
								if(tag != "") {	// Evitamos crear un tag sin nada
									Tag ntag = new Tag();
									ntag.setName(tag);
									Tag stag = tag_service.saveTag(ntag);
									if(stag != null) {//entra en stag != null
										ps.getTaglist().add(stag);
									}
								}
							}
						}
						Post ps2 = savePostDatBBDD(ps);
						// codigo almacenar en la localBBDD
						//System.out.println(ps2.getId_post());
						if(ps2 != null) {
							savePostLocalBBDD(imageBytes,ps2.getId_post(),u.getUsername());
						}
						return true;
					}
				}else {
					System.err.println("[ERROR] [si831] - user null");
				}
			}catch(Exception e) {
				System.err.println("[ERROR] [si001] - Error al decodificar la base de una imagen \n" + e.toString());
			}
		//System.out.println("Base ok");
		
		}
		return false;
	}
	
	/*
	 * Pre:
	 * Post: Metodo para almacenar los binarios en la bbdd local
	 */
	private boolean savePostLocalBBDD(byte[] imageBytes,Long id_img,String username) {
		SLUtils s = new SLUtils();
		s.getConnection(username);
		try {
			s.savePost(imageBytes, id_img);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	/*
	 * Pre:
	 * Post: Metodo para almacenar los datos de los posts en la base de datos
	 */
	@Override
	public Post savePostDatBBDD(Post post) {
		try {
			return post_dao.save(post);
		}catch(Exception e) {
			return null;
		}
		
	}

	/*
	 * Pre:
	 * Post: Metodo para Obtener los binarios por el id del post
	 */
	@Override
	public BinaryFile getImageById_Post(Long id) {
		Optional<Post> p = post_dao.findById(id);
		if(!p.isEmpty()) {
			BinaryFile f = new BinaryFile();
			
			Post post = p.get();
			f.setFormat(post.getExtension());
			
			SLUtils u = new SLUtils();
			u.getConnection(post.getUsuario().getUsername());
			byte[] b = u.getPostByIdPost(id);
			f.setData(b);
			
			return f;
		}else {
			return null;
		}
	}

	/*
	 * Pre:
	 * Post: Metodo para obtener los posts filtrados por los tags
	 */
	@Override
	public Page<Post> getPaginasToPostsByTag(Pageable pageable, String tag) {
		List<Post> posts = post_dao.findPostsByTag(tag);
		int start = (int) pageable.getOffset();
		if (start >= posts.size()) {	// Evitamos bug de datos inexistentes
		    return new PageImpl<>(Collections.emptyList(), pageable, 0);
		}
		int end = Math.min((start + pageable.getPageSize()), posts.size());
		Page<Post> pages = new PageImpl<>(posts.subList(start, end), pageable, posts.size());
		return pages;
	}

	/*
	 * Pre:
	 * Post: Metodo para Obtener la info de un post post su id
	 */
	@Override
	public Post getPostById(Long id) {
		Optional<Post> p = post_dao.findById(id);
		if(p.isPresent()) {
			return p.get();
		}else {
			return null;
		}
	}
}
