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
        <title>View Tech Support</title>
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
                <form action="admin" method="post">
                    <input type="submit" value="View Support(DB)">
                </form>
            </nav>
        </header>
        <section>
            <h1>Tech Support Table</h1>
            <table>
                <tr>
                    <th colspan="5">Technical Support Team</th>
                </tr>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Phone#</th>
                    <th style="width: 1px"/>
                </tr>
               
                <!--
                Populates table with data from tech_support DB
                techSupport is an ArrayList of that data
                Submitting editButton form sends that row's tech info to AdminServlet
                to route it to edit_tech_support.jsp for editing
                -->
                <c:forEach var="tech" items="${techSupport}">
                    <tr>
                        <td>${tech.firstName} </td>
                        <td>${tech.lastName}</td>
                        <td>${tech.email}</td>
                        <td>${tech.phone}</td>
                        <td>
                            <form name="editButton" method="post" action="admin">
                                <input type="hidden" name="action" value="editButton">
                                <input type="hidden" name="techEmail" value="${tech.email}">
                                <input type="submit" value="Edit">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="5"><a href="add_tech_support.jsp">Add New Tech</a></td>
                </tr>
            </table>
        </section>
        <c:import url="/includes/footer.jsp" />