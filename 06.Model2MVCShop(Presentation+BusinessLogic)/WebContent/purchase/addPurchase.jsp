


<%-- <%@page import="com.model2.mvc.service.domain.Product"%>
<%@page import="com.model2.mvc.service.purchase.PurchaseService"%>
<%@page import="com.model2.mvc.service.purchase.impl.PurchaseServiceImpl"%>
<%@page import="com.model2.mvc.service.domain.Purchase"%> --%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%-- <%
        	Purchase purchase = (Purchase)request.getAttribute("purchase");
        %> --%>
        
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>

<body>

<form name="updatePurchase" action="/updatePurchaseView.do" method="post">

다음과 같이 구매가 되었습니다.

<table border=1>
	<tr>
		<td>물품번호</td>
		<%-- <td><%=purchase.getPurchaseProd().getProdNo() %></td> --%>
		<td>${purchase.purchaseProd.prodNo }</td>
		<td></td>
	</tr>
	<tr>
		<td>구매자아이디</td>
		<%-- <td><%=purchase.getBuyer().getUserId() %></td> --%>
		<td>${purchase.buyer.userId }</td>
		<td></td>
	</tr>
	<tr>
		<td>구매방법</td>
		<td>
		<%-- <%
		if(purchase.getPaymentOption().equals("1")) {%>
			카드 결제
		<%} else if(purchase.getPaymentOption().equals("2")) {%>
			휴대폰 결제
		<%} else {%>
			무통장 입금
		<%}
		%> --%>
		<c:if test="${purchase.paymentOption.equals('0') }">
		카드 결제
		</c:if>
		<c:if test="${purchase.paymentOption.equals('1') }">
		휴대폰 결제
		</c:if>
		<c:if test="${purchase.paymentOption.equals('2') }">
		무통장 입금
		</c:if>
			
		
		</td>
		<td></td>
	</tr>
	<tr>
		<td>구매자이름</td>
		<%-- <td><%=purchase.getReceiverName() %></td> --%>
		<td>${purchase.receiverName }</td>
		<td></td>
	</tr>
	<tr>
		<td>구매자연락처</td>
		<%-- <td><%=purchase.getReceiverPhone() %></td> --%>
		<td>${purchase.receiverPhone }</td>
		<td></td>
	</tr>
	<tr>
		<td>구매자주소</td>
		<%-- <td><%=purchase.getDivyAddr() %></td> --%>
		<td>${purchase.divyAddr }</td>
		<td></td>
	</tr>
		<tr>
		<td>구매요청사항</td>
		<%-- <td><%=purchase.getDivyRequest() %></td> --%>
		<td>${purchase.divyRequest }</td>
		<td></td>
	</tr>
	<tr>
		<td>배송희망일자</td>
		<%-- <td><%=purchase.getDivyDate() %></td> --%>
		<td>${purchase.divyDate }</td>
		<td></td>
	</tr>
</table>
</form>

</body>
</html>