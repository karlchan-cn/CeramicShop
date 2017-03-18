/**
 * 
 */
package cn.com.grocery.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author karl
 *
 */
@Controller
public class BaseAction {
	Logger LOG = LoggerFactory.getLogger(BaseAction.class);
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public String handleAllException(Exception e) {
		LOG.error("action uncatched exception:{}", e.getMessage(), e);
		return "error";
	}
}
