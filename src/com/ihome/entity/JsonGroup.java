package com.ihome.entity;

import java.util.List;

public class JsonGroup {
	private List<House> list;
	private long count;
	public List<House> getList() {
		return list;
	}
	public JsonGroup() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setList(List<House> list) {
		this.list = list;
	}
	public long getCount() {
		return count;
	}
	public JsonGroup(List<House> list, long count) {
		super();
		this.list = list;
		this.count = count;
	}
	public void setCount(long count) {
		this.count = count;
	}

}
