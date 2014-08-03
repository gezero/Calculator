package exam.instructions;

/**
 * @author Jiri
 */
public class Add implements Instruction {
    private Double value;

    public Add(Double value) {
        this.value = value;
    }

    @Override
    public double calculate(double operand) {
        return operand + value;
    }
}
