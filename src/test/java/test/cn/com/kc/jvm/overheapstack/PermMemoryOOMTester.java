package test.cn.com.kc.jvm.overheapstack;

import java.util.ArrayList;
import java.util.List;

public class PermMemoryOOMTester {

	/**
	 * vm args:-XX:PermSize:10M -XX:MaxPermSize:10M
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws Throwable {
		List<String> stringList = new ArrayList<String>();
		int counter = 1;
		while (true) {
			try {
				stringList.add(String.valueOf(counter++).intern());
			} catch (Throwable e) {
				System.out.println("List's size is:" + stringList.size());
				throw e;
			}

		}

	}

}
