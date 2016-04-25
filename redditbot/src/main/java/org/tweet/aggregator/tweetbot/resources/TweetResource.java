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

@Path("/tweet")
public class TweetResource {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTweet(Tweet tweet) {
		Aggregator aggregator = Aggregators.newAggregatorService();
		aggregator.addNodes(new A(), new B(), new C());
		D d = new D();
		aggregator.addNode(d);
		try {
			aggregator.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("d value = " + d.getD());
		System.out.println("Tweet id = " + tweet.getId());
		return Response.ok().build();
	}
}
