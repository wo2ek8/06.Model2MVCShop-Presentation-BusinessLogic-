<%-- <%@page import="java.util.Map"%>
<%@page import="com.model2.mvc.common.Search"%>
<%@page import="com.model2.mvc.service.domain.Purchase"%>
<%@page import="java.util.List"%>

<%@page import="com.model2.mvc.common.Page"%>
<%@page import="com.model2.mvc.common.util.CommonUtil"%> --%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <!-- EL / JSTL 적용으로 주석처리 -->
    <%-- <%
        	List<Purchase> list = (List<Purchase>)request.getAttribute("list");
            Page resultPage = (Page)request.getAttribute("resultPage");
            
            Search search = (Search)request.getAttribute("search");
        %> --%>
<!DOCTYPE html>
<html>
<head>
<title>구매 목록조회</title>

<link rel="stylesheet" href="../css/admin.css" type="text/css">

<script type="text/javascript">
	function fncGetList(currentPage) {
		document.getElementById("currentPage").value = currentPage;
		document.detailForm.submit();
	}
</script>
</head>

<body bgcolor="#ffffff" text="#000000">

<div style="width: 98%; margin-left: 10px;">

<form name="detailForm" action="/listPurchase.do" method="post">

<table width="100%" height="37" border="0" cellpadding="0"	cellspacing="0">
	<tr>
		<td width="15" height="37"><img src="/images/ct_ttl_img01.gif"width="15" height="37"></td>
		<td background="/images/ct_ttl_img02.gif" width="100%" style="padding-left: 10px;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="93%" class="ct_ttl01">구매 목록조회</td>
				</tr>
			</table>
		</td>
		<td width="12" height="37"><img src="/images/ct_ttl_img03.gif"	width="12" height="37"></td>
	</tr>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0"	style="margin-top: 10px;">
	<tr>
		<%-- <td colspan="11">전체 <%=resultPage.getTotalCount()%> 건수, 현재 <%=resultPage.getCurrentPage()%> 페이지</td> --%>
		<td colspan="11">전체 ${resultPage.totalCount } 건수, 현재 ${resultPage.currentPage } 페이지</td>
	</tr>
	<tr>
		<td class="ct_list_b" width="100">No</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150">회원ID</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150">회원명</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b">전화번호</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b">배송현황</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b">정보수정</td>
	</tr>
	<tr>
		<td colspan="11" bgcolor="808285" height="1"></td>
	</tr>

	<%-- <%
		for(int i = 0; i < list.size(); i++) {
		
		Purchase purchaseVO = list.get(i);
	%>
	
	<tr class="ct_list_pop">
		<td align="center">
			<a href="/getPurchase.do?tranNo=<%=purchaseVO.getTranNo()%>"><%=i + 1 %></a>
		</td>
		<td></td>
		<td align="left">
			<a href="/getUser.do?userId=<%=purchaseVO.getBuyer().getUserId()%>"><%=purchaseVO.getBuyer().getUserId()%></a>
		</td>
		<td></td>
		<td align="left"><%=purchaseVO.getReceiverName() %></td>
		<td></td>
		<td align="left"><%=purchaseVO.getReceiverPhone() %></td>
		<td></td>
		<td align="left">
		<%
		if(purchaseVO.getTranCode().equals("1")) {%>
			현재구매완료상태 입니다.
		<%} else if(purchaseVO.getTranCode().equals("2")) {%>
			현재배송중상태 입니다.
		<%} else if(purchaseVO.getTranCode().equals("3")) {%>
			현재배송완료상태 입니다.
		<%}
		%>
			  
		
				</td>
		<td></td>
		<td align="left">
		<%
		if(purchaseVO.getTranCode().equals("2")) {%>
			<a href="/updateTranCode.do?tranNo=10082&tranCode=3">물건도착</a>
		<%}
		%>
		
			
		</td>
	</tr>
	<tr>
		<td colspan="11" bgcolor="D6D7D6" height="1"></td>
	</tr>
	<%
	
		} 
	
	%> --%>
	
	<c:set var="i" value="0"/>
	<c:forEach var="purchase" items="${list }">
	<c:set var="i" value="${i + 1 }"/>
	<tr class="ct_list_pop">
	<Td align="center">
	<a href="/getPurchase.do?tranNo=${purchase.tranNo }">${i }</a>
	</Td>
	<td></td>
	<td align="left">
	<a href="/getUser.do?userId=${purchase.buyer.userId }">${purchase.buyer.userId }</a>
	</td>
	<td></td>
		<td align="left">${purchase.receiverName }</td>
		<td></td>
		<td align="left">${purchase.receiverPhone }</td>
		<td></td>
		<td align="left">
			<c:if test="${purchase.tranCode.trim().equals('0') }">
			현재구매완료상태 입니다.
			</c:if>
			<c:if test="${purchase.tranCode.trim().equals('1') }">
			현재배송중상태 입니다.
			</c:if>
			<c:if test="${purchase.tranCode.trim().equals('2') }">
			현재배송완료상태 입니다.
			</c:if>
			
		</td>
		<td></td>
		<td align="left">
		
		<c:if test="${purchase.tranCode.trim().equals('1') }">
		<a href="/updateTranCode.do?tranNo=${purchase.tranNo }&tranCode=2&page=${resultPage.currentPage}">물건도착</a>
		</c:if>
		
			
		</td>
	</tr>
	<tr>
		<td colspan="11" bgcolor="D6D7D6" height="1"></td>
	</tr>
	
	</c:forEach>
	
	
	
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top: 10px;">
	<tr>
		<td align="center">
		 	<input type="hidden" id="currentPage" name="currentPage" value=""/>
		 	<!-- EL / JSTL 적용으로 주석 처리 -->
		 	<%-- <%if(resultPage.getCurrentPage() <= resultPage.getPageUnit()) {%>
		 		
		 	<%} else {%>
		 		<a href="/listPurchase.do?currentPage=<%=resultPage.getCurrentPage() - 1%>">이전 </a> 
		 	<%}
		 	
		 	for(int i = resultPage.getBeginUnitPage(); i <= resultPage.getEndUnitPage(); i++) {%>
		 		<a href="/listPurchase.do?currentPage=<%=i%>"><%=i%></a>
		 	<%}
		 	
		 	if(resultPage.getEndUnitPage() >= resultPage.getMaxPage()) {%>
		 		
		 	<%} else {%>
		 		<a href="/listPurchase.do?currentPage=<%=resultPage.getEndUnitPage() + 1%>"> 다음</a> 
		 	<%}
		 	%> --%>
			
			<jsp:include page="../common/pageNavigator.jsp"/>
		
		</td>
	</tr>
</table>

<!--  페이지 Navigator 끝 -->
</form>

</div>

</body>
</html>