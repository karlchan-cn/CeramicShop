/**
 * 
 */
package cn.com.kc.blog.controller.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import cn.com.kc.blog.common.util.CommonUtils;

/**
 * @author kchen1
 * 
 */
public final class BlogControllerHelper {
private BlogControllerHelper() {

}

/**
 * create a text/plain response entity object
 * 
 * @param responseBody
 *            response content
 * @return responseentity
 */
public static ResponseEntity<String> getResponseEntity(final String responseBody) {
	return new ResponseEntity<String>(
					responseBody,
					CommonUtils.getHttpHeadersByType(""), HttpStatus.CREATED);
}
}
