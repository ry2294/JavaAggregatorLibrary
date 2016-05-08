package com.aggregatorlibrary;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class GraphExecutors {
	/**
	 * Creates a single cached thread pool
	 */ 
	private static final ExecutorService executor = Executors.newCachedThreadPool();
	
	/**
	 * The function newCachedThreadPool returns a new GraphExecutorService which makes use of,
	 * a singelton cached thread pool.
	 */ 
	public static GraphExecutor newCachedThreadPool() {
		return new GraphExecutorService(executor);
	}

	private GraphExecutors() {
	}
}
