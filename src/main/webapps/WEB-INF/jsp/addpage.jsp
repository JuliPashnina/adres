<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Добавить населенный пункт</title>
</head>
<body>
 
<h1>Новый населенный пункт:</h1>
<c:url var="saveUrl" value="main/naspunkt/add" />
<form:form modelAttribute="naspunktAttribute" method="POST" action="${saveUrl}">
 <table>
  <tr>
   <td><form:label path="cmOkato">cmOkato:</form:label></td>
   <td><form:input path="cmOkato"/></td>
  </tr>
 
  <tr>
   <td><form:label path="state">state</form:label></td>
   <td><form:input path="state"/></td>
  </tr>
   
  <tr>
   <td><form:label path="cmCtext">cmCtext</form:label></td>
   <td><form:input path="cmCtext"/></td>
  </tr>

  <tr>
   <td><form:label path="cmSocr">cmSocr:</form:label></td>
   <td><form:input path="cmSocr"/></td>
  </tr>
 
  <tr>
   <td><form:label path="cmNterr">cmNterr</form:label></td>
   <td><form:input path="cmNterr"/></td>
  </tr>
   
  <tr>
   <td><form:label path="cmPoselen">cmPoselen</form:label></td>
   <td><form:input path="cmPoselen"/></td>
  </tr>
 </table>
  
 <input type="submit" value="Save" />
</form:form>
 
</body>
</html>

