package com.ihome.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.ihome.entity.OrderPageGroup;
import com.ihome.service.OrderService;
import com.ihome.service.impl.OrderServiceImpl;

@WebServlet("/findAll")
public class FindAllServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.设置编码格式
		request.setCharacterEncoding("utf-8");
		//2.获取数据
		String userIdStr = request.getParameter("userId");			//需要改
		String currPageStr = request.getParameter("currPage");
		String pageSizeStr = request.getParameter("pageSize");
		int userId = Integer.parseInt(userIdStr);					//需要改
		int currPage = Integer.parseInt(currPageStr);
		int pageSize = Integer.parseInt(pageSizeStr);
		OrderService service = new OrderServiceImpl();
		OrderPageGroup orderPageGroup = null;
		try {
			orderPageGroup = service.findAll(userId,currPage,pageSize);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(JSONObject.toJSONString(orderPageGroup));
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
