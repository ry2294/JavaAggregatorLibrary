package com.aggregatorlibrary;

import java.util.concurrent.ConcurrentHashMap;

import com.aggregatorlibrary.exceptions.CyclicGraphException;

class GraphBuilderKhans {

	public static void buildGraph(ConcurrentHashMap<Class<? extends Runnable>, Task> graph) 
			throws CyclicGraphException {
		injectDependecies(graph);
		constructEdges(graph);
		if(isGraphCyclic(graph))
			throw new CyclicGraphException();
	}
	
	private static void injectDependecies(ConcurrentHashMap<Class<? extends Runnable>, Task> graph) {
		
	}
	
	private static void constructEdges(ConcurrentHashMap<Class<? extends Runnable>, Task> graph) {
		
	}
	
	private static boolean isGraphCyclic(ConcurrentHashMap<Class<? extends Runnable>, Task> graph) {
		return false;
	}
}
