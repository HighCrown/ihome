package com.ihome.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ihome.dao.HouseDao;
import com.ihome.entity.House;
import com.ihome.entity.JsonGroup;
import com.ihome.entity.PageGroup;
import com.ihome.entity.User;
import com.ihome.util.DBUtil;


public class HouseDaoImpl implements HouseDao {

	@Override
	public House findHouse(int id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(DBUtil.getDataSource());
		List<House> list = jdbcTemplate.query("select * from ih_house_info where id=?",new BeanPropertyRowMapper<House>(House.class),id);
		return list.get(0);
	}
	@Override
	public JsonGroup findHouseMsg(int start, int pageSize, int aid,  int last, int findFlag) {
		JdbcTemplate template = new JdbcTemplate(DBUtil.getDataSource());
		Long count = template.queryForObject("SELECT count(*) FROM ih_house_info h,ih_user_profile u WHERE h.user_id =u.id AND area_id=? AND ? BETWEEN min_days AND max_days",
				Long.class, aid, last);
		switch (findFlag) {
		case 1:
			List<House> list1 = template.query(
					"SELECT h.id,index_image_url,price,title,room_count,order_count,address,avatar_url,h.create_time FROM ih_house_info h,ih_user_profile u WHERE h.user_id =u.id AND area_id=? AND ? BETWEEN min_days AND max_days ORDER BY h.create_time DESC LIMIT ?,?",
					new BeanPropertyRowMapper<House>(House.class), aid, last, start, pageSize);
			return new JsonGroup(list1, count);
		case 2:
			List<House> list2 = template.query(
					"SELECT h.id,index_image_url,price,title,room_count,order_count,address,avatar_url,h.create_time FROM ih_house_info h,ih_user_profile u WHERE h.user_id =u.id AND area_id=? AND ? BETWEEN min_days AND max_days ORDER BY order_count DESC LIMIT ?,?",
					new BeanPropertyRowMapper<House>(House.class), aid, last, start, pageSize);

			return new JsonGroup(list2, count);
		case 3:
			List<House> list3 = template.query(
					"SELECT h.id,index_image_url,price,title,room_count,order_count,address,avatar_url,h.create_time FROM ih_house_info h,ih_user_profile u WHERE h.user_id =u.id AND area_id=? AND ? BETWEEN min_days AND max_days ORDER BY price ASC LIMIT ?,?",
					new BeanPropertyRowMapper<House>(House.class), aid, last, start, pageSize);
			
			return new JsonGroup(list3, count);
		case 4:
			List<House> list4 = template.query(
					"SELECT h.id,index_image_url,price,title,room_count,order_count,address,avatar_url,h.create_time FROM ih_house_info h,ih_user_profile u WHERE h.user_id =u.id AND area_id=? AND ? BETWEEN min_days AND max_days ORDER BY price DESC LIMIT ?,?",
					new BeanPropertyRowMapper<House>(House.class), aid, last, start, pageSize);
			
			return new JsonGroup(list4, count);
		
		
		default:
			break;
		}
		return null;
	}

	@Override
	public JsonGroup findHouseMsg(int start, int pageSize, int last, int findFlag) {
		JdbcTemplate template = new JdbcTemplate(DBUtil.getDataSource());
		Long count = template.queryForObject("SELECT count(*) FROM ih_house_info h,ih_user_profile u WHERE h.user_id =u.id AND ? BETWEEN min_days AND max_days",
				Long.class, last);
		switch (findFlag) {
		case 1:
			List<House> list1 = template.query("SELECT h.id,index_image_url,price,title,room_count,order_count,address,avatar_url,h.create_time FROM ih_house_info h,ih_user_profile u WHERE h.user_id =u.id  AND ? BETWEEN min_days AND max_days ORDER BY h.create_time DESC LIMIT ?,?",
					new BeanPropertyRowMapper<House>(House.class), last, start, pageSize);
			return new JsonGroup(list1,count);
		case 2:
			List<House> list2 = template.query("SELECT h.id,index_image_url,price,title,room_count,order_count,address,avatar_url,h.create_time FROM ih_house_info h,ih_user_profile u WHERE h.user_id =u.id  AND ? BETWEEN min_days AND max_days ORDER BY order_count DESC LIMIT ?,?",
					new BeanPropertyRowMapper<House>(House.class), last, start, pageSize);
			return new JsonGroup(list2,count);
		case 3:
			List<House> list3 = template.query("SELECT h.id,index_image_url,price,title,room_count,order_count,address,avatar_url,h.create_time FROM ih_house_info h,ih_user_profile u WHERE h.user_id =u.id  AND ? BETWEEN min_days AND max_days ORDER BY price ASC LIMIT ?,?",
					new BeanPropertyRowMapper<House>(House.class), last, start, pageSize);
			return new JsonGroup(list3,count);
		case 4:
			List<House> list4 = template.query("SELECT h.id,index_image_url,price,title,room_count,order_count,address,avatar_url,h.create_time FROM ih_house_info h,ih_user_profile u WHERE h.user_id =u.id  AND ? BETWEEN min_days AND max_days ORDER BY price DESC LIMIT ?,?",
					new BeanPropertyRowMapper<House>(House.class), last, start, pageSize);
			return new JsonGroup(list4,count);
		default:
			break;
		}
		return null;
	}

	@Override
	public PageGroup findAllMyHouse(User user, int currPage, int pageSize) throws Exception {
		int start = (currPage - 1) * pageSize;
		JdbcTemplate template = new JdbcTemplate(DBUtil.getDataSource());
		List<House> list = template.query("select * from ih_house_info where user_id = ? limit ?,?",
				new BeanPropertyRowMapper<House>(House.class), user.getId(), start, pageSize);
		Integer count = template.queryForObject("select count(*) from ih_house_info where user_id = ? ", Integer.class,
				user.getId());
		PageGroup pageGroup = new PageGroup(list, count);
		return pageGroup;
	}

	@Override
	public void deleteMyHouse(int id) throws Exception {
		JdbcTemplate template = new JdbcTemplate(DBUtil.getDataSource());
		template.update("delete from ih_house_info where id = ?", id);
	}

	@Override
	public void updateHouse(House house) throws Exception {
		JdbcTemplate template = new JdbcTemplate(DBUtil.getDataSource());
		template.update(
				"UPDATE ih_house_info SET title = ?,price=?,area_id=?,address=?,room_count=?,acreage=?,unit=?,capacity=?,beds=?,deposit=?,min_days=?,max_days=? where id = ?",
				house.getTitle(), house.getPrice(), house.getAreaId(), house.getAddress(), house.getRoomCount(),
				house.getAcreage(), house.getUnit(), house.getCapacity(), house.getBeds(), house.getDeposit(),
				house.getMinDays(), house.getMaxDays(), house.getId());
	}
}
