/**
 * 
 */
package cn.com.kc.blog.controller.service.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author chenjinlong2
 * 
 */
@Controller(value = "cn.com.kc.blog.controller.service.impl.BlogIndexController")
@RequestMapping("/")
public class BlogIndexController {
	@RequestMapping(method = RequestMethod.GET)
	public String showIndex() {
		return "index";
	}
}
