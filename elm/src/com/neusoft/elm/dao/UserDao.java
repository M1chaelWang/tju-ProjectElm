package com.neusoft.elm.dao;

import com.neusoft.elm.po.User;

public interface UserDao {

	public User getUserByIdByPass(String userId, String password) throws Exception;

	// 查询手机号码是否已注册，只查询有没有
	public int getUserById(String userId) throws Exception;

	// 添加用户信息
	public int saveUser(User user) throws Exception;
}
