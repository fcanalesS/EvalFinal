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
				<form method='POST' action='OwnerController'>
					<label>Rut</label>
					<input class='form-control' name='rut' id='rut' type='text'>
					<br>
					<label>Nombre</label>
					<input class='form-control' name='nombre' id='nombre' type='text'>
					<br>
					<label>Apellido</label>
					<input class='form-control' name='apellido' id='apellido' type='text'>
					<br>
					<label>Direccion</label>
					<input class='form-control' name='direccion' id='direccion' type='text'>
					<br>
					<label>Correo</label>
					<input class='form-control' name='correo' id='correo' type='email'>
					<br>
					<label>Telefono</label>
					<input class='form-control' name='telefono' id='text' type='text'>
					
					<br>
					<button class='btn btn-success iniciarsesion' id='btnIniciarSesion' id='iniciarsesion' type='submit'>Grabar</button>	
				</form>
			</div>
		</div>
	</div>
</body>
</html>