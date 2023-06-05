<%--
  Created by IntelliJ IDEA.
  User: DaeHwan
  Date: 2023-06-02
  Time: 오후 05:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="resources_path" value="${pageContext.request.contextPath}/resources"/>
<c:set var="view_path" value="${pageContext.request.contextPath}/../WEB-INF/view"/>
<%
    request.setCharacterEncoding("UTF-8");
    String title = "자전거 관리";
%>

<html>
<head>
    <title><%=title%></title>
    <link rel="stylesheet" href="${resources_path}/css/operation/bicycle/bicycleMgmt.css">
    <link rel="stylesheet" href="${resources_path}/css/common.css">
</head>
<body>
<jsp:include page="${view_path}/fragment/header.jsp" flush="true">
    <jsp:param name="title" value='<%=title%>' />
</jsp:include>
<main>
    <div class="container">
        <div class="cont_box">
            <form action="info.do" method="post">
                <table>
                    <tr>
                        <th colspan="4">자전거 목록</th>
                    </tr>
                    <tr>
                        <td>번호</td>
                        <td>처리 상태</td>
                        <td>위치</td>
                        <td>대여 상태</td>
                    </tr>
                </table>
                <a class="cansle_but" href="../operation.do">돌아가기</a>
                <a class="regist_but" href="bicycleMgmt/regist.do">자전거 등록</a>
                <a href="bicycleMgmt/info.do">자전거 조회</a>
            </form>

        </div>
    </div>
</main>
<jsp:include page="${view_path}/fragment/footer.jsp" />
</body>
</html>
