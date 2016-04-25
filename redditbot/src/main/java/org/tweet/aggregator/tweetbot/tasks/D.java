package org.tweet.aggregator.tweetbot.tasks;

import com.aggregatorlibrary.Dependency;

public class D implements Runnable {
	@Dependency
	private B b;
	
	@Dependency
	private C c;
	
	private String d;
	
	public D() {}
	
	public D(B b, C c) {
		this.b = b;
		this.c = c;
	}
	
	@Override
	public void run() {
		System.out.println("Running Class D with b value = " + b.getB() + " c value = " + c.getC());
		d = new String("String d");
	}
	
	public String getD() {
		return d;
	}
}