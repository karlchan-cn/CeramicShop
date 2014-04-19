/**
 * 
 */
package test.cn.com.kc.blog.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import cn.com.kc.blog.pojo.BlogImage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import junit.framework.TestCase;

/**
 * @author kchen1
 * 
 */
public class JDKCommonFunctionTester extends TestCase {
@Test
public void testRegexExpression() {
	try {
		Pattern pattern = Pattern.compile("<图片\\d>");
		Matcher matcher = pattern.matcher("<图片1> Hello World,正则表达式 Hello World");
		// 替换第一个符合正则的数据

		System.out.println(matcher.pattern());
		String templateString = "<div class='image-thumb'><img alt='图片2' src='http://localhost:8081/Blog/assets/images/1383115183842P1040071.JPG'></div>";
		System.out.println(matcher.replaceFirst("Java1"));
	} catch (Exception e) {
		e.printStackTrace();
	}

}

@Test
public void testParseJsonArrayString() {
	try {
		String jsonArrayString = "[{\"entity\":{\"id\":1,\"title\":\"Test\",\"createdate\":1382943486000,\"content\":\""
									+
									"colu\",\"readprivate\":\"X\",\"commentable\":false,\"isTemp\":true,\"images\":null,\"user\":null,\"comments\":null,\"categorys\":null},\"id\":18,\"name\":\"1383118304283IMG_0089.JPG\","
									+
									"\"position\":null,\"tempid\":1,\"size\":2403428,\"sizeUnit\":null,\"showName\":\"IMG_0089.JPG\",\"description\":null,\"currentUploadName\":\"??1\"},{\"entity\":{\"id\":1,"
									+
									"\"title\":\"Test\",\"createdate\":1382943486000,"
									+
									"\"content\":\"colu\",\"readprivate\":\"X\",\"commentable\":false,\"isTemp\":true,\"images\":null,\"user\":null,\"comments\":null,\"categorys\":null},\"id\":19,"
									+
									"\"name\":\"1383118304674IMG_0110.JPG\",\"position\":null,\"tempid\":2,\"size\":2537206,\"sizeUnit\":null,\"showName\":\"IMG_0110.JPG\",\"description\":null,"
									+
									"\"currentUploadName\":\"??2\"},{\"entity\":{\"id\":1,\"title\":\"Test\",\"createdate\":1382943486000,\"content\":\""
									+
									"colu\",\"readprivate\":\"X\",\"commentable\":false,\"isTemp\":true,\"images\":null,\"user\":null,\"comments\":null,\"categorys\":null},\"id\":20,"
									+
									"\"name\":\"1383118305022IMG_0073.JPG\",\"position\":null,\"tempid\":3,\"size\":2537752,\"sizeUnit\":null,\"showName\":\"IMG_0073.JPG\",\"description\":null,\"currentUploadName\":\"??3\"}]";
		JSON.parseArray(jsonArrayString, BlogImage.class);
	} catch (Exception e) {
		e.printStackTrace();
	}

}
}
