package it.unitn.disi.web.RG.esamegiugno21.servlets;

import it.unitn.disi.web.RG.esamegiugno21.beans.UserBean;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ValidateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("Home");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext ctx = request.getServletContext();
        HttpSession session = request.getSession();
        List<UserBean> usersList = (LinkedList<UserBean>) ctx.getAttribute("users");
        String username = (String) session.getAttribute("username");
        String destination = (String) request.getAttribute("destination");
        if(destination == null || destination.equals("null"))
            destination = "HomeServlet";
        if(username != null){
            RequestDispatcher rd = request.getRequestDispatcher("HomeServlet");
            rd.forward(request, response);
        }
        String inUsername = (String) request.getParameter("username");
        String inPassword = (String) request.getParameter("password");
        UserBean user = new UserBean(inUsername, inPassword);
        System.out.println(usersList.contains(user));
        if(usersList != null && usersList.contains(user)){
            session.setAttribute("username", inUsername);
            RequestDispatcher rd = request.getRequestDispatcher(destination);
            rd.forward(request, response);
            return;
        }
        request.setAttribute("message", "Credenziali errate");
        RequestDispatcher rd = request.getRequestDispatcher("LoginServlet");
        rd.forward(request, response);
    }
}