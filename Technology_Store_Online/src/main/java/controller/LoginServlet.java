package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html/charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action){
            case "block":
//                showBlockUser(req,resp);
                break;
            default:
                showLoginForm(req,resp);
                break;
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html/charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action){
            case "block":
//                try {
//                    blockUser(req,resp);
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
                break;
            default:
                login(req,resp);
                break;
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String message;

        if(userName.equals("lyho161020") && password.equals("lyho123")) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/products");
            dispatcher.forward(req,resp);
        }else {
            message = "Tên đăng nhập hoặc mật khẩu không đúng!";
            req.setAttribute("message", message);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
            dispatcher.forward(req,resp);
        }

    }

    private void showLoginForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
        dispatcher.forward(req,resp);
    }
}
