package com.ihome.service.impl;

import java.util.List;

import com.ihome.dao.AreaDao;
import com.ihome.dao.impl.AreaDaoImpl;
import com.ihome.entity.Area;
import com.ihome.service.AreaService;

public class AreaServiceImpl implements AreaService {
    AreaDao areadao=new AreaDaoImpl();
	@Override
	public List<Area> findAreas() {
		// TODO Auto-generated method stub
		return areadao.findAreas();
	}
	AreaDao dao = new AreaDaoImpl();
	@Override
	public String findAreaNameById(int areaId) throws Exception {
		return dao.findAreaNameById(areaId);
	}
	@Override
	public List<Area> findAllArea() throws Exception {
		return dao.findAllArea();
	}

}
