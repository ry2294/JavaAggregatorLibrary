package com.aggregatorlibrary;

import java.util.concurrent.ExecutorService;

class GraphExecutorService implements GraphExecutor {
	private final ExecutorService executor;
	
	public GraphExecutorService(ExecutorService executor) {
		this.executor = executor;
	}
	
	@Override
	public void execute(Graph graph) {
	}

}
