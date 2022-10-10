package it.unitn.disi.web.RG.esamegiugno21.servlets;

import it.unitn.disi.web.RG.esamegiugno21.auxiliary.Initializer;
import it.unitn.disi.web.RG.esamegiugno21.beans.ItemList;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class HomeServlet extends HttpServlet {

    @Override
    public void init(){
        ServletContext ctx = getServletContext();
        if(ctx.getAttribute("users") == null){
            new Initializer(ctx);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext ctx = request.getServletContext();
        ItemList itemList = (ItemList) ctx.getAttribute("itemList");
        ItemList activeItems = itemList.getActiveItems();
        request.setAttribute("activeItems", activeItems);
        RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
