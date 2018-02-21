package com.shuframework.testmodel;

import java.io.Serializable;

/**
 * 普通的pojo
 * 
 * @author shu
 *
 */
public class BookInfo3 implements Serializable{
	
	private static final long serialVersionUID = -439721954189063679L;
	
	private Integer id;
	private String name;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public BookInfo3() {}
	
	public BookInfo3(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "BookInfo [id=" + id + ", name=" + name + "]";
	}
}
