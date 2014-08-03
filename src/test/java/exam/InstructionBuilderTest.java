package exam;

import com.sun.org.apache.xpath.internal.operations.Mult;
import exam.instructions.Add;
import exam.instructions.Divide;
import exam.instructions.Multiply;
import exam.instructions.Subtract;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class InstructionBuilderTest {
    @Test
    public void checkBuilding(){
        InstructionBuilder builder = new InstructionBuilder();

        List<Instruction> instructions =
                builder
                        .addInstruction("subtract", 10d)
                        .addInstruction("apply", 3d)
                        .addInstruction("multiply",2d)
                        .addInstruction("divide",5d)
                        .addInstruction("add",7d)
                        .build();

        assertThat(instructions.size(),is(5));
        assertThat(instructions.get(0) instanceof Subtract,is(true));
        assertThat(instructions.get(1) instanceof Apply,is(true));
        assertThat(instructions.get(2) instanceof Multiply,is(true));
        assertThat(instructions.get(3) instanceof Divide,is(true));
        assertThat(instructions.get(4) instanceof Add,is(true));

        assertThat(instructions.get(0).calculate(3),is(-7d));
        assertThat(instructions.get(1).calculate(3),is(3d));
        assertThat(instructions.get(2).calculate(3),is(6d));
        assertThat(instructions.get(3).calculate(3),is(0.6d));
        assertThat(instructions.get(4).calculate(3),is(4d));

    }

}