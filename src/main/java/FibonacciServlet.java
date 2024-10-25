import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/generateFibonacci")
public class FibonacciServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String numberStr = request.getParameter("number");

        if (numberStr == null || numberStr.trim().isEmpty()) {
            request.setAttribute("error", "Please enter a valid number.");
            request.getRequestDispatcher("fiboResult.jsp").forward(request, response);
            return;
        }

        try {
            int number = Integer.parseInt(numberStr.trim());

            if (number < 0) {
                request.setAttribute("error", "Please enter a non-negative number.");
                request.getRequestDispatcher("fiboResult.jsp").forward(request, response);
                return;
            }

            List<Integer> fibonacciSequence = generateFibonacci(number);

            request.setAttribute("fibonacciSequence", fibonacciSequence);
            request.setAttribute("number", number);
            request.getRequestDispatcher("fiboResult.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid number format.");
            request.getRequestDispatcher("fiboResult.jsp").forward(request, response);
        }
    }

    private List<Integer> generateFibonacci(int number) {
        List<Integer> list = new ArrayList<>();
        int a = 0, b = 1;
        while (a <= number) {
            list.add(a);
            int temp = a + b;
            a = b;
            b = temp;
        }
        return list;
    }
}
