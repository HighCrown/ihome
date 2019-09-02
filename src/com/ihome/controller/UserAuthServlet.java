package com.ihome.controller;
/*
 * 实名认证
 */

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ihome.entity.User;
import com.ihome.service.UserService;
import com.ihome.service.impl.UserServiceImpl;

@WebServlet("/UserAuthServlet")
public class UserAuthServlet extends HttpServlet {

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

		// 判断是否有用户登陆
		User checkUser = (User) request.getSession().getAttribute("existUser");
		UserService userservice = new UserServiceImpl();
		try {
			String realName = request.getParameter("realName");
			String idCard = request.getParameter("idCard");
			userservice.setAuthByUserId(checkUser, realName, idCard);
			checkUser.setRealName(realName);
			checkUser.setIdCard(idCard);
			System.out.println(checkUser.getIdCard()+" "+checkUser.getRealName());
			request.getSession().setAttribute("checkUser", checkUser);
			request.getRequestDispatcher("auth.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
