package com.StringCrud;

import java.util.Scanner;

public class StringCRUD extends StringDB {

	public static String testRequest = "";

	public void strat(){
		String resault = "";
		while (!"quit".equals(resault)) {
			resault = doStart();
			System.out.println(resault);
		}
		Solution.setProperties(map);//запись в файл
	}

	public void setTestRequest(String testRequest) {
		this.testRequest = testRequest;//ввод запросов для тестов
	}

	public String doStart() {
		String[] str;
		if (testRequest.equals("")) {//проверка был лии запрос от теста
			System.out.print("Enter: ");
			str = new Scanner(System.in).nextLine().split(" ");
		} else {
			str = testRequest.split(" ");
		}
		String comand = str[0].toLowerCase();
		String value = "";
		int id = -1;
		if (str.length > 1) {
			if (Character.isDigit(str[1].charAt(0))) {
				id = Integer.parseInt(str[1]);
				if (str.length > 2) {
					value = str[2];
				}
			} else {
				value = str[1];
			}
		}

		switch (comand) {
			case "create":
				if (insert(value)) {
					return ("String " + value + " created");
				} else {
					return ("String " + value + " invalid");
				}


			case "get":
				return (get(id));
			case "delite":
				if (remove(id)) {
					return ("String " + value + " delited");
				} else {
					return ("String by index " + id + " not found");
				}
			case "update":
				if (update(value, id)) {
					return ("String with id = " + id + " updated");
				} else {
					return ("String with id = " + id + " not found");
				}
			case "quit":
				return ("quit");
			default:
				return "Unexpected value: " + comand;
		}
	}

}
