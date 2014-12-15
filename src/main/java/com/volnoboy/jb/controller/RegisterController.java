package com.volnoboy.jb.controller;

import com.volnoboy.jb.entity.User;
import com.volnoboy.jb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by volnoboy on 12/15/14.
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private UserService userService;

	@ModelAttribute("user")
	public User constructUser() {
		return new User();
	}

	@RequestMapping()
	public String showRegister() {
		return "user-register";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String doRegister(@Valid @ModelAttribute("user")User user, BindingResult result) {
		if(result.hasErrors()) {
			return"user-register";
		}
		userService.save(user);
		return "redirect:/register.html?success=true";
	}

}
