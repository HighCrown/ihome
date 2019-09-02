package com.ihome.dao;

import java.util.List;

import com.ihome.entity.Area;

public interface AreaDao {

	List<Area> findAreas();
	String findAreaNameById(int areaId) throws Exception;
	List<Area> findAllArea() throws Exception;
}
