<%-- 
    Document   : footer
    Created on : Feb 27, 2022, 8:11:18 PM
    Author     : Andrew Montgomery
--%>

<%@ page import="java.util.GregorianCalendar, java.util.Calendar" %>
<%  
    GregorianCalendar currentDate = new GregorianCalendar();
    int currentYear = currentDate.get(Calendar.YEAR);
%>
<p>&copy; Copyright <%= currentYear %> Andrew Montgomery</p>
</body>
</html>