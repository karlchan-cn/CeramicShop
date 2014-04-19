/**
 * 
 */
package cn.com.kc.blog.vo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author karl
 * 
 */

public class BlogImageVO implements Serializable {

/**
	 * 
	 */
private static final long serialVersionUID = -5219931739057719520L;

/**
	 * 
	 */
public BlogImageVO() {

}

private BlogEntityVO entity;

private Long id;
private String name;
private String position;

private Long tempid;

private Long size;

private String sizeUnit;

private String showName;

public String getShowName() {
	return showName;
}

public void setShowName(String showName) {
	this.showName = showName;
}

public Long getSize() {
	return size;
}

public void setSize(Long size) {
	this.size = size;
}

public Long getTempid() {
	return tempid;
}

public void setTempid(Long tempId) {
	this.tempid = tempId;
}

public BlogEntityVO getEntity() {
	return entity;
}

public void setEntity(BlogEntityVO entity) {
	this.entity = entity;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getPosition() {
	return position;
}

public void setPosition(String position) {
	this.position = position;
}

public String getSizeUnit() {
	return sizeUnit;
}

public void setSizeUnit(String sizeUnit) {
	this.sizeUnit = sizeUnit;
}

}