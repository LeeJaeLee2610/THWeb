<%-- 
    Document   : delete
    Created on : Apr 24, 2022, 8:58:41 PM
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
        <h1>Delete</h1>
        <form action='DeleteController' post='method'>
            <input type="hidden" name="id" value='${v4}'>
            <div>
                <label for='code'>Product Code:</label>
                <input type="text" id='code' name='code' value='${v1}'>
            </div>
            <div>
                <label for='description'>Product Description:</label>
                <input type="text" id='description' name='description' value='${v2}'>
            </div>
            <div>
                <label for='price'>Product Price:</label>
                <input type="text" id='price' name='price' value="${v3}">
            </div>
            <div class='btn-p'>
                <button type="submit" name="btn-yn" value="yes">Yes</button>
                <button name="btn-yn" value="no">No</button>
            </div>
        </form>
    </body>
</html>
