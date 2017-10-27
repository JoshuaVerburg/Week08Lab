<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Users</title>
        <link rel="stylesheet" href="<c:url value='styles/notes.css' />" />
    </head>
    <body>
        <h1>Manage Note</h1>
        <h2>Note</h2>
        <p>${errorMessage}</p>
        <table>
            <tr>
                <th>ID</th>
                <th>Date</th>
                <th>Contents</th>
                <th>Delete</th>
                <th>Edit</th>
            </tr>
            <c:forEach var="note" items="${notes}">
                <tr>
                    <td>${note.noteid}</td>
                    <td>${note.dateCreated}</td>
                    <td>${note.contents}</td>
                    <td>
                        <form action="users" method="post" >
                            <input type="submit" value="Delete">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="selectedNote" value="${note.noteid}">
                        </form>
                    </td>
                    <td>
                        <form action="users" method="get">
                            <input type="submit" value="Edit">
                            <input type="hidden" name="action" value="view">
                            <input type="hidden" name="selectedNote" value="${note.noteid}">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <c:if test="${selectedNote == null}">
            <h3>Add Note</h3>
            <form action="users" method="POST">
                Contents: <input type="text" name="contents"><br>
                <input type="hidden" name="action" value="add">
                <input type="submit" value="Save">
            </form>
        </c:if>
        <c:if test="${selectedNote != null}">
            <h3>Edit Note</h3>
            <form action="users" method="POST">
                Note ID: <input type="text" name="noteid" value="${selectedNote.noteid}" readonly><br>
                Date Created: <input type="text" name="datecreated" value="${selectedNote.dateCreated}" readonly><br>
                Contents: <input type="text" name="contents" value="${selectedNote.contents}"><br>
                <input type="hidden" name="action" value="edit">
                <input type="submit" value="Save">
            </form>
        </c:if>
    </body>
</html>
