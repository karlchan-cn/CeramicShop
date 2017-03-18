/**
 * 
 */
package cn.com.grocery.action.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author karl
 * @date Dec 25, 2016 8:14:11 PM
 */
@Controller
@ControllerAdvice
public class ErrorController {
	private static final Logger LOG = LoggerFactory.getLogger(ErrorController.class);

	public ErrorController() {
		LOG.info("started {}", ErrorController.class);
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	@RequestMapping(path={"/404","/500"})
	public ModelAndView handleAllException() {
		return new ModelAndView("/error_all");
	}
}
