/**
 * 
 */
package cn.com.grocery.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.codec.digest.DigestUtils;
import org.codehaus.jackson.map.annotate.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.testng.collections.Maps;

import cn.com.grocery.admin.vo.AdminUserVO;
import cn.com.grocery.admin.vo.validator.AdminUserVOValidator;
import cn.com.grocery.common.ApiResult;
import cn.com.grocery.common.Pager;
import cn.com.grocery.domain.AdminUser;
import cn.com.grocery.service.AdminUserManageService;

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
	@Autowired()
	@Qualifier("messageSource")
	private MessageSource messageSource;
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

//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		binder.setValidator(new AdminUserVOValidator());
//	}

	@RequestMapping("/save")
	@JsonView(ApiResult.class)
	@ResponseBody
	public ApiResult<AdminUserVO> saveUser(HttpServletRequest request, HttpServletResponse response,
			@Valid @ModelAttribute AdminUserVO user, BindingResult bindingResult, String userToken) {
		ModelAndView result = new ModelAndView();
		StringBuilder ermsgSb = new StringBuilder();
		// TODO use other validate token framework
		// Object sesToken = request.getSession().getAttribute("se_user_token");
		// if (!StringUtils.equals(sesToken == null ? null :
		// sesToken.toString(), userToken))
		// ermsgSb.append("请勿重复提交。");
		//
		ApiResult<AdminUserVO> apiRet = new ApiResult<AdminUserVO>();
		if (bindingResult.getErrorCount() > 0) {
			result.setViewName("/admin/console/user/add");
			setToken(result, request);
			result.addObject("error_msg", bindingResult.getAllErrors().toString());
			//result.addObject("error_msg", ermsgSb.toString());
			//apiRet.setMessage(bindingResult.getAllErrors().toString());
			apiRet.setMessage("测试中文乱码");
			return apiRet;
		}

		AdminUser u = new AdminUser();
		user.initToUser(u);
		u.setPassword(adminUserManageService.securePassword(u.getPassword()));
		adminUserManageService.saveUser(u);
		result.setViewName("/admin/console/user/add");
		//return result;
		return null;
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
