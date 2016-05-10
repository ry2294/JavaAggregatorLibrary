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
	
	public StoreInDynamoDB(Tweet tweet) {
		this.tweet = tweet;
	}
	
	public StoreInDynamoDB() {
	}

	@Override
	public void run() {
		JSONObject tweet = new JSONObject();
		tweet.put("table", this.tweet.getTable());
		tweet.put("id", this.tweet.getTweetid());
		tweet.put("text", this.tweet.getText());
		
		try {
			HttpResponse<JsonNode> jsonResponse = Unirest
					.post("http://redditbot.us-west-2.elasticbeanstalk.com/comment")
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
