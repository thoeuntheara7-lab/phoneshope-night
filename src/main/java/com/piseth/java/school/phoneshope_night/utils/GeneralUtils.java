package com.piseth.java.school.phoneshope_night.utils;

import java.util.List;

public class GeneralUtils {

	// convert list of String to Integer
	// ["Dara","Thida","Seyha"]
	// => [4,5,4]

	public static List<Integer> toIngeterList(List<String> list) {
		return list.stream().map(s -> s.length()).toList();
	}
	public static List<Integer> getEvenNumber(List<Integer> list){
		return list.stream().filter(x-> x%2 == 0).toList();
	}

}
