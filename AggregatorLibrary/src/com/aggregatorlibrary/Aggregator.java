package com.aggregatorlibrary;

public interface Aggregator {
	public void addParameter(Parameter parameter);
	public void addNode(Runnable node);
	public void execute();
}
