<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Общий список</title>
</head>
<body>
<h1>Населенные пункты</h1>
 
<c:url var="addUrl" value="/main/naspunkt/add" />
<table style="border: 1px solid; width: 500px; text-align:center">
 <thead style="background:#fcf">
  <tr>
   <th>CM_OKATO</th>
   <th>STATE</th>
   <th>CM_CTEXT</th>
   <th>CM_SOCR</th>
   <th>CM_NTERR</th>
   <th>CM_POSELEN</th>
   <th colspan="3"></th>
  </tr>
 </thead>
 <tbody>
 <c:forEach items="${naspunkt}" var="city">
   <c:url var="editUrl" value="/main/naspunkt/edit?id=${city.cmOkato}" />
   <c:url var="deleteUrl" value="/main/naspunkt/delete?id=${city.cmOkato}" />
  <tr>
   <td><c:out value="${city.cmOkato}" /></td>
   <td><c:out value="${city.cmCtext}" /></td>
   <td><c:out value="${city.state}" /></td>
   <td><c:out value="${city.cmSocr}" /></td>
   <td><c:out value="${city.cmNterr}" /></td>
   <td><c:out value="${city.cmNposelen}" /></td>
   <td><a href="${editUrl}">Edit</a></td>
   <td><a href="${deleteUrl}">Delete</a></td>
   <td><a href="${addUrl}">Add</a></td>
  </tr>
 </c:forEach>
 </tbody>
</table>
 
<c:if test="${empty naspunkt}">
 There are currently no cities in the list. <a href="${addUrl}">Add</a> a city.
</c:if>
 
</body>
</html>
