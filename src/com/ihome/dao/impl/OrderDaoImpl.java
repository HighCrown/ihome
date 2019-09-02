package com.ihome.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ihome.dao.OrderDao;
import com.ihome.entity.Order;
import com.ihome.entity.OrderPageGroup;
import com.ihome.entity.OrderUserId;
import com.ihome.entity.User;
import com.ihome.entity.UserAndHouseAndOrder;
import com.ihome.util.DBUtil;

public class OrderDaoImpl implements OrderDao {

	@Override
	public void submitOrder(Order order) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(DBUtil.getDataSource());
		jdbcTemplate.update("insert into ih_order_info values (null,?,?,?,?,?,?,?,?,?,null,?)", order.getUserId(),
				order.getSellerId(), order.getHouseId(), order.getBeginDate(), order.getEndDate(), order.getDays(),
				order.getHousePrice(), order.getAmount(), order.getStatus(), new Date());
	}

	@Override
	public OrderPageGroup findAll(int userId,int currPage,int pageSize) {
		int start=(currPage-1)*pageSize;
		JdbcTemplate template = new JdbcTemplate(DBUtil.getDataSource());
		List<Order> list = template.query("SELECT *\r\n" + 
				"FROM ih_house_info,ih_order_info\r\n" + 
				"WHERE ih_order_info.house_id = ih_house_info.id  AND ih_order_info.user_id=? limit ?,?", new BeanPropertyRowMapper<Order>(Order.class),userId,start,pageSize);
		Long count = template.queryForObject("SELECT COUNT(*)\r\n" + 
				"FROM ih_house_info,ih_order_info\r\n" + 
				"WHERE ih_order_info.house_id = ih_house_info.id and ih_order_info.user_id=? ", long.class,userId);
		return new OrderPageGroup(list, count);
	}

	@Override
	public void updateOrderStatus(int orderId) {
		JdbcTemplate template = new JdbcTemplate(DBUtil.getDataSource());
		template.update("update ih_order_info set status='COMPLETE' where id=?",orderId);
	}
	@Override
	public List<UserAndHouseAndOrder> findAllOrder(User user) throws Exception {
		JdbcTemplate template = new JdbcTemplate(DBUtil.getDataSource());
		List<UserAndHouseAndOrder> list = template.query(
				"SELECT o.id,o.user_id,o.house_id,o.seller_id,h.title,h.index_image_url,o.begin_date,o.end_date,o.house_price,o.amount,o.status,o.comment,h.create_time FROM ih_user_profile u,ih_house_info h,ih_order_info o WHERE u.id=o.user_id AND h.id=o.house_id AND o.seller_id=?",
				new BeanPropertyRowMapper<UserAndHouseAndOrder>(UserAndHouseAndOrder.class), user.getId());
		return list;
	}

	@Override
	public void updateWaitPayentById(int id) throws Exception {
		JdbcTemplate template = new JdbcTemplate(DBUtil.getDataSource());
		template.update("update ih_order_info set status = ? where id= ?","WAIT_PAYMENT",id);
	}

	@Override
	public void updateRejectedById(int id, String rejectReason) throws Exception {
		JdbcTemplate template = new JdbcTemplate(DBUtil.getDataSource());
		template.update("update ih_order_info set status = ?,comment=? where id= ?","REJECTED",rejectReason,id);
	}

	
}
