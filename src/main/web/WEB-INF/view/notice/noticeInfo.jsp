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
    String title = "QnA 조회";
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
            <table class="qna">
                <tr>
                    <td>Q/A</td>
                    <td>
                        <div class="qna_title_container"></div>
                        <div class="qna_content_container"></div>
                    </td>
                </tr>
                <tr>
                    <td>Q/A 답변</td>
                    <td>
                        <form action="regist.do" method="post">
                            <textarea class="answer_container" name="content"></textarea>
                            <input class="button" type="submit" value="답변 등록">
                        </form>
                        <div class="answer_container"></div>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</main>
<jsp:include page="${view_path}/fragment/footer.jsp" />
</body>
</html>
