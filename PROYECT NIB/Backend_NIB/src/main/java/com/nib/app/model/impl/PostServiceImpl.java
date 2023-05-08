package com.nib.app.model.impl;

import java.sql.SQLException;
import java.util.Base64;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDAO post_dao;
	
	@Autowired
	private UsuarioService usuario_service;
	
	@Autowired
	private TagService tag_service;
	
	@Override
	public long getPostCount() {
		return post_dao.count();
	}

	@Override
	public Page<Post> getPaginasPosts(Pageable pageable) {
		return post_dao.findAll(pageable);
	}

	@Override
	public boolean savePost(Image image) {
		String[] base64_str = image.getBase64Img().split("base64,");
		if(base64_str.length == 2) {
			System.out.println(image.getToken());
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
							tag = tag.replaceAll(" ", "").replaceAll(";", "");
							System.out.println(tag);
							Tag tg = tag_service.findByName(tag);
							if(tg != null) {
								ps.getTaglist().add(tg);
							}else {
								Tag ntag = new Tag();
								ntag.setName(tag);
								Tag stag = tag_service.saveTag(ntag);
								if(stag != null) {
									System.out.println("entra en stag != null");
									ps.getTaglist().add(stag);
								}
							}
						}
						Post ps2 = savePostDatBBDD(ps);
						// codigo almacenar en la localBBDD
						System.out.println(ps2.getId_post());
						if(ps2 != null) {
							savePostLocalBBDD(imageBytes,ps2.getId_post(),u.getUsername());
						}
						
						
						return true;
					}
				}else {
					System.out.println("user null");
				}
				
				
				
			}catch(Exception e) {
				System.err.println("[ERROR] [si001] - Error al decodificar la base de una imagen \n" + e.toString());
			}
		System.out.println("Base ok");
		
		}
		
		
		return false;
	}
	
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

	@Override
	public Post savePostDatBBDD(Post post) {
		try {
			return post_dao.save(post);
		}catch(Exception e) {
			return null;
		}
		
	}

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
	
	

	
}
