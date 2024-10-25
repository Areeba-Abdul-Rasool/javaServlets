<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fibonacci Sequence Result</title>
</head>
<body>
    <h1>Fibonacci Sequence Result</h1>

    <%
        String error = (String) request.getAttribute("error");
        List<Integer> fibonacciSequence = (List<Integer>) request.getAttribute("fibonacciSequence");
        Integer number = (Integer) request.getAttribute("number");
    %>

    <% if (error != null) { %>
        <p style="color: red;"><%= error %></p>
    <% } else if (fibonacciSequence != null) { %>
        <p>Fibonacci sequence up to <%= number %>:</p>
        <ul>
            <% for (Integer num : fibonacciSequence) { %>
                <li><%= num %></li>
            <% } %>
        </ul>
    <% } %>

    <br>
    <a href="fibonacci.html">Try another number</a>
</body>
</html>
