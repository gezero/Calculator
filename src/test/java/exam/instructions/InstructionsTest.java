package exam.instructions;

import exam.Apply;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class InstructionsTest {

    @Test
    public void addTest() {
        Add add = new Add(10d);

        assertThat(add.calculate(0d), is(10d));
        assertThat(add.calculate(3d), is(13d));
        assertThat(add.calculate(-3d), is(7d));
    }

    @Test
    public void subtractTest() {
        Subtract add = new Subtract(10d);

        assertThat(add.calculate(0d), is(-10d));
        assertThat(add.calculate(3d), is(-7d));
        assertThat(add.calculate(-3d), is(13d));
    }

    @Test
    public void multiplyTest() {
        Multiply add = new Multiply(10d);

        assertThat(add.calculate(0d), is(0d));
        assertThat(add.calculate(3d), is(30d));
        assertThat(add.calculate(-3d), is(-30d));
    }

    @Test
    public void divideTest() {
        Divide add = new Divide(10d);

        assertThat(add.calculate(1d), is(0.1d));
        assertThat(add.calculate(0d), is(0d));
        assertThat(add.calculate(3d), is(0.3d));
        assertThat(add.calculate(-3d), is(-0.3d));
    }

    @Test(expected = ArithmeticException.class)
    public void divideByZeroTest() {
        Divide add = new Divide(0d);
    }

    @Test
    public void applyTest() {
        Apply add = new Apply(10d);

        assertThat(add.calculate(0d), is(10d));
        assertThat(add.calculate(3d), is(10d));
        assertThat(add.calculate(-3d), is(10d));
    }

}