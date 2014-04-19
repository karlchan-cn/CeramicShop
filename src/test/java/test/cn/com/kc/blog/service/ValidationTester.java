/**
 * 
 */
package test.cn.com.kc.blog.service;

import java.util.Iterator;
import java.util.Set;
import static org.junit.Assert.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

import cn.com.kc.blog.pojo.BlogUser;

/**
 * @author chenjinlong2
 * 
 */
public class ValidationTester extends BootTester {
	private static Validator validator;

	@BeforeClass
	public static void initSetup() {
		validator = (Validator) context
				.getBean(BeanNamesConst.NAME_HIBERNATE_VALIDATOR);
	}

	@Test
	public void validateBlogUser() {
		BlogUser user = new BlogUser();
		Set<ConstraintViolation<BlogUser>> retSet = validator.validate(user);
		ConstraintViolation<BlogUser> constraintViolation = null;
		for (final Iterator<ConstraintViolation<BlogUser>> iterator = retSet
				.iterator(); iterator.hasNext();) {
			constraintViolation = iterator.next();
			System.out.println(constraintViolation.getPropertyPath());
			System.out.println(constraintViolation.getMessage());
		}

	}
}
