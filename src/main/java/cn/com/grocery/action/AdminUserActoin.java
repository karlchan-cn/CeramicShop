/**
 * 
 */
package cn.com.grocery.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.grocery.vo.AdminUserVO;

/**
 * @author karl
 *
 *
 */
@RequestMapping(value = { "/admin/user" })
public class AdminUserActoin {
	@RequestMapping(value = { "/manage" })
	public ModelAndView manage() {
		ModelAndView result = new ModelAndView("");
		return result;
	}

	@RequestMapping("list")
	public ResponseEntity<AdminUserVO> list(HttpServletRequest request, HttpServletResponse response) {
		ResponseEntity<AdminUserVO> result = new ResponseEntity<AdminUserVO>(HttpStatus.OK);
		return result;
	}

}
