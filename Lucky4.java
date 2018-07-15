package com.coding.codechef.practice;

import java.util.Scanner;

public class Lucky4 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int size = input.nextInt();
		String[] listOfIntegers = new String[size];
		
		for (int i = 0; i < size; i++) {
			listOfIntegers[i] = input.next();
		}
		
		for (String integer : listOfIntegers) {
			System.out.println(occurenceOfFour(integer));
		}
		
		input.close();
	}

	private static int occurenceOfFour(String integer) {
		int startAt = 0;
		int occurence = 0;
		
		while (integer.indexOf("4", startAt) != -1) {
			startAt = integer.indexOf("4", startAt);
			occurence += 1;
			startAt += 1;
		}
		
		return occurence;
	}

}
