package com.ihome.dao;

import java.util.List;
import java.util.Map;

import com.ihome.entity.Area;
import com.ihome.entity.House;
import com.ihome.entity.User;

public interface AddHouseDao {

	void addHouseByUserId(User exitxUser, House house) throws Exception;

	List<Area> findAreaByUserId() throws Exception;

	Integer findAreaIdByName(Area area) throws Exception;

	void addFacility(House realHouse, String[] facilityStr) throws Exception;

	List<House> findHouseIdByUserId(User exitxUser) throws Exception;

	void setHouseImg(House realHouse, String srcString) throws Exception;

}
