<%@ page import="persistence.entity.Bicycle" %><%--
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
    String title = "자전거 정보";
    Bicycle bicycle = (Bicycle) request.getAttribute("bicycle");
%>

<html>
<head>
    <title><%=title%></title>

    <link rel="stylesheet" href="${resources_path}/css/common.css">
    <link rel="stylesheet" href="${resources_path}/css/operation/station/bicycleInfo.css">
    <link rel="stylesheet" href="${resources_path}/css/operation/station/stationInfoTable.css">

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
            <div class="main_cont">
                <table class="info_table">
                    <tr>
                        <td class="row_name">자전거 번호</td>
                        <td>
                            <p class="row_text"><% out.print(bicycle.getId()); %></p>
                        </td>
                    </tr>
                    <tr>
                        <td class="row_name">대여 상태</td>
                        <td>
                            <p id="rent" class="row_text"><% out.print( bicycle.getStation()==null ? "대여 중 " : "대여 가능"); %></p>
                        </td>
                    </tr>
                    <tr>
                        <td class="row_name">처리 이력</td>
                        <td>
                            <p class="processing_history"><% out.print(bicycle.getState()); %></p>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td class="btn_wrap">
                            <button class="table_btn" onclick="history.back();">뒤로</button>
                            <button class="table_btn" onclick="">수정</button>
                            <button class="table_btn" onclick="">삭제</button>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
<jsp:include page="${view_path}/fragment/footer.jsp" />
</body>
</html>
