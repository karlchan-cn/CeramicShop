package cn.com.kc.blog.pojo;

import java.util.Date;

import javax.persistence.Id;

public class Event {
	@Id
	private Long id;

	private String title;
	private Date date;

	public Event() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}