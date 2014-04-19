package test.cn.com.kc.jvm.overheapstack;

/**
 * vm args: -Xss128K
 * @author karl
 *
 */
public class StackOverFlowTester {
	private int deepLevel = 1;

	public void createStackOverFlow() {
		deepLevel++;
		createStackOverFlow();
	}

	public int getDeepLevel() {
		return this.deepLevel;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StackOverFlowTester tester = new StackOverFlowTester();
		try {

			tester.createStackOverFlow();
		} catch (Throwable e) {
			System.out.println("stack deep level is:" + tester.getDeepLevel());
		}

	}
}
