<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="utf-8">
<title>Cidades</title>
<link rel="icon" href="imagens/Logo.jpg">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="text-center p-3 mb-0 bg-dark bg-gradient text-white" style="height: 100vh; width: 100vw;">
		<br>
		<h1><font color="#FFCC00">Editar Cidade</font></h1>
		<h2><font color="#FFCC00">Nome Cidade</font></h2>
		<form name="frmCidade" action="update">
			<input type="text" name="idcid" class="form-label" style="width: 75px;" readonly
				value="<%out.println(request.getAttribute("idcid"));%>"> 
				<input type="text" name="nomecid" class="form-label" style="width: 320px;"
				value="<%out.println(request.getAttribute("nomecid"));%>">
			<h2><font color="#FFCC00">Irradiações</font></h2>
			<input type="text" name="janeiro" class="form-label" style="width: 100px;"
				value="<%out.println(request.getAttribute("janeiro"));%>"> <input
				type="text" name="fevereiro" class="form-label" style="width: 100px;"
				value="<%out.println(request.getAttribute("fevereiro"));%>">
			<input type="text" name="marco" class="form-label" style="width: 100px;"
				value="<%out.println(request.getAttribute("marco"));%>"> <input
				type="text" name="abril" class="form-label" style="width: 100px;"
				value="<%out.println(request.getAttribute("abril"));%>"> <input
				type="text" name="maio" class="form-label" style="width: 100px;"
				value="<%out.println(request.getAttribute("maio"));%>"> <input
				type="text" name="junho" class="form-label" style="width: 100px;"
				value="<%out.println(request.getAttribute("junho"));%>"> <input
				type="text" name="julho" class="form-label" style="width: 100px;"
				value="<%out.println(request.getAttribute("julho"));%>"> <input
				type="text" name="agosto" class="form-label" style="width: 100px;"
				value="<%out.println(request.getAttribute("agosto"));%>"> <input
				type="text" name="setembro" class="form-label" style="width: 100px;"
				value="<%out.println(request.getAttribute("setembro"));%>">
			<input type="text" name="outubro" class="form-label" style="width: 100px;"
				value="<%out.println(request.getAttribute("outubro"));%>"> <input
				type="text" name="novembro" class="form-label" style="width: 100px;"
				value="<%out.println(request.getAttribute("novembro"));%>">
			<input type="text" name="dezembro" class="form-label" style="width: 100px;"
				value="<%out.println(request.getAttribute("dezembro"));%>">
			<br> <input type="button" value="Salvar" class="btn btn-primary"
				onclick="validarcidades()">
		</form>
		<br> <a href="main" class="btn btn-primary">Voltar</a>
		<script src="validador.js"></script>
	</div>
</body>
</html>