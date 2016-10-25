<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head> 
    <title>JSP output</title> 
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
	<c:choose>
		<c:when test="${!empty name}"> <!-- !name.toString().equals('') -->
			<p>Hello, ${name} !</p>
		</c:when>
		<c:when test="${!empty value}">
			<p>The value is ${value} !</p>
		</c:when>
		<c:otherwise>
			<p>Nothing to add.</p>
		</c:otherwise>
	</c:choose> 
</body>
</html>
