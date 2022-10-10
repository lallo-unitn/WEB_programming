package it.unitn.disi.web.RG.esamegiugno21.auxiliary;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        String path = httpRequest.getServletPath();
        String query = httpRequest.getQueryString();
        String destination = path;
        if(query != null && !query.equals("null"))
            destination = path + "?" + query;
        httpRequest.setAttribute("destination", destination);
        String username = (String) session.getAttribute("username");
        if(username != null && !username.equals("null")){
            RequestDispatcher rd = httpRequest.getRequestDispatcher(destination);
            rd.forward(request, response);
            return;
        }
        RequestDispatcher rd = httpRequest.getRequestDispatcher("LoginServlet");
        rd.forward(request, response);
        try {
            chain.doFilter(request, response);
        } catch (Throwable e){
            e.printStackTrace();
        }
    }
}
