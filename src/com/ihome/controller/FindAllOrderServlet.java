package com.ihome.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.ihome.entity.Order;
import com.ihome.entity.User;
import com.ihome.entity.UserAndHouseAndOrder;
import com.ihome.service.OrderService;
import com.ihome.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class FindAllOrderServlet
 */
@WebServlet("/findAllOrder")
public class FindAllOrderServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderService orderService = new OrderServiceImpl();
		User user = (User) request.getSession().getAttribute("existUser");
		try {
			List<UserAndHouseAndOrder> list = orderService.findAllOrder(user);
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(JSONObject.toJSONString(list));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
