package main.java.com.blablacar;

import main.java.com.blablacar.business.Lawn;

public class Main {

    public static void main(String[] args) {
        run(args);
    }

    private static void run(String[] args) {
        String path;
        if (args != null && args.length > 0 && args[0] != null && !args[0].isEmpty()) {
            path = args[0];
        } else {
            path = "src/test/resources/input.txt";
        }

        Lawn lawn = new Lawn(path);
        lawn.start();

        lawn.getMowers().forEach(System.out::println);
    }
}
