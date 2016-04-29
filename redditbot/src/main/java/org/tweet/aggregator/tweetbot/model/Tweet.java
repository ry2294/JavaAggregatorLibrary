package org.tweet.aggregator.tweetbot.model;

public class Tweet {
	private String tweetid, text, lat, lon, time;
	
	public String toString() {
		return tweetid + " " + text + " " + lat + "" + lon;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTweetid() {
		return tweetid;
	}

	public void setTweetid(String tweetid) {
		this.tweetid = tweetid;
	}
}
