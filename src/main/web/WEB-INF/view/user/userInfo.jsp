<%@ page import="persistence.entity.User" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="resources_path" value="${pageContext.request.contextPath}/resources"/>
<c:set var="view_path" value="${pageContext.request.contextPath}/../WEB-INF/view"/>
<%
    request.setCharacterEncoding("UTF-8");
    String title = "회원 정보 조회";
    User user = (User) request.getAttribute("user");
%>

<html>
<head>
    <title><%=title%></title>
    <link rel="stylesheet" href="${resources_path}/css/reset.css">
    <link rel="stylesheet" href="${resources_path}/css/common.css">
    <link rel="stylesheet" href="${resources_path}/css/user/userInfo.css">
    <script defer type="text/javascript" src="${resources_path}/js/minors.js"></script>
</head>
<body>
<jsp:include page="${view_path}/fragment/header.jsp" flush="true">
    <jsp:param name="title" value='<%=title%>' />
</jsp:include>
<main>
    <div class="container">
        <div class="cont_box">
            <div class="main_cont">
                <form action="./userInfo.do" method="GET">
                    <label for="serial">회원 시리얼:</label>
                    <input type="text" id="serial" name="serial">
                    <button type="submit">조회</button>
                    <button type="button" onclick="window.location.href='http://localhost:8080/gijangBicycleRental/user.do';">뒤로가기</button>
                </form>
                <table class="info_table">
                    <% if (user != null) { %>
                    <tr>
                        <td class="row_name">아이디</td>
                        <td>
                            <p class="row_text"><% out.print(user.getId()); %></p>
                        </td>
                    </tr>
                    <tr>
                        <td class="row_name">이름</td>
                        <td>
                            <p class="row_text"><% out.print(user.getName()); %></p>
                        </td>
                    </tr>
                    <tr>
                        <td class="row_name">이메일</td>
                        <td>
                            <p class="row_text" class="row_text"><% out.print(user.getEmail()); %></p>
                        </td>
                    </tr>
                    <tr>
                        <td class="row_name">생년월일</td>
                        <td>
                            <p class="row_text"><% out.print(user.getBirthDate()); %></p>
                        </td>
                    </tr>
                    <tr>
                        <td class="row_name">주소</td>
                        <td>
                            <p class="row_text"><% out.print(user.getAddress()); %></p>
                        </td>
                    </tr>
                    <tr>
                        <td class="row_name">전화번호</td>
                        <td>
                            <p class="row_text"><% out.print(user.getPhone()); %></p>
                        </td>
                    </tr>
                    <% if (user.getParentPhone() != null) { %>
                    <tr>
                        <td class="row_name">보호자 전화번호</td>
                        <td>
                            <p class="row_text"><% out.print(user.getParentPhone()); %></p>
                        </td>
                    </tr>
                    <% } %>
                    <% } %>
                </table>
            </div>
        </div>
    </div>
</main>
<jsp:include page="${view_path}/fragment/footer.jsp" />
</body>
</html>
