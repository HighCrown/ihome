package com.ihome.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.aliyuncs.http.HttpResponse;
import com.ihome.alipay.config.AlipayConfig;


@WebServlet("/buy")
public class AlipayServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
		
		//设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		//同步跳转，跳转到order页面
		alipayRequest.setReturnUrl(AlipayConfig.return_url);
		//异步跳转
		alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
		//获取订单状态
		String status = request.getParameter("status");
		request.getSession().setAttribute("statu", status);
		//商户订单号，商户网站订单系统中唯一订单号，必填
		Date date = new Date();
		long time = date.getTime();
		String timesString = time+"";
		String Mills = timesString.substring(timesString.length()-2);
		String out_trade_no = date.getYear()+(date.getMonth()+1)+date.getDay()+date.getHours()+date.getMinutes()+date.getSeconds()+Mills;
		//付款金额，必填
		String total_amount = new String(request.getParameter("amount").getBytes("ISO-8859-1"),"UTF-8");
//				
		//订单名称，必填
		String subject = ("爱家租房：")+new String(request.getParameter("id").getBytes("ISO-8859-1"),"UTF-8");
//				
		//商品描述，可空
		String body = "爱家租房nbsp;nbsp;nbsp;享受家的温馨";
//				
		
		alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
				+ "\"total_amount\":\""+ total_amount +"\"," 
				+ "\"subject\":\""+ subject +"\"," 
				+ "\"body\":\""+ body +"\"," 
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
		
		//若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
		//alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
		//		+ "\"total_amount\":\""+ total_amount +"\"," 
		//		+ "\"subject\":\""+ subject +"\"," 
		//		+ "\"body\":\""+ body +"\"," 
		//		+ "\"timeout_express\":\"10m\"," 
		//		+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
		//请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节
		
		//请求
		String result="";
		try {
			result = alipayClient.pageExecute(alipayRequest).getBody();
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("text/html;charset="+"utf-8");
		//输出
		response.getWriter().write(result);
		response.getWriter().flush();
		response.getWriter().close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
