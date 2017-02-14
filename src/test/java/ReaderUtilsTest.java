import com.blablacar.utils.ReaderUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ReaderUtilsTest {

    @Test
    public void should_return_built_list_for_input() throws Exception {
        List<String> expected = Arrays.asList("5 5", "1 2 N", "LFLFLFLFF", "3 3 E", "FFRFFRFRRF");

        ReaderUtils readerUtils = new ReaderUtils("src/test/resources/input.txt");

        assertEquals(readerUtils.read(), expected);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_for_incorrect_file_path() throws Exception {
        new ReaderUtils(null);
    }


}
