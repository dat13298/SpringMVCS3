<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit New Book</title>
</head>
<body>
<h1>Edit New Book</h1>
<%--@elvariable id="book" type="vn.aptech.spring.model.book.Book"--%>
<form:form modelAttribute="book" action="/books/update" method="post">
    <form:hidden path="id" />
    <table>
        <tr>
            <td>
                <form:label path="title">Title:</form:label>
            </td>
            <td>
                <form:input path="title" id="title" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="author">Author:</form:label>
            </td>
            <td>
                <form:input path="author" id="author" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="publishedYear">Published Year:</form:label>
            </td>
            <td>
                <form:input path="publishedYear" id="publishedYear" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="copiesAvailable">Published Year:</form:label>
            </td>
            <td>
                <form:input path="copiesAvailable" id="copiesAvailable" />
            </td>
        </tr>
        <tr>
            <td colspan="2" style="align-content: center">
                <input type="submit" value="Add Book"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
