<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
  <a href="books/add-new">Add New Book</a>
  <table border="solid 1px">
    <caption>Books List</caption>
    <tr>
      <th>ID</th>
      <th>Title</th>
      <th>Author</th>
      <th>Year</th>
      <th>Copies</th>
      <th>Action</th>
    </tr>
    <c:forEach var="b" items="${books.content}">
      <tr>
        <td>${b.id}</td>
        <td>${b.title}</td>
        <td>${b.author}</td>
        <td>${b.publishedYear}</td>
        <td>${b.copiesAvailable}</td>
        <td>
          <a href="<c:url value="/books/editBook/${b.id}"/>" >Edit</a>
        </td>
      </tr>
    </c:forEach>
  </table>
  <c:if test="${totalPages > 1}">
    <div>
      <c:if test="${currentPage > 0}">
        <a href="<c:url value="/books?page=${currentPage - 1}&size=5"/>">Prev</a>
      </c:if>
      <c:forEach var="i" begin="0" end="${totalPages -1}">
        <a href="<c:url value="/books?page=${i}&size=5"/>">${i + 1}</a>
      </c:forEach>
      <c:if test="${currentPage < totalPages -1}">
        <a href="<c:url value="/books?page=${currentPage + 1}&size=5"/>">Next</a>
      </c:if>
    </div>
  </c:if>
</body>
</html>
