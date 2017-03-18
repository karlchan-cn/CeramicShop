/**
 * 
 */
package cn.com.grocery.action.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.google.common.collect.Maps;

import cn.com.grocery.domain.AdminUser;

/**
 * @author karl
 *
 */
@Controller
public class IndexController {
	@RequestMapping("/index")
	public MappingJackson2JsonView index() {
		Map<String, Object> attribute = Maps.newHashMap();
		AdminUser user = new AdminUser();
		attribute.put("user", user);
		MappingJackson2JsonView view = new MappingJackson2JsonView();
		view.setAttributesMap(attribute);
		return view;
	}
}
