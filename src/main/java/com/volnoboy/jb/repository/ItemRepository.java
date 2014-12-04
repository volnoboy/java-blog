package com.volnoboy.jb.repository;

import com.volnoboy.jb.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by volnoboy on 12/4/14.
 */
public interface ItemRepository extends JpaRepository<Item, Integer> {
}
