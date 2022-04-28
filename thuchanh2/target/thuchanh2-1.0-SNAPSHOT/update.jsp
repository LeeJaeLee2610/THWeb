<%-- 
    Document   : update
    Created on : Apr 25, 2022, 1:34:13 PM
    Author     : LeeJaeLee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/style.css"/>
    </head>
    <body>
        <h1>Product</h1>
        <p>Product ID: ${v4}</p>
        <form action='ProductUpdateController' method="post">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name ="pid" value="${v4}">
            <div>
                <label for='code'>Product Code:</label>
                <input type="text" id='code' name='code' value='${v1}'>
                <span class="message">${mes1}</span>
            </div>
            <div>
                <label for='description'>Product Description:</label>
                <input type="text" id='description' name='description' value='${v2}'>
                <span class="message">${mes2}</span>
            </div>
            <div>
                <label for='price'>Product Price:</label>
                <input type="text" id='price' name='price' value="${v3}">
                <span class="message">${mes3}</span>
            </div>
            <div class='btn-p'>
                <button type="submit" name="btn-update" value="up">Update Product</button>
                <button name="btn-update" value="view">View Product</button>
            </div>
        </form>
    </body>
</html>
