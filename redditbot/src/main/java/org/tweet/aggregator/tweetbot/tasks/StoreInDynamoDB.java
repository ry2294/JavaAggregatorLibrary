package org.tweet.aggregator.tweetbot.tasks;

import org.json.JSONObject;
import org.tweet.aggregator.tweetbot.model.Tweet;

import com.aggregatorlibrary.Param;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class StoreInDynamoDB implements Runnable {
	@Param
	Tweet tweet;

	@Override
	public void run() {
		JSONObject tweet = new JSONObject();
		tweet.put("table", "javatweet");
		tweet.put("tweetid", this.tweet.getTweetId());
		tweet.put("text", this.tweet.getText());
		tweet.put("lat", this.tweet.getLat());
		tweet.put("lon", this.tweet.getLon());
		
		try {
			HttpResponse<JsonNode> jsonResponse = Unirest
					.post("https://tweetmap-ry2294.c9users.io/tweet")
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
