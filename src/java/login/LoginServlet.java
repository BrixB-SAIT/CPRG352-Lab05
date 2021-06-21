package login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import login.AccountServices;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // create HttpSession object
        // refer to Demo05 for more examples of HttpSession!
        HttpSession session = request.getSession();

        String username = (String) session.getAttribute("showUser");

        // set logOutClicked with request parameter "logout"
        String logOutClicked = request.getParameter("logout");

        if (logOutClicked != null) {
            // if logout has been clicked, terminate session. Destroy the evidence
            session.invalidate();
            // Display a message to show user that you have succesfully logged out!
            request.setAttribute("errorMsg", "You have successfully logged out.");

            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        } else if (username != null) {
            // if username is not empty, direct to home page
            response.sendRedirect("home");
        } else {
            // if param is empty, login again with proper credentials and password
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // create HttpSession object
        // refer to Demo05 for more examples of HttpSession!
        HttpSession session = request.getSession();
        // Create AccountService object
        AccountServices accServices = new AccountServices();

        // Stores the String username and password from the name login.jsp.
        String username = request.getParameter("in_username");
        String password = request.getParameter("in_password");

        // set logInClicked with request parameter "login"
        String logInClicked = request.getParameter("login");

        //////VALIDATION\\\\\\\\
        if (logInClicked != null) {

            // display an error message to show user that the fields are empty
            if (username == null || username.equals("") || password == null || password.equals("")) {
                request.setAttribute("errorMsg", "Please enter your username");
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                return;
            } //////END OF VALIDATION\\\\\\\\
            else {
                // if values are correct, send them to home page
                if (accServices.login(username, password) != null) {
                    session.setAttribute("showUser", username);
                    response.sendRedirect("home");
                } else {
                    // if values are incorrect, display an error message
                    request.setAttribute("errorMsg", "username and password does not exist. Please try again.");
                    getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

                }
            }

        }
    }

}
