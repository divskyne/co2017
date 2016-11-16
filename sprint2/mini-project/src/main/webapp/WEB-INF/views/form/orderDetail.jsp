<!DOCTYPE HTML>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.time.LocalDateTime" %>

<link rel="stylesheet" media="screen" href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css">
<html>
<!-- source: http://www.textfixer.com/tutorials/css-table-alternating-rows.php -->
<style type="text/css">
	.TFtable{
		width:100%; 
		border-collapse:collapse; 
	}
	.TFtable td{ 
		padding:7px; border:#4e95f4 1px solid;
	}
	/* provide some minimal visual accomodation for IE8 and below */
	.TFtable tr{
		background: #b8d1f3;
	}
	/*  Define the background color for all the ODD background rows  */
	.TFtable tr:nth-child(odd){ 
		background: #b8d1f3;
	}
	/*  Define the background color for all the EVEN background rows  */
	.TFtable tr:nth-child(even){
		background: #dae5f4;
	}
</style>
<head>
<title>Order Information</title>
</head>
<body>
<h2>Order Information</h2>
<section>
<p>id: ${order.getLastId()-1}</p>
<p>Date: ${date}</p>
</section>
<section>
<p>
<a href="/item/detail" class="btn btn-default">Add new item</a>
<a href="/order/" class="btn btn-default">Show all orders</a>
<p/>
</section>
<section>
<table class="TFtable">
<tr>
  <td><h3>Id</h3></td>
  <td><h3>Name</h3></td>
  <td><h3>Description</h3></td>
  <td><h3>Price</h3></td>
  <td><h3>Amount</h3></td>
  <td><h3>Cost</h3></td>
  <td><h3></h3></td>
  <td><h3></h3></td>
</tr>
<c:forEach items="${itemList}" var="item">
<tr>
	<td><c:out value="${item.getId()}"/></td>
	<td><c:out value="${item.getName()}"/></td>
	<td><c:out value="${item.getDescription()}"/></td>
	<td><c:out value="${item.getPrice()}"/></td>
	<td><c:out value="${item.getAmount()}"/></td>
	<td><c:out value="${item.getCost()}"/></td>
	<td><a href="/order/itemDetail?orderId=${item.getId()}">Edit</a></td>
	<td><a href="/order/delete?orderId=${item.getId()}">Delete</a></td>
</tr>
</c:forEach>
</table>
</section>
</body>
</html>
