<%--
  Created by IntelliJ IDEA.
  User: DaeHwan
  Date: 2023-05-28
  Time: 오후 1:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="resources_path" value="${pageContext.request.contextPath}/resources"/>
<c:set var="view_path" value="${pageContext.request.contextPath}/../WEB-INF/view"/>
<%
  request.setCharacterEncoding("UTF-8");
  String title = "메인 페이지";
%>

<html>
<head>
  <title><%=title%></title>
  <link rel="stylesheet" href="${resources_path}/css/reset.css">
  <link rel="stylesheet" href="${resources_path}/css/common.css">
  <link rel="stylesheet" href="${resources_path}/css/main.css">
</head>
<body>
  <jsp:include page="${view_path}/fragment/header.jsp" flush="true">
    <jsp:param name="title" value='<%=title%>' />
  </jsp:include>
  <main>
    <div class="container">
      <div class="cont_box">
        <div class="nav_wrap">
          <div class="nav_col">
            회원 관리
            <button onclick="window.location.href='/gijangBicycleRental/user/registMgmt.do'">
              회원 가입
            </button>
            <button onclick="window.location.href='/gijangBicycleRental/user/userInfo.do'">
              회원 정보 조회
            </button>
          </div>
          <div class="nav_col">
            대여 관리
            <button onclick="window.location.href='/gijangBicycleRental/rental/rental.do'">
              자전거 대여
            </button>
            <button onclick="window.location.href='/gijangBicycleRental/rental/state.do'">
              대여 현황 조회
            </button>
          </div>
          <div class="nav_col">
            이력 관리
            <button onclick="window.location.href='/gijangBicycleRental/history/paymentInfo.do'">
              결제 내역 조회
            </button>
            <button onclick="window.location.href='/gijangBicycleRental/history/bicycleStatistics.do'">
              자전거별 운영 통계
            </button>
          </div>
          <div class="nav_col">
            공지 관리
            <button onclick="window.location.href='/gijangBicycleRental/notice.do'">
              공지 관리
            </button>
          </div>
          <div class="nav_col">
            운영 관리
            <button onclick="window.location.href='/gijangBicycleRental/operation/bicycleMgmt.do'">
              자전거 관리
            </button>
            <button onclick="window.location.href='/gijangBicycleRental/operation/stationMgmt.do'">
              대여소 관리
            </button>
          </div>
        </div>
      </div>
    </div>
  </main>
  <jsp:include page="${view_path}/fragment/footer.jsp" />
</body>
</html>

