package com.ihome.service.impl;

import java.util.List;

import com.ihome.dao.OrderDao;
import com.ihome.dao.impl.OrderDaoImpl;
import com.ihome.entity.Order;
import com.ihome.entity.OrderPageGroup;
import com.ihome.entity.OrderUserId;
import com.ihome.entity.User;
import com.ihome.entity.UserAndHouseAndOrder;
import com.ihome.service.OrderService;

public class OrderServiceImpl implements OrderService {
	private OrderDao dao = new OrderDaoImpl();
	@Override
	public void submitOrder(Order order) {
		OrderDao orderdao=new OrderDaoImpl();
		orderdao.submitOrder(order);
	}
	
	@Override
	public OrderPageGroup findAll(int userId,int currPage,int pageSize) throws Exception {
		// TODO Auto-generated method stub
		OrderPageGroup group = dao.findAll(userId,currPage,pageSize);
		return dao.findAll(userId, currPage, pageSize);
	}
	@Override
	public void updateOrderStatus(int orderId) {
		// TODO Auto-generated method stub
		dao.updateOrderStatus(orderId);
	}

	
	
	@Override
	public List<UserAndHouseAndOrder> findAllOrder(User user) throws Exception {
		return dao.findAllOrder(user);
	}
	@Override
	public void updateWaitPayentById(int id) throws Exception {
		dao.updateWaitPayentById(id);
		
	}
	@Override
	public void updateRejectedById(int id, String rejectReason) throws Exception {
		dao.updateRejectedById(id,rejectReason);
		
	}

}
