package com.macro.springboot.controller;

import com.macro.springboot.entity.User;
import com.macro.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class SingleViewController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login(){
		return "login";
	}

	// Index页面返回方式
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model){
		List<User> userList = userService.findAllUsers();

		model.addAttribute(userList);
		return "index";
	}

}
