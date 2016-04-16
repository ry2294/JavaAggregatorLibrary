package com.aggregatorlibrary;

import java.util.HashSet;

class Task<K extends Runnable> {
	private HashSet<Class<? extends Runnable>> inDegree;
	private HashSet<Class<? extends Runnable>> outDegree;
	private K node;
	
	public Task(K node){
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

	public K getNode() {
		return node;
	}
}
