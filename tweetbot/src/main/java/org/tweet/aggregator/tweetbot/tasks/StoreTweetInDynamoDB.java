package org.tweet.aggregator.tweetbot.tasks;

import com.aggregatorlibrary.Param;

public class StoreTweetInDynamoDB implements Runnable {
	@Param
	String test;

	@Override
	public void run() {
		System.out.println("Running StoreTweetInDynamoDB");
		System.out.println("test = " + test);
	}

}
