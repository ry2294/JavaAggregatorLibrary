package com.aggregatorlibrary;

public class Aggregators {
	
	/**
	 * The newAggregatorService function returns a new instance of an AggregatorService.
	 */ 
	public static Aggregator newAggregatorService() {
		return new AggregatorService();
	}
	
	/** Cannot instantiate. */
	private Aggregators() {}
}
