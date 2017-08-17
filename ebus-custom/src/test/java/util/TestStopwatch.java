package util;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;

public class TestStopwatch {
	public static void main(String[] args) throws InterruptedException {
		testStopwatch();
	}

	private static void testStopwatch() throws InterruptedException {
		Stopwatch stopwatch = Stopwatch.createStarted();
//		Stopwatch stopwatch = Stopwatch.createUnstarted().start(); 或者用这种，不推荐用new Stopwatch(); 
		 TimeUnit.MILLISECONDS.sleep(88);
		 long nanos = stopwatch.elapsed(TimeUnit.NANOSECONDS);
		 long mills = stopwatch.elapsed(TimeUnit.MILLISECONDS);
		 long seconds = stopwatch.elapsed(TimeUnit.SECONDS);
		 System.out.println(mills);
		 System.out.println(nanos);
		 System.out.println(seconds);
		
	}

}
