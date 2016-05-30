/**
 * 
 */
package cn.com.grocery.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author karl
 * @date Dec 25, 2016 9:15:50 PM
 */
@Component
public class CommonHandlerExceptionResolver implements HandlerExceptionResolver {
	private static final Logger LOG = LoggerFactory.getLogger(CommonHandlerExceptionResolver.class);

	public CommonHandlerExceptionResolver() {
		LOG.info("started {}", CommonHandlerExceptionResolver.class);
	}

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		LOG.error(String.format("error occur %s", ex.getMessage()), ex);
		ModelAndView mav = new ModelAndView("/common/404");
		return mav;
	}

}
