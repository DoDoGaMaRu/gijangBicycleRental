<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="resources_path" value="${pageContext.request.contextPath}/resources"/>
<c:set var="view_path" value="${pageContext.request.contextPath}/../WEB-INF/view"/>
<%
    request.setCharacterEncoding("UTF-8");
    String title = "회원 정보 조회";
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
            <table>
                <tr>
                    <th colspan="2">회원 정보 조회</th>
                </tr>
                <tr>
                    <td>아이디</td>
                    <td>id_value</td>
                </tr>
                <tr>
                    <td>이름</td>
                    <td>name_value</td>
                </tr>
                <tr>
                    <td>이메일</td>
                    <td>email_value</td>
                </tr>
                <tr>
                    <td>생년월일</td>
                    <td>birthDate_value</td>
                </tr>
                <tr>
                    <td>주소</td>
                    <td>address_value</td>
                </tr>
                <tr>
                    <td>전화번호</td>
                    <td>phoneNumber_value</td>
                </tr>
            </table>
        </div>
    </div>
</main>
<jsp:include page="${view_path}/fragment/footer.jsp" />
</body>
</html>
