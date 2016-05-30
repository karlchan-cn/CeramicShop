/**
 * 
 */
package cn.com.grocery.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.grocery.common.Pager;
import cn.com.grocery.vo.AdminUserVO;
import cn.com.grocery.vo.GroceryEntityVO;

/**
 * @author karl
 *
 */
@RequestMapping(value = { "/admin/console/entity" })
@Controller
public class GroceryEntityAction {

	private static final Logger LOG = LoggerFactory.getLogger(GroceryEntityAction.class);

	@RequestMapping(value = { "/add", "/edit" })
	public ModelAndView add() {
		ModelAndView result = new ModelAndView("/admin/console/entity/add");
		Pager pager = new Pager();
		return result;
	}

	@RequestMapping("/save")
	public ResponseEntity<AdminUserVO> saveEntity(HttpServletRequest request, HttpServletResponse response,
			GroceryEntityVO vo) {
		return null;
	}
}
