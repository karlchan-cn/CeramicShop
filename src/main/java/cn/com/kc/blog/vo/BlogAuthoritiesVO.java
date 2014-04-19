/**
 * 
 */
package cn.com.kc.blog.vo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

/**
 * @author kchen1
 * 
 */

public class BlogAuthoritiesVO implements Serializable {

/**
	 * 	
	 */
private static final long serialVersionUID = 1L;

private BlogUserVO user;

private String authority;

private Long id;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getAuthority() {
	return authority;
}

public void setAuthority(String authority) {
	this.authority = authority;
}

public BlogUserVO getUser() {
	return user;
}

public void setUser(BlogUserVO user) {
	this.user = user;
}

}
