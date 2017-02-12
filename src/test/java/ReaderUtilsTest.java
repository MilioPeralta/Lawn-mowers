package test.java;

import main.java.com.blablacar.utils.ReaderUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Milio PERALTA on 12/02/2017.
 */
public class ReaderUtilsTest {

    @Test
    public void should_return_built_list_for_input() throws Exception {
        List<String> expected = new ArrayList<>();
        expected.add("5 5");
        expected.add("1 2 N");
        expected.add("LFLFLFLFF");
        expected.add("3 3 E");
        expected.add("FFRFFRFRRF");

        ReaderUtils readerUtils = new ReaderUtils("C:\\Users\\Milio\\IdeaProjects\\mowers\\src\\test\\resources\\input.txt");

        assertEquals(readerUtils.read(), expected);
    }


}
