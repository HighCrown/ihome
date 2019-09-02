package com.ihome.dao;

import com.ihome.entity.User;

public interface UserDao {

	void add(User user);

	User login(User user);
	
	User findUser(int id);
	
	void setAuthByUserId(User checkUser, String realName, String idCard) throws Exception;

	void setUsername(User checkUser, String newUsername) throws Exception;

	void setUserImg(User user, String fName) throws Exception;

	

}
