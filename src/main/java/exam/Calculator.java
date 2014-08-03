package exam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Jiri
 */
public class Calculator {


    public double calculate(List<Instruction> instructions) {
        validateScript(instructions);
        double value = instructions.remove(instructions.size() - 1).calculate(0d);
        for (Instruction instruction : instructions) {
            value = instruction.calculate(value);
        }
        return value;
    }

    private void validateScript(List<Instruction> instructions) {
        checkNotNull(instructions);
        checkArgument(instructions.get(instructions.size() - 1) instanceof Apply);
    }

    public static void main(String[] args){
        if (args.length != 1) {
            help();
            return;
        }
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(args[0]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            help();
            return;
        }

        Calculator calculator = new Calculator();

        double result = 0;
        try {
            result = calculator.calculate(InstructionBuilder.readFromStream(inputStream));
        } catch (IOException e) {
            e.printStackTrace();
            help();
            return;
        }
        System.out.println(result);

    }

    private static void help() {
        System.out.println("The program accepts only 1 parameter. It has to be a path to a file containing");
        System.out.println("instructions that the calculator should calculate");
    }
}
