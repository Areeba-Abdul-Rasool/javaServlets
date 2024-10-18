<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Character Frequency Result</title>
</head>
<body>
    <h1>Frequency Result</h1>

    <table border="1">
        <tr>
            <th>Character</th>
            <th>Frequency</th>
        </tr>

        <%
            Map<Character, Integer> charFrequencyMap = (Map<Character, Integer>) request.getAttribute("charFrequencyMap");
            if (charFrequencyMap != null) {
                for (Map.Entry<Character, Integer> entry : charFrequencyMap.entrySet()) {
        %>
            <tr>
                <td><%= entry.getKey() %></td>
                <td><%= entry.getValue() %></td>
            </tr>
        <%
                }
            } else {
        %>
            <tr>
                <td colspan="2">No data available.</td>
            </tr>
        <%
            }
        %>
    </table>

    <br>
</body>
</html>
