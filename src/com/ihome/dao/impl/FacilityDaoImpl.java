package com.ihome.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ihome.dao.FacilityDao;
import com.ihome.entity.Facility;
import com.ihome.entity.FacilityInfo;
import com.ihome.util.DBUtil;


public class FacilityDaoImpl implements FacilityDao {

	@Override
	public List<Facility> findFacility(int id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(DBUtil.getDataSource());
		List<Facility> list = jdbcTemplate.query("SELECT f.id,f.name FROM ih_house_facility hf,ih_facility_info f WHERE hf.facility_id = f.id AND hf.house_id = ?;", new BeanPropertyRowMapper<Facility>(Facility.class),id);
		return list;
	}
	@Override
	public List<FacilityInfo> findFacilityByHouseId(int id) throws Exception {
		JdbcTemplate template = new JdbcTemplate(DBUtil.getDataSource());
		List<FacilityInfo> list = template.query("select * from ih_house_facility where house_id = ?", new BeanPropertyRowMapper<FacilityInfo>(FacilityInfo.class), id);
		return list;
	}

	@Override
	public void del(int id) throws Exception {
		JdbcTemplate template = new JdbcTemplate(DBUtil.getDataSource());
		template.update("delete from ih_house_facility where house_id = ?",id);
	}


	@Override
	public void updateFacilitys(String facilitys, int id) throws Exception {
		System.out.println(facilitys);
		int facilitysId = Integer.parseInt(facilitys);
		JdbcTemplate template = new JdbcTemplate(DBUtil.getDataSource());
		template.update("insert into ih_house_facility values(?,?)",id,facilitysId);
	}

}
