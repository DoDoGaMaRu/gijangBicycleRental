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
    String title = "공지 관리";
    final int MAX_OF_LIST = 8;
    List<Qna> qnas = (List<Qna>)request.getAttribute("qnas");
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
            </a>
            <table class="qna_list" border="1">
                <thead>
                <tr>
                    <th>번호</th>
                    <th class="title">제목</th>
                    <th>작성자</th>
                    <th class="date">게시일</th>
                </tr>
                </thead>
                <tbody>
                <%
                    Qna q = null;
                    String infoAtt;
                    for(int i = 0; i < MAX_OF_LIST; i++) {
                        if (i < qnas.size()) {
                            q = qnas.get(i);
                            infoAtt = "style='cursor:hand' onclick=\"location.href='notice/view.do?id="+q.getId()+"'\"";
                        } else {
                            infoAtt = "";
                            q = null;
                        }
                        out.print("<tr " + infoAtt + ">");
                        out.print("<td>" + (q == null ? "" : q.getId()) + "</td>");
                        out.print("<td>" + (q == null ? "" : q.getTitle()) + "</td>");
                        out.print("<td>" + (q == null ? "" : q.getUser().getName()) + "</td>");
                        out.print("<td>" + (q == null ? "" : q.getRegdate()) + "</td>");
                        out.print("</tr>");
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</main>
<jsp:include page="${view_path}/fragment/footer.jsp" />
</body>
</html>
