package com.aggregatorlibrary;

import java.util.concurrent.ExecutionException;

import com.aggregatorlibrary.exceptions.CyclicGraphException;

public interface Aggregator {
	public <K> void addParameter(K parameter);
	
	/**
	 * The addNode function is used to add a node/task into the graph. The user passes the object of 
	 * the task which he wants to add to the graph. The function takes the task and adds it into the dependency graph.
	 */
	public <K extends Runnable> void addNode(K node);
	
	/**
	 * The addNodes function is used to add a set of nodes/tasks into the graph. The user passes the objects of 
	 * the tasks which he wants to add to the graph. The function takes the task and adds it into the dependency graph.
	 */
	public void addNodes(Runnable... node);
	
	/**
	 * The execute function is used to process the graph and run the tasks added to the graph.
	 * The user can the execute function whenever he wants to run the Aggregator. 
	 * The function throws different types of exception in case of any errors.
	 */
	public void execute() throws CyclicGraphException, IllegalArgumentException, IllegalAccessException, InterruptedException, ExecutionException;
}
