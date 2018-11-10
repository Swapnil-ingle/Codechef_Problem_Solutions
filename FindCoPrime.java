package com.coding.codechef.practice;

import java.util.Scanner;

public class FindCoPrime {
	// CoPrime numbers are numbers 
	// that have common factor
	// as 1 only.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the two numbers: ");
		String[] input = sc.nextLine().split(" ");
		
		try {
			if (areCoPrime(Integer.parseInt(input[0]),Integer.parseInt(input[1]))) {
				System.out.println("Yes, these numbers are co prime indeed!");
			}
		} catch (Exception e) {
			System.out.println("Exception occured: " + e.getMessage());
		}
		
		sc.close();
	}

	private static boolean areCoPrime(int firstInt, int secondInt) {
		for (int i=2; i<firstInt; i++) {
			if ((i % firstInt == 0) && (i % secondInt == 0)) {
				return true;
			} else {
				continue;
			}
		}
		
		return false;
	}

}
