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


@WebServlet("/findAreas")
public class FindAreasServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 AreaService service=  new AreaServiceImpl();
	 List<Area> list=service.findAreas();
	 response.setCharacterEncoding("utf-8");
	 response.setContentType("text/html;charset=utf-8");
	 response.getWriter().write(JSONObject.toJSONString(list));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
