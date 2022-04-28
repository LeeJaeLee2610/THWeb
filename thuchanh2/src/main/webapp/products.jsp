<%-- 
    Document   : products
    Created on : Apr 24, 2022, 8:57:11 PM
    Author     : LeeJaeLee
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/style.css"/>
    </head>
    <body>
        <h1>Products</h1>
        <div class='table'>
            <div class='head'>
                <div>Code</div>
                <div>Description</div>
                <div>Price</div>
            </div>
            <c:forEach items="${listP}" var='o'>
                <div class='about'>
                    <div>${o.code}</div>
                    <div>${o.description}</div>
                    <div>${o.price}$</div>
                    <div><a href="ProductUpdateController?id=${o.id}">Edit</a></div>
                    <div><a href="ProductDeleteController?id=${o.id}">Delete</a></div>
                </div>
            </c:forEach>
        </div>
        <button class="btn-add"><a href="product.jsp">Add Product</a></button>
    </body>
</html>
