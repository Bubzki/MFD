<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <title>Students</title>
    </head>
    <body>
        <h1 class="container mt-3 md-3 text-center display-2">Hello student!</h1>
        <div class="container m-auto ">
            <form method="post" action="StudentAdd">
                <table>
                   <tbody>
                        <tr>
                            <td class="input-group mb-3"><label class="input-group-text" for="name">Name</label>
                            <input class="form-control" id="name" type="text" name="name"></td>
                        </tr>
                        <tr>
                            <td class="input-group mb-3"><label class="input-group-text" for="surname">Surname</label>
                            <input class="form-control" id="surname" type="text" name="surname"></td>
                        </tr>
                        <tr>
                            <td class="input-group mb-3"><label class="input-group-text" for="age">Age</label>
                            <input class="form-control" id="age" type="text" name="age"></td>
                        </tr>
                        <tr>
                            <td class="input-group mb-3"><label class="input-group-text" for="email">Email</label>
                            <input class="form-control" id="email" type="text" name="email"></td>
                        </tr>
                        <tr>
                            <td class="input-group mb-3"><label class="input-group-text" for="group">Group</label>
                            <input class="form-control" id="group" type="text" name="group"></td>
                        </tr>
                        <tr>
                            <td class="input-group mb-3"><label class="input-group-text" for="faculty">Faculty</label>
                            <input class="form-control" id="faculty" type="text" name="faculty"></td>
                        </tr>
                   </tbody>
                </table>
                <input class="btn btn-primary mt-2" type="submit" name="send" value="Submit">
            </form>
        </div>
        <div class="container mt-3">
            <c:if test="${students.size() > 0}">
                <table class="table">
                    <thead class="table-dark">
                    <tr>
                        <th>Name</th>
                        <th>Surname</th>
                        <th>Age</th>
                        <th>Email</th>
                        <th>Group</th>
                        <th>Faculty</th>
                    </tr>
                    </thead>
                    <c:forEach var="student" items="${students}">
                        <tr>
                            <td><c:out value="${student.getName()}"/></td>
                            <td><c:out value="${student.getSurname()}"/></td>
                            <td><c:out value="${student.getAge()}"/></td>
                            <td><c:out value="${student.getEmail()}"/></td>
                            <td><c:out value="${student.getGroup()}"/></td>
                            <td><c:out value="${student.getFaculty()}"/></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </div>
    </body>
</html>
