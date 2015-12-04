package com.maxgain.code.util;




public class Pair<A, B> {

	private final A instanceOfA;
	private final B instanceOfB;

	public Pair(A instanceOfA, B instanceOfB) {
		this.instanceOfA = instanceOfA;
		this.instanceOfB = instanceOfB;
	}

	public A getA() {
		return instanceOfA;
	}

	public B getB() {
		return instanceOfB;
	}

	@Override
	public int hashCode() {
		return instanceOfA.hashCode() ^ instanceOfB.hashCode();
	}

	@Override
	public boolean equals(Object instance) {
		if (!(instance instanceof Pair)) {
			return false;
		} else {
			Pair pair = (Pair) instance;
			return this.instanceOfA.equals(pair.getA()) && 
					this.instanceOfB.equals(pair.getB());
		}
	}

}