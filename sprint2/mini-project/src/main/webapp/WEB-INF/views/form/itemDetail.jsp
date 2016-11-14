<!DOCTYPE HTML>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" media="screen" href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css">
<html>
<head>
    <title>Item Editing</title>
</head>
<body>
<h2>New/edit Item Information</h2>
<form:form method="POST" commandName="item" action="/item/add">
	<select>
		<option value="NONE">--- Select ---</option>
		<c:forEach items="${productList}" var="product">
		<form:select path="product" items="${productList}"
					multiple="true" /></c:forEach>
	</select>
 <table>
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit" class="btn btn-default"/>
        </td>
    </tr>
</table>  
</form:form>
</body>
</html>
