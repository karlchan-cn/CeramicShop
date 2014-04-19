/**
 * 
 */
package cn.com.kc.blog.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

import java.util.List;
import java.util.Set;

/**
 * @author chenjinlong2
 * 
 */

public class BlogUserVO implements Serializable {

/**
	 * 
	 */
private static final long serialVersionUID = -2467016020275506982L;

private Long id;

private String userName;

private String showName;

private String password;

private String email;

private Timestamp createTime;

private String address;

private String phoneNumber;

private String validateCode;
private Boolean enabled;

public Boolean getEnabled() {
	return enabled;
}

public void setEnabled(Boolean enabled) {
	this.enabled = enabled;
}

private List<BlogAuthoritiesVO> authorities;

public List<BlogAuthoritiesVO> getAuthorities() {
	if (authorities == null) {
		authorities = new ArrayList<BlogAuthoritiesVO>();
	}
	return authorities;
}

public void setAuthorities(List<BlogAuthoritiesVO> authorities) {
	this.authorities = authorities;
}

private Set<BlogEntityVO> entities;

private Set<BlogCommentsVO> comments;

public Set<BlogCommentsVO> getComments() {
	return comments;
}

public void setComments(Set<BlogCommentsVO> comments) {
	this.comments = comments;
}

public Set<BlogEntityVO> getEntities() {
	return entities;
}

public void setEntities(Set<BlogEntityVO> entities) {
	this.entities = entities;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getShowName() {
	return showName;
}

public void setShowName(String showName) {
	this.showName = showName;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public Timestamp getCreateTime() {
	return createTime;
}

public void setCreateTime(Timestamp createTime) {
	this.createTime = createTime;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getPhoneNumber() {
	return phoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}

public String getValidateCode() {
	return validateCode;
}

public void setValidateCode(String validateCode) {
	this.validateCode = validateCode;
}

}
