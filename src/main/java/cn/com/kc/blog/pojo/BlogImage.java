/**
 * 
 */
package cn.com.kc.blog.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

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
@Entity
@Table(name = "BLOG_IMAGE")
public class BlogImage implements Serializable {

/**
	 * 
	 */
private static final long serialVersionUID = -5219931739057719520L;

/**
	 * 
	 */
public BlogImage() {

}

@ManyToOne(cascade = { CascadeType.PERSIST }, fetch = FetchType.LAZY, targetEntity = BlogEntity.class)
@JoinColumn(name = "ENTITY_ID", nullable = true)
private BlogEntity entity;
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String name;
private String position;
private Timestamp createDate;
@Transient
private Long tempid;
@Transient
private Long size;
@Transient
private String sizeUnit;
@Transient
private String showName;
/**
 * image's description
 */
private String description;
/**
 * image's state
 */
private String state;
/**
 * while image can't be display,the text replacement.
 */
private String replacement;



public Timestamp getCreateDate() {
	return createDate;
}

public void setCreateDate(Timestamp createDate) {
	this.createDate = createDate;
}

public String getReplacement() {
	return replacement;
}

public void setReplacement(String replacement) {
	this.replacement = replacement;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

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

public BlogEntity getEntity() {
	return entity;
}

public void setEntity(BlogEntity entity) {
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
//