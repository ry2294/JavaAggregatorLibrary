package org.tweet.aggregator.tweetbot.tasks;

import com.aggregatorlibrary.Dependency;

public class C implements Runnable {
	@Dependency
	private A a;
	
	private String c;
	
	public C() {}
	
	public C(A a) {
		this.a = a;
	}
	
	@Override
	public void run() {
		System.out.println("Running Class C with value = " + a.getA());
		c = new String("String c");
	}
	
	public String getC() {
		return c;
	}
}