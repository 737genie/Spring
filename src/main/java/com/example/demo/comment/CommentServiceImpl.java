package com.example.demo.comment;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.demo.Post;
import com.example.demo.User.SiteUser;

@Service
public class CommentServiceImpl implements CommentService{
	
	private final CommentRepository commentRepository;
	
	public CommentServiceImpl(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}

	@Override
	public void create(Post post, String content, SiteUser author) {
		// TODO Auto-generated method stub
		Comment comment = new Comment();
		comment.setAuthor(author);
		comment.setCreateAt(LocalDateTime.now());
		comment.setPost(post);
		comment.setContent(content);
		this.commentRepository.save(comment);
	}
	
}
