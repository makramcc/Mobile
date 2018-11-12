package com;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.logging.Logger;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Servicehelper {
	public static <T extends Object> String parseToJson(LinkedList<LinkedList<String>> link) {
		ObjectMapper mapper = new ObjectMapper();
		String response = null;
		try {
			response = mapper.writeValueAsString(link);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}
	
	public static LinkedList<LinkedList<String>> parseFromJson(String json) {
		ObjectMapper mapper = new ObjectMapper();
		LinkedList<LinkedList<String>> response = null;
	 	try {
			response = mapper.readValue(json, new TypeReference<LinkedList<LinkedList<String>>>(){});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}
}
