package com.aggregatorlibrary;

import java.util.concurrent.ExecutionException;

interface GraphExecutor {
	public void execute(Graph graph) throws InterruptedException, ExecutionException;
}
