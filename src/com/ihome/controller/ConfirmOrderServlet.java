package com.ihome.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ihome.service.OrderService;
import com.ihome.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class ConfirmOrderServlet
 */
@WebServlet("/confirmOrder")
public class ConfirmOrderServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		OrderService orderService = new OrderServiceImpl();
		try {
			orderService.updateWaitPayentById(id);
			response.sendRedirect("/ihome/lorders.html");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
