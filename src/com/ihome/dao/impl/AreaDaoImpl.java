package com.ihome.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ihome.dao.AreaDao;
import com.ihome.entity.Area;
import com.ihome.util.DBUtil;


public class AreaDaoImpl implements AreaDao {

	@Override
	public List<Area> findAreas() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(DBUtil.getDataSource());
		List<Area> list = jdbcTemplate.query("select * from ih_area_info",new BeanPropertyRowMapper<Area>(Area.class));
		return list;
	}
	@Override
	public String findAreaNameById(int areaId) throws Exception {
		JdbcTemplate template = new JdbcTemplate(DBUtil.getDataSource());
		List<Area> list = template.query("select * from ih_area_info where id = ?", new BeanPropertyRowMapper<Area>(Area.class),areaId);
		try {
			return list.get(0).getName();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Area> findAllArea() throws Exception {
		JdbcTemplate template = new JdbcTemplate(DBUtil.getDataSource());
		List<Area> list = template.query("select * from ih_area_info", new BeanPropertyRowMapper<Area>(Area.class));
		return list;
	}

}
