package com.aggregatorlibrary;

import com.aggregatorlibrary.exceptions.CyclicGraphException;

class GraphBuilderKhans {

	public static void buildGraph(Graph graph) 
			throws CyclicGraphException, IllegalArgumentException, IllegalAccessException {
		graph.injectParameters();
		graph.injectDependencies();
		constructEdges(graph);
		if(isGraphCyclic(graph))
			throw new CyclicGraphException();
	}
	
	private static void constructEdges(Graph graph) {
	}
	
	private static boolean isGraphCyclic(Graph graph) {
		return false;
	}
	
	private GraphBuilderKhans() {}
}
