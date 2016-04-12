package org.tweet.aggregator.tweetbot.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.tweet.aggregator.tweetbot.model.Tweet;
import org.tweet.aggregator.tweetbot.tasks.StoreTweetInDynamoDB;

@Path("/tweet")
public class TweetResource {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTweet(Tweet tweet) {
		System.out.println("Tweet id = " + tweet.getId());
		StoreTweetInDynamoDB storeTweetTask = new StoreTweetInDynamoDB();
		storeTweetTask.run();
		return Response.ok().build();
	}
}
