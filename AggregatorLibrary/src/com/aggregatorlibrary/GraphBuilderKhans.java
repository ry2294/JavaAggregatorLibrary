package com.aggregatorlibrary;

import com.aggregatorlibrary.exceptions.CyclicGraphException;

class GraphBuilderKhans {

	public static void buildGraph(Graph graph) 
			throws CyclicGraphException, IllegalArgumentException, IllegalAccessException {
		graph.injectContainers();
		if(isGraphCyclic(graph))
			throw new CyclicGraphException();
	}
	
	private static boolean isGraphCyclic(Graph graph) {
		return false;
	}
	
	private GraphBuilderKhans() {}
}
