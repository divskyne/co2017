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

<section>
<form:form method="POST" commandName="item" action="/item/add">
   <table>
    <tr>
    
    <tr>
     <td><form:label path="name">Product</form:label></td>
     <td><form:select path="name">
					  <form:option value="" label="--- Select Product ---" />
					  <c:forEach items="${productList}" var="product">	
						<option value="${product.getName()}">${product.getName()}</option>
			</c:forEach>
				      </form:select></td>
    </tr>
    <tr>
        <td><form:label path="amount">Amount</form:label></td>
        <td><form:input path="amount" /></td>
    </tr>
    
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit" class="btn btn-default"/>
        </td>
    </tr>
</table>  
</form:form>
</section>
</body>
</html>
