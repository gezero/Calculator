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
            switch (split[0]){
                case "add":{
                    builder.add(value);
                    break;
                }
                case "subtract":{
                    builder.subtract(value);
                    break;
                }
                case "multiply":{
                    builder.multiply(value);
                    break;
                }
                case "divide":{
                    builder.divide(value);
                    break;
                }
                case "apply":{
                    builder.apply(value);
                    break;
                }
                default:{
                    throw new UnsupportedOperationException("Operation " + split[0] + " is not supported");
                }

            }

        }
        return builder.build();
    }

    private void apply(Double value) {
        instructions.add(new Apply(value));
    }

    private void divide(Double value) {
        instructions.add(new Divide(value));
    }

    private void multiply(Double value) {
        instructions.add(new Multiply(value));
    }

    private InstructionBuilder subtract(Double value) {
        instructions.add(new Subtract(value));
        return this;
    }

    private InstructionBuilder add(Double value) {
        instructions.add(new Add(value));
        return this;
    }

    private List<Instruction> build() {
        return instructions;
    }
}
