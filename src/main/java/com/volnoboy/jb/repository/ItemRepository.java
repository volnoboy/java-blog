package com.volnoboy.jb.repository;

import com.volnoboy.jb.entity.Blog;
import com.volnoboy.jb.entity.Item;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by volnoboy on 12/4/14.
 */
public interface ItemRepository extends JpaRepository<Item, Integer> {
	List<Item> findByBlog(Blog blog, Pageable pageable);

	Item findByBlogAndLink(Blog blog, String link);
}
