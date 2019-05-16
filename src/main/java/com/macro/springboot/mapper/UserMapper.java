package com.macro.springboot.mapper;

import com.macro.springboot.entity.User;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 继承通用Mapper获取CURD方法
 */
public interface UserMapper extends Mapper<User> {
	@Select("select * from [User] where uuid = #{uuid}")
	User findUserByUuid(String uuid);

	@Select("select * from [User] where 1=1")
	List<User> findAllUsers();
}
