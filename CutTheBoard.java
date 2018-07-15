package com.coding.codechef.practice;

import java.util.Scanner;

class CutTheBoard {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String testCases[] = getInput(scan);
		
		for (int i=0; i<testCases.length; i++) {
			process(testCases[i]);
		}
	}

	private static void process(String testCase) {
		int m = Integer.parseInt(testCase.substring(0, testCase.indexOf(' ')));
		int n = Integer.parseInt(testCase.substring(testCase.indexOf(' ') + 1, testCase.length()));
		
		System.out.println((m-1)*(n-1));
	}

	private static String[] getInput(Scanner scan) {
		String testCases[] = new String[Integer.parseInt(scan.nextLine())];
		for (int i=0; i<testCases.length; i++) {
			testCases[i] = scan.nextLine();
		}
		return testCases;
	}

}
