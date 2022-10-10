package it.unitn.disi.web.RG.esamegiugno21.servlets;

import it.unitn.disi.web.RG.esamegiugno21.beans.ItemBean;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Map;

public class SubmitOfferServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("HomeServlet");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer itemId = Integer.parseInt( request.getParameter("id") );
        System.out.println("IDSub" + request.getParameter("id"));
        ServletContext ctx = getServletContext();
        Map<Integer, ItemBean> itemMap =
                (Map<Integer, ItemBean>) ctx.getAttribute("itemMap");
        ItemBean item = itemMap.get(itemId);
        Integer offer = Integer.parseInt( request.getParameter("offer") );
        item.setCurrPrice( offer );
        HttpSession session = request.getSession();
        item.setBestOfferer( (String) session.getAttribute("username") );
        RequestDispatcher rd = request.getRequestDispatcher("DetailsServlet?id=" + itemId);
        rd.forward(request, response);
    }
}
