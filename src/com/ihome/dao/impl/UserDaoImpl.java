package com.ihome.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ihome.dao.UserDao;
import com.ihome.entity.User;
import com.ihome.util.DBUtil;
import com.mysql.jdbc.jdbc2.optional.SuspendableXAConnection;

public class UserDaoImpl implements UserDao {

	@Override
	public void add(User user) {
		System.out.println(user);
		JdbcTemplate jt = new JdbcTemplate(DBUtil.getDataSource());
//		像数据库中插入数据
		jt.update("insert into ih_user_profile values(null,?,?,?,?,?,?,?)",
		user.getName(),user.getMobile(),user.getPasswordHash(),user.getRealName(),user.getIdCard(),user.getAvatarUrl(),user.getCreateTime());

	}

	@Override
	public User login(User user) {
		JdbcTemplate jt = new JdbcTemplate(DBUtil.getDataSource());
		List<User> list = jt.query("select * from ih_user_profile where mobile=? and password_hash=?",
				new BeanPropertyRowMapper<User>(User.class),user.getMobile(),user.getPasswordHash());
		System.out.println(user.getMobile());
		System.out.println(user.getPasswordHash());
		
		try {
			return list.get(0);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}	
		}

	@Override
	public User findUser(int id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(DBUtil.getDataSource());
		List<User> list = jdbcTemplate.query("select * from ih_user_profile where id=?", new BeanPropertyRowMapper<User>(User.class),id);
		return list.get(0);
	}
	public void setAuthByUserId(User checkUser, String realName, String idCard) throws Exception {
		JdbcTemplate jdbc = new JdbcTemplate(DBUtil.getDataSource());
		jdbc.update("update ih_user_profile set real_name = ? , id_card = ? where id = ?", realName, idCard, checkUser.getId());
	}

	@Override
	public void setUsername(User checkUser, String newUsername) throws Exception {
		JdbcTemplate jdbc = new JdbcTemplate(DBUtil.getDataSource());
		jdbc.update("update ih_user_profile set name = ? where id = ?", newUsername, checkUser.getId());
	}

	@Override
	public void setUserImg(User user, String fName) throws Exception {
		JdbcTemplate jdbc = new JdbcTemplate(DBUtil.getDataSource());
		jdbc.update("update ih_user_profile set avatar_url = ? where id = ?", fName, user.getId());
	}

	
}
