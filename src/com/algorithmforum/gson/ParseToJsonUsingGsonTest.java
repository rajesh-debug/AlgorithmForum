package com.algorithmforum.gson;

import com.google.gson.Gson;

public class ParseToJsonUsingGsonTest {

	public static void main(String[] args) {
		Employee employee = new Employee(10, "Awadh", "F");
		
		
		Gson gson = new Gson();
		String empStr = gson.toJson(employee);
		
		System.out.println(empStr);
	}
}
