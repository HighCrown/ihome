package com.ihome.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.ihome.entity.Area;
import com.ihome.entity.House;
import com.ihome.entity.User;
import com.ihome.service.AddHouseService;
import com.ihome.service.impl.AddHouseServiceImpl;

import sun.security.util.Length;

/*
 * 发布房源信息
 */
@WebServlet("/AddNewHouseServlet")
public class AddNewHouseServlet extends HttpServlet {

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

		// 假装自己有用户
		User exitxUser = (User) request.getSession().getAttribute("existUser");

		// 拿到提交的所有信息
		House house = new House();
		Area area = new Area();

		try {
			BeanUtils.populate(house, request.getParameterMap());

			String areaName = request.getParameter("areaName");
			AddHouseService houseService = new AddHouseServiceImpl();
			area.setName(areaName);

			Integer areaId = houseService.findAreaIdByName(area);
			house.setAreaId(areaId);
			// 添加房源
			houseService.addHouseByUserId(exitxUser, house);
			System.out.println(house.getId());
			
			//获取到刚刚添加房源的ID
			List<House> housesList = houseService.findHouseIdByUserId(exitxUser);
			int size = housesList.size();
			House realHouse = housesList.get(size-1);
			System.out.println(realHouse.getId());

			// 拿到房源里勾选的设施的数组
			Map<String, String[]> map = request.getParameterMap();
			String[] facilityStr = map.get("facility");
			
			// 每个房子都可能有多个设施
			houseService.addFacility(realHouse, facilityStr);

			response.sendRedirect("my.jsp");
		} catch (Exception e) {
			response.sendRedirect("my.jsp");
			System.out.println("添加失败");
			e.printStackTrace();
		}

	}

}
