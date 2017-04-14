<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order List</title>
 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
 
</head>
<body>
 
   <jsp:include page="_header.jsp" />
   <jsp:include page="_menu.jsp" />
 
  <%--  <fmt:setLocale value="en_US" scope="session"/> --%>
  
   <div class="page-title">Order List</div>
 
   <%-- <div>Total Order Count: ${paginationResult.totalRecords}</div> --%>
  
   <table border="1" style="width:100%">
       <tr>
           <th>Order Num</th>
           <th>Order Name</th>
           <th>Order Price</th>
           <th>Order Date</th>
           <th>Order Quantity</th>
           <th>Amount</th>
       </tr>
       <c:forEach items="${list}" var="order">
           <tr>
               <td>${order.orderNum}</td>
               <td>${order.product.name}</td>
               <td> <fmt:formatNumber value="${order.product.price}" type="currency"/></td>
               <td>
                  <fmt:formatDate value="${order.orderDate}" pattern="dd-MM-yyyy HH:mm"/>
               </td>
               <td>${order.quantity}</td>
              
               <td style="color:red;">
                  <fmt:formatNumber value="${order.amount}" type="currency"/>
               </td>
           </tr>
       </c:forEach>
   </table>
  <%--  <c:if test="${paginationResult.totalPages > 1}">
       <div class="page-navigator">
          <c:forEach items="${paginationResult.navigationPages}" var = "page">
              <c:if test="${page != -1 }">
                <a href="orderList?page=${page}" class="nav-item">${page}</a>
              </c:if>
              <c:if test="${page == -1 }">
                <span class="nav-item"> ... </span>
              </c:if>
          </c:forEach>
          
       </div>
   </c:if> --%>
 
 
 
 
   <jsp:include page="_footer.jsp" />
 
</body>
</html>