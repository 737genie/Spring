package com.example.demo.comment;

import com.example.demo.Post;
import com.example.demo.User.SiteUser;

public interface CommentService {
	public void create(Post post, String content, SiteUser author);
	Comment getComment(Long id);
	public void modify(Comment cmt, String content);
	public void delete(Comment cmt);
}
