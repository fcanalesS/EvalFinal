<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>PetSmile - Inicio</title>
</head>
<body>
<div class='container pt-4'>
		<div class='row'>
			<div class='col-md-6'>
				<form method='POST' action='LoginController'>
					<label>Nombre de Usuario</label>
					<input class='form-control username' name='username' id='username' type='text'>
					<br>
					<label>Password</label>
					<input class='form-control password' name='password' id='password' type='password'>
					<br>
					<button class='btn btn-success iniciarsesion' id='btnIniciarSesion' id='iniciarsesion' type='submit'>Iniciar Sesion</button>	
				</form>
			</div>
		</div>
	</div>
</body>
</html>