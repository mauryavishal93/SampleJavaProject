package com.maurya.sample;

public class Sample {

	static FunctionLib funLib = new FunctionLib();
	public static void main(String[] args) {

		System.out.println("**************Welcome To Sample Project**************");
		funLib.displayData("Mathematics");
		funLib.addData(5, 1);
		funLib.subtractData(5, 1);
		funLib.muliplyData(5, 1);
		funLib.divideData(15, 3);
		System.out.println("**************Execution Terminated**************");
		System.out.println("**************Execution Terminated**************");
	}

}
