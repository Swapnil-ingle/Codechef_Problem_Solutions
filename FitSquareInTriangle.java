package com.coding.codechef.practice;

import java.util.Scanner;

public class FirSquareInTraingle {

	public static void main(String[] args) {
		int[] testCases = getTestCases();
		
		for (int base : testCases) {
			System.out.println(calculateTriangles(0, base));
		}
	}

	private static int[] getTestCases() {
		Scanner scan = new Scanner(System.in);
		int[] testInputs = new int[scan.nextInt()];
		
		for (int i=0; i < testInputs.length; i++) {
			testInputs[i] = scan.nextInt();
		}
		
		scan.close();
		return testInputs;
	}

	private static int calculateTriangles(int noOfTriangles, int currentBase) {
		if (currentBase < 4) {
			return noOfTriangles;
		} else {
			int remainingLenght = currentBase;
			currentBase = 0;
			while (remainingLenght >= 4) {
				remainingLenght -= 2;
				noOfTriangles++;
				currentBase += 2;
			}
			return calculateTriangles(noOfTriangles, currentBase);
		}
	}
}
