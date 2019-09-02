package com.ihome.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.ihome.entity.JsonGroup;
import com.ihome.service.HouseService;
import com.ihome.service.impl.HouseServiceImpl;


@WebServlet("/findHouseMsg")
public class FindHouseMsgServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         request.setCharacterEncoding("utf-8");
         response.setCharacterEncoding("utf-8");
         response.setContentType("text/html;charset=utf-8");
         String currPageStr = request.getParameter("currPage");
         String pageSizeStr = request.getParameter("pageSize");
         String aidStr = request.getParameter("aid");
//         String aname = request.getParameter("aname");
         String sd = request.getParameter("sd");
         String ed = request.getParameter("ed");
         String findFlagStr = request.getParameter("findFlag");
         int currPage = Integer.parseInt(currPageStr);
         int pageSize = Integer.parseInt(pageSizeStr);
         int findFlag = Integer.parseInt(findFlagStr);
         int start =(currPage-1)*pageSize;
         HouseService service=new HouseServiceImpl();
         JsonGroup jsonGroup=null;
         try {
        	 int aid = Integer.parseInt(aidStr);
        	 jsonGroup=service.findHouseMsg(start,pageSize,aid,sd,ed,findFlag);
        	 response.getWriter().write(JSONObject.toJSONString(jsonGroup));
			
		} catch (Exception e) {
			jsonGroup=service.findHouseMsg(start,pageSize,sd,ed,findFlag);
			response.getWriter().write(JSONObject.toJSONString(jsonGroup));
		}
      
         
         
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
