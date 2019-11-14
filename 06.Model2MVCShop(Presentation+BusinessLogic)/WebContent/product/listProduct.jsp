<%-- <%@page import="com.model2.mvc.service.domain.User"%>
<%@page import="com.model2.mvc.service.domain.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model2.mvc.common.Search"%>
<%@page import="java.util.HashMap"%> --%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <!-- EL / JSTL 적용으로 주석 처리 -->
    <%-- <%
        	HashMap<String, Object> map = (HashMap<String, Object>)request.getAttribute("map");
                    Search search = (Search)request.getAttribute("search");
                    
                    
                    
                    int total = 0;
                    ArrayList<Product> list = null;
                    if(map != null) {
                    	total = ((Integer)map.get("count")).intValue();
                    	list = (ArrayList<Product>)map.get("list");
                    }
                    
                    int currentPage = search.getCurrentPage();
                    
                    int totalPage = 0;
                    if(total > 0) {
                    	totalPage = total / search.getPageSize();
                    	if(total % search.getPageSize() > 0) {
                    		totalPage += 1;
                    	}
                    }
        %> --%>
<!DOCTYPE html>
<html>
<head>
<title>상품 목록조회</title>

<style>
        * {
            padding: 0;
            margin: 0;
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
            font-family: 'Roboto', sans-serif;
            font-family: 'Nanum Gothic', sans-serif;
            color: #898989;
        }
        div.wrap {
            width: 1300px;
            margin: 50px auto;
            overflow: hidden;
        }
        div.nav {
            overflow: hidden;
        }
        div.nav div.pageInfo {
            float: left;
            line-height: 25px;
            margin-left: 10px;
        }
        div.nav div.search {
            float: right;
            margin-right: 10px;
        }
        div.nav div.search select {
            height: 25px;
        }
        div.nav div.search input {
            height: 25px;
        }
        div.nav div.search a {
            display: inline-block;
            height: 25px;
        }
        div.nav div.search a img {
            height: 10px;
            margin-left: 5px;
        }
        ul.sorting {
            text-align: right;
            margin-top: 20px;
            margin-right: 10px;
        }
        ul.sorting li {
            display: inline-block;
        }
        ul.sorting li span {
            display: inline-block;
            width: 10px;
            height: 10px;
            border: 1px solid;
        }
        ul.sorting li.on span {
            background-color: rgb(217, 159, 157);
        }
        div.product {
            width: 25%;
            padding: 10px;
            float: left;
        	margin-top: 20px;
        }
        div.product img {
            width: 100%;
        }
        div.listProduct {
        	overflow: hidden;
        	margin-bottom: 30px;
        }
        div.page {
        	text-align: center;
        	margin-top: 15px;
        }
        div.product:nth-child(5) {
        	clear: both;
        }
        div.prodName span {
        	text-decoration: line-through;
        }
    </style>

<script type="text/javascript">

function fncGetList(currentPage, sorting){
	document.getElementById("currentPage").value = currentPage;
	document.getElementById("sorting").value = sorting;
	document.detailForm.submit();
}

</script>
</head>

