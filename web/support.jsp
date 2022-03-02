<%-- 
    Document   : support
    Created on : Feb 27, 2022, 9:50:45 PM
    Author     : Andrew Montgomery
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Support</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/main.css">
    </head>
    <body>
        <header>
            <nav>
                <form action="about" method="get">
                    <input type="submit" value="About">
                </form>
                <form action="support" method="post">
                    <input type="submit" value="Support">
                </form>
            </nav>
        </header>
        <section>
            <h1>Support</h1>
            <p>For any technical issues, 
                <br>please reach out to any of the following
            personnel: </p>
            <table>
                <tr>
                    <th colspan="3">Technical Support Team</th>
                </tr>
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone#</th>
                </tr>
                
                <!--TO-DO: (Step 6) Populate table using servlet and TechSupportIO getTechSupport()-->
<!--                <tr>
                    <td>John Smith</td>
                    <td>jsmith@mdc.edu</td>
                    <td>(305)1234-5678</td>
                </tr>
                <tr>
                    <td>Maria Tovar</td>
                    <td>mtovar@mdc.edu</td>
                    <td>(305)1234-5679</td>
                </tr>
                <tr>
                    <td>Charles Darwin</td>
                    <td>cdarwin@mdc.edu</td>
                    <td>(305)1234-5680</td>
                </tr>-->
                <!--End TO-DO-->
                <c:forEach var="tech" items="${techSupport}">
                    <tr>
                        <td>${tech.name}</td>
                        <td>${tech.email}</td>
                        <td>${tech.phone}</td>
                    </tr>
                </c:forEach>
                
            </table>
        </section>
        <c:import url="/includes/footer.jsp" />