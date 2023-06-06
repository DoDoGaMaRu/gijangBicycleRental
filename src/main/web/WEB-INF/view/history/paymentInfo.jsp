<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="resources_path" value="${pageContext.request.contextPath}/resources"/>
<c:set var="view_path" value="${pageContext.request.contextPath}/../WEB-INF/view"/>
<%
    request.setCharacterEncoding("UTF-8");
    String title = "결제 내역 조회";
%>

<html>
<head>
    <title><%=title%></title>
    <link rel="stylesheet" href="${resources_path}/css/reset.css">
    <link rel="stylesheet" href="${resources_path}/css/common.css">
    <link rel="stylesheet" href="${resources_path}/css/history/paymentInfo.css">
</head>
<body>
<jsp:include page="${view_path}/fragment/header.jsp" flush="true">
    <jsp:param name="title" value='<%=title%>' />
</jsp:include>
<main>
    <div class="container">
        <div class="cont_box">
            <div class="inquiry_bar">
                <label>기간 <input type="date" class="date_range" required> ~ <input type="date" class="date_range" required></label>
                <span class="id">oose123</span>
                <span class="id" style="margin-right: 50px">아이디</span>
            </div>
            <div class="payment_details">
                <span class="detail">결제 일련번호</span>
                <span class="detail">결제 일시</span>
                <span class="detail">결제 종류</span>
                <span class="detail">결제 금액</span>
            </div>
            <div class="payResults">
            <%--더미데이터--%>
                <div class="resultSet">
                    <span class="res" id="payNum">PAYNUM1</span>
                    <span class="res" id="payDate">23.03.17</span>
                    <span class="res" id="payType">토스페이</span>
                    <span class="res" id="payAmount">1300원</span>
                </div>
                <div class="resultSet">
                    <span class="res">PAYNUM2</span>
                    <span class="res">23.05.27</span>
                    <span class="res">삼성페이</span>
                    <span class="res">1900원</span>
                </div>
                <div class="resultSet">
                    <span class="res">PAYNUM3</span>
                    <span class="res">23.06.01</span>
                    <span class="res">체크카드</span>
                    <span class="res">800원</span>
                </div>
            </div>
            <%-- 조회 버튼 --%>
            <div class="btnBox">
                <button class="inquiry_Btn">조회</button>
            </div>
        </div>
    </div>
</main>
<jsp:include page="${view_path}/fragment/footer.jsp" />
</body>
</html>