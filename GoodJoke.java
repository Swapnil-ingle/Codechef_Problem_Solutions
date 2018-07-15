package com.coding.codechef.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GoodJoke {

	public static void main(String[] args) {
		Map<Integer, String[]> testCase_To_PointsDetail = new HashMap<Integer, String[]>();
		testCase_To_PointsDetail = getInput(testCase_To_PointsDetail);
		
	}

	private static Map<Integer, String[]> getInput(Map<Integer, String[]> testCase_To_PointsDetail) {
		Scanner scan = new Scanner(System.in);
		int totalCase = Integer.parseInt(scan.nextLine());
		for (int currentCase = 0; currentCase<totalCase; currentCase++) {
			
			int totalNoOfPoints = Integer.parseInt(scan.nextLine());
			String[] pointDetail = new String[totalNoOfPoints];
			
			for (int currentPoint = 0; currentPoint < totalNoOfPoints; currentPoint++) {
				pointDetail[currentPoint] = scan.nextLine();
			}
			
			testCase_To_PointsDetail.put(currentCase, pointDetail);
		}
		scan.close();
		
		return testCase_To_PointsDetail;
	}

}
