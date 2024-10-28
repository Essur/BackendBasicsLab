package org.teikado.backendbasicslab.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

class CalculationTest {
    private FunctionCalculator calculation;
    private static final double DELTA = 0.001;

    @BeforeEach
    void setUp() {
        calculation = new FunctionCalculator();
    }

    @Test
    void testCalculateFunctionValues() {
        double a = 2.8, b = -0.3, c = 4;

        // Test value for x < 1.4
        double result1 = calculation.calculate(1.0, a, b, c);
        assertEquals(6.5, result1, DELTA);

        // Test value for x == 1.4
        double result2 = calculation.calculate(1.4, a, b, c);
        assertEquals(3.440, result2, DELTA);

        // Test value for x > 1.4
        double result3 = calculation.calculate(1.5, a, b, c);
        assertEquals(1.303, result3, DELTA);
    }

    @Test
    void testCalculateSteps() {
        double start = 0;
        double end = 2;
        double step = 0.002;
        int expectedSteps = 1001;

        int steps = calculation.calculateSteps(start, end, step);
        assertEquals(expectedSteps, steps);
    }

    @Test
    void testXAndYArrayCreation() {
        double a = 2.8, b = -0.3, c = 4;
        double start = 0, end = 2, step = 0.002;

        calculation.calculateValues(start, end, step, a, b, c);

        double[] xValues = calculation.getXValues();
        double[] yValues = calculation.getYValues();

        assertEquals(1001, xValues.length);
        assertEquals(1001, yValues.length);

        // Check specific elements in x and y arrays
        assertEquals(0, xValues[0], DELTA);
        assertEquals(1.0, xValues[500], DELTA);
        assertEquals(2.0, xValues[1000], DELTA);
    }

    @Test
    void testMaxAndMinIndexes() {
        double a = 2.8, b = -0.3, c = 4;
        double start = 0, end = 2, step = 0.002;

        calculation.calculateValues(start, end, step, a, b, c);

        int maxIndex = calculation.getMaxIndex();
        int minIndex = calculation.getMinIndex();

        double maxValue = calculation.getYValues()[maxIndex];
        double minValue = calculation.getYValues()[minIndex];

        // Assertions for expected behavior of max/min values
        assertEquals(0.983, minValue, DELTA);  // Check minimum value for y
        assertTrue(maxValue > minValue);     // Ensure max value is greater than min
    }

    @Test
    void testSumAndAverageOfYArray() {
        double a = 2.8, b = -0.3, c = 4;
        double start = 0, end = 2, step = 0.002;

        calculation.calculateValues(start, end, step, a, b, c);

        double sum = calculation.getSum();
        double average = calculation.getAverage();
        double[] yValues = calculation.getYValues();

        // Calculate expected values for comparison
        double expectedSum = 0;
        for (double value : yValues) {
            expectedSum += value;
        }
        double expectedAverage = expectedSum / yValues.length;

        assertEquals(expectedSum, sum, DELTA);
        assertEquals(expectedAverage, average, DELTA);
    }
}
