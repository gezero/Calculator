package exam.instructions;

import exam.Instruction;

/**
 * @author Jiri
 */
public class Subtract implements Instruction {
    private Double value;

    public Subtract(Double value) {
        this.value = value;
    }
    @Override
    public double calculate(double operand) {
        return operand + value;
    }
}
