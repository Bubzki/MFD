<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  <title>Statistic</title>
</head>
<body>
  <h1 class="container mt-3 md-3 text-center display-2">Statistic</h1>
  <div class="container m-auto ">
    <table class="table table-hover">
      <tbody>
        <tr>
          <td class="table-dark col-sm-3">Youngest student:</td>
          <td>${stat.getYoungestStudent()}</td>
        </tr>
        <tr>
          <td class="table-dark col-sm-3">Oldest student:</td>
          <td>${stat.getOldestStudent()}</td>
        </tr>
        <tr>
          <td class="table-dark col-sm-3">Average Age:</td>
          <td>${stat.getAverageAge()}</td>
        </tr>
        <tr>
          <td class="table-dark col-sm-3">Most popular domain for email:</td>
          <td>${stat.getPopularDomain()}</td>
        </tr>
        <tr>
          <td class="table-dark col-sm-3">Students with the "sumdu" email domain:</td>
          <td>${stat.getSumduDomain()}</td>
        </tr>
        <tr>
          <td class="table-dark col-sm-3">Number of groups:</td>
          <td>${stat.getGroups()}</td>
        </tr>
      </tbody>
    </table>
  </div>
  <div class="container m-auto ">
    <span class="md-2"><b>Number of students from each named faculty</b></span>
    <table class="table table-hover">
      <tbody>
      <c:forEach var="faculty" items="${stat.getFaculties().entrySet()}">
        <tr>
          <td class="table-dark col-sm-3">${faculty.getKey()}</td>
          <td>${faculty.getValue()}</td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</body>
</html>
