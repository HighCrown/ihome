package com.ihome.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.ihome.entity.House;
import com.ihome.service.FacilityService;
import com.ihome.service.HouseService;
import com.ihome.service.impl.FacilityServiceImpl;
import com.ihome.service.impl.HouseServiceImpl;

@WebServlet("/updateHouse")
public class UpdateHouseServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		House house = new House();
		Map<String, String[]> map = request.getParameterMap();
		HouseService service = new HouseServiceImpl();
		FacilityService facilityService = new FacilityServiceImpl();
		try {
			BeanUtils.populate(house, map);
			service.updateHouse(house);
			String[] facilitys = map.get("facility");
			facilityService.updateFacilitys(facilitys,house.getId());
			response.sendRedirect("/ihome/myhouse.html");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
