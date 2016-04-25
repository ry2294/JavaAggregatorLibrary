package com.aggregatorlibrary;

import java.util.concurrent.ExecutionException;

import com.aggregatorlibrary.exceptions.CyclicGraphException;

class AggregatorService implements Aggregator {
	Graph graph;
	
	public AggregatorService() {
		graph = new Graph();
	}

	@Override
	public <K> void addParameter(K parameter) {
		graph.addParameter(parameter);
	}

	@Override
	public <K extends Runnable> void addNode(K node) {
		graph.addVertex(node);
	}

	@Override
	public void execute() 
			throws CyclicGraphException, IllegalArgumentException, IllegalAccessException, InterruptedException, ExecutionException {
		GraphBuilderKhans.buildGraph(graph);
		GraphExecutor graphExecutor = GraphExecutors.newCachedThreadPool();
		graphExecutor.execute(graph);
	}

	@Override
	public void addTasks(Runnable... node) {
	}

}
