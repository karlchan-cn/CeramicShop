/**
 * 
 */
package cn.com.grocery.common;

import java.io.Serializable;

/**
 * @author karl
 * @date Jan 2, 2017 5:07:50 PM
 */
public class ApiResult<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6638577926111554634L;
	private String message;
	private T data;
	private Integer code;

	public ApiResult() {
		code = 0;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
