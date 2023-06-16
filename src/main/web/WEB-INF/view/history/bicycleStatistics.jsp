<%@ page import="persistence.entity.Bicycle" %>
<%@ page import="java.util.List" %>
<%@ page import="persistence.entity.Rental" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="resources_path" value="${pageContext.request.contextPath}/resources"/>
<c:set var="view_path" value="${pageContext.request.contextPath}/../WEB-INF/view"/>
<%
    request.setCharacterEncoding("UTF-8");
    String title = "자전거별 운영 통계";

    List<Bicycle> bicycles = (List<Bicycle>) request.getAttribute("bicycles");
    List<Rental> rentals = (List<Rental>) request.getAttribute("rentals");
    String id = request.getParameter("id");
    String state = request.getParameter("state");
%>

<html>
<head>
    <title><%=title%></title>
    <link rel="stylesheet" href="${resources_path}/css/reset.css">
    <link rel="stylesheet" href="${resources_path}/css/common.css">
    <link rel="stylesheet" href="${resources_path}/css/history/bicycleStatistics.css">

    <script defer type="text/javascript" src="${resources_path}/js/history/bicycleStatistics.js"></script>
</head>
<body>
<jsp:include page="${view_path}/fragment/header.jsp" flush="true">
    <jsp:param name="title" value='<%=title%>' />
</jsp:include>
<main>
    <div class="container">
        <form class="cont_box" onsubmit="return validateForm()">
            <div class="inquiry_bar">
                <input type="search" class="input_bicycleId" name="id" placeholder="자전거 일련번호">
                <span class="bicycle_state">자전거 상태</span>
                <select class="select_bicycleState" name="state">
                    <option class="inquiry_option">전체</option>
                    <option class="inquiry_option" value="대여 가능">대여 가능</option>
                    <option class="inquiry_option" value="대여 중">대여 중</option>
                    <option class="inquiry_option" value="고장">고장</option>
                </select>
            </div>
            <table>
                <thead>
                <tr>
                    <th>일련번호</th>
                    <th>자전거 상태</th>
                    <th>운행거리</th>
                </tr>
                </thead>
                <tbody>
                    <%
                        Bicycle b = null;
                        Rental r = null;
                        double totalDistance = 0;

                        for (int i=0; i < bicycles.size(); i++) {
                            b = bicycles.get(i);
                            if ((id == null || b.getId().toString().equals(id)) && (state == null || b.getState().toString().equals(state))){
                                out.print("<tr>");
                                out.print("<td>"+ b.getId() +"</td>");
                                out.print("<td>"+ b.getState() +"</td>");

                                // distance 매핑
                                for (int j = 0; j < rentals.size(); j++){
                                    r = rentals.get(j);
                                    if (b.getId() == r.getBicycle().getId()) {
                                        totalDistance += (r.getDistance() != null) ? r.getDistance():0;
                                    }
                                }
                                out.print("<td>"+ totalDistance +" km</td>");
                                out.print("</tr>");
                                totalDistance = 0;
                            }
                        }
                    %>
                </tbody>
            </table>
            <%-- 조회 버튼 --%>
            <div class="btnBox">
                <input class="inquiry_Btn" type="submit" value="조회">
            </div>
        </form>
    </div>
</main>
<jsp:include page="${view_path}/fragment/footer.jsp" />
</body>
</html>