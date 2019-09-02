package com.ihome.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.ihome.entity.Facility;
import com.ihome.entity.User;
import com.ihome.service.FacilityService;
import com.ihome.service.UserService;
import com.ihome.service.impl.FacilityServiceImpl;
import com.ihome.service.impl.UserServiceImpl;

/**
 * Servlet implementation class GetHouseMessage
 */
@WebServlet("/getfacilitymsg")
public class GetFacilityMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetFacilityMessage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String idStr = request.getParameter("id");
		FacilityService facilityservice=new FacilityServiceImpl();
		List<Facility> list=facilityservice.findFacility(Integer.parseInt(idStr));
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(JSONObject.toJSONString(list));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
