<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="resources_path" value="${pageContext.request.contextPath}/resources"/>
<c:set var="view_path" value="${pageContext.request.contextPath}/../WEB-INF/view"/>
<%
    request.setCharacterEncoding("UTF-8");
    String title = "미성년자 회원 가입";
%>

<html>
<head>
    <title><%=title%></title>
    <link rel="stylesheet" href="${resources_path}/css/reset.css">
    <link rel="stylesheet" href="${resources_path}/css/common.css">
    <link rel="stylesheet" href="${resources_path}/css/user/userMinorsRegist.css">

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
</head>
<body>
<jsp:include page="${view_path}/fragment/header.jsp" flush="true">
    <jsp:param name="title" value='<%=title%>' />
</jsp:include>
<main>
    <div class="container">
        <div class="cont_box">
            <div class="main_cont">
                <form class="regist_form" action="minorsRegist.do" method="post">
                    <table class="info_table">
                        <tr>
                            <td class="row_name">아이디</td>
                            <td><input class="row_text" type="text" name="id" required="required"></td>
                            <td><button type="button" onclick="checkDuplicateId()">아이디 중복 확인</button></td>
                        </tr>
                        <tr>
                            <td class="row_name">비밀번호</td>
                            <td><input class="row_text" type="password" name="pw" required="required"></td>
                        </tr>
                        <tr>
                            <td class="row_name">이름</td>
                            <td><input class="row_text" type="text" name="name" required="required"></td>
                        </tr>
                        <tr>
                            <td class="row_name">이메일</td>
                            <td><input class="row_text" type="text" name="email" required="required" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"></td>
                        </tr>
                        <tr>
                            <td class="row_name">생년월일</td>
                            <td><label><input type="date" class="row_text" name="birthDate" required></label></td>
                        </tr>
                        <tr>
                            <td class="row_name">주소</td>
                            <td><input class="row_text" type="text" name="address" required="required"></td>
                        </tr>
                        <tr>
                            <td class="row_name">전화번호</td>
                            <td><input class="row_text" type="text" name="phone" required="required" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}"></td>
                        </tr>
                        <tr>
                            <td class="row_name">보호자 전화번호</td>
                            <td><input class="row_text" type="text" name="parentPhone" required="required" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}"></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td class="btn_wrap">
                                <input class="table_btn" type="submit" value="가입하기" />
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
</main>
<jsp:include page="${view_path}/fragment/footer.jsp" />
</body>
</html>