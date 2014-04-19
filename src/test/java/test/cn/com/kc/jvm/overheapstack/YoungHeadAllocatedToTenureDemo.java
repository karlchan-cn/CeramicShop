package test.cn.com.kc.jvm.overheapstack;

public class YoungHeadAllocatedToTenureDemo {

	/**
	 * vm args: -Xmx20M -Xms20M -Xmn10M -XX:SurvivorRatio=8 -XX:+PrintGCDetails
	 * 
	 * @param args
	 */
	public static final int _1MB = 1024 * 1024;

	public static void youngMAllocatedToTenureM() {
		byte[] arrayA, arrayB, arrayC, arrayD;
		System.out.println("");
		arrayA = new byte[2 * _1MB];
		arrayB = new byte[2 * _1MB];
		arrayC = new byte[2 * _1MB];
		arrayD = new byte[4 * _1MB];
	}

	/**
	 * vm args: -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
	 */
	public static void testTenureThreShold() {
		byte[] arrayA, arrayB, arrayC, arrayD;
		System.out.println("");
		arrayA = new byte[_1MB / 4];
		arrayB = new byte[4 * _1MB];
		arrayC = new byte[4 * _1MB];
		arrayC = null;
		arrayC = new byte[4 * _1MB];
	}

	public static void main(String[] args) {
		//YoungHeadAllocatedToTenureDemo.youngMAllocatedToTenureM();
		YoungHeadAllocatedToTenureDemo.testTenureThreShold();
	}

}
