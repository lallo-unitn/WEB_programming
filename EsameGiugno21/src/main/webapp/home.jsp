<%@ page import="it.unitn.disi.web.RG.esamegiugno21.beans.ItemBean" %><%--
  Created by IntelliJ IDEA.
  User: ricca
  Date: 19/06/2022
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <jsp:useBean id="activeItems"
                 class="it.unitn.disi.web.RG.esamegiugno21.beans.ItemList"
                 scope="request"/>
    <%
        for (ItemBean item :
                activeItems) {%>
            <p>
                <a href="DetailsServlet?id=<%=item.getId()%>"><%=item.getTitle()%></a>
                <br>
                ID: <%= item.getId()%>
                <br>
                Prezzo attuale: <%= item.getCurrPrice()%>
                <br>
                Scadenza: <%= item.getTimestamp()%>
            <hr>
        <%}%>
</body>
</html>
