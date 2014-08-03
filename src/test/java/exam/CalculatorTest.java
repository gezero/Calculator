package exam;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testCalculate() throws Exception {
        Calculator calculator = new Calculator();

        List<Instruction> instructions = new InstructionBuilder().subtract(10d).apply(15d).build();

        assertThat(calculator.calculate(instructions),is(5d));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWrongScriptCalculate() throws Exception {
        Calculator calculator = new Calculator();

        List<Instruction> instructions = new InstructionBuilder().subtract(10d).apply(15d).divide(10d).build();

        calculator.calculate(instructions);
    }

    @Test
    public void testCalculateLongList() throws Exception {
        Calculator calculator = new Calculator();

        List<Instruction> instructions = new InstructionBuilder()
                .subtract(10d)
                .add(20d)
                .multiply(2d)
                .add(15d)
                .subtract(101d)
                .divide(3d)
                .apply(15d).build();

        // ((15-10+20)*2 + 15 -101)/3 = -12
        assertThat(calculator.calculate(instructions),is(-12d));
    }
}