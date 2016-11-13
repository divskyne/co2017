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
   <table>
    <tr>
        <td><form:label path="name">Item: </form:label></td>
        <td>
        	<c:forEach items="${itemList}" var="product">
        <td><c:out value="${item.getName()}"/></td>
        	</c:forEach>
        </td>
    </tr>
    <tr>
        <td><form:label path="price">Amount: </form:label></td>
        <td><form:input path="price" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit" class="btn btn-default"/>
        </td>
    </tr>
</table>  
</form:form>
</body>
</html>
