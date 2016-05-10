package com.aggregatorlibrary;

class Parameter<K> {
	private K parameter;
	public Parameter(K parameter) {
		this.parameter = parameter;
	}
	
	public K getNode() {
		return parameter;
	}
}
