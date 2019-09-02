package com.ihome.service.impl;



import java.util.Date;

import com.ihome.dao.UserDao;
import com.ihome.dao.impl.UserDaoImpl;
import com.ihome.entity.User;
import com.ihome.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao dao = new UserDaoImpl();
	@Override
	public void add(User user)  {
		user.setRealName(null);
		user.setIdCard(null);
		user.setAvatarUrl("/ihome/img/2.jpg");
		user.setCreateTime(new Date());
		dao.add(user);
			   
	}
	@Override
	public User login(User user) {
		return dao.login(user);
	}
	@Override
	public User findUser(int id)  {
		UserDao userdao=new UserDaoImpl();
		return userdao.findUser(id);
	}

	@Override
	public void setAuthByUserId(User checkUser, String realName, String idCard) throws Exception {
		dao.setAuthByUserId(checkUser,realName,idCard);
	}

	@Override
	public void setUsername(User checkUser, String newUsername) throws Exception {
		dao.setUsername(checkUser,newUsername);
	}

	@Override
	public void setUserImg(User user, String fName) throws Exception {
		dao.setUserImg(user,fName);
	}

}
