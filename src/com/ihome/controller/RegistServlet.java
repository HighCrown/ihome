package com.ihome.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.ihome.entity.User;
import com.ihome.service.UserService;
import com.ihome.service.impl.UserServiceImpl;



@WebServlet("/regist")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		request.setCharacterEncoding("utf-8");
		try {
			BeanUtils.populate(user, request.getParameterMap());
			System.out.println(user.getMobile());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		UserService service = new UserServiceImpl();
		String comfirmcode = request.getParameter("comfirmMobile"); 
		System.out.println(comfirmcode);
		String code = (String) request.getSession().getAttribute("code");
		System.out.println(code);
		if (comfirmcode.equals(code)) {
			service.add(user);
			response.sendRedirect("/ihome/login.jsp");
		}else {
			response.sendRedirect("/ihome/regist.html");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
