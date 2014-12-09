package com.volnoboy.jb.repository;

import com.volnoboy.jb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by volnoboy on 12/4/14.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByName(String userName);
}
