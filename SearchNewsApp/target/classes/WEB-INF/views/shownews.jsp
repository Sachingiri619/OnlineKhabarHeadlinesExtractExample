<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="info.news.model.Headlines"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>
<%@ page import="java.io.*,java.util.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Results</title>

<style>         
.blue-button{
	background: #25A6E1;
	filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#25A6E1',endColorstr='#188BC0',GradientType=0);
	padding:3px 5px;
	color:#fff;
	font-family:'Helvetica Neue',sans-serif;
	font-size:12px;
	border-radius:2px;
	-moz-border-radius:2px;
	-webkit-border-radius:4px;
	border:1px solid #1A87B9
}     
table {
  font-family: "Helvetica Neue", Helvetica, sans-serif;
   width: 50%;
}
th {
  background: SteelBlue;
  color: white;
}
 td,th{
                border: 1px solid gray;
                width: 25%;
                text-align: left;
                padding: 5px 10px;
            }
</style>

</head>
<body>

<div>
<form:form method="GET" modelAttribute="headlines" action="/SearchNewsApp/search">
  
  Enter text to search headlines related to it : <input type="text" name="enterText">
  
  <input type="submit" value="Find">
  
</form:form  >
</div>
<div>
<c:if test="${!empty listOfHeadlines}">

<table class="tg">
	<tr>
		<th width="80">S.No.</th>
		<th width="120">news</th>
		<th width="120">link</th>
		
	</tr>
 	<c:forEach items="${listOfHeadlines}" var="headlines">
		<tr>
			<td>${headlines.id}</td>
			<td>${headlines.news}</td>
			<td>
			<a href=${headlines.link}>google.com</a>
			</td>			
		</tr>
	</c:forEach>
	</table>	
	
</c:if>
</div>
</body>
</html>