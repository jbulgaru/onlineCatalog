package com.stefanini.onlinecatalog;

import com.stefanini.onlinecatalog.dao.DaoCatalogUser;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletLogin", value = "/ServletLogin")
public class ServletLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoCatalogUser daoCatalogUser = new DaoCatalogUser();
        // check credentials
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (daoCatalogUser.checkCredentials(username, password)) {
            // set cookie which confirm logging in to application
            Cookie loggedCookie = new Cookie("logged", "The_Dark_Side_of_the_Moon");
            loggedCookie.setMaxAge(60);
            response.addCookie(loggedCookie);

            String previousURL = (String) request.getSession().getAttribute("urlToReturn");
            if (previousURL != null) response.sendRedirect(previousURL);
            else response.sendRedirect("/OnlineCatalog");
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/sign-in.jsp");
            dispatcher.forward(request, response);
        }

    }

}
