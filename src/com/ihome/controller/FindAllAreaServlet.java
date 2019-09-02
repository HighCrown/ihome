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
import com.ihome.service.AddHouseService;
import com.ihome.service.impl.AddHouseServiceImpl;

/*
 * 查询所有城区然后用AJAX传到下拉框中
 */
@WebServlet("/FindAllAreaServlet")
public class FindAllAreaServlet extends HttpServlet {
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
		
		AddHouseService houseService = new AddHouseServiceImpl();
		try {
			List<Area> areaList = houseService.findAreaByUserId();
			String json = JSONObject.toJSONString(areaList);
			response.getWriter().write(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
