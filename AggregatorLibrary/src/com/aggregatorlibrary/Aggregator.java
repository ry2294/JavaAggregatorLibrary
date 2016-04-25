package com.aggregatorlibrary;

import java.util.concurrent.ExecutionException;

import com.aggregatorlibrary.exceptions.CyclicGraphException;

public interface Aggregator {
	public <K> void addParameter(K parameter);
	
	public <K extends Runnable> void addNode(K node);
	
	public void addTasks(Runnable... node);
	
	public void execute() throws CyclicGraphException, IllegalArgumentException, IllegalAccessException, InterruptedException, ExecutionException;
}
