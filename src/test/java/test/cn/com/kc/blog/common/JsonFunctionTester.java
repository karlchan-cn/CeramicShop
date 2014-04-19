/**
 * 
 */
package test.cn.com.kc.blog.common;

import java.io.File;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

import cn.com.kc.blog.pojo.BlogEntity;

/**
 * @author kchen1
 * 
 */
public class JsonFunctionTester {
@Test
public void testToJsonFunction() {
	try {
		BlogEntity entity = new BlogEntity();
		entity.setId(1l);
		JSON.toJSONString(entity);
	} catch (Exception e) {
		e.printStackTrace();
	}

}

@Test
public void name() {
	try {
		System.getProperty("user.dir");
		File file =
						new File(System.getProperty("user.dir") + "/中文");
		file.exists();
		file.mkdir();
	} catch (Exception e) {
		e.printStackTrace();
	}

}
}
