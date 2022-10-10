package it.unitn.disi.web.RG.esamegiugno21.servlets;

import it.unitn.disi.web.RG.esamegiugno21.beans.ItemList;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class SoldServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext ctx = request.getServletContext();
        ItemList itemList = (ItemList) ctx.getAttribute("itemList");
        ItemList soldList = itemList.getExpiredItems();
        request.setAttribute("soldList", soldList);
        RequestDispatcher rd = request.getRequestDispatcher("sold.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
