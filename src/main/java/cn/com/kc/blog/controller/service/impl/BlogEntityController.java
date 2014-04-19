/**
 * 
 */
package cn.com.kc.blog.controller.service.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.kc.blog.bl.service.IBlogEntityService;
import cn.com.kc.blog.bl.service.IBlogImageService;
import cn.com.kc.blog.common.util.CommonControllerUtils;
import cn.com.kc.blog.common.util.CommonUtils;
import cn.com.kc.blog.commondao.pagination.impl.PageRequestImpl;
import cn.com.kc.blog.commondao.pagination.service.Page;
import cn.com.kc.blog.commondao.pagination.service.PageRequest;
import cn.com.kc.blog.pojo.BlogEntity;
import cn.com.kc.blog.pojo.BlogEntityConst;
import cn.com.kc.blog.pojo.BlogImage;
import cn.com.kc.blog.pojo.BlogUser;
import cn.com.kc.blog.userauthenfilter.impl.CustomedAuthenticateConst;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mortennobel.imagescaling.AdvancedResizeOp;
import com.mortennobel.imagescaling.ResampleFilters;
import com.mortennobel.imagescaling.ResampleOp;

/**
 * @author chenjinlong2
 * 
 */
@Controller(value = "cn.com.kc.blog.controller.service.impl.BlogEntityController")
@RequestMapping("/entity")
public class BlogEntityController {
/**
 * get user infor if login successfully
 * 
 * @return
 */
private BlogUser getCurrentLoginSuccessUser() {
	BlogUser user = (BlogUser) CommonUtils
					.getRequest()
					.getSession()
					.getAttribute(
									CustomedAuthenticateConst.CONST_BLOG_USER_ATTRIBUTE);
	if (user == null) {
		throw new RuntimeException("请登录。");
	}
	return user;
}

/**
 * entity.jsp
 */
public static final String CONST_ENTITY_PAGE = "entity";
public static final String CONST_VIEW_ENTITY_PAGE = "viewentity";
public static final String CONST_IMAGES_COUNT = "image-count";
public static final String CONST_IMAGES_SIZE = "image-size";
public static final String CONST_RET_ERROR = "error";
public static final String CONST_RET_ERROR_MSG = "errorMsg";
public static final String CONST_RET_IMGLIST = "imagelist";
public static final String CONST_ERRORMSG_OULCOUNT = "一次只允许上传20张图片。";
public static final String CONST_ERRORMSG_OULSIZE = "一次只允许上传5Mb图片。";
public static final String CONST_UL_ACTION_INIT = "init";
public static final String CONST_UL_ACTION_CLEAR = "clear";
public static final String CONST_REQUESTATTRIBUTENAME_ENTITY = "entity";
public static final String CONST_RESPONSEATTRNAME_ENTITYLIST = "entitylist";
public static final String CONST_RESPONSEATTRNAME_PAGE = "page";
public static final String CONST_REQUESTATTRIBUTENAME_ENTITY_JSON = "entityjson";
public static final String CONST_ALL = "all";
public static final BigDecimal CONST_MAX_UPLOAD_SIZE = new BigDecimal(
				1024 * 1024 * 5);
/**
 * high image quality is important.
 */
private static float JPEG_QUALITY_HIGH = 1.0f;
/**
 * entity's image thumbnail width;
 */
private static int JEPG_WIDTH_ENTITY_IMAGE = 120;
/**
 * entity's image thumbnail high;
 */
private static int JEPG_HIGH_ENTITY_IMAGE = 90;
/**
 * thumb string constant.
 */
private static String CONST_STR_THUMB = "thumb";

/**
 * entity's image thumbnail width;
 */
private static int JEPG_WIDTH_ENTITY_IMAGE_RAW = 600;
/**
 * entity's image thumbnail high;
 */
private static int JEPG_HIGH_ENTITY_IMAGE_RAW = 450;

/**
 * json mapper
 */
private static final ObjectMapper mapper = new ObjectMapper();
/**
		 * 
		 */
@Resource(name = "cn.com.kc.blog.bl.service.IBlogEntityService")
private IBlogEntityService blogEntityService;
@Resource(name = "cn.com.kc.blog.bl.service.IBlogImageService")
private IBlogImageService blogImageDaoService;

public IBlogImageService getBlogImageDaoService() {
	return blogImageDaoService;
}

public void setBlogImageDaoService(IBlogImageService blogImageDaoService) {
	this.blogImageDaoService = blogImageDaoService;
}

/**
 * 
 * @return
 */
public IBlogEntityService getBlogEntityService() {
	return blogEntityService;
}

/**
 * 
 * @param blogEntityService
 */
public void setBlogEntityService(final IBlogEntityService blogEntityService) {
	this.blogEntityService = blogEntityService;
}

/**
 * 
 * @return
 */
public IBlogEntityService getUserService() {
	return blogEntityService;
}

/**
 * 
 * @param newblogEntityService
 */
@Resource(name = "cn.com.kc.blog.bl.service.IBlogEntityService")
public void setUserService(final IBlogEntityService newblogEntityService) {
	this.blogEntityService = newblogEntityService;
}

@RequestMapping("/create")
public ModelAndView createEntity() {
	// load the temperay
	ModelAndView modelAndView = new ModelAndView();
	modelAndView.setViewName(CONST_ENTITY_PAGE);
	final BlogUser user = getCurrentLoginSuccessUser();
	BlogEntity entity = blogEntityService.getTempEntity(user);
	if (entity.getId() == null) {
		// detached object, as session is closed and to avoid to-json method
		// cause the hibernate's seesion error,so here it createa a entity
		// and copies saved properties from the detached object.
		entity = createTempEntity(user, entity);
		BlogEntity tempEntity = new BlogEntity();
		tempEntity.setId(entity.getId());
		tempEntity.setIsTemp(entity.getIsTemp());
		tempEntity.setCreatedate(entity.getCreatedate());
		tempEntity.setCommentable(entity.getCommentable());
		tempEntity.setReadprivate(entity.getReadprivate());
		entity = tempEntity;
		tempEntity = null;
	}
	// construct the return json object.
	modelAndView.getModelMap().put(CONST_REQUESTATTRIBUTENAME_ENTITY,
					entity);
	BlogEntity entityJson = new BlogEntity();
	entityJson.setId(entity.getId());
	entityJson.setTitle(entity.getTitle());
	entityJson.setContent(entity.getContent());
	entityJson.setReadprivate(entity.getReadprivate());
	entityJson.setCommentable(entity.getCommentable());
	entityJson.setCreatedate(entity.getCreatedate());
	entityJson.setIsTemp(entity.getIsTemp());
	entityJson.setImages(entity.getImages());
	modelAndView.getModelMap().put(CONST_REQUESTATTRIBUTENAME_ENTITY_JSON,
					JSON.toJSONString(entity));
	return modelAndView;
}

/**
 * 
 * @param user
 * @param entity
 */
public BlogEntity createTempEntity(final BlogUser user,
				final BlogEntity entity) {
	entity.setIsTemp(true);
	entity.setCreatedate(new Timestamp(Calendar.getInstance()
					.getTimeInMillis()));
	entity.setCommentable(true);
	entity.setReadprivate(BlogEntityConst.CONSTR_READ_PRATE_ALL);
	return (BlogEntity) blogEntityService.saveEntity(user, entity);
}

/**
 * view entity with entity id;
 * 
 * @param entityId
 *            entity id;
 * @return model and view
 */
@RequestMapping("/view/{entityId}")
public ModelAndView viewEntity(@PathVariable final String entityId) {
	// load the temperay
	ModelAndView modelAndView = new ModelAndView();
	modelAndView.setViewName(CONST_VIEW_ENTITY_PAGE);
	if (CONST_ALL.equals(entityId)) {
		modelAndView
						.addObject(CONST_REQUESTATTRIBUTENAME_ENTITY, CONST_ALL);
	} else {
		final BlogEntity entity = blogEntityService.getEntityAndImagesById(Long
						.valueOf(entityId));
		entity.setContent(getDisplayedContent(entity.getContent(),
						entity.getImages()));
		modelAndView.addObject(CONST_REQUESTATTRIBUTENAME_ENTITY, entity);
	}
	return modelAndView;
}

/**
 * get the paged data according to page request
 * 
 * @return listed paged data.
 */
@RequestMapping("getpagedentities")
@ResponseBody
public ResponseEntity<String> getPagedEntityData(
				@RequestParam("userid") final Long userId,
				PageRequestImpl pageRequestImpl,
				@RequestParam("entityid") final String entity) {
	// if do not privide page request,insance a default page request with
	// page size of 10 and page number of 1
	if (pageRequestImpl == null) {
		pageRequestImpl = new PageRequestImpl(
						PageRequest.DEFAULT_PAGENUMBER,
						PageRequest.DEFAULT_PAGESIZE);
	}
	// request user's entity list
	final Page<BlogEntity> page = blogEntityService
					.getBasePagedEntityDataByParam(pageRequestImpl,
									new Object[] { userId });
	JSONObject jsonObject = new JSONObject();
	jsonObject.put(CONST_RESPONSEATTRNAME_PAGE, page);
	ResponseEntity<String> responseEntity = new ResponseEntity<String>(
					jsonObject.toJSONString(),
					CommonUtils.getHttpHeadersByType(""), HttpStatus.CREATED);
	return responseEntity;
}

/**
 * 
 * @return
 */

public ModelAndView viewEntities() {
	return null;
}

/**
 * 获取当前上传数量-get current uploaded image count / upload window.
 * 
 * @param session
 *            session对象.
 * @return 数量-count
 */
private Integer getCurrentUploadedCount(HttpSession session) {
	// 初始化获取当前上传文件总数量
	Integer imageCount = (Integer) session.getAttribute(CONST_IMAGES_COUNT);
	if (imageCount == null) {
		imageCount = 0;
	}
	return imageCount;
}

/**
 * creat and save image thumbnail use java-image-scaling library.
 * 
 * @param sourceFile
 *            source file location
 * @param destFile
 *            desctination file location
 * @param width
 *            specified width of the thumbnail
 * @param height
 *            specified high of the thumbnail
 * @throws IOException
 *             any io exception;
 */
private void scaleAndSaveImageWithJImage(String sourceFile,
				String destFile, int width, int height) throws IOException {
	BufferedImage sourceImage = ImageIO.read(new File(sourceFile));
	ResampleOp resampleOp = new ResampleOp(width, height);
	resampleOp.setFilter(ResampleFilters.getLanczos3Filter());
	resampleOp.setUnsharpenMask(AdvancedResizeOp.UnsharpenMask.Normal);
	BufferedImage destImage = resampleOp.filter(sourceImage, null);
	writeJpeg(destImage, destFile, JPEG_QUALITY_HIGH);
}

/**
 * creat and save image thumbnail use java-image-scaling library.
 * 
 * @param sourceFile
 *            source file location
 * @param destFile
 *            desctination file location
 * @param width
 *            specified width of the thumbnail
 * @param height
 *            specified high of the thumbnail
 * @throws IOException
 *             any io exception;
 */
private void scaleAndSaveImageWithJImage(final InputStream fileis,
				String destFile, int width, int height) throws IOException {
	BufferedImage sourceImage = ImageIO.read(fileis);
	ResampleOp resampleOp = new ResampleOp(width, height);
	resampleOp.setFilter(ResampleFilters.getLanczos3Filter());
	resampleOp.setUnsharpenMask(AdvancedResizeOp.UnsharpenMask.Normal);
	BufferedImage destImage = resampleOp.filter(sourceImage, null);
	writeJpeg(destImage, destFile, JPEG_QUALITY_HIGH);
}

/**
 * Write a JPEG file setting the compression quality.
 * 
 * @param image
 *            a BufferedImage to be saved
 * @param destFile
 *            destination file (absolute or relative path)
 * @param quality
 *            a float between 0 and 1, where 1 means uncompressed.
 * @throws IOException
 *             in case of problems writing the file
 */
private void writeJpeg(BufferedImage image, String destFile, float quality)
	throws IOException {
	ImageWriter writer = null;
	FileImageOutputStream output = null;
	try {
		writer = ImageIO.getImageWritersByFormatName("jpeg").next();
		ImageWriteParam param = writer.getDefaultWriteParam();
		param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
		param.setCompressionQuality(quality);
		output = new FileImageOutputStream(new File(destFile));
		writer.setOutput(output);
		IIOImage iioImage = new IIOImage(image, null, null);
		writer.write(null, iioImage, param);
	} catch (IOException ex) {
		throw ex;
	} finally {
		if (writer != null)
			writer.dispose();
		if (output != null)
			output.close();
	}
}

@RequestMapping("/saveimagefile")
@ResponseBody
@SuppressWarnings("unchecked")
public ResponseEntity<String> saveImageFile(HttpServletRequest request,
				HttpServletResponse response, HttpSession httpSession) {
	JsonFactory jsonFactory = new JsonFactory();
	// 初始化获取当前上传文件总数量
	Integer uploadedCount = getCurrentUploadedCount(httpSession);
	final Map<String, Object> retVal = new HashMap<String, Object>();
	final BlogImage blogImage = new BlogImage();
	List<BlogImage> imageList = new ArrayList<BlogImage>();
	imageList.add(blogImage);
	DiskFileItemFactory factory = new DiskFileItemFactory();
	ServletFileUpload upload = new ServletFileUpload(factory);
	List<FileItem> items = null;
	// if over 20 images upload, return false-如果上传超过20张,直接返回false.
	if (uploadedCount >= 20) {
		retVal.put(CONST_RET_ERROR, Boolean.TRUE);
		retVal.put(CONST_RET_ERROR_MSG, CONST_ERRORMSG_OULCOUNT);
	} else {
		try {
			// 增加文件数量
			uploadedCount++;
			items = upload.parseRequest(request);
			Iterator<FileItem> iterator = items.iterator();
			FileItem item = null;
			final String uploadDir = CommonControllerUtils
							.getUploadDir(request);
			while (iterator.hasNext()) {
				item = iterator.next();
				if (!item.isFormField()) {
					// to-do 判断文件时图片文件 该次上传的文件数量不超过 20张, 判断该次上传文件长度不超过5mb
					// 判断文件大小是否超过最大上限
					if (CONST_MAX_UPLOAD_SIZE.subtract(
									BigDecimal.valueOf(item.getSize())).longValue() < 0L) {
						retVal.put(CONST_RET_ERROR, Boolean.TRUE);
						retVal.put(CONST_RET_ERROR_MSG,
										CONST_ERRORMSG_OULSIZE);
						break;
					}
					String fileName = String.valueOf(System
									.currentTimeMillis()) + item.getName();
					String imageDesPath = uploadDir + fileName;
					blogImage.setName(fileName);
					blogImage.setShowName(item.getName());
					blogImage.setSize(item.getSize());
					// save the large image
					scaleAndSaveImageWithJImage(item.getInputStream(),
									imageDesPath, JEPG_WIDTH_ENTITY_IMAGE_RAW,
									JEPG_HIGH_ENTITY_IMAGE_RAW);
					// save the thunmbnail
					scaleAndSaveImageWithJImage(imageDesPath, uploadDir
																+ CONST_STR_THUMB + fileName,
									JEPG_WIDTH_ENTITY_IMAGE, JEPG_HIGH_ENTITY_IMAGE);
					// Image image =
				} else if ("tempid".equals(item.getFieldName())) {
					blogImage.setTempid(Long.valueOf(item.getString()));
				} else if ("entity".equals(item.getFieldName())) {
					JsonParser jp = jsonFactory.createJsonParser(item
									.getString());
					blogImage.setEntity(mapper.readValue(jp,
									BlogEntity.class));
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	if (!Boolean.TRUE.equals(retVal.get(CONST_RET_ERROR))) {
		blogImageDaoService.saveImage(blogImage);
	}
	// 用此类构造字符串
	StringWriter w = new StringWriter();
	retVal.put(CONST_RET_IMGLIST, imageList);
	try {
		mapper.writeValue(w, retVal);
	} catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException(e);
	}
	ResponseEntity<String> responseEntity = new ResponseEntity<String>(
					w.toString(), CommonUtils.getHttpHeadersByType(""),
					HttpStatus.CREATED);
	return responseEntity;
}

/**
 * 弹出上传窗口时初始化本次上传数量Session信息
 * 
 * @param action
 * @param request
 * @param httpSession
 */
@RequestMapping("/inituploadinfo")
@ResponseBody
public void initUploadinfo(@ModelAttribute("action") final String action,
				final HttpServletRequest request, final HttpSession httpSession) {
	httpSession.setAttribute(CONST_IMAGES_COUNT, 0);
}

@RequestMapping("/remove/{entityId}")
@ResponseBody
public String delEntity(@PathVariable("entityId") final Long entityId) {
	try {
		blogEntityService.delEntity(blogEntityService
						.getEntityById(entityId));
	} catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException(e);
	}

	return null;
}

/**
 * 
 * @return
 */
@RequestMapping("/publishEntity")
@ResponseBody
public BlogEntity publishEntity(
				@RequestParam("entity") final String entity,
				@RequestParam("imagesList") final String imagesList,
				HttpServletRequest request, HttpServletResponse response) {
	// ModelAndView retVal = new ModelAndView();
	BlogEntity blogEntity = null;
	try {
		blogEntity = mapper.readValue(entity, BlogEntity.class);
		blogEntity.setIsTemp(Boolean.FALSE);
		// ArrayList<BlogImage> imageArrayList = (ArrayList<BlogImage>)
		// JSON.parseArray(imagesList, BlogImage.class);
		// blogEntity.setContent(getDisplayedContent(blogEntity.getContent(),
		// imageArrayList));
		blogEntityService.updatePublished(blogEntity);
	} catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException(e);
	}

	return blogEntity;
}

/**
 * update blog entity.
 * 
 * @param entity
 *            entity to be updated.
 * @param request
 *            current wrapped request
 * @param response
 *            current wrapped response
 * @return updated entity
 */
@RequestMapping("/updateEntity")
@ResponseBody
public BlogEntity updateEntity(@RequestParam("entity") final String entity,
				HttpServletRequest request, HttpServletResponse response) {
	BlogEntity retVal = null;
	try {
		retVal = mapper.readValue(entity, BlogEntity.class);
		final BlogUser user = getCurrentLoginSuccessUser();
		retVal.setCreatedate(new Timestamp(Calendar.getInstance()
						.getTimeInMillis()));
		getBlogEntityService().updateEntity(retVal, user);
	} catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException(e);
	}
	return retVal;
}

@RequestMapping("/edit/{entityId}")
public ModelAndView editEntity(@PathVariable("entityId") final Long entityId) {
	final ModelAndView modelAndView = new ModelAndView();
	modelAndView.setViewName(CONST_ENTITY_PAGE);
	BlogEntity entity = blogEntityService.getEntityById(entityId);
	modelAndView.getModelMap().put(CONST_REQUESTATTRIBUTENAME_ENTITY_JSON,
					JSON.toJSONString(entity));
	modelAndView.getModelMap().put(CONST_REQUESTATTRIBUTENAME_ENTITY,
					entity);
	return modelAndView;
}

/**
 * parse content to show-type.
 * 
 * @param previewContent
 *            content
 * @param imageArrayList
 *            images
 * @return parsed content
 */
private String getDisplayedContent(String previewContent,
				final List<BlogImage> imageArrayList) {
	previewContent = previewContent.replaceAll("&", "&amp;");
	previewContent = previewContent.replaceAll("<", "&lt;");
	previewContent = previewContent.replaceAll(">", "&gt;");
	previewContent = previewContent.replaceAll("\"", "&quot;");
	previewContent = previewContent.replaceAll("\n", "<br>");
	int i = 1;
	for (BlogImage currentImage : imageArrayList) {
		previewContent = previewContent
						.replaceAll(
										"&lt;图片" + i + "&gt;",
										"<div class='image-thumb'><img alt='图片"
														+ i
														+ "' src='http://localhost:8081/Blog/assets/images/"
														+ currentImage.getName()
														+ "'><label class='imagedescription'>"
														+ (currentImage.getDescription() == null ? ""
																		: currentImage.getDescription())
														+ "</label></div>");
		i++;
	}
	return previewContent;
}

@RequestMapping("/editepreviewcontent")
@ResponseBody
public ResponseEntity<String> editePreviewContent(
				@RequestParam("previewContent") String previewContent,
				@RequestParam("imagesList") final String imagesList) {
	HashMap<String, String> retVal = new HashMap<String, String>();
	ArrayList<BlogImage> imageArrayList = (ArrayList<BlogImage>) JSON
					.parseArray(imagesList, BlogImage.class);
	retVal.put("content",
					getDisplayedContent(previewContent, imageArrayList));
	ResponseEntity<String> responseEntity = new ResponseEntity<String>(
					JSON.toJSONString(retVal),
					CommonUtils.getHttpHeadersByType(""), HttpStatus.OK);
	return responseEntity;
}
}
// to do 保存图片,删除图片,控制上传窗口的状态.