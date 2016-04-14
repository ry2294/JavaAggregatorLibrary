package com.aggregatorlibrary;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;

class AggregatorService implements Aggregator {
	ConcurrentHashMap<Class<? extends Runnable>, Task> graph;
	
	public AggregatorService() {
		graph = new ConcurrentHashMap<Class<? extends Runnable>, Task>();
	}

	@Override
	public void addParameter(Parameter parameter) {
	}

	@Override
	public void addNode(Runnable node) {
	}

	@Override
	public void execute() {
		Executors.newFixedThreadPool(1);
	}

}
