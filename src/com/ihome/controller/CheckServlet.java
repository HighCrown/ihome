package com.ihome.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import org.apache.commons.beanutils.BeanUtils;

import com.ihome.entity.User;
import com.ihome.service.UserService;
import com.ihome.service.impl.UserServiceImpl;

import sun.java2d.pipe.RenderQueue;


@WebServlet("/check")
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String checkcode  = request.getParameter("checkcode");
		String code = (String) request.getSession().getAttribute("checkcode_session");
		if (!(code.equalsIgnoreCase(checkcode))) {
			request.getSession().setAttribute("msg", "验证码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		
		UserService service = new UserServiceImpl();
		User existUser = service.login(user);
//		通过existUser判断是否数据库中数据
		if (existUser==null) {
			request.getSession().setAttribute("msg", "用户名或者密码错误");
			response.sendRedirect("/ihome/login.jsp");
		}else {
			System.out.println(existUser.getName());
			request.getSession().setAttribute("existUser", existUser);
			response.setContentType("text/html; charset=utf-8");
			response.setCharacterEncoding("utf-8");
			response.sendRedirect("/ihome/index.html");
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
