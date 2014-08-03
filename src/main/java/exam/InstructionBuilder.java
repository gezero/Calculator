package exam;

import exam.instructions.Add;
import exam.instructions.Divide;
import exam.instructions.Multiply;
import exam.instructions.Subtract;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiri
 */
public class InstructionBuilder {
    private List<Instruction> instructions = new ArrayList<>();

    public static List<Instruction> readFromStream(InputStream inputStream) throws IOException {
        Reader reader = new InputStreamReader(inputStream);
        return readFromReader(reader);
    }

    public static List<Instruction> readFromReader(Reader reader) throws IOException {
        InstructionBuilder builder = new InstructionBuilder();
        BufferedReader bufferedReader = new BufferedReader(reader);

        String line;
        while ((line = bufferedReader.readLine()) != null){
            String[] split = line.split(" ");
            Double value = Double.valueOf(split[1]);
            builder.addInstruction(split[0], value);

        }
        return builder.build();
    }

    public InstructionBuilder addInstruction(String instruction, Double value) {
        switch (instruction){
            case "add":{
                return add(value);
            }
            case "subtract":{
                return subtract(value);
            }
            case "multiply":{
                return multiply(value);
            }
            case "divide":{
                return divide(value);
            }
            case "apply":{
                return apply(value);
            }
            default:{
                throw new UnsupportedOperationException("Operation " + instruction + " is not supported");
            }

        }
    }

    public InstructionBuilder apply(Double value) {
        instructions.add(new Apply(value));
        return this;
    }

    public InstructionBuilder divide(Double value) {
        instructions.add(new Divide(value));
        return this;
    }

    public InstructionBuilder multiply(Double value) {
        instructions.add(new Multiply(value));
        return this;
    }

    public InstructionBuilder subtract(Double value) {
        instructions.add(new Subtract(value));
        return this;
    }

    public InstructionBuilder add(Double value) {
        instructions.add(new Add(value));
        return this;
    }

    public List<Instruction> build() {
        return instructions;
    }
}
