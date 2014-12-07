package com.volnoboy.jb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by volnoboy on 12/7/14.
 */
@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
