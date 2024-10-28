package org.teikado.backendbasicslab.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.teikado.backendbasicslab.logic.FunctionCalculator;

import java.io.IOException;

@WebServlet("/calculate")
public class CalculationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        double start = Double.parseDouble(request.getParameter("start"));
        double end = Double.parseDouble(request.getParameter("end"));
        double step = Double.parseDouble(request.getParameter("step"));
        double a = Double.parseDouble(request.getParameter("a"));
        double b = Double.parseDouble(request.getParameter("b"));
        double c = Double.parseDouble(request.getParameter("c"));

        FunctionCalculator calculation = new FunctionCalculator();
        calculation.calculateValues(start, end, step, a, b, c);

        int maxIndex = calculation.getMaxIndex();
        int minIndex = calculation.getMinIndex();
        double sum = calculation.getSum();
        double average = calculation.getAverage();

        request.setAttribute("xValues", calculation.getXValues());
        request.setAttribute("yValues", calculation.getYValues());
        request.setAttribute("maxIndex", maxIndex);
        request.setAttribute("minIndex", minIndex);
        request.setAttribute("maxValue", calculation.getYValues()[maxIndex]);
        request.setAttribute("minValue", calculation.getYValues()[minIndex]);
        request.setAttribute("maxX", calculation.getXValues()[maxIndex]);
        request.setAttribute("minX", calculation.getXValues()[minIndex]);
        request.setAttribute("sum", sum);
        request.setAttribute("average", average);

        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
