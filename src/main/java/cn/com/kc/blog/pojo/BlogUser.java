/**
 * 
 */
package cn.com.kc.blog.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.IndexColumn;
import org.hibernate.validator.constraints.Email;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * @author chenjinlong2
 * 
 */

@Entity
@Table(name = "USERS", uniqueConstraints = { @UniqueConstraint(columnNames = { "USERNAME" }) })
public class BlogUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2467016020275506982L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull(message = "{username.illegal}")
	@Column(unique = true, name = "USERNAME")
	@IndexColumn(name = "USERNAME")
	private String userName;
	@NotNull
	private String showName;
	@NotNull
	private String password;
	@NotNull
	@Email
	private String email;
	@NotNull
	private Timestamp createTime;
	@NotNull
	private String address;
	@NotNull
	private String phoneNumber;
	@NotNull
	private String validateCode;
	private Boolean enabled;

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@OneToMany(fetch = FetchType.EAGER, targetEntity = BlogAuthorities.class, mappedBy = "user", cascade = { CascadeType.ALL })
	private List<BlogAuthorities> authorities;

	public List<BlogAuthorities> getAuthorities() {
		if (authorities == null) {
			authorities = new ArrayList<BlogAuthorities>();
		}
		return authorities;
	}

	public void setAuthorities(List<BlogAuthorities> authorities) {
		this.authorities = authorities;
	}

	@OneToMany(fetch = FetchType.LAZY, targetEntity = BlogEntity.class, mappedBy = "user", cascade = { CascadeType.REMOVE })
	private Set<BlogEntity> entities;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = BlogComments.class, mappedBy = "user", cascade = { CascadeType.REMOVE })
	private Set<BlogComments> comments;

	public Set<BlogComments> getComments() {
		return comments;
	}

	public void setComments(Set<BlogComments> comments) {
		this.comments = comments;
	}

	public Set<BlogEntity> getEntities() {
		return entities;
	}

	public void setEntities(Set<BlogEntity> entities) {
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
