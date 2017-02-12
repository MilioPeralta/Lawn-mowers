package test.java;

import main.java.com.blablacar.business.Lawn;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Milio PERALTA on 12/02/2017.
 */
public class LawnTest {

    @Test
    public void should_return_1_3_N_and_5_1_E_for_input_txt() throws Exception {
        Lawn lawn = new Lawn("C:\\Users\\Milio\\IdeaProjects\\mowers\\src\\test\\resources\\input.txt");

        lawn.start();

        assertEquals(lawn.getMowers().get(0).getCoordinates().getX(), 1);
        assertEquals(lawn.getMowers().get(0).getCoordinates().getY(), 3);
        assertEquals(lawn.getMowers().get(0).getOrientation().getLabel(), "N");

        assertEquals(lawn.getMowers().get(1).getCoordinates().getX(), 5);
        assertEquals(lawn.getMowers().get(1).getCoordinates().getY(), 1);
        assertEquals(lawn.getMowers().get(1).getOrientation().getLabel(), "E");
    }

    @Test
    public void should_return_1_5_N_and_3_0_S_for_input_txt() throws Exception {
        Lawn lawn = new Lawn("C:\\Users\\Milio\\IdeaProjects\\mowers\\src\\test\\resources\\input3.txt");

        lawn.start();

        assertEquals(lawn.getMowers().get(0).getCoordinates().getX(), 1);
        assertEquals(lawn.getMowers().get(0).getCoordinates().getY(), 5);
        assertEquals(lawn.getMowers().get(0).getOrientation().getLabel(), "N");

        assertEquals(lawn.getMowers().get(1).getCoordinates().getX(), 3);
        assertEquals(lawn.getMowers().get(1).getCoordinates().getY(), 0);
        assertEquals(lawn.getMowers().get(1).getOrientation().getLabel(), "S");
    }

    @Test
    public void should_return_5_5_N_and_0_0_S_for_input_txt() throws Exception {
        Lawn lawn = new Lawn("C:\\Users\\Milio\\IdeaProjects\\mowers\\src\\test\\resources\\input4.txt");

        lawn.start();

        assertEquals(lawn.getMowers().get(0).getCoordinates().getX(), 5);
        assertEquals(lawn.getMowers().get(0).getCoordinates().getY(), 5);
        assertEquals(lawn.getMowers().get(0).getOrientation().getLabel(), "N");

        assertEquals(lawn.getMowers().get(1).getCoordinates().getX(), 0);
        assertEquals(lawn.getMowers().get(1).getCoordinates().getY(), 0);
        assertEquals(lawn.getMowers().get(1).getOrientation().getLabel(), "S");
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_for_BAD_DATA() throws Exception {
        new Lawn("C:\\Users\\Milio\\IdeaProjects\\mowers\\src\\test\\resources\\input2.txt");
    }

}
