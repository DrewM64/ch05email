<%-- 
    Document   : edit_tech_support
    Created on : Mar 31, 2022, 1:18:15 PM
    Author     : daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Tech Support</title>
    </head>
    <body>
        <!--Allows user to edit (UPDATE) existing tech support information. Validation for 
        required fields and phone number being numbers handled on servlet
        Receives techSupport from AdminServlet to populate fields
        Sends to AdminServlet with action "edit"
        -->
        <h1>Edit Tech Support</h1>
        <p><i>${message}</i></p>
    <form action="admin" method="post">
        <input type="hidden" name="action" value="edit">        
        <label>Email to edit:</label><span>${tech.email}</span><br>
        <input type="email" name="email" value="${tech.email}" 
               required><br>
        <label>Set First Name:</label>
        <input type="text" name="firstName" value="${tech.firstName}" 
               required><br>
        <label>Set Last Name:</label>
        <input type="text" name="lastName" value="${tech.lastName}"  
               required><br>
        <label>Set Phone Number:</label>
        <input type="text" name="phoneNumber" value="${tech.phoneNumber}"  
               required><br>  
        <label>&nbsp;</label>
        <input type="submit" value="Submit">
    </form>
    <c:import url="/includes/footer.jsp" />