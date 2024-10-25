import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/convert")
public class TempConverterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String temperatureStr = request.getParameter("temperature");
            String conversionType = request.getParameter("conversionType");

            if (temperatureStr == null || conversionType == null || temperatureStr.trim().isEmpty()) {
                response.sendRedirect("error.jsp");
                return;
            }

            double temperature = Double.parseDouble(temperatureStr.trim());
            double convertedTemperature = 0;

            switch (conversionType) {
                case "CtoF":
                    convertedTemperature = (temperature * 9/5) +32;
                    break;
                case "FtoC":
                    convertedTemperature = (temperature - 32) *5/9;
                    break;
                default:
                    response.sendRedirect("error.jsp");
                    return;
            }
            request.setAttribute("convertedTemperature", convertedTemperature);
            request.setAttribute("originalTemperature", temperature);
            request.setAttribute("conversionType", conversionType);

            request.getRequestDispatcher("converterresult.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            response.sendRedirect("error.jsp");
        } catch (Exception e) {
            response.sendRedirect("error.jsp");
        }
    }
}
