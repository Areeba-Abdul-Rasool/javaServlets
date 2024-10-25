import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/calculate")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String num1Str = request.getParameter("num1");
            String num2Str = request.getParameter("num2");
            String operation = request.getParameter("operation");

            if (num1Str==null || num2Str==null || operation == null ||
                    num1Str.trim().isEmpty() || num2Str.trim().isEmpty()) {
                response.sendRedirect("error.jsp");
                return;
            }

            double num1 =Double.parseDouble(num1Str.trim());
            double num2 =Double.parseDouble(num2Str.trim());
            double result=0;
            String op = "";

            switch (operation) {
                case "add":
                    result = num1 + num2;
                    op = "+";
                    break;
                case "subtract":
                    result = num1 - num2;
                    op = "-";
                    break;
                case "multiply":
                    result = num1*num2;
                    op = "*";
                    break;
                case "divide":
                    if (num2!=0) {
                        result = num1/num2;
                        op = "/";
                    } else {
                        response.sendRedirect("error.jsp");
                        return;
                    }
                    break;
                default:
                    response.sendRedirect("error.jsp");
                    return;
            }

            request.setAttribute("result", result);
            request.setAttribute("operation", op);
            request.setAttribute("num1", num1);
            request.setAttribute("num2", num2);

            request.getRequestDispatcher("result.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            response.sendRedirect("error.jsp");
        } catch (Exception e) {
            response.sendRedirect("error.jsp");
        }
    }
}
