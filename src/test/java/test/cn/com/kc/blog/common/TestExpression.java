/**
 * 
 */
package test.cn.com.kc.blog.common;

import java.sql.Timestamp;
import java.util.Calendar;

/**
 * @author kchen1
 * 
 */
public class TestExpression {

/**
 * @param args
 */
public static void main(String[] args) {
	// TODO Auto-generated method stub
	// String singleIPRegex =
	// "(([01]?\\d{1,2}|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d{1,2}|2[0-4]\\d|25[0-5])";
	// singleIPRegex
	// ="^10\\.30\\.178\\.([1-9][0-9]|1([0-9][0-9])|200)-10\\.30\\.178\\.([1-9][0-9]|1([0-9][0-9])|200)$";
	// String rangeRegex = singleIPRegex + "-" + singleIPRegex;
	// if ("10.30.178.10-10.30.178.200".matches(singleIPRegex)) {
	// String a = "10.30.178.10-10.30.178.200";
	//
	// // do your stuff
	// }
	Timestamp a = new Timestamp(System.currentTimeMillis());
	Calendar now = java.util.Calendar.getInstance();
	Calendar tomorrow = java.util.Calendar.getInstance();
	tomorrow.set(Calendar.HOUR, now.get(Calendar.HOUR) + 1);
	System.out.println(now.getTimeInMillis());
	System.out.println(tomorrow.getTimeInMillis());
}

}
