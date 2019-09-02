package com.ihome.service;

import java.util.List;

import com.ihome.entity.Facility;
import com.ihome.entity.FacilityInfo;

public interface FacilityService {

	List<Facility> findFacility(int id);
	List<FacilityInfo> findFacilityByHouseId(int id) throws Exception;

	void del(int id) throws Exception;

	void updateFacilitys(String[] facilitys, int id) throws Exception;


}
