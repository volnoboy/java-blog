package com.volnoboy.jb.controller;

import com.volnoboy.jb.entity.User;
import com.volnoboy.jb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String doRegister(@Valid @ModelAttribute("user")User user, BindingResult result, RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			return"user-register";
		}
		userService.save(user);
		redirectAttributes.addFlashAttribute("success", true);
		return "redirect:/register.html";
	}

	@RequestMapping("/available")
	@ResponseBody
	public String available(@RequestParam String username) {
		Boolean available = userService.findOne(username) == null;
		return available.toString();
	}

}
