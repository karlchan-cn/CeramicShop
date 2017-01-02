/**
 * 
 */
package cn.com.grocery.action;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;

import cn.com.grocery.admin.vo.UploadItemVo;

/**
 * @author karl
 *
 *
 */
@Controller
@RequestMapping(value = { "/admin/console/common" })
public class CommonUploadActoin {
	private static final int CONST_USER_ICON_WIDTH = 500;
	private static final int CONST_USER_ICON_HEIGHT = 600;
	private static final Logger LOG = LoggerFactory.getLogger(CommonUploadActoin.class);

	@RequestMapping(value = { "/image/view" })
	public String getTempImage(HttpServletRequest request, HttpServletResponse response, String name) {
		try {
			response.getOutputStream().write(Files.readAllBytes(Paths.get("/upload/" + name)));
		} catch (IOException e) {
			LOG.error(String.format("view temporary file:%s got error:%s", name, e.getMessage()), e);
		}

		return null;
	}

	@RequestMapping(value = { "/upload/user/icon" })
	@ResponseBody
	public String manage(HttpServletRequest request, HttpServletResponse response,
			@RequestParam MultipartFile[] files) {
		JSONArray result = new JSONArray();
		if (files != null && files.length != 0) {
			String realPath = "/upload";
			for (MultipartFile file : files) {
				String fullName = file.getOriginalFilename();
				String name = FilenameUtils.getBaseName(fullName);
				String ext = FilenameUtils.getExtension(fullName);
				String savedName = System.currentTimeMillis() + StringUtils.substring(name, 0, 5)
						+ FilenameUtils.EXTENSION_SEPARATOR_STR + ext;
				InputStream ips = null;
				// 这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉，我是看它的源码才知道的
				try {
					ips = file.getInputStream();
					BufferedImage image = scale(ips, BufferedImage.TYPE_INT_RGB, CONST_USER_ICON_WIDTH,
							CONST_USER_ICON_HEIGHT, 1d, 1d);
					ImageIO.write(image, "jpeg", new File(realPath, savedName));
				} catch (Exception e) {
					LOG.error("error:{}|{}", ToStringBuilder.reflectionToString(file), e.getMessage());
				} finally {
					if (ips != null) {
						try {
							ips.close();
						} catch (IOException e) {

						}
					}
				}
				UploadItemVo vo = new UploadItemVo();
				vo.setName(name);
				vo.setSavedName(savedName);
				vo.setSize(file.getSize());
				result.add(vo);
			}
		}
		return result.toJSONString();
	}

	/**
	 * scale image
	 * 
	 * @param sbi
	 *            image to scale
	 * @param imageType
	 *            type of image
	 * @param dWidth
	 *            width of destination image
	 * @param dHeight
	 *            height of destination image
	 * @param fWidth
	 *            x-factor for transformation / scaling
	 * @param fHeight
	 *            y-factor for transformation / scaling
	 * @return scaled image
	 */
	public static BufferedImage scale(InputStream ips, int imageType, int dWidth, int dHeight, double fWidth,
			double fHeight) {
		BufferedImage dbi = null;
		if (ips != null) {
			dbi = new BufferedImage(dWidth, dHeight, imageType);
			Graphics2D g = dbi.createGraphics();
			AffineTransform at = AffineTransform.getScaleInstance(fWidth, fHeight);
			try {
				g.drawRenderedImage(ImageIO.read(ips), at);
			} catch (IOException e) {
				LOG.error("reder image file got error:{}", e.getMessage());
				return null;
			}
		}
		return dbi;
	}
}
