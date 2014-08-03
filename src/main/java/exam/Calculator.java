package exam;

import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Jiri
 */
public class Calculator {


    public double calculate(List<Instruction> instructions) {
        validateScript(instructions);
        double value = instructions.remove(instructions.size()-1).calculate(0d);
        for (Instruction instruction : instructions) {
            value = instruction.calculate(value);
        }
        return value;
    }

    private void validateScript(List<Instruction> instructions) {
        checkNotNull(instructions);
        checkArgument(instructions.get(instructions.size()-1) instanceof Apply);
    }
}
