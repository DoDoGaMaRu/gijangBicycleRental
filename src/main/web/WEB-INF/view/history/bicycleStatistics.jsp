<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="resources_path" value="${pageContext.request.contextPath}/resources"/>
<c:set var="view_path" value="${pageContext.request.contextPath}/../WEB-INF/view"/>
<%
    request.setCharacterEncoding("UTF-8");
    String title = "자전거별 운영 통계";
%>

<html>
<head>
    <title><%=title%></title>
    <link rel="stylesheet" href="${resources_path}/css/reset.css">
    <link rel="stylesheet" href="${resources_path}/css/common.css">
    <link rel="stylesheet" href="${resources_path}/css/history/bicycleStatistics.css">
</head>
<body>
<jsp:include page="${view_path}/fragment/header.jsp" flush="true">
    <jsp:param name="title" value='<%=title%>' />
</jsp:include>
<main>
    <div class="container">
        <div class="cont_box">
            <div class="inquiry_bar">
                <input type="search" class="input_bicycleNum" placeholder="자전거 일련번호">
                <select class="select_bicycleState">
                    <option class="inquiry_option" selected>자전거 상태</option>
                    <option class="inquiry_option" value="rentPossible">대여 가능</option>
                    <option class="inquiry_option" value="rent">대여 중</option>
                    <option class="inquiry_option" value="breakdown">고장</option>
                </select>
            </div>
            <div class="bicycle_details">
                <span class="detail">일련번호</span>
                <span class="detail">자전거 상태</span>
                <span class="detail">운행거리</span>
            </div>
            <div class="bicycleResults">
                <%--더미데이터--%>
                <div class="resultSet">
                    <span class="res" id="bicycleNum">BicycleNUM1</span>
                    <span class="res" id="bicycleState">대여 중</span>
                    <span class="res" id="distance">1.2km</span>
                </div>
                <div class="resultSet">
                    <span class="res">BicycleNUM2</span>
                    <span class="res">대여 가능</span>
                    <span class="res">2.1km</span>
                </div>
                <div class="resultSet">
                    <span class="res">BicycleNUM3</span>
                    <span class="res">고장</span>
                    <span class="res">0.4km</span>
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