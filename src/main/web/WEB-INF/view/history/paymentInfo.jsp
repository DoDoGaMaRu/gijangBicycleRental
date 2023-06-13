<%@ page import="persistence.entity.Payment" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="resources_path" value="${pageContext.request.contextPath}/resources"/>
<c:set var="view_path" value="${pageContext.request.contextPath}/../WEB-INF/view"/>
<%
    request.setCharacterEncoding("UTF-8");
    String title = "결제 내역 조회";

    List<Payment> payments = (List<Payment>) request.getAttribute("payments");
%>

<html>
<head>
    <title><%=title%></title>
    <link rel="stylesheet" href="${resources_path}/css/reset.css">
    <link rel="stylesheet" href="${resources_path}/css/common.css">
    <link rel="stylesheet" href="${resources_path}/css/history/paymentInfo.css">
</head>
<body>
<jsp:include page="${view_path}/fragment/header.jsp" flush="true">
    <jsp:param name="title" value='<%=title%>' />
</jsp:include>
<main>
    <div class="container">
        <form class="cont_box">
            <div class="inquiry_bar">
                <label>기간 <input type="date" class="date_range" name="from" required> ~ <input type="date" class="date_range" name="to" required></label>
                <input class="input_serial" type="text" name="serial" required>
                <span class="serial" style="margin-right: 50px">회원 시리얼</span>
            </div>
            <table>
                <thead>
                <tr>
                    <th>결제 일련번호</th>
                    <th>결제 일시</th>
                    <th>결제 종류</th>
                    <th>결제 금액</th>
                </tr>
                </thead>
                <tbody>
                <%
                    if (payments.size() != 0){
                        Payment p = null;
                        for (int i=0; i < payments.size(); i++) {
                            p = payments.get(i);

                            out.print("<tr>");
                            out.print("<td>"+(p==null ? "null":p.getId())+"</td>");
                            out.print("<td>"+(p==null ? "null":p.getRegdate())+"</td>");
                            out.print("<td>"+(p==null ? "null":p.getPaymentMethod())+"</td>");
                            out.print("<td>"+(p==null ? "null":p.getAmount())+"원</td>");
                            out.print("</tr>");
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