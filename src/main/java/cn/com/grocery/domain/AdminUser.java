/**
 * 
 */
package cn.com.grocery.domain;

/**
 * @author karl
 *
 */
public class AdminUser {
	private Long id;
	private String userName;
	private String dsiplayName;
	private Long groupId;
	private String password;
	private String email;
	private String phone;
	private String country;

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

	public String getDsiplayName() {
		return dsiplayName;
	}

	public void setDsiplayName(String dsiplayName) {
		this.dsiplayName = dsiplayName;
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

}
