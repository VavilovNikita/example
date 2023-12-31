package com.StringCrud;

import com.StringCrud.models.Command;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Loader loader = new Loader();

        Validator validator = new Validator();
        Parser parser = new Parser(validator);

        Storage storage = new Storage(loader.loadFromFile());
        Service service = new Service(storage);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(Print.HELP);
            while (true) {
                try {
                    System.out.print("Enter:");
                    String line = scanner.nextLine();
                    if ("QUIT".equals(line) || "quit".equals(line)) {
                        loader.saveToFile(service.getMap());
                        break;
                    }
                    if ("HELP".equals(line) || "help".equals(line)) {
                        System.out.println(Print.HELP);
                        continue;
                    }
                    Command command = parser.parse(line);
                    service.execute(command);

                } catch (Exception e) {
                    e.printStackTrace();
//                    System.out.println(e.getMessage());
                }

            }
        }
    }
}