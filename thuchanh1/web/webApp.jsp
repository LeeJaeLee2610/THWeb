<%-- 
    Document   : webApp
    Created on : Apr 5, 2022, 8:49:48 AM
    Author     : Legion 5
--%>

<%@page import="dao.UserDao"%>
<%@page import="model.User"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>web App</title>
    </head>
    <body>
        <h1>Welcome ${data} to Web</h1>
        <%
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
            out.println(sdf.format(date));
        %>
        <%
            UserDao ud = new UserDao();
            String user = request.getParameter("user");
            User u = ud.layIP(user);
            if(u != null){
        %>
            <h1>IP <%= u.getIp() %></h1>
        <%
            }
        %>
        <h1>${mes3}</h1>
        <h1>${sessionScope.view}</h1>
        <button><a href="index.jsp">Logout</a></button>
    </body>
</html>
