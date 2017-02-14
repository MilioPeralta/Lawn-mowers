import com.blablacar.business.Instruction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InstructionTest {

    @Test
    public void should_return_LEFT_for_L() throws Exception {
        assertEquals(Instruction.findByLabel('L'), Instruction.LEFT);
    }

    @Test
    public void should_return_RIGHT_for_R() throws Exception {
        assertEquals(Instruction.findByLabel('R'), Instruction.RIGHT);
    }

    @Test
    public void should_return_FRONT_for_F() throws Exception {
        assertEquals(Instruction.findByLabel('F'), Instruction.FRONT);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_for_incorrect_values() throws Exception {
        Instruction.findByLabel('a');
    }


}
