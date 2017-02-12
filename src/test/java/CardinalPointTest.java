package test.java;

import main.java.com.blablacar.business.CardinalPoint;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardinalPointTest {

    @Test
    public void should_return_NORTH_for_N() throws Exception {
        assertEquals(CardinalPoint.findByLabel("N"), CardinalPoint.NORTH);
    }

    @Test
    public void should_return_EAST_for_E() throws Exception {
        assertEquals(CardinalPoint.findByLabel("E"), CardinalPoint.EAST);
    }

    @Test
    public void should_return_WEST_for_W() throws Exception {
        assertEquals(CardinalPoint.findByLabel("W"), CardinalPoint.WEST);
    }

    @Test
    public void should_return_SOUTH_for_S() throws Exception {
        assertEquals(CardinalPoint.findByLabel("S"), CardinalPoint.SOUTH);
    }

    @Test
    public void should_return_WEST_for_NORTH_turn_left() throws Exception {
        assertEquals(CardinalPoint.NORTH.turnLeft(), CardinalPoint.WEST);
    }

    @Test
    public void should_return_EAST_for_NORTH_turn_right() throws Exception {
        assertEquals(CardinalPoint.NORTH.turnRight(), CardinalPoint.EAST);
    }

    @Test
    public void should_return_NORTH_for_EAST_turn_left() throws Exception {
        assertEquals(CardinalPoint.EAST.turnLeft(), CardinalPoint.NORTH);
    }

    @Test
    public void should_return_SOUTH_for_EAST_turn_right() throws Exception {
        assertEquals(CardinalPoint.EAST.turnRight(), CardinalPoint.SOUTH);
    }

    @Test
    public void should_return_EAST_for_SOUTH_turn_left() throws Exception {
        assertEquals(CardinalPoint.SOUTH.turnLeft(), CardinalPoint.EAST);
    }

    @Test
    public void should_return_WEST_for_SOUTH_turn_right() throws Exception {
        assertEquals(CardinalPoint.SOUTH.turnRight(), CardinalPoint.WEST);
    }

    @Test
    public void should_return_WEST_for_WEST_turn_left() throws Exception {
        assertEquals(CardinalPoint.WEST.turnLeft(), CardinalPoint.SOUTH);
    }

    @Test
    public void should_return_EAST_for_WEST_turn_right() throws Exception {
        assertEquals(CardinalPoint.WEST.turnRight(), CardinalPoint.NORTH);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_for_BAD_DATA() throws Exception {
        CardinalPoint.findByLabel(null);
    }
}
