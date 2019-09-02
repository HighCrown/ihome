package com.ihome.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.ihome.entity.House;
import com.ihome.service.HouseService;
import com.ihome.service.impl.HouseServiceImpl;

/**
 * Servlet implementation class GetHouseMessage
 */
@WebServlet("/gethousemsg")
public class GetHouseMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetHouseMessage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String idStr = request.getParameter("id");
		HouseService houseservice=new HouseServiceImpl();
		House existHouse=houseservice.findHouse(Integer.parseInt(idStr));
		request.getSession().setAttribute("existHouse", existHouse);
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(JSONObject.toJSONString(existHouse));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
