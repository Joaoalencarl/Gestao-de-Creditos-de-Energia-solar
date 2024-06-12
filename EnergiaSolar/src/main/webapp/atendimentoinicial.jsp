<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.Clientes"%>
<%@ page import="java.util.ArrayList"%>

<%
@SuppressWarnings("unchecked")
ArrayList<Clientes> listacli = (ArrayList<Clientes>) request.getAttribute("clientes");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="utf-8">
<title>Atendimento</title>
<link rel="icon" href="imagens/Logo.jpg">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="text-center p-3 mb-0 bg-dark bg-gradient text-white" style="height: 100vh; width: 100vw;">
		<br>
		<h1><font color="#FFCC00">Atendimento</font></h1>
		<h2><font color="#FFCC00">Novo Chamado</font></h2>
		<form name="frmChamado" action="">
			<select name="clientes" class="form-select-sm" style="width: 280px;">
				<%
				for (int i = 0; i < listacli.size(); i++) {
				%>
				<option value="<%=listacli.get(i).getIdcli()%>"><%=listacli.get(i).getNomecli()%></option>
				<%
				}
				%>
			</select>			
			<input type="button" value="Novo Chamado" class="btn btn-primary">
		</form>

		<br>
		<br> <a href="novocli" class="btn btn-primary">Novo Cliente</a> <br>
		<br> <a href="index" class="btn btn-primary">Voltar</a>

	</div>
</body>
</html>