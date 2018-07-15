package com.coding.codechef.practice;

import java.util.Scanner;

public class FindPermutation {

	public static void main(String[] args) {
		int[] permute = getInput();
		
	}

	private static int[] getInput() {
		Scanner scan = new Scanner(System.in);
		int numberOfInt = scan.nextInt();
		int[] permute = new int[numberOfInt];
		
		for (int i=0;i<numberOfInt;i++) {
			permute[i] = scan.nextInt();
		}
		scan.close();
		return permute;
	}

}
