package com.lwer0.PvPLeague.utils;

import  java.util.Random;

public class RandomWin {
	
	
	//Random int for give points on win
	public static int RandomWin() {
	     Random generator = new Random(System.currentTimeMillis());
	     int randomint = 20 + generator.nextInt(30 - 20 + 1);
	     return randomint;
	}
	public static int RandomLose() {
		Random generator = new Random(System.currentTimeMillis());
	     int randomint = 8 + generator.nextInt(16 - 8 + 1);
	     return randomint;
	}
}
