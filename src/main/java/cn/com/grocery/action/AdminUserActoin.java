/**
 * 
 */
package cn.com.grocery.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.testng.collections.Maps;

import cn.com.grocery.common.Pager;
import cn.com.grocery.domain.AdminUser;
import cn.com.grocery.service.AdminUserManageService;
import cn.com.grocery.vo.AdminUserVO;

/**
 * @author karl
 *
 *
 */
@Controller
@RequestMapping(value = { "/admin/console/user" })
public class AdminUserActoin {

	@Autowired
	private AdminUserManageService adminUserManageService;
	private static final int CONST_USERNAME_MAX_SIZE = 15;

	@RequestMapping(value = { "/manage" })
	public ModelAndView manage() {
		ModelAndView result = new ModelAndView("/admin/console/user/list");
		Pager pager = new Pager();
		pager.setHql("from AdminUser ");
		Map<String, Object> param = Maps.newHashMap();
		pager.setCount(adminUserManageService.count(null, param));
		List<AdminUser> users = adminUserManageService.listUser(pager, param);
		List<AdminUserVO> data = new ArrayList<AdminUserVO>();
		for (AdminUser adminUser : users) {
			AdminUserVO vo = new AdminUserVO();
			vo.initFromUser(adminUser);
			data.add(vo);
		}
		result.addObject("users", data);
		result.addObject("pager", pager);
		return result;
	}

	@RequestMapping(value = { "/add" })
	public ModelAndView add(HttpServletRequest request) {
		ModelAndView result = new ModelAndView("/admin/console/user/add");
		setToken(result, request);
		return result;
	}

	private void setToken(ModelAndView result, HttpServletRequest request) {
		String token = DigestUtils.md5Hex(String.valueOf(System.currentTimeMillis()));
		(((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession())
				.setAttribute("se_user_token", token);
		result.addObject("user_token", token);
	}

	@RequestMapping("/list")
	public ResponseEntity<List<AdminUserVO>> list(HttpServletRequest request, HttpServletResponse response,
			Pager pager) {
		Map<String, Object> param = Maps.newHashMap();
		pager.setHql("from AdminUser ");
		List<AdminUser> users = adminUserManageService.listUser(pager, param);
		List<AdminUserVO> data = new ArrayList<AdminUserVO>();
		for (AdminUser adminUser : users) {
			AdminUserVO vo = new AdminUserVO();
			vo.initFromUser(adminUser);
			data.add(vo);
		}
		ResponseEntity<List<AdminUserVO>> result = new ResponseEntity<List<AdminUserVO>>(data, HttpStatus.OK);
		return result;
	}

	@RequestMapping("/save")
	public ModelAndView saveUser(HttpServletRequest request, HttpServletResponse response, AdminUserVO user,
			String userToken) {
		ModelAndView result = new ModelAndView();
		StringBuilder ermsgSb = new StringBuilder();
		Object sesToken = request.getSession().getAttribute("se_user_token");
		if (!StringUtils.equals(sesToken == null ? null : sesToken.toString(), userToken))
			ermsgSb.append("请勿重复提交。");
		if (StringUtils.isBlank(user.getUserName()) || user.getUserName().length() > CONST_USERNAME_MAX_SIZE)
			ermsgSb.append("用户不能为空/不合法。");
		if (StringUtils.isBlank(user.getDisplayName()) || user.getDisplayName().length() > CONST_USERNAME_MAX_SIZE)
			ermsgSb.append("显示名称不能为空/不合法。");
		if (StringUtils.isBlank(user.getPassword()))
			ermsgSb.append("密码不能为空。");
		if (!EmailValidator.getInstance().isValid(user.getEmail()))
			ermsgSb.append("email不合法。");
		if (ermsgSb.length() > 0) {
			result.setViewName("/admin/console/user/add");
			setToken(result, request);
			result.addObject("error_msg", ermsgSb.toString());
		} else {
			AdminUser u = new AdminUser();
			user.initToUser(u);
			u.setPassword(adminUserManageService.securePassword(u.getPassword()));
			adminUserManageService.saveUser(u);
			result.setViewName("/admin/console/user/add");
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(DigestUtils.md5Hex("admin" + "admin".hashCode()));
	}

	@RequestMapping("/delete")
	public ResponseEntity<AdminUserVO> delete(HttpServletRequest request, HttpServletResponse response,
			AdminUserVO user) {

		return null;
	}

	@RequestMapping("/update")
	public ResponseEntity<AdminUserVO> update(HttpServletRequest request, HttpServletResponse response,
			AdminUserVO user) {

		return null;
	}

}
