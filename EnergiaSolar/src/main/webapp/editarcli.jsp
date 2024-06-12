<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="utf-8">
<title>Clientes</title>
<link rel="icon" href="imagens/Logo.jpg">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="text-center p-3 mb-0 bg-dark bg-gradient text-white" style="height: 100vh; width: 100vw;">
		<br>
		<h1><font color="#FFCC00">Editar Cliente</font></h1>
		<form name="frmCliente" action="updatecli">
			<input type="text" name="idcli" class="form-label" style="width: 75px;" readonly value="<%out.println(request.getAttribute("idcli"));%>"> 
			<input type="text" name="cli" class="form-label" style="width: 320px;" value="<%out.println(request.getAttribute("cli"));%>">
			<input type="text" name="empr" class="form-label" style="width: 320px;" value="<%out.println(request.getAttribute("empr"));%>">
			<br>
			<input type="text" name="cpf" class="form-label" style="width: 320px;" value="<%out.println(request.getAttribute("cpf"));%>">
			<input type="text" name="cnpj" class="form-label" style="width: 320px;" value="<%out.println(request.getAttribute("cnpj"));%>">
			<br>
			<input type="text" name="tel1" class="form-label" style="width: 220px;" value="<%out.println(request.getAttribute("tel1"));%>">
			<input type="text" name="tel2" class="form-label" style="width: 220px;" value="<%out.println(request.getAttribute("tel2"));%>">
			<br>
			<input type="button" value="Salvar" class="btn btn-primary" onclick="validarclientes()">
		</form>
		<br> <a href="novocli" class="btn btn-primary">Voltar</a>
		<script src="validador.js"></script>
	</div>
</body>
</html>