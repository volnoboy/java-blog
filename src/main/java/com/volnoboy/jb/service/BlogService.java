package com.volnoboy.jb.service;

import com.volnoboy.jb.entity.Blog;
import com.volnoboy.jb.entity.User;
import com.volnoboy.jb.repository.BlogRepository;
import com.volnoboy.jb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by volnoboy on 12/9/14.
 */
@Service
public class BlogService {

	@Autowired
	private BlogRepository blogRepository;

	@Autowired
	private UserRepository userRepository;

	public void save(Blog blog, String name) {
		User user = userRepository.findByName(name);
		blog.setUser(user);
		blogRepository.save(blog);
	}

}
