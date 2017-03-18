/**
 * 
 */
package cn.com.grocery.common.constants.enums;

/**
 * @author karl
 *
 */
public enum UploadFileTypeEnums {
	ADMIN_ICON("/grocery-admin/icon/", 12, "管理员头像"), ADMIN_TMP_FILE("/grocery-admin/tmp", 11, "管理后台临时文件");
	private String path;
	private int type;
	private String desc;

	private UploadFileTypeEnums(String path, int type, String desc) {
		this.path = path;
		this.type = type;
		this.desc = desc;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public static UploadFileTypeEnums getUploadFileType(int type) {
		for (UploadFileTypeEnums enumType : UploadFileTypeEnums.values()) {
			if (enumType.type == type) {
				return enumType;
			}
		}
		return null;
	}
}
