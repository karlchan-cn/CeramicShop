package test.cn.com.kc.jvm.overheapstack;

public class BugThreadMonitorDemo {

	public void createDeadLoopThread() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					;
				}

			}
		}, "Test Dead Loop Thread");
		thread.start();
	}

	private static Object firstLock = new Object();
	private static Object secondLock = new Object();

	public void createDeadLock(final Object lockA, final Object lockB) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lockA) {
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized (lockB) {

					}
				}

			}
		});
		thread.start();
	}

	public void createLockedThread(final Object lock) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lock) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}, "Test Locked Thread");
		thread.start();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BugThreadMonitorDemo demo = new BugThreadMonitorDemo();
		demo.createDeadLoopThread();
		demo.createLockedThread(new Object());
		demo.createDeadLock(BugThreadMonitorDemo.firstLock,
				BugThreadMonitorDemo.secondLock);
		demo.createDeadLock(BugThreadMonitorDemo.secondLock,
				BugThreadMonitorDemo.firstLock);

	}

}
