package com.maurya.sample;

public class FunctionLib {
	
	protected String displayData(String string) {
		return string;
	}
	
	protected int addData(int x, int y) {
		System.out.println("Addition of "+ x+" & "+y+" = "+(x+y));
		return x+y;
	}
	
	protected int muliplyData(int x, int y) {
		System.out.println("Multiplication of "+ x+" & "+y+" = "+(x*y));
		return x*y;
	}


	protected double divideData(int x, int y) {
		System.out.println("Division of "+ x+" & "+y+" = "+(x/y));
		return x/y;
	}
	
	protected int subtractData(int x, int y) {
		System.out.println("Subtractiob of "+ x+" & "+y+" = "+(x-y));
		return x-y;
	}
}
