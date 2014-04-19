/**
 * 
 */
package cn.com.kc.blog.bl.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;

/**
 * @author kchen1
 * 
 */
public interface IBlogAdminMgrService {

/**
 * Bean name;
 */
String BEAN_NAME = IBlogUserService.class.getName();

public ResponseEntity<String> saveUploadFile(HttpServletRequest request,
				HttpServletResponse response);
}
