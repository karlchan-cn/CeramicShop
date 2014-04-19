/**
 * 
 */
package cn.com.kc.blog.controller.service.impl;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.kc.blog.bl.service.IBlogImageService;
import cn.com.kc.blog.common.util.CommonControllerUtils;
import cn.com.kc.blog.common.util.DataTableUtility;
import cn.com.kc.blog.commondao.pagination.impl.PageRequestImpl;
import cn.com.kc.blog.commondao.pagination.service.Page;
import cn.com.kc.blog.commondao.pagination.service.PageRequest;
import cn.com.kc.blog.pojo.BlogImage;

import com.alibaba.fastjson.JSONObject;

/**
 * @author karl
 * 
 */
@Controller(value = "cn.com.kc.blog.controller.service.impl.BlogImageController")
@RequestMapping("/imagemanage")
public class BlogImageController {

	/**
	 * 
	 */
	public BlogImageController() {
		// TODO Auto-generated constructor stub
	}

	@Resource(name = "cn.com.kc.blog.bl.service.IBlogImageService")
	private IBlogImageService blogImageService;

	public IBlogImageService getBlogImageService() {
		return blogImageService;
	}

	public void setBlogImageService(IBlogImageService blogImageService) {
		this.blogImageService = blogImageService;
	}

	@RequestMapping("/delimage")
	@ResponseBody
	public String delImage(HttpServletRequest request,
			@RequestParam("imageId") Long imageId,
			@RequestParam("imageName") String imageName) {
		// delete image file
		final String updatedFileLoc = CommonControllerUtils
				.getUploadDir(request);
		new File(updatedFileLoc + BlogImageControllerConst.CONST_STR_THUMB
				+ imageName).delete();
		new File(updatedFileLoc + imageName).delete();
		// del database record;
		getBlogImageService().delImage(imageId);
		return null;
	}

	/**
	 * get the paged data according to page request
	 * 
	 * @return listed paged data.
	 */
	@RequestMapping("/getpaginatedimages")
	@ResponseBody
	public ResponseEntity<String> getPaginatedImages(
			final HttpServletRequest request) {
		// if do not privide page request,insance a default page request with
		// page size of 10 and page number of 1
		PageRequest pageRequestImpl = null;
		if (pageRequestImpl == null) {
			pageRequestImpl = new PageRequestImpl(
					PageRequest.DEFAULT_PAGENUMBER,
					PageRequest.DEFAULT_PAGESIZE);
			pageRequestImpl = DataTableUtility.extractRequstParameters(request);
		}
		// request user's entity list
		final Page<BlogImage> page = blogImageService
				.getPaginatedImages(pageRequestImpl);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(ControllerImplConst.CONST_RESPONSEATTRNAME_PAGE, page);
		jsonObject.toJSONString();
		return BlogControllerHelper.getResponseEntity(DataTableUtility
				.assembleTableData(page).toJSONString());
	}

}
