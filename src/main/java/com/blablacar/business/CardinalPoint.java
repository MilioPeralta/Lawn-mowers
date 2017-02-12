package main.java.com.blablacar.business;

/**
 * Representation of a cardinal point
 *
 * Each cardinalPoint has two methods :
 * - turnLeft : turn at 90° on the left
 * - turnRight : turn at 90° on the right
 * <p>
 * Created by Milio PERALTA on 12/02/2017.
 */
public enum CardinalPoint {
    NORTH("N") {
        @Override
        public CardinalPoint turnLeft() {
            return CardinalPoint.WEST;
        }

        @Override
        public CardinalPoint turnRight() {
            return CardinalPoint.EAST;
        }
    },
    EAST("E") {
        @Override
        public CardinalPoint turnLeft() {
            return CardinalPoint.NORTH;
        }

        @Override
        public CardinalPoint turnRight() {
            return CardinalPoint.SOUTH;
        }
    },
    WEST("W") {
        @Override
        public CardinalPoint turnLeft() {
            return CardinalPoint.SOUTH;
        }

        @Override
        public CardinalPoint turnRight() {
            return CardinalPoint.NORTH;
        }
    },
    SOUTH("S") {
        @Override
        public CardinalPoint turnLeft() {
            return CardinalPoint.EAST;
        }

        @Override
        public CardinalPoint turnRight() {
            return CardinalPoint.WEST;
        }
    };

    private String label;

    public abstract CardinalPoint turnLeft();

    public abstract CardinalPoint turnRight();

    CardinalPoint(String label) {
        this.label = label;
    }

    public static CardinalPoint findByLabel(String label) {
        for (CardinalPoint cardinalPoint : CardinalPoint.values()) {
            if (cardinalPoint.getLabel().equals(label)) {
                return cardinalPoint;
            }
        }
        throw new IllegalArgumentException();
    }

    public String getLabel() {
        return label;
    }

}
