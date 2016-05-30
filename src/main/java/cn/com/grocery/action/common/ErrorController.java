/**
 * 
 */
package cn.com.grocery.action.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author karl
 * @date Dec 25, 2016 8:14:11 PM
 */
@Controller
public class ErrorController {
	private static final Logger LOG = LoggerFactory.getLogger(ErrorController.class);

	public ErrorController() {
		LOG.info("started {}", ErrorController.class);
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public String handleAllException() {
		return "error;";
	}
}
