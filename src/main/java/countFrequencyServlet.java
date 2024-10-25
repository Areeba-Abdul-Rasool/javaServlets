import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/Countfequency")
public class countFrequencyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String inputString = request.getParameter("inputString");

        Map<Character, Integer> charFrequencyMap = new HashMap<>();

        for (char c : inputString.toCharArray()) {
            charFrequencyMap.put(c,charFrequencyMap.getOrDefault(c, 0) + 1);
        }

        request.setAttribute("charFrequencyMap", charFrequencyMap);
        request.getRequestDispatcher("frequencyResult.jsp").forward(request, response);
    }
}
