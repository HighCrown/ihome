package com.ihome.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ihome.dao.HouseDao;
import com.ihome.dao.impl.HouseDaoImpl;
import com.ihome.entity.House;
import com.ihome.entity.JsonGroup;
import com.ihome.entity.PageGroup;
import com.ihome.entity.User;
import com.ihome.service.AreaService;
import com.ihome.service.FacilityService;
import com.ihome.service.HouseService;

public class HouseServiceImpl implements HouseService {

	private HouseDao dao = new HouseDaoImpl();
	AreaService areaService = new AreaServiceImpl();
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public House findHouse(int id) {
		return dao.findHouse(id);
	}

	@Override
	public JsonGroup findHouseMsg(int start, int pageSize, int aid, String sd, String ed, int findFlag) {
		if (sd == "" && ed == "") {
			int last = 1;
			return dao.findHouseMsg(start, pageSize, aid, last, findFlag);
		} else {

			try {
				Date sdDate = format.parse(sd);
				Date edDate = format.parse(ed);
				int last = (int) ((edDate.getTime() - sdDate.getTime()) / 1000 / 60 / 60 / 24);
				return dao.findHouseMsg(start, pageSize, aid, last, findFlag);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public JsonGroup findHouseMsg(int start, int pageSize, String sd, String ed, int findFlag) {
		if (sd == "" && ed == "") {
			int last = 1;
			return dao.findHouseMsg(start, pageSize, last, findFlag);
		} else {

			try {
				Date sdDate = format.parse(sd);
				Date edDate = format.parse(ed);
				int last = (int) ((edDate.getTime() - sdDate.getTime()) / 1000 / 60 / 60 / 24);
				return dao.findHouseMsg(start, pageSize, last, findFlag);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;

	}

	@Override
	public PageGroup findAllMyHouse(User user, int currPage, int pageSize) throws Exception {
		PageGroup group = dao.findAllMyHouse(user, currPage, pageSize);
		for (int i = 0; i < group.getList().size(); i++) {
			String areaName = areaService.findAreaNameById(group.getList().get(i).getAreaId());
			group.getList().get(i).setAreaName(areaName);
			Date create_time = group.getList().get(i).getCreateTime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
			String format = sdf.format(create_time);
			group.getList().get(i).setTime(format);
		}
		return group;
	}

	
	FacilityService f = new FacilityServiceImpl();
	@Override
	public void deleteMyHouse(int id) throws Exception {
		f.del(id);
		dao.deleteMyHouse(id);
	}

	@Override
	public void updateHouse(House house) throws Exception {
		dao.updateHouse(house);

	}

}
