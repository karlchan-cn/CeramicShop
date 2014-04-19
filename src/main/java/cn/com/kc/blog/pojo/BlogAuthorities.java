/**
 * 
 */
package cn.com.kc.blog.pojo;

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
@Entity
@Table(name = "AUTHORITIES")
public class BlogAuthorities implements Serializable {

/**
	 * 	
	 */
private static final long serialVersionUID = 1L;
@ManyToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY, targetEntity = BlogUser.class)
@JoinColumn(name = "USER_ID", nullable = false, insertable = true, updatable = true, referencedColumnName = "ID")
@Index(name = "USER_ID")
private BlogUser user;
@Column(name = "AUTHORITY")
private String authority;

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
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

public BlogUser getUser() {
	return user;
}

public void setUser(BlogUser user) {
	this.user = user;
}

}
