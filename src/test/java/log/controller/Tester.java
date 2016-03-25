package log.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Tester {
	public static void main(String[] args) throws Exception {
		String a = "2014-4-19 9:30";
		String b = "2014-4-19 9:31";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd hh:mm");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(simpleDateFormat.parse(a));
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(simpleDateFormat.parse(b));
		System.out.println(calendar2.getTimeInMillis()
				- calendar.getTimeInMillis());
	}
}
