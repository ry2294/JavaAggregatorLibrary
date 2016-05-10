package com.aggregatorlibrary;

public class Aggregators {
	
	public static Aggregator newAggregatorService() {
		return new AggregatorService();
	}
	
	/** Cannot instantiate. */
	private Aggregators() {}
}
