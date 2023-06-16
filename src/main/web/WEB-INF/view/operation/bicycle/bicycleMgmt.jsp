<%@ page import="persistence.entity.Bicycle" %>
<%@ page import="java.util.List" %><%--
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
    final int MAX_OF_LIST = 10;
    final int MAX_OF_PAGE = 10;
    List<Bicycle> bicycles = (List<Bicycle>) request.getAttribute("bicycles");
    Integer curPage = (Integer) request.getAttribute("curPage");
    Integer endPage = (Integer) request.getAttribute("endPage");
%>

<html>
<head>
    <title><%=title%></title>
    <link rel="stylesheet" href="${resources_path}/css/reset.css">
    <link rel="stylesheet" href="${resources_path}/css/common.css">
    <link rel="stylesheet" href="${resources_path}/css/operation/bicycle/bicycleMgmt.css">
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
                    <p class="cont_title">자전거 목록</p>
                </div>
                <div class="cont_middle">
                    <div class="bicycle_list">
                        <table>
                            <thead>
                            <tr>
                                <th>번호</th>
                                <th>처리 상태</th>
                                <th>위치</th>
                                <th>대여 상태</th>
                            </tr>
                            </thead>
                            <tbody>
                            <%
                                Bicycle b = null;
                                String infoAtt;
                                for (int i=0; i<MAX_OF_LIST; i++) {
                                    if (i < bicycles.size()) {
                                        b = bicycles.get(i);
                                        infoAtt = "style='cursor:hand' onclick=\"location.href='bicycleMgmt/info.do?id="+b.getId()+"'\"";
                                    }
                                    else {
                                        infoAtt = "";
                                        b = null;
                                    }
                                    out.print("<tr "+infoAtt+">");
                                    out.print("<td>"+(b==null ? "":b.getId())+"</td>");
                                    out.print("<td>"+(b==null ? "":b.getState())+"</td>");
                                    out.print("<td>"+(b==null ? "":( b.getStation()==null ? "" : b.getStation().getAddress()))+"</td>");
                                    out.print("<td>"+(b==null ? "":( b.getStation()==null ? "대여 중 " : "대여 가능"))+"</td>");
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
                                String pageBtnAtt = " style='cursor:hand' onclick=\"location.href='bicycleMgmt.do?page="+i+"'\"";
                                out.print("<div"+ pageBtnClass + pageBtnAtt +">");
                                out.print(i);
                                out.print("</div>");
                            }
                        %>
                    </div>
                </div>
                <div class="cont_bottom">
                    <div class="regist_btn" style='cursor:hand' onclick="location.href='bicycleMgmt/regist.do'">
                        등록
                    </div>
                    <div class="back_btn" style='cursor:hand' onclick="window.location.href='/gijangBicycleRental/main.do'">
                        뒤로
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<jsp:include page="${view_path}/fragment/footer.jsp" />
</body>
</html>
