package org.tweet.aggregator.tweetbot.resources;

import java.util.concurrent.ExecutionException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.tweet.aggregator.tweetbot.model.Tweet;
import org.tweet.aggregator.tweetbot.tasks.*;

import com.aggregatorlibrary.Aggregator;
import com.aggregatorlibrary.Aggregators;
import com.aggregatorlibrary.exceptions.CyclicGraphException;

@Path("/tweet")
public class TweetResource {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTweet(Tweet tweet) {
		Aggregator aggregator = Aggregators.newAggregatorService();
		aggregator.addNode(new A());
		aggregator.addNode(new B());
		aggregator.addNode(new C());
		D d = new D();
		aggregator.addNode(d);
		try {
			aggregator.execute();
		} catch (CyclicGraphException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println("d value = " + d.getD());
		System.out.println("Tweet id = " + tweet.getId());
		return Response.ok().build();
	}
}
