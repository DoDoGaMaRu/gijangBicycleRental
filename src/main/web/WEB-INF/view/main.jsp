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
</head>
<body>
  <jsp:include page="${view_path}/fragment/header.jsp" flush="true">
    <jsp:param name="title" value='<%=title%>' />
  </jsp:include>
  <main>
    <div class="container">
      <div class="cont_box">

        <button onclick="window.location.href='/gijangBicycleRental/user.do'">
          회원 관리
        </button>

        <button onclick="window.location.href='/gijangBicycleRental/rental.do'">
          대여 관리
        </button>

        <button onclick="window.location.href='/gijangBicycleRental/history.do'">
          이력 관리
        </button>

        <button onclick="window.location.href='/gijangBicycleRental/notice.do'">
          공지 관리
        </button>

        <button onclick="window.location.href='/gijangBicycleRental/operation.do'">
          운영 관리
        </button>

      </div>
    </div>
  </main>
  <jsp:include page="${view_path}/fragment/footer.jsp" />
</body>
</html>

