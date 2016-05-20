/**
 * 
 */
package cn.com.grocery.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
@RequestMapping( value = { "/admin/user" } )
public class AdminUserActoin {

	@Autowired
	private AdminUserManageService adminUserManageService;

	@RequestMapping( value = { "/manage" } )
	public ModelAndView manage() {
		ModelAndView result = new ModelAndView( "" );
		return result;
	}

	@RequestMapping( "/list" )
	public ResponseEntity<List<AdminUserVO>> list( HttpServletRequest request, HttpServletResponse response, Pager pager ) {
		List<AdminUser> users = adminUserManageService.listUser( pager );
		List<AdminUserVO> data = new ArrayList<AdminUserVO>();
		for( AdminUser adminUser : users ) {
			AdminUserVO vo = new AdminUserVO();
			vo.initFromUser( adminUser );
		}
		ResponseEntity<List<AdminUserVO>> result = new ResponseEntity<List<AdminUserVO>>( data, HttpStatus.OK );
		return result;
	}

	@RequestMapping( "/save" )
	public ResponseEntity<AdminUserVO> saveUser( HttpServletRequest request, HttpServletResponse response, AdminUserVO user ) {

		return null;
	}

	@RequestMapping( "/delete" )
	public ResponseEntity<AdminUserVO> delete( HttpServletRequest request, HttpServletResponse response, AdminUserVO user ) {

		return null;
	}

	@RequestMapping( "/update" )
	public ResponseEntity<AdminUserVO> update( HttpServletRequest request, HttpServletResponse response, AdminUserVO user ) {

		return null;
	}

}
