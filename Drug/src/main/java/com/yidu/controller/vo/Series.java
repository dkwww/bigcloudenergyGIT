package com.yidu.controller.vo;

import java.util.List;
import java.util.Map;

public class Series {
	private String name;
	private String type;
	private String stack;
	private String areaStyle;
	private String drugId;
	private List<Integer> date;
	private Map<String,Object> mup;
	
	
	public Map<String, Object> getMup() {
		return mup;
	}
	public void setMup(Map<String, Object> mup) {
		this.mup = mup;
	}
	public List<Integer> getDate() {
		return date;
	}
	public void setDate(List<Integer> date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStack() {
		return stack;
	}
	public void setStack(String stack) {
		this.stack = stack;
	}
	public String getAreaStyle() {
		return areaStyle;
	}
	public void setAreaStyle(String areaStyle) {
		this.areaStyle = areaStyle;
	}
	public String getDrugId() {
		return drugId;
	}
	public void setDrugId(String drugId) {
		this.drugId = drugId;
	}
	
	
}
