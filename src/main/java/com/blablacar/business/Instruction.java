package com.blablacar.business;

import java.util.function.BiFunction;

/**
 * Representation of an instruction with its associated method :
 * <p>
 * - turnLeft : turn the mower at 90° on the left without moving the mower
 * - turnRight : turn the mower at 90° on the right without moving the mower
 * - goForward : means the mower move forward from one space in the direction in which it faces and without changing the orientation
 * <p>
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
        Coordinates upperRightCornerCoordinates = lawn.getUpperRightCornerCoordinates();

        switch (orientation) {
            case NORTH:
                nextCoordinates.setX(coordinates.getX());
                nextCoordinates.setY(getValidCoordinate(coordinates.getY() + 1, upperRightCornerCoordinates.getY()));
                break;
            case EAST:
                nextCoordinates.setX(getValidCoordinate(coordinates.getX() + 1, upperRightCornerCoordinates.getX()));
                nextCoordinates.setY(coordinates.getY());
                break;
            case WEST:
                nextCoordinates.setX(getValidCoordinate(coordinates.getX() - 1, upperRightCornerCoordinates.getX()));
                nextCoordinates.setY(coordinates.getY());
                break;
            case SOUTH:
                nextCoordinates.setX(coordinates.getX());
                nextCoordinates.setY(getValidCoordinate(coordinates.getY() - 1, upperRightCornerCoordinates.getY()));
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
        throw new IllegalArgumentException("Unknown Instruction");
    }

    private char getLabel() {
        return label;
    }

    public static void move(char c, Mower mower, Lawn lawn) {
        Instruction instruction = findByLabel(c);
        instruction.apply(mower, lawn);
    }
}
