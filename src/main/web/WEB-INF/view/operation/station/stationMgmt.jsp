<%@ page import="persistence.entity.Station" %>
<%@ page import="java.util.List" %><%--
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
    String title = "대여소 관리";
    final int MAX_OF_LIST = 10;
    final int MAX_OF_PAGE = 10;
    List<Station> stations = (List<Station>) request.getAttribute("stations");
    Integer curPage = (Integer) request.getAttribute("curPage");
    Integer endPage = (Integer) request.getAttribute("endPage");
%>

<html>
<head>
    <title><%=title%></title>
    <link rel="stylesheet" href="${resources_path}/css/reset.css">
    <link rel="stylesheet" href="${resources_path}/css/common.css">
    <link rel="stylesheet" href="${resources_path}/css/operation/station/stationMgmt.css">
</head>
<body>
<jsp:include page="${view_path}/fragment/header.jsp" flush="true">
    <jsp:param name="title" value='<%=title%>' />
</jsp:include>
<main>
    <div class="container">
        <div class="cont_box">
            <div class="main_cont">
                <div class="cont_top">
                    <p class="cont_title">대여소 목록</p>
                </div>
                <div class="cont_middle">
                    <div class="station_list">
                        <table>
                            <thead>
                            <tr>
                                <th>번호</th>
                                <th>이름</th>
                                <th>사물 주소</th>
                            </tr>
                            </thead>
                            <tbody>
                            <%
                                Station s = null;
                                String infoAtt;
                                for (int i=0; i<MAX_OF_LIST; i++) {
                                    if (i < stations.size()) {
                                        s = stations.get(i);
                                        infoAtt = "style='cursor:hand' onclick=\"location.href='stationMgmt/info.do?id="+s.getId()+"'\"";
                                    }
                                    else {
                                        infoAtt = "";
                                        s = null;
                                    }
                                    out.print("<tr "+infoAtt+">");
                                    out.print("<td>"+(s==null ? "":s.getId())+"</td>");
                                    out.print("<td>"+(s==null ? "":s.getName())+"</td>");
                                    out.print("<td>"+(s==null ? "":s.getAddress())+"</td>");
                                    out.print("</tr>");
                                }
                            %>
                            </tbody>
                        </table>
                    </div>
                    <div class="page_btn_wrap">
                        <%
                            int remainRange = endPage - curPage + 1;
                            int leftRange = (remainRange<MAX_OF_PAGE/2) ? MAX_OF_PAGE-(remainRange) : MAX_OF_PAGE/2;
                            int pageStart = (curPage<=leftRange) ? 1 : curPage-leftRange;

                            for (int i = pageStart; i<pageStart+MAX_OF_PAGE && i<= endPage; i++) {
                                String pageBtnClass = " class='page_btn "+(curPage.equals(i) ? "cur_page":"")+"'";
                                String pageBtnAtt = " style='cursor:hand' onclick=\"location.href='stationMgmt.do?page="+i+"'\"";
                                out.print("<div"+ pageBtnClass + pageBtnAtt +">");
                                out.print(i);
                                out.print("</div>");
                            }
                        %>
                    </div>
                </div>
                <div class="cont_bottom">
                    <div class="regist_btn" style='cursor:hand' onclick="location.href='stationMgmt/regist.do'">
                        등록
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<jsp:include page="${view_path}/fragment/footer.jsp" />
</body>
</html>
