import com.blablacar.business.Lawn;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LawnTest {

    @Test
    public void should_return_1_3_N_and_5_1_E_for_input_txt() throws Exception {
        Lawn lawn = new Lawn("src/test/resources/input.txt");

        lawn.start();

        assertEquals(lawn.getMowers().get(0).getCoordinates().getX(), 1);
        assertEquals(lawn.getMowers().get(0).getCoordinates().getY(), 3);
        assertEquals(lawn.getMowers().get(0).getOrientation().getLabel(), "N");

        assertEquals(lawn.getMowers().get(1).getCoordinates().getX(), 5);
        assertEquals(lawn.getMowers().get(1).getCoordinates().getY(), 1);
        assertEquals(lawn.getMowers().get(1).getOrientation().getLabel(), "E");
    }

    @Test
    public void should_return_1_2_N_for_input_3x2() throws Exception {
        Lawn lawn = new Lawn("src/test/resources/input_3x2.txt");

        lawn.start();

        assertEquals(lawn.getMowers().get(0).getCoordinates().getX(), 1);
        assertEquals(lawn.getMowers().get(0).getCoordinates().getY(), 2);
        assertEquals(lawn.getMowers().get(0).getOrientation().getLabel(), "N");
    }

    @Test
    public void should_return_0_3_N_for_input_2x3() throws Exception {
        Lawn lawn = new Lawn("src/test/resources/input_2x3.txt");

        lawn.start();

        assertEquals(lawn.getMowers().get(0).getCoordinates().getX(), 0);
        assertEquals(lawn.getMowers().get(0).getCoordinates().getY(), 3);
        assertEquals(lawn.getMowers().get(0).getOrientation().getLabel(), "N");
    }

    @Test
    public void should_return_1_5_N_and_3_0_S_for_input_txt() throws Exception {
        Lawn lawn = new Lawn("src/test/resources/input3.txt");

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
        Lawn lawn = new Lawn("src/test/resources/input4.txt");

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
        new Lawn("src/test/resources/input2.txt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_for_incomplete_file() throws Exception {
        new Lawn("src/test/resources/input5.txt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_for_negative_coordinate() throws Exception {
        new Lawn("src/test/resources/input6.txt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_for_incorrect_instructions() throws Exception {
        Lawn lawn = new Lawn("src/test/resources/input7.txt");
        lawn.start();
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_for_incorrect_coordinate() throws Exception {
        Lawn lawn = new Lawn("src/test/resources/input8.txt");
        lawn.start();
    }

}
