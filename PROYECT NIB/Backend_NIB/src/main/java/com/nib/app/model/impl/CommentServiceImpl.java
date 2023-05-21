package com.nib.app.model.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nib.app.model.dao.usuario.CommentDAO;
import com.nib.app.model.entity.Comment;
import com.nib.app.model.entity.Post;
import com.nib.app.model.entity.user.Usuario;
import com.nib.app.model.service.CommentService;
import com.nib.app.model.service.PostService;
import com.nib.app.model.service.UsuarioService;
import com.nib.app.objects.FComment;

/*
 * Implementacion del servicio de comentarios
 */
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDAO commentDAO;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	/*
	 * Pre:
	 * Post: Metodo para almacenar un comentario
	 */
	@Override
	public boolean saveComment(FComment comment) {
		Comment c = new Comment();
		c.setMessage(comment.getMessage());
		c.setDate(new Date());
		Usuario u = usuarioService.findUsernameByToken(comment.getToken_usuario());
		Post p = postService.getPostById(comment.getId_post());
		c.setPost(p);
		c.setUsuario(u);
		if(u == null || p == null) {
			return false;
		}
		try {
			commentDAO.save(c);
		}catch (Exception e) {
			System.out.println("[ERROR] - Error al guardar el comentario.");
			return false;
		}
		
		return true;
	}

	/*
	 * Pre:
	 * Post: Metodo el cual devuelve una lista de comentarios por su post
	 */
	@Override
	public List<FComment> getCommentsByPostId(Long postId) {
		List<Comment> c = commentDAO.findCommentsByIdPost(postId);
		List<FComment> fc = new ArrayList<FComment>();
		
		for (Comment comment : c) {
			fc.add(new FComment(
					comment.getId_comment(),
					"", 
					comment.getPost().getId_post(), 
					comment.getUsuario().getNombre(), 
					comment.getUsuario().getImgProfile(),
					comment.getMessage(), 
					comment.getDate()));
		}
		return fc;
	}
}
