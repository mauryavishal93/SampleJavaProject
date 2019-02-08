package com.maurya.sample;

import java.util.Random;

public class RandomNumberGeneration {

	public static String strCatlog1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
	public static String strCatlog = "1234567890";
	protected String getRandomString(String chars, int size) {
        StringBuilder strBuilder = new StringBuilder();
        Random random = new Random();
        while (strBuilder.length() <= size) { // length of the random string.
            int index = (int) (random.nextFloat() * chars.length());
            strBuilder.append(chars.charAt(index));
        }
        String saltStr = strBuilder.toString();
        return saltStr;

    }
	public static void main(String[] args) {

		RandomNumberGeneration randomGen = new RandomNumberGeneration();
		String randomStr=randomGen.getRandomString(strCatlog,4);
		randomStr=randomStr+"-"+randomGen.getRandomString(strCatlog,4);
		randomStr=randomStr+"-"+randomGen.getRandomString(strCatlog,8);
		randomStr=randomStr+"-"+randomGen.getRandomString(strCatlog,12);
		System.out.println(randomStr);
	}

}
