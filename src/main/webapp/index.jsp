<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Calculation Input</title>
</head>
<body>
<h1>Enter Calculation Parameters</h1>
<form action="calculate" method="post">
    <label for="a">Parameter a:</label>
    <input type="number" step="0.01" id="a" name="a" required><br>

    <label for="b">Parameter b:</label>
    <input type="number" step="0.01" id="b" name="b" required><br>

    <label for="c">Parameter c:</label>
    <input type="number" step="0.01" id="c" name="c" required><br>

    <label for="start">Start:</label>
    <input type="number" step="0.001" id="start" name="start" required><br>

    <label for="end">End:</label>
    <input type="number" step="0.001" id="end" name="end" required><br>

    <label for="step">Step:</label>
    <input type="number" step="0.001" id="step" name="step" required><br>

    <input type="submit" value="Calculate">
</form>
</body>
</html>
