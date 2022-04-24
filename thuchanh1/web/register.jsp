<%-- 
    Document   : register
    Created on : Apr 5, 2022, 9:42:51 AM
    Author     : Legion 5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link rel="stylesheet" href="styles/style.css"/>
    </head>
    <body>
        <form action="RegisterServlet" method="post">
            <div>
                    <input type="text" name="user" id="user" onfocus="this.value = ''" placeholder="username"><br>
                    <label>&nbsp;</label>
                    <span class="form-message invalid">${mes1}</span><br>
            </div>
            <div>
                    <input type="password" name="pass" id="pass" onfocus="this.value = ''" placeholder="password"><br>
                    <label>&nbsp;</label>
                    <span class="form-message invalid">${mes2}</span><br>
            </div>
            <div id="btn">
                <input type="submit" id="register" name="action" value="Register"/>
            </div>
            <h3>${mes3}</h3>
        </form>
    </body>
</html>
