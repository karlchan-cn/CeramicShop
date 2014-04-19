/**
 * 
 */
package cn.com.kc.blog.common.util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

/**
 * @author kchen1
 * 
 */
public final class CommonControllerUtils {
private CommonControllerUtils() {

}

/**
 * location to save image file.
 */
private static String UPLOAD_DIR = null;

/**
 * 
 * @param request
 * @return
 */
public static String getUploadDir(final HttpServletRequest request) {
	if (UPLOAD_DIR == null) {
		UPLOAD_DIR = request.getSession().getServletContext()
						.getRealPath("/")
						+ "WEB-INF/assets/upload/images/";
		// 初始化下载目录
		File uploadDir = new File(UPLOAD_DIR);
		if (!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
	}
	return UPLOAD_DIR;
}
}
