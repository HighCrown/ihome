package com.ihome.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.ihome.entity.User;

/*
 *AJAX 先判断是否已经实名认证
 */
@WebServlet("/UserSwitchAuthServlet")
public class UserSwitchAuthServlet extends HttpServlet {
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
////		user.setRealName("");
////		user.setIdCard("");

//		// 拿登陆的用户
//		request.getSession().setAttribute("switchUser", user);
		
		// 去拿登陆认证后的用户
		User checkUser = (User) request.getSession().getAttribute("checkUser");
		if (checkUser == null || checkUser.getRealName() == null || checkUser.getIdCard() == null) {
			// 认证之前
			User existUser = (User) request.getSession().getAttribute("existUser");
			String json = JSONObject.toJSONString(existUser);
			System.out.println(existUser.getRealName()+"RealName");
			System.out.println(existUser.getIdCard()+"IdCard");
			System.out.println("为空没认证");
			response.getWriter().write(json);
		} else {
			// 认证之后
			System.out.println("不为空认证了");
			String json = JSONObject.toJSONString(checkUser);
			response.getWriter().write(json);
		}

	}

}
