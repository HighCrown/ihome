package com.ihome.entity;

import java.util.List;

public class OrderPageGroup {
	private List<Order> list;
	private long count;
	public List<Order> getList() {
		return list;
	}
	public void setList(List<Order> list) {
		this.list = list;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public OrderPageGroup(List<Order> list, long count) {
		super();
		this.list = list;
		this.count = count;
	}
	public OrderPageGroup() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
