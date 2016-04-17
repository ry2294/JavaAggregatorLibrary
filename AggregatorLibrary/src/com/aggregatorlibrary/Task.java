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
	
	@SuppressWarnings("unchecked")
	public HashSet<Class<? extends Runnable>> getInDegree() {
		HashSet<Class<? extends Runnable>> hashSet = new HashSet<Class<? extends Runnable>>();
		hashSet = (HashSet<Class<? extends Runnable>>) inDegree.clone();
		return hashSet;
	}
	
	public void addInDegree(Class<? extends Runnable> cls) {
		inDegree.add(cls);
	}
	
	public void removeInDegree(Class<? extends Runnable> cls) {
		inDegree.remove(cls);
	}
	
	public boolean isInDegreeEmpty() {
		return inDegree.isEmpty();
	}

	@SuppressWarnings("unchecked")
	public HashSet<Class<? extends Runnable>> getOutDegree() {
		HashSet<Class<? extends Runnable>> hashSet = new HashSet<Class<? extends Runnable>>();
		hashSet = (HashSet<Class<? extends Runnable>>) outDegree.clone();
		return hashSet;
	}
	
	public void addOutDegree(Class<? extends Runnable> cls) {
		outDegree.add(cls);
	}

	public K getNode() {
		return node;
	}
}
