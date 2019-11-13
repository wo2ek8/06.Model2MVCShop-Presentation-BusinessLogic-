<%@page import="com.model2.mvc.service.domain.Product"%>
<%@page import="com.model2.mvc.service.product.ProductService"%>
<%@page import="com.model2.mvc.service.product.impl.ProductServiceImpl"%>
<%@page import="com.model2.mvc.service.domain.User"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

li {
	list-style: none;
}

a {
	text-decoration: none;
	color: inherit;
}

body {
	font-size: 12px;
	color: #898989;
	font-family: 'Roboto', sans-serif;
	font-family: 'Nanum Gothic', sans-serif;
}

img {
	width: 100px;
	margin: 10px;
}

table {
	margin: 0 auto;
	text-align: center;
	border-collapse: collapse;
}

tr {
	border-top: 1px solid;
	border-bottom: 1px solid;
}

div.title {
	padding: 30px 0;
	font-weight: bold;
	letter-spacing: 2px;
	text-align: center;
}

tr:nth-child(1) {
	line-height: 3;
}

td.name {
	text-align: left;
}

div.button {
	display: inline-block;
	height: 30px;
	background: #fff;
}

div.button a {
	display: block;
	border: 1px solid;
	height: 50%;
	font-size: 10px;
}

td.select a {
	padding: 5px 10px;
	display: inline-block;
	margin-bottom: 3px;
	color: #fff;
	background-color: #c9c9c9;
}

center {
	margin-top: 30px;
}
</style>
</head>
<body>
	<div class="title">SHOPPING CART</div>
	<table>
		<colgroup>
			<col width="50px">
			<col width="150px">
			<col width="350px">
			<col width="100px">
			<col width="100px">
			<col width="100px">
			<col width="100px">
			<col width="100px">
		</colgroup>
		<tr>
			<td><input type="checkbox" name="check"></td>
			<td>Product</td>
			<td>Name</td>
			<td>Price</td>
			<td>Quantity</td>
			<td>Mileage</td>
			<td>Total</td>
			<td>Select</td>
		</tr>
		<%-- <%
			User user = (User) session.getAttribute("user");
			String userId = user.getUserId();
			String cart = null;
			Cookie[] cookies = request.getCookies();
			if (cookies != null && cookies.length > 0) {
				for (int i = 0; i < cookies.length; i++) {
					Cookie cookie = cookies[i];
					if (cookie.getName().equals(userId)) {
						cart = cookie.getValue();
					}
				}
				if (cart != null) {
					String[] c = cart.split(",");
					for (int i = 0; i < c.length; i++) {
						if (!c[i].equals("null") && !c[i].equals("")) {
		%>

		<%
			ProductService productService = new ProductServiceImpl();
			Product product = productService.getProduct(Integer.parseInt(c[i]));
		%> --%>
		
		<c:forEach var="product" items="${list }">
		<tr>
			<td><input type="checkbox" name="check"></td>
			<td><img src="../images/uploadFiles/${product.fileName }"
				alt=""></td>
			<td class="name"><strong>${product.prodName }</strong></td>
			<td><strong>${product.price }원</strong></td>
			<td>-</td>
			<td>-</td>
			<td><strong>${product.price }원</strong></td>
			<td class="select"><a
				href="/addPurchaseView.do?prodNo=${product.prodNo }">주문하기</a><br>
				<a href="/removeCart.do?prodNo=${product.prodNo }">삭제하기</a></td>
		</tr>
		</c:forEach>
		<%-- <%
			} else {%>
				</table>
				<center>장바구니가 비어 있습니다.</center>
			<%}
					}%>
					</table>
		
	
	<%
		} else {%> </table><center>장바구니가 비어 있습니다.</center> <%}
		} %> --%>
	
</table>
</body>
</html>