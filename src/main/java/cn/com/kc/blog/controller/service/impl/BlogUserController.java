/**
 * 
 */
package cn.com.kc.blog.controller.service.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.kc.blog.bl.service.IBlogUserService;
import cn.com.kc.blog.common.util.CommonUtils;
import cn.com.kc.blog.pojo.BlogUser;

import com.octo.captcha.service.CaptchaService;
import com.octo.captcha.service.CaptchaServiceException;

/**
 * @author chenjinlong2
 * 
 */
@Controller(value = "cn.com.kc.blog.controller.service.impl.BlogUserController")
@RequestMapping("/user")
public class BlogUserController {

private IBlogUserService userService;

private CaptchaService captchaService;
/**
 * content Type represent image.
 */
private static final String IMAGE_CONTENT_TYPE = "image/jpeg";

/**
 * 
 * @return
 */
public CaptchaService getCaptchaService() {
	return captchaService;
}

/**
 * 
 * @param captchaService
 */
@Resource(name = "jcaptchaService")
public void setCaptchaService(CaptchaService captchaService) {
	this.captchaService = captchaService;
}

public IBlogUserService getUserService() {
	System.out.println("");
	return userService;
}

@Resource(name = "cn.com.kc.blog.bl.service.IBlogUserService")
public void setUserService(final IBlogUserService userService) {
	this.userService = userService;
}

@RequestMapping("/validate")
@ResponseBody
public String validateUser(
				@Validated @ModelAttribute("user") final BlogUser user,
				final BindingResult result) {
	return result.toString();
}

@SuppressWarnings("restriction")
@RequestMapping(produces = MediaType.IMAGE_JPEG_VALUE, value = { "/securitycode" })
@ResponseBody
public ResponseEntity<byte[]> getSecurityCode(HttpServletRequest httpServletRequest,
				HttpServletResponse httpServletResponse, HttpSession httpSession) {
	// the output stream to render the captcha image as jpeg into
	ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
	ResponseEntity<byte[]> responseEntity = null;
	try {
		try {
			// get the session id that will identify the generated captcha.
			// the same id must be used to validate the response, the session id
			// is
			// a good candidate!
			String captchaId = httpServletRequest.getSession().getId();
			// call the ImageCaptchaService getChallenge method
			BufferedImage challenge =
							(BufferedImage) captchaService.getChallengeForID(captchaId,
											httpServletRequest.getLocale());

			// a jpeg encoder
			ImageIO.write(challenge, "JPEG", jpegOutputStream);
		} catch (IllegalArgumentException e) {
			httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		} catch (CaptchaServiceException e) {
			httpServletResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return null;
		}
		responseEntity = new ResponseEntity<byte[]>(
						jpegOutputStream.toByteArray(),
						CommonUtils.getHttpHeadersByType(MediaType.IMAGE_JPEG_VALUE),
						HttpStatus.OK);
		return responseEntity;
	} catch (Exception e) {
		throw new RuntimeException("生成验证码报错!");
	}
}

@RequestMapping(value = { "/login" })
public String signin(HttpSession session, HttpServletRequest httpServletRequest) {
	// security validate exception message key stored in session.
	final String excpetionSessionKey = AbstractAuthenticationProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY;
	// get the expcetion.
	final Exception expception = ((Exception) session
					.getAttribute(excpetionSessionKey));
	if (expception != null) {
		// set the message in request,remove exception stored in Session
		final String message = expception.getMessage();
		session.removeAttribute(excpetionSessionKey);
		httpServletRequest.setAttribute(excpetionSessionKey, message);
	}
	return "signin";
}

@RequestMapping(value = { "/register" })
public String register() {
	return "register";
}

@RequestMapping(value = { "/adduser" })
public void saveUser(
				@Validated @ModelAttribute("user") final BlogUser user,
				final BindingResult result) {
	if (result.getErrorCount() > 0) {
		return;
	}
	this.userService.saveUser(user);
}

/**
 * 
 * @param username
 * @return
 */
public BlogUser getBlogUserByName(final String username) {
	return this.userService.getUserByUsername(username);
}
}
