import com.blablacar.business.Coordinates;
import com.blablacar.utils.ReaderUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CoordinatesTest {

    @Test
    public void should_return_5_6_for_5_6() throws Exception {
        Coordinates coordinates = new Coordinates(5,6);
        assertEquals(coordinates.getX(), 5);
        assertEquals(coordinates.getY(), 6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_for_null_values() throws Exception {
        new Coordinates(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_for_negative_values() throws Exception {
        new Coordinates(-1, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_for_incorrect_values() throws Exception {
        new Coordinates("aze aze");
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_for_outside_bounds() throws Exception {
        new Coordinates("1 1", new Coordinates(0,0));
    }


}
