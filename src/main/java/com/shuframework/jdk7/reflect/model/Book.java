package com.shuframework.jdk7.reflect.model;

import java.util.Date;

/**
 * 自定义对象 --JavaBean <br>
 * 需要有一组特殊的方法：getXxx 和 setXxx <br>
 * 必须存在默认的构造方法 <br>
 * 
 */
public class Book {

	private Long id;
	private String title;
	private double price;
	private Date createtime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", price=" + price + ", createtime=" + createtime + "]";
	}

}