<body>
<form name="detailForm" action="/listProduct.do?menu=${param.menu }" method="post">
    <div class="wrap">
        <div class="nav">
            <div class="pageInfo">
                전체 ${resultPage.totalCount } 건수, 현재 ${resultPage.currentPage } 페이지
            </div>
            <div class="search">
                <select name="searchCondition" id="">
                    <option value="0" ${!empty search.searchCondition && search.searchCondition == 0 ? "selected" : "" }>상품번호</option>
				<option value="1" ${!empty search.searchCondition && search.searchCondition == 1 ? "selected" : "" }>상품명</option>
				<option value="2" ${!empty search.searchCondition && search.searchCondition == 2 ? "selected" : "" }>상품가격</option>
                </select>
                <input type="text" name="searchKeyword" value="${!empty search.searchKeyword ? search.searchKeyword : '' }">
                <a href="javascript:fncGetList('1', '')"><img src="../images/header_ico_search.png" alt=""> SEARCH</a>
            </div>
        </div>
        <input type="hidden" id="sorting" name="sorting" value=""/>
        <ul class="sorting">
        <c:if test="${!empty search.sorting }">
        <c:if test="${search.sorting == '0' }">
        <li class="on"><a href="/listProduct.do?menu=${param.menu }&sorting=0&searchCondition=${search.searchCondition}&searchKeyword=${search.searchKeyword}"><span></span> 신상품</a></li>
            <li><a href="/listProduct.do?menu=${param.menu }&sorting=1&searchCondition=${search.searchCondition}&searchKeyword=${search.searchKeyword}"><span></span> 낮은가격</a></li>
            <li><a href="/listProduct.do?menu=${param.menu }&sorting=2&searchCondition=${search.searchCondition}&searchKeyword=${search.searchKeyword}"><span></span> 높은가격</a></li>
            <li><a href="/listProduct.do?menu=${param.menu }&sorting=3&searchCondition=${search.searchCondition}&searchKeyword=${search.searchKeyword}"><span></span> 이름</a></li>
        </c:if>
        <c:if test="${search.sorting == '1' }">
        <li><a href="/listProduct.do?menu=${param.menu }&sorting=0&searchCondition=${search.searchCondition}&searchKeyword=${search.searchKeyword}"><span></span> 신상품</a></li>
            <li class="on"><a href="/listProduct.do?menu=${param.menu }&sorting=1&searchCondition=${search.searchCondition}&searchKeyword=${search.searchKeyword}"><span></span> 낮은가격</a></li>
            <li><a href="/listProduct.do?menu=${param.menu }&sorting=2&searchCondition=${search.searchCondition}&searchKeyword=${search.searchKeyword}"><span></span> 높은가격</a></li>
            <li><a href="/listProduct.do?menu=${param.menu }&sorting=3&searchCondition=${search.searchCondition}&searchKeyword=${search.searchKeyword}"><span></span> 이름</a></li>
        </c:if>
        <c:if test="${search.sorting == '2' }">
        <li><a href="/listProduct.do?menu=${param.menu }&sorting=0&searchCondition=${search.searchCondition}&searchKeyword=${search.searchKeyword}"><span></span> 신상품</a></li>
            <li><a href="/listProduct.do?menu=${param.menu }&sorting=1&searchCondition=${search.searchCondition}&searchKeyword=${search.searchKeyword}"><span></span> 낮은가격</a></li>
            <li class="on"><a href="/listProduct.do?menu=${param.menu }&sorting=2&searchCondition=${search.searchCondition}&searchKeyword=${search.searchKeyword}"><span></span> 높은가격</a></li>
            <li><a href="/listProduct.do?menu=${param.menu }&sorting=3&searchCondition=${search.searchCondition}&searchKeyword=${search.searchKeyword}"><span></span> 이름</a></li>
        </c:if>
        <c:if test="${search.sorting == '3' }">
        <li><a href="/listProduct.do?menu=${param.menu }&sorting=0&searchCondition=${search.searchCondition}&searchKeyword=${search.searchKeyword}"><span></span> 신상품</a></li>
            <li><a href="/listProduct.do?menu=${param.menu }&sorting=1&searchCondition=${search.searchCondition}&searchKeyword=${search.searchKeyword}"><span></span> 낮은가격</a></li>
            <li><a href="/listProduct.do?menu=${param.menu }&sorting=2&searchCondition=${search.searchCondition}&searchKeyword=${search.searchKeyword}"><span></span> 높은가격</a></li>
            <li class="on"><a href="/listProduct.do?menu=${param.menu }&sorting=3&searchCondition=${search.searchCondition}&searchKeyword=${search.searchKeyword}"><span></span> 이름</a></li>
        </c:if>
        </c:if>
        <c:if test="${empty search.sorting}">
        <li><a href="/listProduct.do?menu=${param.menu }&sorting=0&searchCondition=${search.searchCondition}&searchKeyword=${search.searchKeyword}"><span></span> 신상품</a></li>
            <li><a href="/listProduct.do?menu=${param.menu }&sorting=1&searchCondition=${search.searchCondition}&searchKeyword=${search.searchKeyword}"><span></span> 낮은가격</a></li>
            <li><a href="/listProduct.do?menu=${param.menu }&sorting=2&searchCondition=${search.searchCondition}&searchKeyword=${search.searchKeyword}"><span></span> 높은가격</a></li>
            <li><a href="/listProduct.do?menu=${param.menu }&sorting=3&searchCondition=${search.searchCondition}&searchKeyword=${search.searchKeyword}"><span></span> 이름</a></li>
        </c:if>
            
        </ul>
        <div class="listProduct">
        <c:set var="i" value="0"/>
        <c:forEach var="product" items="${list }">
        <c:set var="i" value="${i + 1 }"/>
        
            <div class="product">
                
                <div class="image">
                    <img src="../images/uploadFiles/${product.fileName }" alt="">
                </div>
                <div class="prodName">
	                <c:if test="${param.menu.equals('manage') }">
						<a href="/updateProductView.do?prodNo=${product.prodNo }">${product.prodName }</a>
					</c:if>
					
					<c:if test="${param.menu.equals('search') }">
						<c:if test="${product.quantity > 0}">
							<a href="/getProduct.do?prodNo=${product.prodNo }">${product.prodName }</a>
						</c:if>
						
					</c:if>
                    
                </div>
                <div class="price">
                    ${product.price }원
                </div>
                <div class="prodDetail">
                    ${product.prodDetail }
                </div>
            </div>
            </c:forEach>
            
        </div>
        <div class="page">
	        <input type="hidden" id="currentPage" name="currentPage" value=""/>
	        <jsp:include page="../common/pageNavigator.jsp"/>
        </div>
    </div>
    </form>
</body>
</html>