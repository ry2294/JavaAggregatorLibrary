package com.aggregatorlibrary;

import com.aggregatorlibrary.exceptions.CyclicGraphException;

public interface Aggregator {
	public <K> void addParameter(K parameter);
	
	public <K extends Runnable> void addNode(K node);
	
	public void execute() throws CyclicGraphException, IllegalArgumentException, IllegalAccessException;
}
