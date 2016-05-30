/**
 * 
 */
package cn.com.grocery.vo;

/**
 * @author karl
 *
 */
public class UploadItemVo {
	/** file's source name **/
	private String name;
	/** file's name in disk **/
	private String savedName;
	/** file's size **/
	private long size;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSavedName() {
		return savedName;
	}

	public void setSavedName(String savedName) {
		this.savedName = savedName;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

}
