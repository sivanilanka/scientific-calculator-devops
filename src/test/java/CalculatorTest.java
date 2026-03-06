import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    public void testSquareRoot() {
        assertEquals(4.0, Math.sqrt(16), 0.001);
    }

    @Test
    public void testFactorial() {
        int n = 5;
        int fact = 1;
        for(int i = 1; i <= n; i++) {
            fact *= i;
        }
        assertEquals(120, fact);
    }

    @Test
    public void testNaturalLog() {
        assertEquals(1.0, Math.log(Math.E), 0.001);
    }

    @Test
    public void testPower() {
        assertEquals(8.0, Math.pow(2,3), 0.001);
    }
}
