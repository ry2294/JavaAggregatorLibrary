package com.aggregatorlibrary;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;

import com.aggregatorlibrary.exceptions.CyclicGraphException;

class GraphBuilderKhans {

	public static void buildGraph(Graph graph) 
			throws CyclicGraphException, IllegalArgumentException, IllegalAccessException {
		graph.constructGraph();
		if(isGraphCyclic(graph))
			throw new CyclicGraphException();
	}
	
	private static boolean isGraphCyclic(Graph graph) {
		HashMap<Class<? extends Runnable>, HashSet<Class<? extends Runnable>>> indegrees = 
				new HashMap<Class<? extends Runnable>, HashSet<Class<? extends Runnable>>>();
		HashMap<Class<? extends Runnable>, HashSet<Class<? extends Runnable>>> outdegrees = 
				new HashMap<Class<? extends Runnable>, HashSet<Class<? extends Runnable>>>();
		for(Task<? extends Runnable> task : graph.getTasks()) {
			indegrees.put(task.getNode().getClass(), (HashSet<Class<? extends Runnable>>) task.getInDegree());
			outdegrees.put(task.getNode().getClass(), (HashSet<Class<? extends Runnable>>) task.getOutDegree());
		}
		return topologicalSort(indegrees, outdegrees, graph.size());
	}
	
	private static boolean topologicalSort(
			HashMap<Class<? extends Runnable>, HashSet<Class<? extends Runnable>>> indegrees, 
			HashMap<Class<? extends Runnable>, HashSet<Class<? extends Runnable>>> outdegrees,
			int totalVertices) {
		int visitedVertics = 0;
		Queue<Class<? extends Runnable>> queue = new ArrayDeque<Class<? extends Runnable>>();
		for(Class<? extends Runnable> cls : indegrees.keySet()) {
			if(indegrees.get(cls).isEmpty())
				queue.add(cls);
		}
		while(!queue.isEmpty()) {
			Class<? extends Runnable> source = queue.poll();
			for(Class<? extends Runnable> dest : outdegrees.get(source)) {
				HashSet<Class<? extends Runnable>> destIndegree = indegrees.get(dest);
				destIndegree.remove(source);
				if(destIndegree.isEmpty())
					queue.add(dest);
			}
			visitedVertics++;
		}
		return totalVertices != visitedVertics;
	}
	
	private GraphBuilderKhans() {}
}
