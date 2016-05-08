package com.aggregatorlibrary;

import java.util.concurrent.ExecutionException;

/**
 * The execute function communicates with the Tasks to execute the graph.
 * It takes an object of a Graph and executes the graph.
*/
interface GraphExecutor {
	public void execute(Graph graph) throws InterruptedException, ExecutionException;
}
