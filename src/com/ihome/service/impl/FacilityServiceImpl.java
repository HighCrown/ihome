package com.ihome.service.impl;

import java.util.List;

import com.ihome.dao.FacilityDao;
import com.ihome.dao.impl.FacilityDaoImpl;
import com.ihome.entity.Facility;
import com.ihome.entity.FacilityInfo;
import com.ihome.service.FacilityService;

public class FacilityServiceImpl implements FacilityService {
	FacilityDao facilityDao = new FacilityDaoImpl();

	@Override
	public List<Facility> findFacility(int id) {
		FacilityDao facilitydao = new FacilityDaoImpl();
		return facilitydao.findFacility(id);
	}

	@Override
	public List<FacilityInfo> findFacilityByHouseId(int id) throws Exception {
		return facilityDao.findFacilityByHouseId(id);
	}

	@Override
	public void del(int id) throws Exception {
		facilityDao.del(id);

	}

	@Override
	public void updateFacilitys(String[] facilitys, int id) throws Exception {
		del(id);
		if (facilitys != null) {
			for (int i = 0; i < facilitys.length; i++) {
				facilityDao.updateFacilitys(facilitys[i], id);
			}
		}
	}

}
