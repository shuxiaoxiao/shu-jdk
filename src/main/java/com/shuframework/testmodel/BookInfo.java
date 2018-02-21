package com.shuframework.testmodel;

import java.util.Date;

/**
 * 普通的pojo
 * 
 * @author shu
 *
 */
public class BookInfo {

	private Integer id;
	private String name;
	private Date createTime;
	
	private BookInfo2 bookInfo2;
	public BookInfo2 getBookInfo2() {
		return bookInfo2;
	}

	public void setBookInfo2(BookInfo2 bookInfo2) {
		this.bookInfo2 = bookInfo2;
	}

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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public BookInfo() {
	}

	public BookInfo(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public BookInfo(Integer id, String name, Date createTime) {
		this.id = id;
		this.name = name;
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "BookInfo [id=" + id + ", name=" + name + ", createTime=" + createTime + "]";
	}

}
