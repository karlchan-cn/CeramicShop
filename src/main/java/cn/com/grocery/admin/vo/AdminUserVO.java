/**
 * 
 */
package cn.com.grocery.admin.vo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import com.alibaba.fastjson.annotation.JSONField;

import cn.com.grocery.domain.AdminUser;

/**
 * @author karl
 *
 */
public class AdminUserVO {

	private Long id;

	@JSONField(name = "display_name")
	@NotNull(message = "adminUserVO.displayName")
	@Length(max = 10, min = 1, message = "adminUserVO.displayName")
	private String displayName;

	@JSONField(name = "group_id")
	private Long groupId;

	@NotNull(message = "adminUserVO.password")
	@Length(max = 15, min = 1, message = "adminUserVO.password")
	private String password;

	@Email(regexp = ".+\\@(qq|grocery)\\.com", message = "adminUserVO.email")
	@Length(max = 35, min = 1, message = "adminUserVO.email")
	private String email;

	@NotNull(message = "adminUserVO.icon")
	@Length(min = 1, message = "adminUserVO.icon")
	private String icon;

	private String phone;

	private String country;

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@JSONField(name = "group_name")
	private String groupName;

	@JSONField(name = "group_type")
	private int groupType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getGroupType() {
		return groupType;
	}

	public void setGroupType(int groupType) {
		this.groupType = groupType;
	}

	public void initToUser(AdminUser user) {
		user.setDisplayName(this.getDisplayName());
		user.setEmail(this.getEmail());
		user.setPassword(this.getPassword());
		user.setPhone(this.getPhone());
		user.setCountry(this.getCountry());
		user.setIcon(this.getIcon());
	}

	public void initFromUser(AdminUser user) {
		id = user.getId();
		groupId = user.getGroupId();
		displayName = user.getDisplayName();
		password = user.getPassword();
		email = user.getEmail();
		phone = user.getPhone();
		country = user.getCountry();
		icon = user.getIcon();
	}

}
