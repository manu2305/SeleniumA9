package com.crm.javaUtility;

import java.util.Random;

public class GenerateRandomNumbers {
public static int random() {
	Random r=new Random();
	int value = r.nextInt(1000);
	return value;
}
}
