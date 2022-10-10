<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: ricca
  Date: 19/06/2022
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
    <script>
        let pageRefresher;
        let countdown;
        function myTimer(){
            let elem = document.getElementById("counter");
            if (countdown < 1){
                myVar = null;
                pageRefresher = null;
                document.getElementById("counter").innerHTML = "Asta terminata";
            } else {
                document.getElementById("counter").innerHTML = "Secondo rimasti:" + --countdown;
            }
        }
    </script>
</head>
<body>
    <jsp:useBean id="item"
                 class="it.unitn.disi.web.RG.esamegiugno21.beans.ItemBean"
                 scope="request"/>
    <h2><%= item.getTitle()%></h2>
    Descrizione: <%= item.getDescription()%>
    <br>
    Prezzo corrente: <%= item.getCurrPrice()%>
    <br>
    Miglior offerente: <%= item.getBestOfferer()%>
    <br>

    <%  if ( (boolean) request.getAttribute("isBestOfferer") ){ %>
            Sei il miglior offerente!
        <%} else if( (boolean) request.getAttribute("stillValid") ){%>
            Miglior offerente <%= item.getBestOfferer()%>
    <form action="SubmitOfferServlet" method="POST">
        <input type="number"
               name="offer"
               id="offer"
               min="<%= 1 + item.getCurrPrice()%>"
               required="required">
        <input type="submit" value="Submit">
        <input type="hidden"
               name="id"
               id="id"
               value="<%= item.getId()%>">
    </form>
    <%}%>
    <br>
    <span id="counter"></span>
    <script>
        countdown = <%= ( item.getTimestamp().getTime() - new Date().getTime() ) / 1000%>;
        let myVar = null;
        if(countdown > 0){
            myVar = setInterval(myTimer, 1000);
            function refreshPage() {
                window.location.replace(
                    "DetailsServlet?id=<%= item.getId()%>"
                );
            }
            pageRefresher = setInterval(refreshPage, 10000);
        } else {
            pageRefresher = null;
            myVar = null;
            document.getElementById("counter").innerHTML = "Asta terminata"
        }
    </script>
</body>
</html>
