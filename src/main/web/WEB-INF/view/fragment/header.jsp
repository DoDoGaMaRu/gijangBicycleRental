<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: nm090
  Date: 2023-05-28
  Time: 오후 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="resources_path" value="${pageContext.request.contextPath}/resources"/>

<body>
<header>
    <div class="container">
        <div class="ban">
            <div class="ban_logo">
                공용자전거 무인대여시스템
            </div>
            <div class="ban_login">
                <img class="login_img" src="${resources_path}/img/header_user.png"/>
                <a class="login_btn" href="#">
                    <%
                        // 로그인 로그아웃 표시
                        out.println("로그인");
                    %>
                </a>
            </div>
        </div>
        <div class="title">
            <span class="title_text">
                <%
                    out.println(request.getParameter("title"));
                %>
            </span>
        </div>
    </div>
</header>
</body>