/**
 * 
 */
package cn.com.kc.blog.controller.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.kc.blog.bl.service.IBlogAdminMgrService;

/**
 * @author karl
 * 
 */
@Controller(value = "cn.com.kc.blog.controller.service.impl.BlogAdminMgrController")
@RequestMapping("/admin")
public class BlogAdminMgrController {
@Resource(name = "cn.com.kc.blog.bl.service.IBlogAdminMgrService")
private IBlogAdminMgrService blogAdminMgrService;
final public static String ADMININDEX = "adminIndex";

@RequestMapping("/index")
public ModelAndView adminIndex() {
	final ModelAndView modelAndView = new ModelAndView();
	modelAndView.setViewName(ADMININDEX);
	return modelAndView;
}

@RequestMapping("/uploadfile")
@ResponseBody
public ResponseEntity<String> uploadFile(HttpServletRequest request,
				HttpServletResponse response, HttpSession httpSession) {
	return blogAdminMgrService.saveUploadFile(request, response);
}
}
