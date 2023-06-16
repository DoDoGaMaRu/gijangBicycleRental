<%--
  Created by IntelliJ IDEA.
  User: DaeHwan
  Date: 2023-05-30
  Time: 오후 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="persistence.entity.Rental" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="resources_path" value="${pageContext.request.contextPath}/resources"/>
<c:set var="view_path" value="${pageContext.request.contextPath}/../WEB-INF/view"/>
<%
    request.setCharacterEncoding("UTF-8");
    String title = "대여 현황 조회";
    Rental r = (Rental) request.getAttribute("rental");
%>

<html>
<head>
    <title><%=title%></title>
    <link rel="stylesheet" href="${resources_path}/css/reset.css">
    <link rel="stylesheet" href="${resources_path}/css/common.css">
    <link rel="stylesheet" href="${resources_path}/css/rental/rentalState.css">
    <script defer type="text/javascript" src="${resources_path}/js/minors.js"></script>
</head>
<body>
<jsp:include page="${view_path}/fragment/header.jsp" flush="true">
    <jsp:param name="title" value='<%=title%>' />
</jsp:include>
<main>
    <div class="container">
        <div class="cont_box">

            <form class="state_form" action="state.do" method="post">

                <h1>사용자 시리얼 입력</h1>
                <input type="text" name="serial" required="required"><br>

                <button type="submit">조회</button>

            </form>

            <table class="bicycle_State">
                <% if (r != null) { %>
                <tr class="state">
                    <td>대여 상태</td>
                    <%
                        out.print("<td>"+ (r.getEndTime() == null ? "대여 중" : "현재 대여상태 아님") +"</td>");
                    %>
                </tr>
                <tr class="time">
                    <td>대여 일시</td>
                    <%
                        out.print("<td>"+ (r.getEndTime() == null ? r.getStartTime().toLocalTime() : "현재 대여상태 아님") +"</td>");
                    %>
                </tr>
                <% } %>
            </table>

        </div>
    </div>
</main>
<jsp:include page="${view_path}/fragment/footer.jsp" />
</body>
</html>
