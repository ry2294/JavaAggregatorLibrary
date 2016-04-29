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

	@Override
	public void run() {
		long endTime = System.currentTimeMillis() - startTime;
		JSONObject tweet = new JSONObject();
		tweet.put("table", "javatweet");
		tweet.put("tweetid", this.tweet.getTweetId());
		tweet.put("text", this.tweet.getText());
		tweet.put("lat", this.tweet.getLat());
		tweet.put("lon", this.tweet.getLon());
		tweet.put("time", String.valueOf(endTime));
		tweet.put("sentiment", String.valueOf(sentiment.getPolarity()));
		
		try {
			HttpResponse<JsonNode> jsonResponse = Unirest
					.post("https://tweetmap-ry2294.c9users.io/time")
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
