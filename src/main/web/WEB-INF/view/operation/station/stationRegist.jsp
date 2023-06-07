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
    <link rel="stylesheet" href="${resources_path}/css/operation/station/stationInfoTable.css">

    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=35cc06d0fff9be7acbcab450ef07af23"></script>
    <script defer type="text/javascript" src="${resources_path}/js/operation/station/stationRegist.js"></script>
</head>
<body>
<jsp:include page="${view_path}/fragment/header.jsp" flush="true">
    <jsp:param name="title" value='<%=title%>' />
</jsp:include>
<main>
    <div class="container">
        <div class="cont_box">
            <div class="main_cont">
                <form class="regist_form" action="regist.do" method="post">
                    <table class="info_table">
                        <tr>
                            <td class="row_name">대여소 이름</td>
                            <td>
                                <input class="row_text" type="text" name="name" required="required">
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><div id="map"></div></td>
                        </tr>
                        <tr>
                            <td class="row_name">대여소 위치</td>
                            <td>
                                <input class="row_text" id="coordinate" type="text" name="coordinate" required="required" pattern="[0-9.,]*">
                            </td>
                        </tr>
                        <tr>
                            <td class="row_name">사물 주소</td>
                            <td>
                                <input class="row_text" type="text" name="address" required="required">
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td class="btn_wrap">
                                <input class="table_btn" type="button" onclick="history.back();" value="취소" />
                                <input class="table_btn" type="submit" value="확인" />
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
