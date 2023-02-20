<%-- 
    Document   : shoppinglist
    Created on : 20-Feb-2023, 2:16:24 PM
    Author     : Kelsey
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        Hello, ${name}
        <a href="shoppinglist>action=logout">Logout</a> <br>
        <h2>List</h2><br>
        <form action="" method="post">
                Add Items: <input type="radio" name="itemadd"> <br>
                <ul>    
                <input type="submit" value="Add">
                <input type="hidden" name="action" value="add">  
        </form>
        <br>
        <form action="" method="post">
            <ul>
                <c:forEach items="${itemlist}" var="items">
                    <li>
                        <input type="radio" name="itemname" value="${itemlist}"><br>
                    </li>
                </c:forEach>  
            </ul><br>
            <input type="submit" value="Delete">
            <input type="hidden" name="action" value="delete">
           
        </form>
    </body>
</html>
