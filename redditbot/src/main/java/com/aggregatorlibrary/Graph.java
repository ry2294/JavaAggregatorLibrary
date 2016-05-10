package com.aggregatorlibrary;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

class Graph {
	private ConcurrentHashMap<Class<? extends Runnable>, Task<? extends Runnable>> vertices;
	private ConcurrentHashMap<Class<?>, Parameter<?>> parameters;
	
	public Graph() {
		vertices = new ConcurrentHashMap<Class<? extends Runnable>, Task<? extends Runnable>>();
		parameters = new ConcurrentHashMap<Class<?>, Parameter<?>>();
	}
	
	public <K extends Runnable> void addVertex(K vertex) {
		vertices.put(vertex.getClass(), new Task<K>(vertex));
	}
	
	public <K> void addParameter(K parameter) {
		parameters.put(parameter.getClass(), new Parameter<K>(parameter));
	}
	
	public Collection<Task<? extends Runnable>> getTasks() {
		return vertices.values();
	}
	
	public Task<? extends Runnable> getTask(Class<? extends Runnable> cls) {
		return vertices.get(cls);
	}
	
	public int size() {
		return vertices.size();
	}
	
	public void constructGraph() throws IllegalArgumentException, IllegalAccessException {
		for(Task<? extends Runnable> task : vertices.values()) {
			injectContainersInsideVertex(task);
		}
	}
	
	private void injectContainersInsideVertex(Task<? extends Runnable> task) 
			throws IllegalArgumentException, IllegalAccessException {
		Class<? extends Runnable> cls = task.getNode().getClass();
		Field[] fields = cls.getDeclaredFields();
		for(Field field : fields) {
			if(field.getAnnotation(Param.class) != null && 
					parameters.containsKey(field.getType())) {
				assignParameterToField(field, task);
			}
			if(field.getAnnotation(Dependency.class) != null && 
					vertices.containsKey(field.getType())) {
				assignDependencyToField(field, task);
			}
		}
	}
	
	private void assignParameterToField(Field field, Task<? extends Runnable> task) 
			throws IllegalArgumentException, IllegalAccessException {
		if(!Modifier.isPublic(field.getModifiers())) {
			field.setAccessible(true);
			field.set(task.getNode(), parameters.get(field.getType()).getNode());
			field.setAccessible(false);
		} else field.set(task.getNode(), parameters.get(field.getType()).getNode());
	}
	
	private void assignDependencyToField(Field field, Task<? extends Runnable> task) 
			throws IllegalArgumentException, IllegalAccessException {
		if(!Modifier.isPublic(field.getModifiers())) {
			field.setAccessible(true);
			field.set(task.getNode(), vertices.get(field.getType()).getNode());
			field.setAccessible(false);
		} else field.set(task.getNode(), vertices.get(field.getType()).getNode());
		task.addInDegree(vertices.get(field.getType()).getNode().getClass());
		constructEdge(vertices.get(field.getType()), task);
	}
	
	private void constructEdge(Task<? extends Runnable> source, Task<? extends Runnable> destination) {
		source.addOutDegree(destination.getNode().getClass());
		destination.addInDegree(source.getNode().getClass());
	}
}
