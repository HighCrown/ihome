package com.ihome.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.catalina.Host;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ihome.dao.AddHouseDao;
import com.ihome.entity.Area;
import com.ihome.entity.House;
import com.ihome.entity.User;
import com.ihome.util.DBUtil;

public class AddHouseDaoImpl implements AddHouseDao {

	@Override
	public void addHouseByUserId(User exitxUser, House house) throws Exception {
		JdbcTemplate jdbc = new JdbcTemplate(DBUtil.getDataSource());
		jdbc.update("insert into ih_house_info values (null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", exitxUser.getId(),
				house.getTitle(), house.getPrice(), house.getAreaId(), house.getAddress(), house.getRoomCount(),
				house.getAcreage(), house.getUnit(), house.getCapacity(), house.getBeds(), house.getDeposit(),
				house.getMinDays(), house.getMaxDays(), house.getOrderCount(), house.getIndexImageUrl(),
				house.getCreateTime());
	}

	@Override
	public List<Area> findAreaByUserId() throws Exception {
		JdbcTemplate jdbc = new JdbcTemplate(DBUtil.getDataSource());
		List<Area> list = jdbc.query("select * from ih_area_info", new BeanPropertyRowMapper<Area>(Area.class));
		return list;
	}

	@Override
	public Integer findAreaIdByName(Area area) throws Exception {
		JdbcTemplate jdbc = new JdbcTemplate(DBUtil.getDataSource());
		List<Area> list = jdbc.query("select id from ih_area_info where name = ?",
				new BeanPropertyRowMapper<Area>(Area.class), area.getName());
		Integer areaId = list.get(0).getId();
		return areaId;
	}

	@Override
	public void addFacility(House realHouse, String[] facilityStr) throws Exception {
		JdbcTemplate jdbc = new JdbcTemplate(DBUtil.getDataSource());
		if (facilityStr != null) {
			for (int i = 0; i < facilityStr.length; i++) {
				jdbc.update("insert into ih_house_facility values (?,?)", realHouse.getId(), facilityStr[i]);
			}
		}
	}

	@Override
	public List<House> findHouseIdByUserId(User existUser) throws Exception {
		JdbcTemplate jdbc = new JdbcTemplate(DBUtil.getDataSource());
		List<House> houselist = jdbc.query("select * from ih_house_info where user_id = ?",
				new BeanPropertyRowMapper<House>(House.class), existUser.getId());
		return houselist;
	}

	@Override
	public void setHouseImg(House realHouse, String srcString) throws Exception {
		JdbcTemplate jdbc = new JdbcTemplate(DBUtil.getDataSource());
		jdbc.update("update ih_house_info set index_image_url = ? where id = ?", srcString, realHouse.getId());
	}

}
