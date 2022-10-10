<div>
    <a href="HomeServlet">Homepage</a>
    <a href="SoldServlet">Sold</a>
    <%
        String username = (String) session.getAttribute("username");
        String logout = "";
        if(username == null || username.equals("null")){
            username = "<a href='LoginServlet'>Login</a>";
        } else {
            logout = "<a href='LogoutServlet'>Logout</a>";
        }
    %>
    <%= username%>
    <%= logout%>
</div>