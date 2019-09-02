package com.ihome.entity;

import java.util.List;

public class PageGroup {
	private List<House> list;
	private long count;
	public List<House> getList() {
		return list;
	}
	public void setList(List<House> list) {
		this.list = list;
	}
	public long getCount() {
		return count;
	}
	public PageGroup() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageGroup(List<House> list, long count) {
		super();
		this.list = list;
		this.count = count;
	}
	public void setCount(long count) {
		this.count = count;
	}

}
