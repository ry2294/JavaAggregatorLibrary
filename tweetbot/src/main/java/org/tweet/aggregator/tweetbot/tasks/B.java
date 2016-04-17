package org.tweet.aggregator.tweetbot.tasks;

import com.aggregatorlibrary.Dependency;

public class B implements Runnable {
	@Dependency
	private A a;
	
	private String b;
	
	@Override
	public void run() {
		System.out.println("Running Class B with value = " + a.getA());
		b = new String("String b");
	}
	
	public String getB() {
		return b;
	}
}
