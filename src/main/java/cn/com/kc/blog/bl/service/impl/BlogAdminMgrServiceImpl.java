/**
 * 
 */
package cn.com.kc.blog.bl.service.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mortennobel.imagescaling.AdvancedResizeOp;
import com.mortennobel.imagescaling.ResampleFilters;
import com.mortennobel.imagescaling.ResampleOp;

import cn.com.kc.blog.bl.service.IBlogAdminMgrService;
import cn.com.kc.blog.bl.service.IBlogImageService;
import cn.com.kc.blog.common.util.CommonControllerUtils;
import cn.com.kc.blog.common.util.CommonUtils;
import cn.com.kc.blog.pojo.BlogImage;

/**
 * @author kchen1
 * 
 */
@Service("cn.com.kc.blog.bl.service.IBlogAdminMgrService")
public class BlogAdminMgrServiceImpl implements IBlogAdminMgrService {

@Resource(name = "cn.com.kc.blog.bl.service.IBlogImageService")
private IBlogImageService blogImageDaoService;

public static final BigDecimal CONST_MAX_UPLOAD_SIZE = new BigDecimal(
				1024 * 1024 * 2);
public static final String CONST_ENTITY_PAGE = "entity";
public static final String CONST_VIEW_ENTITY_PAGE = "viewentity";
public static final String CONST_IMAGES_COUNT = "image-count";
public static final String CONST_IMAGES_SIZE = "image-size";
public static final String CONST_RET_ERROR = "error";
public static final String CONST_RET_ERROR_MSG = "errorMsg";
public static final String CONST_RET_IMGLIST = "imagelist";
public static final String CONST_RET_IMG = "image";
public static final String CONST_ERRORMSG_OULCOUNT = "一次只允许上传20张图片。";
public static final String CONST_ERRORMSG_OULSIZE = "文件不能超过2Mb";
public static final String CONST_ERRORMSG_NOTIMAGEFILE = "准允许上传图片文件。";
public static final String CONST_UL_ACTION_INIT = "init";
public static final String CONST_UL_ACTION_CLEAR = "clear";
public static final String CONST_REQUESTATTRIBUTENAME_ENTITY = "entity";
public static final String CONST_RESPONSEATTRNAME_ENTITYLIST = "entitylist";
public static final String CONST_RESPONSEATTRNAME_PAGE = "page";
public static final String CONST_REQUESTATTRIBUTENAME_ENTITY_JSON = "entityjson";
public static final String CONST_ALL = "all";
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
private static String CONST_STR_THUMB = "thumb_";

/**
 * json mapper
 */
private static final ObjectMapper mapper = new ObjectMapper();

/**
 * save image use java-image-scaling library.
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
private void scaleAndSaveImageWithJImage(final BufferedImage sourceImage,
				String destFile, int width, int height) throws IOException {
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

@SuppressWarnings("unchecked")
@Override
public ResponseEntity<String> saveUploadFile(HttpServletRequest request, HttpServletResponse response) {
	// todo 判断文件大小 保存文件
	final Map<String, Object> retVal = new HashMap<String, Object>();
	final BlogImage blogImage = new BlogImage();
	List<BlogImage> imageList = new ArrayList<BlogImage>();
	imageList.add(blogImage);
	final DiskFileItemFactory factory = new DiskFileItemFactory();
	final ServletFileUpload upload = new ServletFileUpload(factory);

	List<FileItem> items = null;
	// analyze request error
	try {
		items = upload.parseRequest(request);
		Iterator<FileItem> iterator = items.iterator();
		FileItem item = null;
		final String uploadDir = CommonControllerUtils
						.getUploadDir(request);
		while (iterator.hasNext()) {
			item = iterator.next();
			if (!item.isFormField()) {
				try {
					// 判断该次上传文件长度不超过2mb
					if (CONST_MAX_UPLOAD_SIZE.subtract(
									BigDecimal.valueOf(item.getSize())).longValue() < 0L) {
						retVal.put(CONST_RET_ERROR, Boolean.TRUE);
						retVal.put(CONST_RET_ERROR_MSG,
										CONST_ERRORMSG_OULSIZE);
						break;
					}
					String fileName = String.valueOf(System
									.currentTimeMillis() + "_" + item.getName());
					String imageDesPath = uploadDir + fileName;
					if (new File(uploadDir + item.getName()).exists()) {

					}
					blogImage.setName(fileName);
					blogImage.setShowName(item.getName());
					blogImage.setSize(item.getSize());
					blogImage.setCreateDate(new Timestamp(Calendar.getInstance().getTimeInMillis()));
					BufferedImage sourceImage = null;
					try {
						sourceImage = ImageIO.read(item.getInputStream());
					} catch (Exception e) {
						retVal.put(CONST_RET_ERROR, Boolean.TRUE);
						retVal.put(CONST_RET_ERROR_MSG,
										CONST_ERRORMSG_NOTIMAGEFILE);
						break;
					}
					// save the large image
					scaleAndSaveImageWithJImage(sourceImage,
									imageDesPath, sourceImage.getWidth(),
									sourceImage.getHeight());
					// save the thunmbnail
					scaleAndSaveImageWithJImage(sourceImage, uploadDir
																+ CONST_STR_THUMB + fileName,
									JEPG_WIDTH_ENTITY_IMAGE, JEPG_HIGH_ENTITY_IMAGE);
				} finally {
					// ensure the uploaded file would be removed.

					item.delete();
				}

			}

		}
	} catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException(e);
	}
	if (!Boolean.TRUE.equals(retVal.get(CONST_RET_ERROR))) {
		blogImageDaoService.saveImage(blogImage);
	}
	// 用此类构造字符串
	StringWriter w = new StringWriter();
	retVal.put(CONST_RET_IMG, blogImage);
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
}
