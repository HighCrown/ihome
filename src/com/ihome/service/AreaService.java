package com.ihome.service;

import java.util.List;

import com.ihome.entity.Area;

public interface AreaService {

	List<Area> findAreas();
	String findAreaNameById(int areaId) throws Exception;

	List<Area> findAllArea() throws Exception;
}
