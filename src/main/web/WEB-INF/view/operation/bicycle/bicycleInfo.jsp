<%@ page import="persistence.entity.Bicycle" %>
<%@ page import="persistence.entity.Station" %><%--
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
    Station station = bicycle.getStation();
    String[] arr = null;
    if (station != null) {
        arr = station.getCoordinate().split(",");
    }
%>

<html>
<head>
    <title><%=title%></title>
    <link rel="stylesheet" href="${resources_path}/css/reset.css">
    <link rel="stylesheet" href="${resources_path}/css/common.css">
    <link rel="stylesheet" href="${resources_path}/css/operation/bicycle/bicycleInfoTable.css">
    <link rel="stylesheet" href="${resources_path}/css/operation/bicycle/bicycleInfo.css">

    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=35cc06d0fff9be7acbcab450ef07af23"></script>
    <script defer type="text/javascript" src="${resources_path}/js/operation/bicycle/bicycleInfo.js"></script>
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
                        <td rowspan="3">
                            <div id="map" data-lat="<%= (arr != null && arr.length >= 2) ? arr[0] : "" %>" data-lng="<%= (arr != null && arr.length >= 2) ? arr[1] : "" %>"></div>
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
                            <p id="processing_history" class="row_text"><% out.print(bicycle.getState()); %></p>
                        </td>

                    </tr>
                    <tr>

                    </tr>


                </table>
                <div class="cont_bottom">

                    <div class="back_btn" style='cursor:hand' onclick="location.href='../bicycleMgmt.do'">
                        뒤로
                    </div>
                    <div class="udpate_btn" onclick="">수정</div>
                    <div class="delete_btn" onclick="">삭제</div>
                </div>
            </div>
        </div>
    </div>
<jsp:include page="${view_path}/fragment/footer.jsp" />
</body>
</html>
