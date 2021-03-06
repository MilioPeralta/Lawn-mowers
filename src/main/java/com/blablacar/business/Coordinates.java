package com.blablacar.business;

/**
 * Representation of a coordinates :
 * <p>
 * Indicates a position in integer precision {@code (x,y)}
 * <p>
 * Created by Milio PERALTA on 12/02/2017.
 */
public class Coordinates {

    /**
     * Number of coordinates needed to construct a {@link Coordinates}
     */
    private static final int NUMBER_COORDINATES_NEEDED = 2;

    /**
     * The X coordinate
     */
    private int x;

    /**
     * The Y coordinate
     */
    private int y;

    /**
     * Construct and initialize a {@link Coordinates}
     * at the origin (0,0) e.g. the lower left of the grid
     */
    public Coordinates() {
        this(0, 0);
    }

    /**
     * Construct and initialize a {@link Coordinates}
     * at the given location {@code (x,y)}
     *
     * @param x the X coordinate of the new {@link Coordinates}
     * @param y the Y coordinate of the new {@link Coordinates}
     */
    public Coordinates(int x, int y) {
        if (areCoordinatesValid(x, y)) {
            this.x = x;
            this.y = y;
            return;
        }

        throw new IllegalArgumentException("Invalid Coordinates");
    }

    /**
     * Construct and initialize a {@link Coordinates}
     * at the given location by the line : "X Y"
     *
     * @param line
     */
    public Coordinates(String line) {
        this(line, null);
    }

    /**
     * Construct and initialize a {@link Coordinates}
     * at the given location by the line : "X Y"
     * and checks that the given X Y is in the grid
     * e.g. X <= upperRightCornerCoordinates.getX()
     * and Y <= upperRightCornerCoordinates.getY()
     *
     * @param line
     */
    public Coordinates(String line, Coordinates upperRightCornerCoordinates) {
        if (line != null && !line.isEmpty()) {
            String[] stringCoordinates = line.split(" ");
            if (stringCoordinates.length >= NUMBER_COORDINATES_NEEDED) {
                try {
                    int x = Integer.parseInt(stringCoordinates[0]);
                    int y = Integer.parseInt(stringCoordinates[1]);

                    if (areCoordinatesValid(x, y, upperRightCornerCoordinates)) {
                        this.x = x;
                        this.y = y;
                        return;
                    }

                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid Coordinates");
                }
            }
        }
        throw new IllegalArgumentException("Invalid line for Coordinates");
    }

    /**
     * Checks if the given coordinates are within the range
     * [0, upperRightCornerCoordinates.getX()] for X
     * [0, upperRightCornerCoordinates.getY()] for Y
     *
     * @param x
     * @param y
     * @param upperRightCornerCoordinates
     * @return
     */
    private boolean areCoordinatesValid(int x, int y, Coordinates upperRightCornerCoordinates) {
        boolean isValid = x >= 0 && y >= 0;

        if (upperRightCornerCoordinates != null) {
            isValid &= x <= upperRightCornerCoordinates.getX() && y <= upperRightCornerCoordinates.getY();
        }

        return isValid;
    }

    /**
     * Checks if the given coordinates are within the range
     * [0, Integer.MAX_VALUE] for X
     * [0, Integer.MAX_VALUE] for Y
     *
     * @param x
     * @param y
     * @return
     */
    private boolean areCoordinatesValid(int x, int y) {
        return areCoordinatesValid(x, y, null);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
