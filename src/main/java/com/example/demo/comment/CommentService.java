package com.example.demo.comment;

import com.example.demo.Post;
import com.example.demo.User.SiteUser;

public interface CommentService {
	public void create(Post post, String content, SiteUser author);
		
}
