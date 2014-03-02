<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
	<head>
	    <link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" >
	</head>
    <body>
        <div class="menuBar">
            <a href=".">
                <img class="logo" src="${pageContext.request.contextPath}/images/white_raven.png" alt="logo"/>
            </a>
            <div class="nav">
                <ul>
                    <li><a href="info">Info</a></li>
                </ul>
            </div>
        </div>
        <br/><br/>
        <c:forEach items="${tags}" var="tag">
           <c:out value="${tag.getName()}"/>
           </br>
        </c:forEach>
    </body>
</html>
