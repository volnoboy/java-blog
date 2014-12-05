package com.volnoboy.jb.repository;

import com.volnoboy.jb.entity.Blog;
import com.volnoboy.jb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by volnoboy on 12/4/14.
 */
public interface BlogRepository extends JpaRepository<Blog, Integer> {

	List<Blog> findByUser(User user);
}
