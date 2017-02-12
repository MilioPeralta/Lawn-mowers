package main.java.com.blablacar.business;

import java.util.function.BiFunction;

/**
 * Created by Milio PERALTA on 12/02/2017.
 */
public enum Instruction implements BiFunction<Mower, Lawn, Mower> {
    LEFT('L', Instruction::turnLeft),
    RIGHT('R', Instruction::turnRight),
    FRONT('F', Instruction::goForward);

    private static Mower turnLeft(Mower mower, Lawn lawn) {
        mower.setOrientation(mower.getOrientation().turnLeft());
        return mower;
    }

    private static Mower turnRight(Mower mower, Lawn lawn) {
        mower.setOrientation(mower.getOrientation().turnRight());
        return mower;
    }

    private static Mower goForward(Mower mower, Lawn lawn) {
        Coordinates coordinates = mower.getCoordinates();
        Coordinates nextCoordinates = new Coordinates();
        CardinalPoint orientation = mower.getOrientation();
        int gridSize = lawn.getGrid().length;


        switch (orientation) {
            case NORTH:
                nextCoordinates.setX(coordinates.getX());
                nextCoordinates.setY(getValidCoordinate(coordinates.getY() + 1, gridSize));
                break;
            case EAST:
                nextCoordinates.setX(getValidCoordinate(coordinates.getX() + 1, gridSize));
                nextCoordinates.setY(coordinates.getY());
                break;
            case WEST:
                nextCoordinates.setX(getValidCoordinate(coordinates.getX() - 1, gridSize));
                nextCoordinates.setY(coordinates.getY());
                break;
            case SOUTH:
                nextCoordinates.setX(coordinates.getX());
                nextCoordinates.setY(getValidCoordinate(coordinates.getY() - 1, gridSize));
                break;
        }

        mower.setCoordinates(nextCoordinates);
        return mower;
    }

    private static int getValidCoordinate(int newCoordinate, int gridSize) {
        if (newCoordinate < 0) {
            return 0;
        }
        return Math.min(gridSize, newCoordinate);
    }

    @Override
    public Mower apply(Mower t, Lawn a) {
        return binaryOperator.apply(t, a);
    }

    private char label;
    private final BiFunction<Mower, Lawn, Mower> binaryOperator;

    Instruction(char label, BiFunction<Mower, Lawn, Mower> binaryOperator) {
        this.label = label;
        this.binaryOperator = binaryOperator;
    }

    public static Instruction findByLabel(char label) {
        for (Instruction instruction : Instruction.values()) {
            if (instruction.getLabel() == label) {
                return instruction;
            }
        }
        throw new IllegalArgumentException();
    }

    public char getLabel() {
        return label;
    }

    public static void move(char c, Mower mower, Lawn lawn) {
        Instruction instruction = findByLabel(c);
        instruction.apply(mower, lawn);
    }
}
