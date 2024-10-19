package operation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/adminlogin")
public class AdminLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    // Admin credentials
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve username and password from the request
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter out=response.getWriter();
        // Check if the credentials match the admin credentials
        if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
            // Redirect the user to the admin dashboard
            response.sendRedirect("admin_dashboard.jsp");
        } else {
            // If the credentials are incorrect, display an error message
        	  out.print("<script>alert('Invalid username and password');</script>");
              
            request.getRequestDispatcher("AdminSign_in.jsp").forward(request, response);
        }
    }
}
