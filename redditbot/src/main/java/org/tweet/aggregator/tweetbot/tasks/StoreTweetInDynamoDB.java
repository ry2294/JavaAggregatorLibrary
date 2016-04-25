package org.tweet.aggregator.tweetbot.tasks;

import com.aggregatorlibrary.Dependency;
import com.aggregatorlibrary.Param;

public class StoreTweetInDynamoDB implements Runnable {
	@Param
	String test;
	
	@Dependency
	SentimentAnalysis analysis;

	@Override
	public void run() {
		System.out.println("Running StoreTweetInDynamoDB");
		System.out.println(analysis.getSentiment());
	}

}
