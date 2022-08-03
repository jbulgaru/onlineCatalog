package com.stefanini.onlinecatalog;

import com.stefanini.onlinecatalog.dao.DaoCatalogUser;
import com.stefanini.onlinecatalog.entity.CatalogUser;

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

@WebServlet(name = "ServletSign", value = "/ServletSign")
public class ServletSign extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoCatalogUser daoUser = new DaoCatalogUser();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//        String password = getHashPassword(request.getParameter("password"));
        CatalogUser user = new CatalogUser(username, password);
        daoUser.save(user);

        daoUser.closeEntityManager();
        RequestDispatcher dispatcher = request.getRequestDispatcher("/OnlineCatalog");
        dispatcher.forward(request, response);
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
