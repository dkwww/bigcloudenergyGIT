/**
 * 
 */
package com.yidu.util;

/**
 * 项目名: 
 * @author 
 * @date 
 */
public class Message {

	private int state ;
	private String msg ;
	private int status;
	private String url;
	private Boolean bln;
	private Object obj;
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Boolean getBln() {
		return bln;
	}
	public void setBln(Boolean bln) {
		this.bln = bln;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}
