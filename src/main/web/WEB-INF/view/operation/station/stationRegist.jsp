<%--
  Created by IntelliJ IDEA.
  User: DaeHwan
  Date: 2023-06-02
  Time: 오후 03:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="resources_path" value="${pageContext.request.contextPath}/resources"/>
<c:set var="view_path" value="${pageContext.request.contextPath}/../WEB-INF/view"/>
<%
    request.setCharacterEncoding("UTF-8");
    String title = "대여소 등록";
%>

<html>
<head>
    <title><%=title%></title>
    <link rel="stylesheet" href="${resources_path}/css/reset.css">
    <link rel="stylesheet" href="${resources_path}/css/common.css">
    <link rel="stylesheet" href="${resources_path}/css/operation/station/stationRegist.css">

    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=35cc06d0fff9be7acbcab450ef07af23"></script>
    <script defer type="text/javascript" src="${resources_path}/js/map.js"></script>
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
                        <th colspan="2">대여소 등록</th>
                    </tr>
                    <tr>
                        <td>대여소 이름</td>
                        <td><input type="text" name="name"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><div id="map"></div></td>
                    </tr>
                    <tr>
                        <td>대여소 위치</td>
                        <td>
                            <input id="coordinate" type="text" name="coordinate">
                        </td>
                    </tr>
                    <tr>
                        <td>사물 주소</td>
                        <td>
                            <input type="text" name="address">
                        </td>
                    </tr>
                    <tr>
                        <th colspan="2">
                            <input type="submit" value="확인">
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
