package main.java.com.blablacar.business;

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
     * at the origin (0,0) e.g. the lower left of a grid
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
        this.x = x;
        this.y = y;
    }

    /**
     * Construct and initialize a {@link Coordinates}
     * at the given location by the line : "X Y"
     *
     * @param line
     */
    public Coordinates(String line) {
        String[] stringCoordinates = line.split(" ");
        if (stringCoordinates.length >= NUMBER_COORDINATES_NEEDED) {
            try {
                int x = Integer.parseInt(stringCoordinates[0]);
                int y = Integer.parseInt(stringCoordinates[1]);

                if (x >= 0 && y >= 0) {
                    this.x = x;
                    this.y = y;
                    return;
                }

            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
        throw new IllegalArgumentException();
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