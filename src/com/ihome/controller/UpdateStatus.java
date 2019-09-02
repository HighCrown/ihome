package com.ihome.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ihome.service.OrderService;
import com.ihome.service.impl.OrderServiceImpl;

@WebServlet("/updateStatus")
public class UpdateStatus extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderIdStr = request.getParameter("orderId");
		int orderId = Integer.parseInt(orderIdStr);
		OrderService service = new OrderServiceImpl();
		service.updateOrderStatus(orderId);
		response.sendRedirect("/ihome/order.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
