package com.aggregatorlibrary;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

class GraphExecutorService implements GraphExecutor {
	private final CompletionService<Task<? extends Runnable>> completionService;
	
	public GraphExecutorService(ExecutorService executor) {
		completionService = new ExecutorCompletionService<Task<? extends Runnable>>(executor);
	}
	
	@Override
	public void execute(Graph graph) throws InterruptedException, ExecutionException {
		Queue<Task<? extends Runnable>> independentTasksQueue = getIndependentTasks(graph);
		for(Task<? extends Runnable> task : independentTasksQueue) {
			completionService.submit(task.getNode(), task);
		}
		runDependentTasks(graph);
	}
	
	/**
	 * Returns the set of tasks which can be run independently for the given graph.
	 * It takes a Graph object and returns an Queue of Tasks objects, specifying which of them can run in parallel.
	 */ 
	private Queue<Task<? extends Runnable>> getIndependentTasks(Graph graph) {
		Queue<Task<? extends Runnable>> queue = new ArrayDeque<Task<? extends Runnable>>();
		for(Task<? extends Runnable> task : graph.getTasks()) {
			if(task.isInDegreeEmpty())
				queue.add(task);
		}
		return queue;
	}
	
	/**
	 * Runs the set of tasks for which this task is dependent on.
	 */ 
	private void runDependentTasks(Graph graph) throws InterruptedException, ExecutionException {
		for(int t = 0; t < graph.size(); t++) {
			Future<Task<? extends Runnable>> future = completionService.take();
			Task<? extends Runnable> completedTask = future.get();
			HashSet<Class<? extends Runnable>> dependentTasks = completedTask.getOutDegree();
			for(Class<? extends Runnable> cls : dependentTasks) {
				graph.getTask(cls).removeInDegree(completedTask.getNode().getClass());
				if(graph.getTask(cls).isInDegreeEmpty())
					completionService.submit(graph.getTask(cls).getNode(), graph.getTask(cls));
			}
		}
 	}
}
