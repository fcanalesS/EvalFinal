
<%@ taglib uri="jakarta.tags.core" prefix="c" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Pet Smile</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">PetSmile</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="DashboardController?opcion=ingresarOwner">Ingresar Dueño</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="DashboardController?opcion=ingresarMascota">Ingresar Mascota</a>
        </li>
       <li class="nav-item">
          <a class="nav-link ingresarAgenda" href="DashboardController?opcion=ingresarAgenda">Ingresar Agenda</a>
        </li>
       
      </ul>
    </div>
  </div>
</nav>

<div class='container pt-4'>
		<div class='row'>
			<h3>Listado de Agendas</h3>
			<br>
			<div class='col-md-6'>
				<table class="table">
					<thead>
						<tr>
							<th>Rut Dueño</th>
							<th>Nombre de Mascota</th>
							<th>Hora</th>
							<th>Fecha</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="p" items="${lista}">
							<tr>
								<td><c:out value="${p.rutOwner}"></c:out></td>
								<td><c:out value="${p.nombreMascota}"></c:out></td>
								<td><c:out value="${p.hora}"></c:out></td>
								<td><c:out value="${p.fecha}"></c:out></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>