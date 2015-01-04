package com.volnoboy.jb.service;

import com.volnoboy.jb.entity.Blog;
import com.volnoboy.jb.entity.Role;
import com.volnoboy.jb.entity.User;
import com.volnoboy.jb.repository.BlogRepository;
import com.volnoboy.jb.repository.RoleRepository;
import com.volnoboy.jb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by volnoboy on 12/4/14.
 */
@Transactional
@Service
public class InitDbService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BlogRepository blogRepository;

    @PostConstruct
        public void init() {
        if(roleRepository.findByName("ROLE_ADMIN") == null) {
            Role roleUser = new Role();
            roleUser.setName("ROLE_USER");
            roleRepository.save(roleUser);


            Role roleAdmin = new Role();
            roleAdmin.setName("ROLE_ADMIN");
            roleRepository.save(roleAdmin);

            User userAdmin = new User();
            userAdmin.setEnabled(true);
            userAdmin.setName("admin");
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            userAdmin.setPassword(encoder.encode("admin"));
            List<Role> roles = new ArrayList<Role>();
            roles.add(roleAdmin);
            roles.add(roleUser);
            userAdmin.setRoles(roles);
            userRepository.save(userAdmin);

            Blog blogJavaVids = new Blog();
            blogJavaVids.setName("TechCrunch");
            blogJavaVids.setUrl("http://feeds.feedburner.com/TechCrunch/");
//          blogJavaVids.setUrl("file:///home/volnoboy/Desktop/tomcat.xml");
            blogJavaVids.setUser(userAdmin);
            blogRepository.save(blogJavaVids);

        }
    }
}
