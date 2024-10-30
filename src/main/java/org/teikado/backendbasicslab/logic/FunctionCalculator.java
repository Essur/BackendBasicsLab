package org.teikado.backendbasicslab.logic;

public class FunctionCalculator {
    private double[] xValues;
    private double[] yValues;

    public void calculateValues(double start, double end, double step, double a, double b, double c) {
        int steps = calculateSteps(start, end, step);
        xValues = new double[steps];
        yValues = new double[steps];

        for (int i = 0; i < steps; i++) {
            double x = start + i * step;
            xValues[i] = x;
            yValues[i] = calculate(x, a, b, c);
        }
    }

    public int calculateSteps(double start, double end, double step) {
        return (int) ((end - start) / step) + 1;
    }

    public double calculate(double x, double a, double b, double c) {
        if (x < 1.4 - 0.00000000001) {
            return a * x * x + b * x + c;
        } else if (x > 1.4 + 0.00000000001) {
            return (a + b * x) / Math.sqrt(x * x + 1);
        } else {
            return a / x * Math.sqrt(x * x + 1);
        }
    }

    public double[] getXValues() {
        return xValues;
    }

    public double[] getYValues() {
        return yValues;
    }

    public int getMaxIndex() {
        int maxIndex = 0;
        for (int i = 1; i < yValues.length; i++) {
            if (yValues[i] > yValues[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public int getMinIndex() {
        int minIndex = 0;
        for (int i = 1; i < yValues.length; i++) {
            if (yValues[i] < yValues[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }
    public double getSum() {
        double sum = 0;
        for (double value : yValues) {
            sum += value;
        }
        return sum;
    }

    public double getAverage() {
        return getSum() / yValues.length;
    }
}
