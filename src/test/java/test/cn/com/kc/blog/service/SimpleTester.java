package test.cn.com.kc.blog.service;

import org.junit.Test;

public class SimpleTester {
	@Test
	public void testReplaceString(){
		String testString = "xmitrcvdkajdfkljsafdlkajsfxmitrcvd";
		
		System.out.println(testString.replaceAll("xmit", "").replaceAll("rcvd", ""));	
	}
}
