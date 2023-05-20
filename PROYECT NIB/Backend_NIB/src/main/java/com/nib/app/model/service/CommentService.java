package com.nib.app.model.service;

import java.util.List;

import com.nib.app.model.entity.Comment;
import com.nib.app.objects.FComment;

public interface CommentService {

	public boolean saveComment(FComment comment);
	public List<FComment> getCommentsByPostId(Long postId);
}
