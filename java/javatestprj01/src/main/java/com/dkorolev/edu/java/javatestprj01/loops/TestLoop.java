package com.dkorolev.edu.java.javatestprj01.loops;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TestLoop {
    public static void main(String[] args) {
	int i = Integer.MAX_VALUE;
	for (int j = 0; j < 10; j++) {
	    System.out.println(i++);
	}
    }

    private static String halfMtrWS(int[][] mtr) {
	StringBuilder result = new StringBuilder();

	for (int i = 0; i < mtr.length; i++) {
	    for (int j = 0; j <= i; j++) {
		result.append(mtr[i][j]).append(" ");
	    }
	    result.append("\n");
	}

	return result.toString();
    }

    private static String readString() {
	Scanner sc = null;
	try {
	    sc = new Scanner(System.in);
	    StringBuilder result = new StringBuilder();
	    boolean isFirstLine = true;
	    boolean continueFlag = true;
	    while (continueFlag) {
		if (!isFirstLine) {
		    result.append("\n");
		} else {
		    isFirstLine = false;
		}
		String line = sc.nextLine();
		if ("".equals(line)) {
		    continueFlag = false;
		} else {
		    result.append(line);
		}
	    }

	    return result.toString();
	} finally {
	    if (sc != null) {
		sc.close();
	    }
	}
    }

    private static int[][] stringToIntArray(String s) {
	String[] rows = s.split("\\n");
	int[][] result = null;
	for (int i = 0; i < rows.length; i++) {
	    String row = rows[i];
	    String[] elements = row.split(" ");

	    if (result == null) {
		result = new int[rows.length][elements.length];
	    }

	    for (int j = 0; j < elements.length; j++) {
		result[i][j] = Integer.valueOf(elements[j]);
	    }
	}
	return result;
    }

    private static String mtrToString(int[][] mtr) {
	StringBuilder result = new StringBuilder();
	for (int i = 0; i < mtr.length; i++) {
	    for (int j = 0; j < mtr[i].length; j++) {
		result.append(mtr[i][j]);
		if (j != mtr[i].length - 1) {
		    result.append(" ");
		}
	    }
	    if (i != mtr.length - 1) {
		result.append("\n");
	    }
	}

	return result.toString();
    }
}
