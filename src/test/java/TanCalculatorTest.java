import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class TanCalculatorTest {

    private static final double DELTA = 0.05;
    private static final double PI = 3.141592653589793D;
    private static final double EPS = 1E-10;


    @ParameterizedTest(name = "Calculate tan({1} PI / {2})")
    @CsvFileSource(resources = "/data.csv")
    void dataTest(Double expectedResult, Integer numerator, Integer denominator) {
        assertEquals(expectedResult, TanCalculator.calculateTan(numerator * PI / denominator, EPS), DELTA);
        assertNotEquals(expectedResult, TanCalculator.calculateTan(numerator * PI / denominator + DELTA, EPS), DELTA);
        assertNotEquals(expectedResult, TanCalculator.calculateTan(numerator * PI / denominator - DELTA, EPS), DELTA);
    }

    @ParameterizedTest(name = "Infinity test tan({0} PI / {1})")
    @CsvSource(value = {"1, 2", "-1, 2", "3, 2", "-3, 2"})
    void infinityTest(Integer numerator, Integer denominator) {
        assertEquals(Double.POSITIVE_INFINITY, TanCalculator.calculateTan(numerator * PI / denominator, EPS), DELTA);
        assertNotEquals(Double.POSITIVE_INFINITY, TanCalculator.calculateTan(numerator * PI / denominator + DELTA, EPS), DELTA);
        assertNotEquals(Double.POSITIVE_INFINITY, TanCalculator.calculateTan(numerator * PI / denominator - DELTA, EPS), DELTA);
    }

    @Test
    void extraValuesTest() {
        assertEquals(Double.NaN, TanCalculator.calculateTan(Double.POSITIVE_INFINITY, EPS));
        assertEquals(Double.NaN, TanCalculator.calculateTan(Double.NEGATIVE_INFINITY, EPS));
        assertEquals(Double.NaN, TanCalculator.calculateTan(Double.NaN, EPS));
    }
}
