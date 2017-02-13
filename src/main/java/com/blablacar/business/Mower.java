package main.java.com.blablacar.business;

/**
 * Representation of a mower :
 * <p>
 * Mower's position is represented by {@link Coordinates} (X,Y)
 * and a {@link CardinalPoint} indicate the orientation according to cardinal notations (N,E,W,S)
 * and a {@link char[]} of instructions
 * <p>
 * Created by Milio PERALTA on 12/02/2017.
 */
public class Mower {
    private Coordinates coordinates;
    private CardinalPoint orientation;
    private char[] instructions;

    /**
     * Construct and initialize a {@link Mower}
     * at the given coordinates and
     * with the given orientation and
     * with the given instruction
     */
    public Mower(Coordinates coordinates, CardinalPoint orientation, char[] instructions) {
        this.coordinates = coordinates;
        this.orientation = orientation;
        this.instructions = instructions;
    }

    /**
     * Construct and initialize a {@link Mower}
     * at the given coordinates and
     * with the given orientation and
     * with the given instruction
     * <p>
     * coordinatesAndOrientation : "1 2 N"
     * instructions : "LFLFLFLFF"
     */
    Mower(String coordinatesAndOrientation, String instructions, Coordinates upperRightCornerCoordinates) {
        this.coordinates = new Coordinates(coordinatesAndOrientation, upperRightCornerCoordinates);
        this.orientation = CardinalPoint.findByLabel(coordinatesAndOrientation.substring(coordinatesAndOrientation.length() - 1));
        this.instructions = instructions.toCharArray();
    }

    /**
     * Play all the instructions
     */
    public void start(Lawn lawn) {
        if (getInstructions() != null && getInstructions().length > 0) {
            for (char instruction : getInstructions()) {
                Instruction.move(instruction, this, lawn);
            }
        }
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public CardinalPoint getOrientation() {
        return orientation;
    }

    void setOrientation(CardinalPoint orientation) {
        this.orientation = orientation;
    }

    private char[] getInstructions() {
        return instructions;
    }

    @Override
    public String toString() {
        return coordinates.getX() + " " + coordinates.getY() + " " + orientation.getLabel();
    }
}
