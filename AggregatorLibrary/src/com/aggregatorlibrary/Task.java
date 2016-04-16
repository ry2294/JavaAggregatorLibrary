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
	
	public void addInDegree(Class<? extends Runnable> cls) {
		inDegree.add(cls);
	}

	public HashSet<Class<? extends Runnable>> getOutDegree() {
		return outDegree;
	}
	
	public void addOutDegree(Class<? extends Runnable> cls) {
		outDegree.add(cls);
	}

	public K getNode() {
		return node;
	}
}
