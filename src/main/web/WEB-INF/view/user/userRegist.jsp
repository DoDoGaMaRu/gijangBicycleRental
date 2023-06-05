<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="resources_path" value="${pageContext.request.contextPath}/resources"/>
<c:set var="view_path" value="${pageContext.request.contextPath}/../WEB-INF/view"/>
<%
    request.setCharacterEncoding("UTF-8");
    String title = "일반 회원 가입";
%>

<html>
<head>
    <title><%=title%></title>
    <%-- <link rel="stylesheet" href="${resources_path}/css/reset.css"> --%>
    <link rel="stylesheet" href="${resources_path}/css/common.css">
    <link rel="stylesheet" href="${resources_path}/css/user/userRegist.css">

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
    <script defer type="text/javascript" src="${resources_path}/js/cal.js"></script>
</head>
<body>
<jsp:include page="${view_path}/fragment/header.jsp" flush="true">
    <jsp:param name="title" value='<%=title%>' />
</jsp:include>
<main>
    <div class="container">
        <div class="cont_box">
            <form action="regist.do" method="post">
                <table>
                    <tr>
                        <th colspan="2">회원가입</th>
                    </tr>
                    <tr>
                        <td>아이디</td>
                        <td><input type="text" name="id"></td>
                        <td><button type="button" onclick="checkDuplicateId()">아이디 중복 확인</button></td>
                        <%-- Todo ID 중복 검사 할 것 --%>
                    </tr>
                    <tr>
                        <td>비밀번호</td>
                        <td><input type="password" name="pw"></td>
                    </tr>
                    <tr>
                        <td>이름</td>
                        <td><input type="text" name="name"></td>
                    </tr>
                    <tr>
                        <td>이메일</td>
                        <td><input type="text" name="email"></td>
                    </tr>
                    <tr>
                        <td>생년월일</td>
                        <td><input type="text" id="birthDate" name="birthDate" readonly></td>
                    </tr>
                    <tr>
                        <td>주소</td>
                        <td><input type="text" name="address"></td>
                    </tr>
                    <tr>
                        <td>전화번호</td>
                        <td><input type="text" name="phoneNumber"></td>
                        <%-- Todo 본인인증 만들어야 하나...? 일단 놔둠 --%>
                    </tr>
                    <tr>
                        <th colspan="2">
                            <input type="submit" value="가입하기">
                        </th>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</main>
<jsp:include page="${view_path}/fragment/footer.jsp" />
</body>
</html>