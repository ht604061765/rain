package com.hunter.rain.framework.bean;

import java.io.Serializable;
import java.util.List;

public class DataGrid<T> implements Serializable{
	private static final long serialVersionUID = 1L;
	public DataGrid(int total,List<T> rows){
		this.total=total;
		this.rows = rows;
	}
	// 总记录数
	private int total;
	// 记录
	private List<T> rows;
	
	//页脚汇总
	private List<T> footer;
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	public List<T> getFooter() {
		return footer;
	}
	public void setFooter(List<T> footer) {
		this.footer = footer;
	}

}
  
