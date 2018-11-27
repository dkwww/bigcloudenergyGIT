/**
 * 
 */
package com.yidu.util;

/**
 * 项目名：Survey
 * 文件名：Page.java
 * @author ZhouJun
 * @date： 2018年9月14日上午9:27:55
 * 类说明: 分页工具
 */
public class PageUtil {
	
	private int curPage = 1;	//页数
	private int rows = 7;	//行数
	private int startRows ; //开始的行数
	private Long totalRows ;	//总行数
	private Long totalPages ; //总页数
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getStartRows() {
		startRows = (curPage-1)*rows;
		return startRows;
	}
	public void setStartRows(int startRows) {
		this.startRows = startRows;
	}
	public Long getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(Long totalRows) {
		this.totalRows = totalRows;
		if(totalRows%rows==0&&totalRows!=0){
			totalPages = totalRows/rows;
		}else{
			totalPages = (totalRows/rows)+1;
		}
	}
	public long getTotalPages() {
		
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = (long) totalPages;
	}

	
}
