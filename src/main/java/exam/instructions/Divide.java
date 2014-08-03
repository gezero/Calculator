package exam.instructions;

import exam.Instruction;

/**
 * @author Jiri
 */
public class Divide implements Instruction {
    private Double value;

    public Divide(Double value) {
        this.value = value;
    }

    @Override
    public double calculate(double operand) {
        return operand / value;
    }
}
