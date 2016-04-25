package org.tweet.aggregator.tweetbot.tasks;

public class A implements Runnable {
	private String a;
	
	public A() {
		
	}
	
	@Override
	public void run() {
		System.out.println("Running Class A");
		a = new String("String a");
	}
	
	public String getA() {
		return a;
	}
}
