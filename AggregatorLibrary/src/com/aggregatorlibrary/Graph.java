package com.aggregatorlibrary;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

class Graph {
	ConcurrentHashMap<Class<? extends Runnable>, Task<? extends Runnable>> vertices;
	ConcurrentHashMap<Class<?>, Parameter<?>> parameters;
	
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
	
	public void injectDependencies() {
		
	}
	
	public void injectParameters() throws IllegalArgumentException, IllegalAccessException {
		for(Task<? extends Runnable> task : vertices.values()) {
			injectParametersInsideVertex(task.getNode());
		}
	}
	
	private <K extends Runnable> void injectParametersInsideVertex(K node) 
			throws IllegalArgumentException, IllegalAccessException {
		Class<? extends Runnable> cls = node.getClass();
		Field[] fields = cls.getDeclaredFields();
		for(Field field : fields) {
			if(field.getAnnotation(Param.class) != null && 
					parameters.containsKey(field.getType())) {
				if(!Modifier.isPublic(field.getModifiers())) {
					field.setAccessible(true);
					field.set(node, parameters.get(field.getType()).getParameter());
					field.setAccessible(false);
				} else
					field.set(node, parameters.get(field.getType()).getParameter());
			}
		}
	}
}
