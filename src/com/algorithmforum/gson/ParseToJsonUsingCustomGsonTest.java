package com.algorithmforum.gson;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class ParseToJsonUsingCustomGsonTest {

	public static void main(String[] args) {
		Employee employee = new Employee(10, "Awadh", "M");

		Gson gson = new GsonBuilder().registerTypeAdapter(Employee.class, new EmployeeSeriliazer()).create();
		
		String empStr = gson.toJson(employee);
		System.out.println(empStr);
	}
}

class EmployeeSeriliazer implements JsonSerializer<Employee> {

	@Override
	public JsonElement serialize(Employee src, Type typeOfSrc, JsonSerializationContext context) {
		JsonObject jsonMerchant = new Gson().toJsonTree(src).getAsJsonObject();
		String gender = src.getGender();
		String salutation = null;
		if (gender != null) {
			salutation = gender.equals("M") ? "Mr. " : "Ms. ";
		}
		jsonMerchant.addProperty("name", salutation + src.getName());
		return jsonMerchant;
	}
}
