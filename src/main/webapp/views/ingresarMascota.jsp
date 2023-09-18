
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
	<div class='container pt-4'>
		<div class='row'>
			<div class='col-md-6'>
				<form method='POST' action='MascotaController'>
					<label>Dueño</label>
					<select class="form-control" id="rut" name="rut">
						<c:forEach var="p" items="${listaOwner}">
							<option value="${p.rut}">${p.nombre} ${p.apellido}</option>
						</c:forEach>
					</select>
					<br>
					<label>Tipo de Mascota</label>
					<input class='form-control' name='tipoMascota' id='tipoMascota' type='text'>
					<br>
					<label>Edad</label>
					<input class='form-control' name='edad' id='edad' type='text'>
					<br>
					<label>nombreMascota</label>
					<input class='form-control' name='nombreMascota' id='nombreMascota' type='text'>
										
					<br>
					<button class='btn btn-success iniciarsesion' id='btnIniciarSesion' id='iniciarsesion' type='submit'>Grabar</button>
					<a class='btn btn-success' style="color:white;" onclick="history.back();window.reload();" >Volver</a>	
				</form>
			</div>
		</div>
	</div>
</body>
</html>