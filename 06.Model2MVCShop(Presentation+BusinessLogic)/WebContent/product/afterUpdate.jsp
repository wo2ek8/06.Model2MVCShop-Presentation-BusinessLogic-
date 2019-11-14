
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
            color: #464646;
            font-size: 14px;
            font-family: 'Roboto', sans-serif;
            font-family: 'Nanum Gothic', sans-serif;
        }
        div.wrap {
            width: 1000px;
            margin: 30px auto;
            overflow: hidden;
        }
        div.wrap > div > div {
            float: left;
        }
        div.image {
            width: 50%;
            padding: 0 20px;
        }
        div.image img {
            width: 100%;
        }
        div.productInfo {
            width: 50%;
            padding: 0 30px;
            font-size: 12px;
        }
        div.prodName {
            font-weight: bold;
            font-size: 16px;
            margin-bottom: 25px;
        }
        table tr {
            height: 30px;
            vertical-align: top;
        }
        table {
            border-bottom: 1px solid #bcbcbc;
            width: 100%;
            margin-bottom: 30px;
        }
        input {
            width: 30px;
            height: 20px;
            float: left;
        }
        table a {
            display: block;
            width: 20px;
            height: 10px;
            
        }
        table a img {
            vertical-align: top;
            height: 100%;
        }
        div.button {
            display: inline-block;
        }
        div.total {
            font-size: 16px;
            font-weight: bold;
            margin-bottom: 30px;
        }
        div.total span {
            color: #898989;
            font-weight: normal;
        }
        div.btn {
            width: 100%;
            overflow: hidden;
        }
        div.btn a {
            width: 32%;
            display: block;
            float: left;
            text-align: center;
            height: 40px;
            line-height: 40px;
            border: 1px solid black;
            font-weight: bold;
        }
        div.btn a:first-child {
            background-color: #d99f9d;
            color: white;
        }
        div.btn a + a {
            margin-left: 2%;
        }
    </style>

<title>Insert title here</title>
</head>

<body>

<form name="detailForm" method="post">

<div class="wrap">
        <div class="afterUpdate">
            <div class="image">
                <img src="/images/uploadFiles/${product.fileName }" alt="">
            </div>
            <div class="productInfo">
                <div class="prodName">
                    ${product.prodName }
                </div>
                <table>
                    <colgroup>
                        <col width="25%">
                        <col width="75%">
                    </colgroup>
                    <tr>
                        <td>
                            Price
                        </td>
                        <td>
                            ${product.price }원
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Code
                        </td>
                        <td>
                            ${product.prodNo }
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Point
                        </td>
                        <td>
                            100원 (1%)
                        </td>
                    </tr>
                    <tr class="quantity">
                        <td>
                            Quantity
                        </td>
                        <td>
                            <input type="text" value="1">
                            <div class="button">
                                <a href="#"><img src="/images/btn_count_up.gif" alt=""></a>
                                <a href="#"><img src="/images/btn_count_down.gif" alt=""></a>
                            </div>
                        </td>
                    </tr>
                    <tr></tr>
                </table>
                <div class="total">
                    TOTAL<span>(QUANTITY) : </span>${product.price }원 <span>(1개)</span>
                </div>
                <div class="btn">
                    <a href="/addCart.do?prodNo=${product.prodNo }&userId=${user.userId}">장바구니</a>
                    <a href="#">관심상품</a>
                    <a href="/addPurchaseView.do?prodNo=${product.prodNo }">구매하기</a>
                </div>
            </div>
        </div>
    </div>


</form>

</body>
</html>