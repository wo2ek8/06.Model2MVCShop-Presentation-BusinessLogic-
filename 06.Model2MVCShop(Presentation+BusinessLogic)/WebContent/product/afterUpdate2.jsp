
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <%-- <%
        	Product productVO = (Product)request.getAttribute("productVO");
            
            User user = (User)session.getAttribute("user");
            String role = "";
            if(user != null) {
            	role = user.getRole();
            }
        %> --%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="../css/admin.css" type="text/css">

<title>Insert title here</title>
</head>

<body bgcolor="#ffffff" text="#000000">

<form name="detailForm" method="post">

<table width="100%" height="37" border="0" cellpadding="0"	cellspacing="0">
	<tr>
		<td width="15" height="37"><img src="/images/ct_ttl_img01.gif"	width="15" height="37"></td>
		<td background="/images/ct_ttl_img02.gif" width="100%" style="padding-left: 10px;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="93%" class="ct_ttl01">상품상세조회</td>
					<td width="20%" align="right">&nbsp;</td>
				</tr>
			</table>
		</td>
		<td width="12" height="37">
			<img src="/images/ct_ttl_img03.gif"  width="12" height="37"/>
		</td>
	</tr>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0"	style="margin-top: 13px;">
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
	<tr>
		<td width="104" class="ct_write">
			상품번호 <img src="/images/ct_icon_red.gif" width="3" height="3" align="absmiddle"/>
		</td>
		<td bgcolor="D6D6D6" width="1"></td>
		<td class="ct_write01">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<%-- <td width="105"><%=productVO.getProdNo() %></td> --%>
					<td width="105">${product.prodNo }</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
	<tr>
		<td width="104" class="ct_write">
			상품명 <img src="/images/ct_icon_red.gif" width="3" height="3" align="absmiddle"/>
		</td>
		<td bgcolor="D6D6D6" width="1"></td>
		<%-- <td class="ct_write01"><%=productVO.getProdName() %></td> --%>
		<td class="ct_write01">${product.prodName }</td>
	</tr>
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
	<tr>
		<td width="104" class="ct_write">
			상품이미지 <img 	src="/images/ct_icon_red.gif" width="3" height="3" align="absmiddle"/>
		</td>
		<td bgcolor="D6D6D6" width="1"></td>
		<td class="ct_write01">
			<img src="/images/uploadFiles/${product.fileName }"/>
		</td>
	</tr>
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
	<tr>
		<td width="104" class="ct_write">
			상품상세정보 <img src="/images/ct_icon_red.gif" width="3" height="3" align="absmiddle"/>
		</td>
		<td bgcolor="D6D6D6" width="1"></td>
		<%-- <td class="ct_write01"><%=productVO.getProdDetail() %></td> --%>
		<td class="ct_write01">${product.prodDetail} </td>
	</tr>
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
	<tr>
		<td width="104" class="ct_write">제조일자</td>
		<td bgcolor="D6D6D6" width="1"></td>
		<%-- <td class="ct_write01"><%=productVO.getManuDate() %></td> --%>
		<td class="ct_write01">${product.manuDate }</td>
	</tr>
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
	<tr>
		<td width="104" class="ct_write">가격</td>
		<td bgcolor="D6D6D6" width="1"></td>
		<%-- <td class="ct_write01"><%=productVO.getPrice() %></td> --%>
		<td class="ct_write01">${product.price }</td>
	</tr>
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
	<tr>
		<td width="104" class="ct_write">등록일자</td>
		<td bgcolor="D6D6D6" width="1"></td>
		<%-- <td class="ct_write01"><%=productVO.getRegDate() %></td> --%>
		<td class="ct_write01">${product.regDate }</td>
	</tr>
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0"	style="margin-top: 10px;">
	<tr>
		<td width="53%"></td>
		<td align="right">

		<table border="0" cellspacing="0" cellpadding="0">
		
		<%-- <%
		if(user != null && role.equals("user")) {%> --%>
		<c:if test="${!empty user && user.role.equals('user')}">
			<tr>
			
			<td width="17" height="23">
				<img src="/images/ct_btnbg01.gif" width="17" height="23"/>
			</td>
			<td background="/images/ct_btnbg02.gif" class="ct_btn01" style="padding-top: 3px;">
				<%-- <a href="/addPurchaseView.do?prodNo=<%=productVO.getProdNo()%>">구매</a> --%>
				<a href="/addPurchaseView.do?prodNo=${product.prodNo }">구매</a>
			</td>
			<td width="14" height="23">
				<img src="/images/ct_btnbg03.gif" width="14" height="23">
			</td>
			<td width="30"></td>
	
			<td width="17" height="23">
				<img src="/images/ct_btnbg01.gif" width="17" height="23"/>
			</td>
			<td background="/images/ct_btnbg02.gif" class="ct_btn01" style="padding-top: 3px;">
				<a href="javascript:history.go(-1)">이전</a>
			</td>
			<td width="14" height="23">
				<img src="/images/ct_btnbg03.gif" width="14" height="23">
			</td>
		</tr>
		</c:if>
		<%-- <%} else if (user != null && role.equals("admin")) {%> --%>
		<c:if test="${!empty user && user.role.equals('admin')}">
			<tr>
			<td width="17" height="23">
				<img src="/images/ct_btnbg01.gif" width="17" height="23"/>
			</td>
			<td background="/images/ct_btnbg02.gif" class="ct_btn01"	style="padding-top: 3px;">
				<a href="/listProduct.do?menu=search">확인</a>
			</td>
			<td width="14" height="23">
				<img src="/images/ct_btnbg03.gif" width="14" height="23"/>
			</td>
		</tr>
		<%-- <%} else {%> --%>
		</c:if>
		<c:if test="${empty user}">
		<tr>
			
			
			
			<td width="30"></td>
	
			<td width="17" height="23">
				<img src="/images/ct_btnbg01.gif" width="17" height="23"/>
			</td>
			<td background="/images/ct_btnbg02.gif" class="ct_btn01" style="padding-top: 3px;">
				<a href="javascript:history.go(-1)">이전</a>
			</td>
			<td width="14" height="23">
				<img src="/images/ct_btnbg03.gif" width="14" height="23">
			</td>
		</tr>
		<%-- <%}
		%> --%>
		</c:if>
			
		</table>

		</td>
	</tr>
</table>
</form>

</body>
</html>