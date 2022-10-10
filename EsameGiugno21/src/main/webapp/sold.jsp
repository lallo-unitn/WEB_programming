<%@ page import="it.unitn.disi.web.RG.esamegiugno21.beans.ItemList" %>
<%@ page import="it.unitn.disi.web.RG.esamegiugno21.beans.ItemBean" %><%--
  Created by IntelliJ IDEA.
  User: ricca
  Date: 20/06/2022
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sold Items</title>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <jsp:useBean id="soldList"
                 class="it.unitn.disi.web.RG.esamegiugno21.beans.ItemList"
                 scope="request"/>
    <%
        for (ItemBean item :
                soldList) {%>
            <p>
            <h2><%= item.getTitle()%></h2>
            <br>
            Prezzo Finale: <%=item.getCurrPrice()%>
            <br>
            Vincitore: <%=item.getBestOfferer()%>
            <hr>
        <%}%>
</body>
</html>
