package com.stefanini.onlinecatalog;

import com.stefanini.onlinecatalog.dao.DaoCatalogUser;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

@WebServlet(name = "ServletLogin", value = "/ServletLogin")
public class ServletLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoCatalogUser daoUser = new DaoCatalogUser();
        // check credentials
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (daoUser.checkCredentials(username, password)) {
            // set cookie which confirm logging in to application
            Cookie loggedCookie = new Cookie("logged", "The_Dark_Side_of_the_Moon");
            loggedCookie.setMaxAge(20);
            response.addCookie(loggedCookie);

            String previousURL = (String) request.getSession().getAttribute("urlToReturn");
            response.sendRedirect(previousURL);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/sign-in.jsp");
            dispatcher.forward(request, response);
        }

    }

    private String getHashPassword (String password) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = factory.generateSecret(spec).getEncoded();
            return new String(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }
}
