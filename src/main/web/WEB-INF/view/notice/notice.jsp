<%--
  Created by IntelliJ IDEA.
  User: DaeHwan
  Date: 2023-05-30
  Time: 오후 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="resources_path" value="${pageContext.request.contextPath}/resources"/>
<c:set var="view_path" value="${pageContext.request.contextPath}/../WEB-INF/view"/>
<%
    request.setCharacterEncoding("UTF-8");
    String title = "공지 관리";
%>

<html>
<head>
    <title><%=title%></title>
    <link rel="stylesheet" href="${resources_path}/css/reset.css">
    <link rel="stylesheet" href="${resources_path}/css/common.css">
    <link rel="stylesheet" href="${resources_path}/css/notice/notice.css">
</head>
<body>
<jsp:include page="${view_path}/fragment/header.jsp" flush="true">
    <jsp:param name="title" value='<%=title%>' />
</jsp:include>
<main>
    <div class="container">
        <div class="cont_box">
            <a href="notice/view.do">
            <table class="qna_list" border="1">
                <tr>
                    <th>번호</th>
                    <th class="title">제목</th>
                    <th>작성자</th>
                    <th class="date">게시일</th>
                </tr>
                <tr>
                    <td>1</td>
                    <td>질문합니다.</td>
                    <td>홍길동</td>
                    <td>2023.05.18 08:12:05</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>또 질문합니다.</td>
                    <td>홍길동</td>
                    <td>2023.05.18 08:12:05</td>
                </tr>
            </table>
            </a>
        </div>
    </div>
</main>
<jsp:include page="${view_path}/fragment/footer.jsp" />
</body>
</html>
