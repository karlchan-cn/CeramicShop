/**
 * 
 */
package cn.com.grocery.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author karl
 *
 */
@Controller
public class AdminAction implements InitializingBean {
	private static final Logger logger = LoggerFactory.getLogger(AdminAction.class);

	@RequestMapping(value = "/admin/index", method = { RequestMethod.GET })
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("/admin/index");
		return mav;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("sjdflkjs");

	}
}
