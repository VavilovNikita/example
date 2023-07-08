package com.StringCrud;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class SaveLoad {
	public static Map<Integer, String> properties = new HashMap<>();
	static String name = "C:\\Users\\vavil\\git\\example\\file.properties";//честно пытался не харкодить тут(нет)

	public static void save() throws Exception {
		FileOutputStream fileOutputStream = new FileOutputStream(name);
		PrintWriter writer = new PrintWriter(fileOutputStream);
		for (Map.Entry<Integer, String> pair : properties.entrySet()) {
			Integer key = pair.getKey();
			String value = pair.getValue();
			String keyValue = key + ":" + value + "\n";
			writer.write(keyValue);
			writer.flush();
		}
		fileOutputStream.close();
	}

	public static Map<Integer, String> getProperties() {
		try {
			return load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void setProperties(Map<Integer, String> properties){
		SaveLoad.properties = properties;
		try {
			save();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Map load() throws Exception {
		FileInputStream fileInputStream = new FileInputStream(name);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
		while (bufferedReader.ready()) {
			String[] s = bufferedReader.readLine().split(":");
			properties.put(Integer.parseInt(s[0]), s[1]);
		}
		bufferedReader.close();
		return properties;
	}
}
