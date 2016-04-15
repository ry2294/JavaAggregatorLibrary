package com.aggregatorlibrary;

import java.util.concurrent.ConcurrentHashMap;

class Graph {
	ConcurrentHashMap<Class<? extends Runnable>, Task> graph;
}
