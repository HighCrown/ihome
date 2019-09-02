package com.ihome.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ihome.dao.AddHouseDao;
import com.ihome.dao.UserDao;
import com.ihome.dao.impl.AddHouseDaoImpl;
import com.ihome.entity.Area;
import com.ihome.entity.House;
import com.ihome.entity.User;
import com.ihome.service.AddHouseService;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class AddHouseServiceImpl implements AddHouseService {
	
	AddHouseDao dao = new AddHouseDaoImpl();

	@Override
	public List<Area> findAreaByUserId() throws Exception {
		return dao.findAreaByUserId();
	}


	@Override
	public Integer findAreaIdByName(Area area) throws Exception {
		return dao.findAreaIdByName(area);
	}


	@Override
	public void addHouseByUserId(User exitxUser, House house) throws Exception {
		house.setCreateTime(new Date());
		dao.addHouseByUserId(exitxUser, house);	
	}


	@Override
	public void addFacility(House realHouse, String[] facilityStr) throws Exception {
		dao.addFacility(realHouse,facilityStr);
	}


	@Override
	public List<House> findHouseIdByUserId(User exitxUser) throws Exception {
		return dao.findHouseIdByUserId(exitxUser);
	}


	@Override
	public void setHouseImg(House realHouse, String srcString) throws Exception {
		dao.setHouseImg(realHouse,srcString);
	}



}
