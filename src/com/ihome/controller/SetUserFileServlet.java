package com.ihome.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.ihome.entity.User;
import com.ihome.service.UserService;
import com.ihome.service.impl.UserServiceImpl;

/*
 * 修改个人用户名
 */
@WebServlet("/setUser")
public class SetUserFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 处理编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type", "text/html;charset=utf-8");

//		// 假装自己有用户
//		User user = new User();
//		user.setId(10001);
//		user.setName("maomao");
//		user.setMobile("18811112222");
//		user.setPasswordHash("1");
//		user.setAvatarUrl("userimg/user1.jpg");
//
//		// 拿登陆的用户
//		request.getSession().setAttribute("existUser", user);
		User checkUser = (User) request.getSession().getAttribute("existUser");
		UserService userservice = new UserServiceImpl();
		String newUsername = request.getParameter("user-name");
		
		//修改头像
		
		
		//修改用户名
		try {
			userservice.setUsername(checkUser, newUsername);
			checkUser.setName(newUsername);
			String json = JSONObject.toJSONString(checkUser);
			response.getWriter().write(json);
		} catch (Exception e) {
			//用户名已存在
			String json = JSONObject.toJSONString(newUsername);
			response.getWriter().write(json);
			e.printStackTrace();
			System.out.println(json);
		}
	}

}
