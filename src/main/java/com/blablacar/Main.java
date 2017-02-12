package main.java.com.blablacar;

import main.java.com.blablacar.business.Lawn;

public class Main {

    public static void main(String[] args) {
        Lawn lawn = new Lawn("C:\\Users\\Milio\\IdeaProjects\\mowers\\src\\main\\resources\\input.txt");
        lawn.start();
    }
}
