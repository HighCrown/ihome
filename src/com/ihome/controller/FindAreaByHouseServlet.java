package com.ihome.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.ihome.entity.Area;
import com.ihome.service.AreaService;
import com.ihome.service.impl.AreaServiceImpl;

@WebServlet("/findAreaByHouseId")
public class FindAreaByHouseServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AreaService areaService = new AreaServiceImpl();
		try {
			List<Area> list = areaService.findAllArea();
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(JSONObject.toJSONString(list));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
