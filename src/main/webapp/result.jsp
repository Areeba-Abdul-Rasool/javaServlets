<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<h2>Calculation Result</h2>
<p>
     <%= request.getAttribute("num1") %>
    <%= request.getAttribute("operation") %>
    <%= request.getAttribute("num2") %> = <%= request.getAttribute("result") %>


 </p>
<a href="calculator.html">Perform Another Calculation</a>
</body>
</html>
