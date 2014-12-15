package com.volnoboy.jb.controller;

import com.volnoboy.jb.entity.Blog;
import com.volnoboy.jb.entity.User;
import com.volnoboy.jb.service.BlogService;
import com.volnoboy.jb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.Principal;

/**
 * Created by volnoboy on 12/4/14.
 */
@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private BlogService blogService;

	@ModelAttribute("blog")
	public Blog constructBlog() {
		return new Blog();
	}

	@RequestMapping("/account")
	public String account(Model model, Principal principal) {
		String userName = principal.getName();
		model.addAttribute("user", userService.findOneWithBlogs(userName));
		return "account";
	}

	@RequestMapping(value = "/account", method = RequestMethod.POST)
	public String doAddBlog(Model model, @Valid @ModelAttribute("blog")Blog blog, BindingResult result, Principal principal) {
		if(result.hasErrors()) {
			return account(model, principal);
		}
		String name = principal.getName();
		blogService.save(blog, name);
		return "redirect:/account.html";
	}

	@RequestMapping("/blog/remove/{id}")
	public String removeBlog(@PathVariable int id) {
		Blog blog = blogService.findOne(id);
		blogService.delete(blog);
		return "redirect:/account.html";
	}
}
