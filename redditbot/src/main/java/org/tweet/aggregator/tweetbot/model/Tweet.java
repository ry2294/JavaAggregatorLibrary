package org.tweet.aggregator.tweetbot.model;

public class Tweet {
	private String tweetid, text, table;
	
	public String toString() {
		return tweetid + " " + text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTweetid() {
		return tweetid;
	}

	public void setTweetid(String tweetid) {
		this.tweetid = tweetid;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}
}
