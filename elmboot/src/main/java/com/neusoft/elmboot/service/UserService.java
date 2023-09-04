package com.neusoft.elmboot.service;

import com.neusoft.elmboot.po.User;

public interface UserService {
	public User getUserByIdByPass(User user);
	
	public int saveUser(User user);
	
	public int getUserById(String userId);

	public void updateTotalPoints(String userId, Integer totalPoints);

	public int getTotalPoints(String userId);
}
