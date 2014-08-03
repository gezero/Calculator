package exam.instructions;

import exam.instructions.Instruction;

/**
 * @author Jiri
 */
public class Apply implements Instruction {
    private Double value;

    public Apply(Double value) {
        this.value = value;
    }

    @Override
    public double calculate(double operand) {
        return value;
    }
}
