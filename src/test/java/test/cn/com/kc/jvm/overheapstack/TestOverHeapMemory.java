/**
 * 
 */
package test.cn.com.kc.jvm.overheapstack;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * vm args: -Xmx20M -Xmx20M
 * @author karl
 * 
 */

public class TestOverHeapMemory {
	@Test
	public void testOverHeapMemory() {
		while (true) {
			// new Thread(new InnerMemoryComsumer()).start();
			cache.add(new TestOverHeapMemory());
			System.out.println("still living");
		}
	}
	
	// private static ThreadLocal cache = new ThreadLocal();
	private static List cache = new ArrayList();

	class InnerMemoryComsumer implements Runnable {

		@Override
		public void run() {
			cache.add(new Object());

		}
	}
}
