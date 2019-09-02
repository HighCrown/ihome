package com.ihome.service;

import com.ihome.entity.House;
import com.ihome.entity.JsonGroup;
import com.ihome.entity.PageGroup;
import com.ihome.entity.User;

public interface HouseService {

	House findHouse(int id);
	JsonGroup findHouseMsg(int start, int pageSize, int aid, String sd,String ed, int findFlag);

	JsonGroup findHouseMsg(int start, int pageSize, String sd,String ed, int findFlag);
	PageGroup findAllMyHouse(User user, int currPage, int pageSize)throws Exception;

	void deleteMyHouse(int id) throws Exception;

	void updateHouse(House house) throws Exception;
}
