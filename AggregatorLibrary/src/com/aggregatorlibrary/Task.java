package com.aggregatorlibrary;

import java.util.HashSet;

class Task {
	private HashSet<Class<? extends Runnable>> inDegree;
	private HashSet<Class<? extends Runnable>> outDegree;
	private Runnable node;
	
	public Task(Runnable node){
		this.node = node;
		inDegree = new HashSet<Class<? extends Runnable>>();
		outDegree = new HashSet<Class<? extends Runnable>>();
	}
	
	public HashSet<Class<? extends Runnable>> getInDegree() {
		return inDegree;
	}

	public HashSet<Class<? extends Runnable>> getOutDegree() {
		return outDegree;
	}

	public Runnable getNode() {
		return node;
	}
}
