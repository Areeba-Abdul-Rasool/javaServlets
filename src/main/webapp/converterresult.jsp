<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Conversion Result</title>
</head>
<body>
    <h1>Conversion Result</h1>
    <p>Original Temperature: ${originalTemperature}</p>
    <p>Conversion Type: ${conversionType == 'CtoF' ? 'Celsius to Fahrenheit' : 'Fahrenheit to Celsius'}</p>
    <p>Converted Temperature: ${convertedTemperature}</p>
    <a href="TemperatureConverter.html">Convert another temperature</a>
</body>
</html>
