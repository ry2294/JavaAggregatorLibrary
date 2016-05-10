package org.tweet.aggregator.tweetbot.tasks;

import org.json.JSONObject;
import org.tweet.aggregator.tweetbot.model.Tweet;

import com.aggregatorlibrary.Dependency;
import com.aggregatorlibrary.Param;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class RecordTime implements Runnable {
	private long startTime;
	
	@Param
	Tweet tweet;
	
	@Dependency
	SentimentAnalysis sentiment;
	
	@Dependency
	StoreInDynamoDB dynamoDB;
	
	public RecordTime() {
		startTime = System.currentTimeMillis();
	}
	
	public RecordTime(Tweet tweet, SentimentAnalysis sentiment, StoreInDynamoDB dynamoDB) {
		startTime = System.currentTimeMillis();
		this.tweet = tweet; this.sentiment = sentiment; this.dynamoDB = dynamoDB;
	}

	@Override
	public void run() {
		long endTime = System.currentTimeMillis() - startTime;
		JSONObject tweet = new JSONObject();
		tweet.put("table", this.tweet.getTable());
		tweet.put("id", this.tweet.getTweetid());
		tweet.put("text", this.tweet.getText());
		tweet.put("time", String.valueOf(endTime));
		tweet.put("sentiment", String.valueOf(sentiment.getPolarity()));
		
		try {
			HttpResponse<JsonNode> jsonResponse = Unirest
					.post("http://redditbot.us-west-2.elasticbeanstalk.com/time")
					.header("accept", "application/json")
					.header("Content-Type", "application/json")
					.body(tweet)
					.asJson();
			jsonResponse.getBody().getObject();
		} catch (UnirestException e) {
			e.printStackTrace();
		}
	}

}
