package com.newer.core.util;

import java.util.Random;

public class StockRandom16 {

	public static StringBuilder random16() {
		StringBuilder s = new StringBuilder();
		Random random = new Random();
		Integer ints;
		for (int i = 0; i < 4 ; i++) {
			ints = (random.nextInt(10000)+100000)%10000;
			// System.out.println(ints.toString());
			s.append(ints.toString());
		}
		return s;
	}
	
	public static void main(String[] args) {
		System.out.println(random16());
	}
}
