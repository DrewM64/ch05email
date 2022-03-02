<%-- 
    Document   : about.jsp
    Created on : Feb 27, 2022, 8:34:57 PM
    Author     : Andrew Montgomery
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>About Us</title>
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
            <h1>About Us</h1>
            <h2>Our Humble Story...</h2>
            <p id="dateline">Dateline: August 20, 2021</p>
                <p>
                An idea was instilled into the minds of four individuals. 
                An idea for the greatest company ever known. Soon, that idea would 
                come to fruition in the form of a startup company, located in scenic Wynwood, Florida.
                </p>
                <p>
                    We are an elite team of professionals changing the scene in Miami, and challenging 
                    all that people know about food catering.
                </p>
                <img alt="business team with thumbs up" src="https://previews.123rf.com/images/piksel/piksel1306/piksel130600044/20174782-business-team-with-thumbs-up.jpg">
        </section>
        <c:import url="/includes/footer.jsp" />