<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update category</title>
</head>
<body>
<%@include file="Header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3 align="center">Category Page</h3>

<form action="<c:url value="/UpdateCategory"/>" method="post">
<table>
<tr>
<td colspan="2">Update Category</td>
</tr>
<tr>
	<td>Category ID</td>
	<td><input type="text" readonly id="categoryid" name="categoryid" value="${categoryInfo.categoryId}"/></td>
</tr>
<tr>
	<td>Category Name</td>
	<td><input type="text" id="categoryname" name="categoryname" value="${categoryInfo.categoryName}"/></td>
</tr>
	<td>Category Desc</td>
	<td><input type="text" id="categorydesc" name="categorydesc" value="${categoryInfo.categoryDesc}"/></td>
</tr>
<tr>
	<td colspan="2"><center>
	<input type="submit" value="Update"/>
	<input type="reset" value="RESET"/>
	</center></td>
</tr>
</table>
</form>

<table align="center">
	<tr>
		<td>Category ID</td>
		<td>Category Name</td>
		<td>Category Desc</td>
		<td>Operation</td>
	</tr>
	<c:forEach items="${listCategories}" var="category">
	<tr>
		<td>${category.categoryId}</td>
		<td>${category.categoryName}</td>
		<td>${category.categoryDesc}</td>
		<td>
		<a href="<c:url value="/UpdateCategory/${category.categoryId}"/>">Update</a>/
		<a href="<c:url value="/deleteCategory/${category.categoryId}"/>">Delete</a>
		</td>
	</tr>
	</c:forEach>
	
</table>

</body>
</html>

