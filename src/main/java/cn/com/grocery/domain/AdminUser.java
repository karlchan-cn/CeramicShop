/**
 * 
 */
package cn.com.grocery.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

/**
 * @author karl
 *
 */
@Entity
@Table( name = "admin_user" )
@DynamicInsert( value = true )
public class AdminUser {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "id" )
	private Long id;

	@Column( name = "user_name" )
	private String userName;

	@Column( name = "display_name" )
	private String displayName;

	@Column( name = "groupId", nullable = true )
	private Long groupId;

	@Column( name = "password" )
	private String password;

	@Column( name = "email" )
	private String email;

	@Column( name = "phone" )
	private String phone;

	@Column( name = "country" )
	private String country;

	public Long getId() {
		return id;
	}

	public void setId( Long id ) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName( String userName ) {
		this.userName = userName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName( String displayName ) {
		this.displayName = displayName;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId( Long groupId ) {
		this.groupId = groupId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword( String password ) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail( String email ) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone( String phone ) {
		this.phone = phone;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry( String country ) {
		this.country = country;
	}

}
