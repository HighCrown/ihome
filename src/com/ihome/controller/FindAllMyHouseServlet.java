package com.ihome.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.ihome.entity.House;
import com.ihome.entity.PageGroup;
import com.ihome.entity.User;
import com.ihome.service.HouseService;
import com.ihome.service.impl.HouseServiceImpl;

/**
 * Servlet implementation class FindAllMyHouse
 */
@WebServlet("/findAllMyHouse")
public class FindAllMyHouseServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("existUser");
		HouseService service = new HouseServiceImpl();
		int currPage = Integer.parseInt(request.getParameter("currPage"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		try {
			PageGroup group = service.findAllMyHouse(user,currPage,pageSize);
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(JSONObject.toJSONString(group));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
