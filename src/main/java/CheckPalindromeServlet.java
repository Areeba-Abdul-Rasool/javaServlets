import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/checkPalindrome")
public class CheckPalindromeServlet extends HttpServlet {

    private boolean isPalindrome(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equalsIgnoreCase(reversed);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String inputString = request.getParameter("inputString");

        if (inputString == null || inputString.trim().isEmpty()) {
            response.sendRedirect("error.jsp");
            return;
        }

        boolean isPalindrome = isPalindrome(inputString.trim());

        request.setAttribute("inputString",inputString);
        request.setAttribute("isPalindrome",isPalindrome);

        request.getRequestDispatcher("palindromeResult.jsp").forward(request, response);
    }
}

