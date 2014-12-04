package com.volnoboy.jb.repository;

import com.volnoboy.jb.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by volnoboy on 12/4/14.
 */
public interface BlogRepository extends JpaRepository<Blog, Integer> {
}
