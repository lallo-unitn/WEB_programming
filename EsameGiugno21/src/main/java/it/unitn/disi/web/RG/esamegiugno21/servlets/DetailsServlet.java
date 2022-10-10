package it.unitn.disi.web.RG.esamegiugno21.servlets;

import it.unitn.disi.web.RG.esamegiugno21.beans.ItemBean;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

public class DetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /////////////// ITEM SETUP ///////////////
        String stringId = request.getParameter("id");
        //System.out.println("ID" + stringId);
        Integer itemId = Integer.parseInt( stringId );
        ServletContext ctx = request.getServletContext();
        Map<Integer, ItemBean> itemMap =
                (Map<Integer, ItemBean>) ctx.getAttribute("itemMap");
        ItemBean item = itemMap.get(itemId);
        request.setAttribute("item", item);
        //System.out.println(item.getId());
        /////////////// VALIDITY SETUP ///////////////
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        boolean isBestOfferer = username.equals( item.getBestOfferer() );
        boolean stillValid = item.getTimestamp().getTime() > (new Date().getTime());
        request.setAttribute("isBestOfferer", isBestOfferer);
        request.setAttribute("stillValid", stillValid);
        RequestDispatcher rd = request.getRequestDispatcher("details.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
