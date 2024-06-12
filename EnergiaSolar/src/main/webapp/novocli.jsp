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

<link rel="stylesheet" type="text/css" href="//assets.locaweb.com.br/locastyle/edge/stylesheets/locastyle.css">
<script type="text/javascript" src="//assets.locaweb.com.br/locastyle/edge/javascripts/locastyle.js"></script>

<link rel="icon" href="imagens/Logo.jpg">
<link rel="stylesheet" href="style.css">
<meta charset="utf-8">
<title>Clientes</title>
</head>
<body>
	<div class="text-center p-3 mb-0 bg-dark bg-gradient" style="height: 100vh; width: 100vw;">
		<br>
		<h1>
			<font color="#FFCC00">Clientes</font>
		</h1>
		<h2>
			<font color="#FFCC00">Cadastrar Novo Cliente</font>
		</h2>
		<form name="frmCliente" action="insertcliente">
			<input type="text" name="cli" placeholder="Nome Cliente" class="form-label" style="width: 320px;">
			<input type="text" name="empr" placeholder="Nome Empresa" class="form-label" style="width: 320px;">
			<br>
			<input type="text" name="cpf" placeholder="CPF" class="form-label cpf-mask" style="width: 320px;">
			<input type="text" name="cnpj" placeholder="CNPJ" class="form-label" style="width: 320px;">
			<br>
			<input type="text" name="tel1" placeholder="Telefone" class="form-label" style="width: 220px;">
			<input type="text" name="tel2" placeholder="Telefone" class="form-label" style="width: 220px;">
			<br> <input type="button" value="Adicionar" class="btn btn-primary" onclick="validarclientes()">
		</form>
		<br>
		<form action="editarcli?idcli=<%=request.getParameter("selecionado")%>">
			<select name="selecionado" class="form-select-sm" style="width: 280px;">
				<%
				for (int i = 0; i < listacli.size(); i++) {
				%>
				<option value="<%=listacli.get(i).getIdcli()%>"><%=listacli.get(i).getNomecli()%></option>
				<%
				}
				%>
			</select> <input type="submit" value="Editar" class="btn btn-primary">
		</form>
		<br>
		<form action="deletecli?idcli=<%=request.getParameter("selecionado2")%>">
			<select name="selecionado2" class="form-select-sm" style="width: 280px;">
				<%for (int i = 0; i < listacli.size(); i++) {%>
					<option value="<%=listacli.get(i).getIdcli()%>"><%=listacli.get(i).getNomecli()%></option>
				<%}%>
			</select> <input type="submit" value="Excluir" class="btn btn-danger"
				onClick="javascript:confirmarcliente(<%=request.getParameter("selecionado2")%>)">
		</form>
		<br>
		<a href="atendIni" class="btn btn-primary">Voltar</a>
		<script src="validador.js"></script>
		<script src="confirmador.js"></script>
	</div>
</body>
</html>