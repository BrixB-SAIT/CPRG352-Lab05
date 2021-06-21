/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // create HttpSession object
        // refer to Demo05 for more examples of HttpSession!
        HttpSession session = request.getSession();
        
        String username = (String) session.getAttribute("showUser");
        
        // send user back to the login page if value is empty
        if (username == null || username.equals("")) {
            response.sendRedirect("login");
           
        // else send user to requested home JSP
         }else {
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);

                }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
