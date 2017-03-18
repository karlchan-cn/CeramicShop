/**
 * 
 */
package cn.com.grocery.admin.vo.validator;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import cn.com.grocery.admin.vo.AdminUserVO;
import cn.com.grocery.admin.vo.constants.VOConstants;

/**
 * @author karl
 * @date Jan 1, 2017 5:11:00 PM
 */
public class AdminUserVOValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(AdminUserVO.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		AdminUserVO user = (AdminUserVO) target;
		if (StringUtils.isBlank(user.getDisplayName())
				|| user.getDisplayName().length() > VOConstants.ADMIN_USERNAME_MAX_SIZE) {
			// errors.reject(VOConstants.CODE_ADMIN_NAME_OVER_MAX_LENGTH, "");
			errors.reject("ADMIN.USER.NAME.EMPTY", "username overlong");
		}

		if (StringUtils.isBlank(user.getPassword())) {
			errors.reject("user.password.empty", "password could not be empty");
		}
		// ermsgSb.append("密码不能为空。");
		if (!EmailValidator.getInstance().isValid(user.getEmail())) {
			errors.reject("user.email.notvalid", "email address is not valid");
		}
		// ermsgSb.append("email不合法。");

	}

}
