<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
	<head>
	    <link href="${pageContext.request.contextPath}/css/error.css" rel="stylesheet" >
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
        <br/> <br/>
        <div>
            <img class="image" src="${pageContext.request.contextPath}/images/nirvana_smiley.jpg" alt="x_x">
        </div>
        </br>
        Error message:<br/>
        <div class="field">
            <c:out value="${errorMessage}"/>
        </div>
        </br>
        Trace:</br>
        <div class="field">
            <c:out value="${trace}"/>
        </div>
    </body>
</html>