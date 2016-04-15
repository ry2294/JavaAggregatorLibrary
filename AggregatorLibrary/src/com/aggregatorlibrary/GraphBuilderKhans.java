package com.aggregatorlibrary;

import com.aggregatorlibrary.exceptions.CyclicGraphException;

class GraphBuilderKhans {

	public static void buildGraph(Graph graph) 
			throws CyclicGraphException {
		injectDependecies(graph);
		constructEdges(graph);
		if(isGraphCyclic(graph))
			throw new CyclicGraphException();
	}
	
	private static void injectDependecies(Graph graph) {
	}
	
	private static void constructEdges(Graph graph) {
	}
	
	private static boolean isGraphCyclic(Graph graph) {
		return false;
	}
	
	private GraphBuilderKhans() {}
}
