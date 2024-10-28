<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Calculation Results</title>
</head>
<body>
<h1>Calculation Results</h1>

<h2>Additional Data</h2>
<p>Maximum element: index = <%= request.getAttribute("maxIndex") %>, y = <%= request.getAttribute("maxValue") %>, x = <%= request.getAttribute("maxX") %></p>
<p>Minimum element: index = <%= request.getAttribute("minIndex") %>, y = <%= request.getAttribute("minValue") %>, x = <%= request.getAttribute("minX") %></p>
<p>Sum of y array elements: <%= request.getAttribute("sum") %></p>
<p>Average of y array elements: <%= request.getAttribute("average") %></p>

<h2>Values Table</h2>
<table border="1">
    <tr>
        <th>Index</th>
        <th>Argument (x)</th>
        <th>Function Value (y)</th>
    </tr>
    <%
        double[] xValues = (double[]) request.getAttribute("xValues");
        double[] yValues = (double[]) request.getAttribute("yValues");

        for (int i = 0; i < xValues.length; i++) {
    %>
    <tr>
        <td><%= i %></td>
        <td><%= xValues[i] %></td>
        <td><%= yValues[i] %></td>
    </tr>
    <% } %>
</table>
<a href="index.jsp">Enter New Values</a>
</body>
</html>
