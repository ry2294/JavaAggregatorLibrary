package org.tweet.aggregator.tweetbot.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.tweet.aggregator.tweetbot.model.Tweet;
import org.tweet.aggregator.tweetbot.tasks.*;

import com.aggregatorlibrary.Aggregator;
import com.aggregatorlibrary.Aggregators;

@Path("/parallel")
public class ParallelResource {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTweet(Tweet tweet) {
		StoreInDynamoDB storeInDynamoDB = new StoreInDynamoDB(tweet);
		SentimentAnalysis sentimentAnalysis = new SentimentAnalysis(tweet);
		RecordTime recordTime = new RecordTime(tweet, sentimentAnalysis, storeInDynamoDB);
		storeInDynamoDB.run();
		sentimentAnalysis.run();
		recordTime.run();
		return Response.ok().build();
	}
}