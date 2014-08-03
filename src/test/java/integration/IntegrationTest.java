package integration;

import exam.Calculator;
import exam.InstructionBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Jiri
 */
public class IntegrationTest {
    Calculator calculator = new Calculator();

    @Test
    public void program1() throws IOException {
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/programs/program1");
        assertThat(calculator.calculate(InstructionBuilder.readFromStream(resourceAsStream)), is(15d));
    }

    @Test
    public void program2() throws IOException {
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/programs/program2");
        assertThat(calculator.calculate(InstructionBuilder.readFromStream(resourceAsStream)), is(45d));
    }

    @Test
    public void program3() throws IOException {
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/programs/program3");
        assertThat(calculator.calculate(InstructionBuilder.readFromStream(resourceAsStream)), is(1d));
    }
}
