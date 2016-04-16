package org.tweet.aggregator.tweetbot.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.tweet.aggregator.tweetbot.model.Tweet;
import org.tweet.aggregator.tweetbot.tasks.StoreTweetInDynamoDB;

import com.aggregatorlibrary.Aggregator;
import com.aggregatorlibrary.Aggregators;
import com.aggregatorlibrary.exceptions.CyclicGraphException;

@Path("/tweet")
public class TweetResource {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTweet(Tweet tweet) {
		StoreTweetInDynamoDB storeTweetTask = new StoreTweetInDynamoDB();
		Aggregator aggregator = Aggregators.newAggregatorService();
		aggregator.addParameter(new String("Dynamo DB"));
		aggregator.addNode(storeTweetTask);
		try {
			aggregator.execute();
		} catch (CyclicGraphException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Tweet id = " + tweet.getId());
		storeTweetTask.run();
		return Response.ok().build();
	}
}
