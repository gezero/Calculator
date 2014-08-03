package exam.instructions;

import exam.Instruction;

/**
 * @author Jiri
 */
public class Multiply implements Instruction {
    private Double value;

    public Multiply(Double value) {
        this.value = value;
    }
    @Override
    public double calculate(double operand) {
        return operand * value;
    }
}
