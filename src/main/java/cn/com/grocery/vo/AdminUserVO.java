/**
 * 
 */
package cn.com.grocery.vo;

import com.alibaba.fastjson.annotation.JSONField;

import cn.com.grocery.domain.AdminUser;

/**
 * @author karl
 *
 */
public class AdminUserVO {

	private Long id;

	@JSONField( name = "user_name" )
	private String userName;

	@JSONField( name = "display_name" )
	private String displayName;

	@JSONField( name = "group_id" )
	private Long groupId;

	private String password;

	private String email;

	private String phone;

	private String country;

	@JSONField( name = "group_name" )
	private String groupName;

	@JSONField( name = "group_type" )
	private int groupType;

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

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName( String groupName ) {
		this.groupName = groupName;
	}

	public int getGroupType() {
		return groupType;
	}

	public void setGroupType( int groupType ) {
		this.groupType = groupType;
	}

	public void initFromUser( AdminUser user ) {
		this.id = user.getId();
		this.groupId = user.getGroupId();
		userName = user.getUserName();
		displayName = user.getDisplayName();
		password = user.getPassword();
		email = user.getEmail();
		phone = user.getPhone();
		country = user.getCountry();
	}

}
