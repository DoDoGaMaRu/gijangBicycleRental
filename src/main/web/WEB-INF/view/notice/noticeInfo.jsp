<%@ page import="persistence.entity.Qna" %>
<%@ page import="java.util.List" %><%--
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
    Qna qna = (Qna) request.getAttribute("qna");
    Qna answer = (Qna) request.getAttribute("answer");
%>

<html>
<head>
    <title><%=title%></title>
    <link rel="stylesheet" href="${resources_path}/css/reset.css">
    <link rel="stylesheet" href="${resources_path}/css/common.css">
    <link rel="stylesheet" href="${resources_path}/css/notice/notice.css">
    <style>

    </style>
</head>
<body>
<jsp:include page="${view_path}/fragment/header.jsp" flush="true">
    <jsp:param name="title" value='<%=title%>' />
</jsp:include>
<main>
    <div class="container">
        <div class="cont_box">
            <form action="view.do?id=<%= qna.getId() %>" method="post">
                <table class="qna">
                    <tr>
                        <td>Q/A</td>
                        <td>
                            <div class="qna_title_container">
                                <%out.print(qna.getTitle());%>
                            </div>
                            <div class="qna_content_container">
                                <%
                                    out.print(qna.getInfo());
                                %>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>Q/A 답변</td>
                        <td>
                            <%
                                if (answer != null && answer.getInfo() != null) {
                            %>
                                <div class="answer_container">
                                    <%= answer.getInfo() %>
                                </div>
                            <%
                            } else {
                            %>
                                <textarea class="answer_container" name="info"></textarea>
                                <input class="button" type="submit" value="답변 등록">
                            <%
                                }
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <a class="button" href="../notice.do">목록</a>
                            <a class="button">수정</a>
                            <a class="button">삭제</a>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</main>
<jsp:include page="${view_path}/fragment/footer.jsp" />
</body>
</html>
