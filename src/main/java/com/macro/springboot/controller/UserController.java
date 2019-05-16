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

	@RequestMapping("list")
	public List<User> list(User user) {
		return userService.list(user);
	}

	@RequestMapping("get")
	public User get(User user) {
		return userService.get(user);
	}

	@RequestMapping("update")
	public int update(User user) {
		return userService.update(user);
	}

	@RequestMapping("save")
	public int save(User user) {
		return userService.save(user);
	}

	@RequestMapping("delete")
	public int delete(User user) {
		return userService.delete(user);
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
