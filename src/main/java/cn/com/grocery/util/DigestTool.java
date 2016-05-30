/**
 * 
 */
package cn.com.grocery.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author karl
 *
 */
public class DigestTool {

	private static final String CONST_ALGORITHEM_MD5 = "MD5";

	public static final String toMd5String(String raw) {
		String result = null;
		if (StringUtils.isNotBlank(raw)) {
			MessageDigest md5Digest;
			try {
				md5Digest = MessageDigest.getInstance(CONST_ALGORITHEM_MD5);
				result = Arrays.toString(md5Digest.digest(raw.getBytes("UTF-8")));
			} catch (NoSuchAlgorithmException e) {
				result = null;
			} catch (UnsupportedEncodingException e) {
				result = null;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(DigestUtils.md5Hex("1111"));
		System.out.println(Arrays.toString(DigestUtils.md5("1111")));
		System.out.println(toMd5String("1111"));
	}
}
