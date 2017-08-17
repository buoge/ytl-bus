package testController;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;

import net.sourceforge.groboutils.junit.v1.MultiThreadedTestRunner;
import net.sourceforge.groboutils.junit.v1.TestRunnable;

/**
 * 
* @Title: TestController2.java 
* @Package testController 
* @Description: 多线程并发测试
* @author 刘伟  15818570028@163.com   
* @date 2017年4月12日 上午10:28:20 
* @version V1.0
 */

public class TestController2 {/*
	int count = 0;// 并发测试count++

	@Before
	public void setup() {
	}

	*//**
	 * 
	 * @Title: MultiRequestsTest
	 * @Description: 使用groboutils并发测试
	 * @throws InterruptedException
	 *//*
	@Test
	public void MultiRequestsTest() throws InterruptedException {
		// 构造一个Runner
		TestRunnable runner = new TestRunnable() {
			@Override
			public void runTest() throws Throwable {
				// 测试内容
				for (int i = 0; i < 10000; i++) {
					count++;
				}

			}
		};
		int runnerCount = 2;
		// Rnner数组，想当于并发多少个。
		TestRunnable[] trs = new TestRunnable[runnerCount];
		for (int i = 0; i < runnerCount; i++) {
			trs[i] = runner;
		}
		// 用于执行多线程测试用例的Runner，将前面定义的单个Runner组成的数组传入
		MultiThreadedTestRunner mttr = new MultiThreadedTestRunner(trs);
		try {
			// 开发并发执行数组里定义的内容
			mttr.runTestRunnables();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		TimeUnit.SECONDS.sleep(1);
		System.out.println(count);
	}

	@Test
	public void test() throws InterruptedException {
		Runnable run = () -> {
			for (int i = 0; i < 10000; i++) {
				count++;
			}
		};
		multithreads(run, 4);
		TimeUnit.SECONDS.sleep(1);
		System.out.println(count);
	}

	*//**
	 * 
	 * @Title: multithreads
	 * @Description: 自己实现的多线程测试
	 * @param run
	 * @param thread
	 *//*
	public void multithreads(Runnable run, int thread) {
		CountDownLatch countDown = new CountDownLatch(thread);
		for (int i = 0; i < thread; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					try {
						run.run();
					} finally {
						countDown.countDown();
					}
				}
			}).start();
		}

		try {
			countDown.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

*/}