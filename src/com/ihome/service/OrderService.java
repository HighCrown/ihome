package com.ihome.service;

import java.util.List;

import com.ihome.entity.Order;
import com.ihome.entity.OrderPageGroup;
import com.ihome.entity.OrderUserId;
import com.ihome.entity.User;
import com.ihome.entity.UserAndHouseAndOrder;

public interface OrderService {

	void submitOrder(Order order);
	OrderPageGroup findAll(int userId, int currPage, int pageSize)throws Exception;

	void updateOrderStatus(int orderId);

	List<UserAndHouseAndOrder> findAllOrder(User user) throws Exception;

	void updateWaitPayentById(int id) throws Exception;

	void updateRejectedById(int id, String rejectReason) throws Exception;
	
}
