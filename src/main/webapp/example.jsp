<%--
  Created by IntelliJ IDEA.
  User: Roshan
  Date: 6/9/20
  Time: 12:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Example</title>
</head>
<body>
    <%@ include file="partials/navbar.jsp"%>
    <%! int counter = 0; %>
    <!--This is an html comment-->
    <% counter +=1; %>
    <h1>This is an example page!</h1>

    <h1>Implicit JSP objects</h1>
<%--    IMPLICIT OBJECTS in JSP--%>
    <p>Path: <%= request.getRequestURL() %></p>
    <p>Query String: <%= request.getQueryString() %></p>
    <p>"name" parameter: <%= request.getParameter("name") %></p>
    <p>"method" attribute: <%= request.getMethod() %></p>
    <p>User-Agent header: <%= request.getHeader("user-agent") %></p>

    <h1>JSP Expression Language</h1>
<%--    JSP Expression Language EL--%>
    <p>User-Agent header: ${header["user-agent"]}</p>
    <p>"page_no" parameter: ${param.page_no}</p>

    <% request.setAttribute("name", "Fernando"); %>
    <p>Hello ${name} !</p>

    <%@ include file="partials/footer.jsp"%>
</body>
</html>
