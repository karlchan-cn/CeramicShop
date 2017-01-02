/**
 * 
 */
package cn.com.grocery.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.testng.collections.Maps;

import cn.com.grocery.admin.vo.AdminUserVO;
import cn.com.grocery.common.Pager;
import cn.com.grocery.domain.AdminUser;
import cn.com.grocery.service.AdminUserManageService;

/**
 * @author karl
 *
 */
@Controller
public class AdminLogonAction {

	@Autowired
	private AdminUserManageService adminUserManageService;

	@RequestMapping(value = { "/admin/signin" }, method = { RequestMethod.GET })
	public ModelAndView signin(String redirect) {
		ModelAndView mav = new ModelAndView("/admin/logon/signin");
		mav.addObject("redirect", redirect);
		return mav;
	}

	@RequestMapping(value = { "/admin/login" }, method = { RequestMethod.POST, RequestMethod.GET })
	public String login(AdminUserVO vo, HttpServletRequest req,
			@RequestParam(name = "redirect", required = false) String redirect) {
		Map<String, Object> param = Maps.newHashMap();
		param.put("email", vo.getUserName());
		param.put("password", adminUserManageService.securePassword(vo.getPassword()));
		Pager pager = new Pager();
		pager.setHql("from AdminUser where email = :email and password = :password");
		pager.setIndex(0);
		pager.setCount(1);
		List<AdminUser> users = adminUserManageService.listUser(pager, param);
		if (users.size() == 0) {
			return "redirect:/admin/signin?redirect=" + redirect;
		}
		req.getSession().setAttribute("user_id", users.get(0).getId());
		if (StringUtils.isBlank(redirect)) {
			redirect = "/admin/console/index";
		}
		return "redirect:" + redirect;
	}

	@RequestMapping(value = { "/admin/logout" }, method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView logout(HttpServletRequest req) {
		req.getSession().removeAttribute("user_id");
		ModelAndView mav = new ModelAndView("/admin/logon/signin");
		return mav;
	}
}
