<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exerício</title>
</head>
<body>
		
		<form:form modelAttribute="torcedor" method="POST" action="cadastro">
		<p> Nome: <input type="text" name="nome"> </p>
		<p> Time: <input type="text" name="time"> </p>
		<input type="submit" value="Enviar">
		<p> ${mensagem} </p>
		
		</form:form>
		
</body>
</html>