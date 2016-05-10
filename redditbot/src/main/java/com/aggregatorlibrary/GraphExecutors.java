package com.aggregatorlibrary;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class GraphExecutors {
	private static final ExecutorService executor = Executors.newCachedThreadPool();
	
	public static GraphExecutor newCachedThreadPool() {
		return new GraphExecutorService(executor);
	}

	private GraphExecutors() {
	}
}
