package test.java;

import main.java.com.blablacar.business.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Milio PERALTA on 12/02/2017.
 */
public class MowersTest {

    private Lawn lawn;

    @Before
    public void before() {
        lawn = new Lawn(new int[5][5], null);
    }

    @Test
    public void should_return_0_0_NORTH_for_0_0_N_and_no_instruction() throws Exception {
        Mower mower = new Mower(new Coordinates(0, 0), CardinalPoint.NORTH, null);
        mower.start(lawn);

        assertEquals(mower.getCoordinates().getX(), 0);
        assertEquals(mower.getCoordinates().getY(), 0);
        assertEquals(mower.getOrientation(), CardinalPoint.NORTH);
    }

    @Test
    public void should_return_0_0_NORTH_for_0_0_WEST_and_turn_left() throws Exception {
        char[] instructions = "L".toCharArray();
        Mower mower = new Mower(new Coordinates(0, 0), CardinalPoint.NORTH, instructions);
        mower.start(lawn);

        assertEquals(mower.getCoordinates().getX(), 0);
        assertEquals(mower.getCoordinates().getY(), 0);
        assertEquals(mower.getOrientation(), CardinalPoint.WEST);
    }

    @Test
    public void should_return_0_0_NORTH_for_0_0_EAST_and_turn_right() throws Exception {
        char[] instructions = "R".toCharArray();
        Mower mower = new Mower(new Coordinates(0, 0), CardinalPoint.NORTH, instructions);
        mower.start(lawn);

        assertEquals(mower.getCoordinates().getX(), 0);
        assertEquals(mower.getCoordinates().getY(), 0);
        assertEquals(mower.getOrientation(), CardinalPoint.EAST);
    }

    @Test
    public void should_return_0_0_NORTH_for_0_1_NORTH_and_go_forward() throws Exception {
        char[] instructions = "F".toCharArray();
        Mower mower = new Mower(new Coordinates(0, 0), CardinalPoint.NORTH, instructions);
        mower.start(lawn);

        assertEquals(mower.getCoordinates().getX(), 0);
        assertEquals(mower.getCoordinates().getY(), 1);
        assertEquals(mower.getOrientation(), CardinalPoint.NORTH);
    }


}
