package com.ihome.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import com.ihome.entity.User;

/*
 * 实名认证过滤器
 */
@WebFilter("/myhouse.html")
//"/orders.html","/lorders.html",,"newhouse.jsp"
public class UserAuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 处理编码
		System.out.println(111);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		((HttpServletResponse) response).setHeader("content-type", "text/html;charset=utf-8");

		// 假装自己有用户没有实名认证
//		User user = new User();
//		user.setIdCard("1");
//		user.setRealName("1");
//		user.setId(10001);
//		((HttpServletRequest)request).getSession().setAttribute("switchUser", user);
		User exitxUser = (User) ((HttpServletRequest)request).getSession().getAttribute("existUser");
		System.out.println(exitxUser.getRealName());
		System.out.println(exitxUser.getIdCard());
		System.out.println("开始过滤");
		if (exitxUser.getRealName()!=null || exitxUser.getIdCard()!=null) {
			System.out.println("放行给Servlet");
			chain.doFilter(request, response);
			System.out.println("放行后回来");
		} else {
			HttpServletResponse response2 = (HttpServletResponse) response;
			response2.setCharacterEncoding("utf-8");
			response2.setContentType("text/html;charset=utf-8");
			System.out.println("不放行");
			response2.sendRedirect("auth.jsp");
		}
	}


}
