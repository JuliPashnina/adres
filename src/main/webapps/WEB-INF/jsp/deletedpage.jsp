<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Сообщение</title>
</head>
<body>
 
<h1>Населенные пункты</h1>
<p>Вы удалили населенный пункт с CM_OKATO = ${cmOkato}  <%= new java.util.Date() %></p>
 
<c:url var="mainUrl" value="/main/naspunkt" />
<p>Вернуться к <a href="${mainUrl}">общему списку</a></p>
 
</body>
</html>
