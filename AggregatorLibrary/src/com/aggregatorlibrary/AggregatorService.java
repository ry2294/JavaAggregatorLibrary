package com.aggregatorlibrary;

class AggregatorService implements Aggregator {
	Graph graph;
	
	public AggregatorService() {
		graph = new Graph();
	}

	@Override
	public void addParameter(Parameter parameter) {
	}

	@Override
	public void addNode(Runnable node) {
	}

	@Override
	public void execute() {
		GraphBuilderKhans.buildGraph(graph);
		GraphExecutor graphExecutor = GraphExecutors.newCachedThreadPool();
		graphExecutor.execute(graph);
	}

}
