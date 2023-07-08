package com.StringCrud;

import java.util.Scanner;

public class StringCRUD extends StringDB {

    public static String[] str;

    public void start() {
        String result = "";
        while (!"quit".equals(result)) {
            System.out.print("Enter: ");
            str = new Scanner(System.in).nextLine().split(" ");
            result = getAnswer();
            System.out.println(result);
        }
        SaveLoad.setProperties(map);//запись в файл
    }


    public String getAnswer() {
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

        return switch (comand) {
            case "create" -> insert(value)
                    ? ("String " + value + " created")
                    : ("String " + value + " invalid");
            case "get" -> (get(id));
            case "delete" -> (remove(id))
                    ? ("String " + value + " delited")
                    : ("String by index " + id + " not found");
            case "update" -> update(value, id)
                    ? ("String with id = " + id + " updated")
                    : ("String with id = " + id + " not found");
            case "quit" -> ("quit");
            default -> "Unexpected value: " + comand;
        };
    }
}
