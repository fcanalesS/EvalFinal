<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Pet Smile</title>
</head>
<body>
	<div class='container pt-4'>
		<div class='row'>
			<div class='col-md-6'>
				<form method='POST' action='AgendaController'>
					<label>Dueño</label>
					<select class="form-control rut" id="rut" name="rut">
						<c:forEach var="p" items="${listaOwner}">
							<option value="${p.rut}">${p.nombre} ${p.apellido}</option>
						</c:forEach>
					</select>
					<br>
					<label>Mascota</label>
					<select class="form-control mascota" id="mascota" name="mascota" onchange="$('#nombreMascota').val($('#mascota option:selected').text())">
						<c:forEach var="p" items="${listaMascota}">
							<option value="${p.idMascota}">${p.nombreMascota}</option>
						</c:forEach>
					</select>
					<br>
					<label>Nombre Mascota</label>
					<input class='form-control nombreMascota' name='nombreMascota' id='nombreMascota' type='text'>
					<br>
					<label>Hora</label>
					<input class='form-control hora' name='hora' id='hora' type='text'>
					<br>
					<label>Fecha</label>
					<input class='form-control fecha' name='fecha' id='fecha' type='date'>
										
					<br>
					<button class='btn btn-success iniciarsesion' id='btnIniciarSesion' id='iniciarsesion' type='submit'>Grabar</button>
					<a class='btn btn-success' style="color:white;" onclick="history.back();window.reload();" >Volver</a>	
				</form>
			</div>
		</div>
	</div>
	
	<script
  src="https://code.jquery.com/jquery-1.12.4.min.js"
  integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
  crossorigin="anonymous"></script>
</body>
</html>