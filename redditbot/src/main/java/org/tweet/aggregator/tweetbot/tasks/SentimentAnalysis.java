package org.tweet.aggregator.tweetbot.tasks;

import org.json.JSONArray;
import org.json.JSONObject;
import org.tweet.aggregator.tweetbot.model.Tweet;

import com.aggregatorlibrary.Param;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class SentimentAnalysis implements Runnable {
	private int polarity = -1;
	@Param
	Tweet tweet;
	
	public SentimentAnalysis(Tweet tweet) {
		this.tweet = tweet;
	}
	
	public SentimentAnalysis() {
	}

	@Override
	public void run() {
		try {
			JSONObject text = new JSONObject();
			text.put("text", tweet.getText());
			JSONObject data = new JSONObject();
			JSONArray texts = new JSONArray();
			texts.put(text);
			data.put("data", texts);
			data.put("language", "auto");

			HttpResponse<JsonNode> jsonResponse = Unirest
			.post("http://www.sentiment140.com/api/bulkClassifyJson?appid=rakesh.891@gmail.com")
			.header("accept", "application/json")
			.body(data)
			.asJson();
			
			JSONObject response = jsonResponse.getBody().getObject();
			JSONArray array = response.getJSONArray("data");
			JSONObject object = array.getJSONObject(0);
			polarity = object.getInt("polarity");
			System.out.println("polarity = " + polarity + " text = " + tweet.getText());
		} catch (UnirestException e) {
			e.printStackTrace();
		}
	}
	
	public int getPolarity() {
		return polarity;
	}

}
