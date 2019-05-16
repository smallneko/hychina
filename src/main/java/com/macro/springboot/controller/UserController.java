package com.macro.springboot.controller;

import com.macro.springboot.entity.User;
import com.macro.springboot.pojo.R;
import com.macro.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/*")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "findAllUser",method = RequestMethod.GET)
	public R findAllUser(){
		try {
			return R.isOk().data(userService.findAllUsers());
		}catch (Exception e){
			return R.isFail(e);
		}
	}

	@RequestMapping(value = "findUserByUuid/{uuid}",method = RequestMethod.GET)
	public R findUserByUuid(@PathVariable("uuid") String uuid){
		try {
			return R.isOk().data(userService.findUserByUuid(uuid));
		}catch (Exception e){
			return R.isFail(e);
		}
	}

}
