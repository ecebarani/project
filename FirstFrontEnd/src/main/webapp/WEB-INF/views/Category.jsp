<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="Header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h3 align="center">Category Page</h3>

<form action="InsertCategory" method="post">
	<table align="center">
		<tr>
			<td>Category Name</td>
			<td><input type="text" id="categoryname" name="categoryname" /></td>
		</tr>
		<td>Category Desc</td>
		<td><input type="text" id="categorydesc" name="categorydesc" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="SUBMIT" /> <input
				type="reset" value="RESET" /></td>
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
			<td><a
				href="<c:url value="/updateCategory/${category.categoryId}"/>">Update</a>/
				<a href="<c:url value="/deleteCategory/${category.categoryId}"/>">Delete</a>
			</td>
		</tr>
	</c:forEach>

</table>

</body>
</html>