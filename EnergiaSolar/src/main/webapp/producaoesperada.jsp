<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>

<%
@SuppressWarnings("unchecked")
ArrayList<JavaBeans> listacid = (ArrayList<JavaBeans>) request.getAttribute("cidades");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="utf-8">
<title>Calculo Produção Esperada</title>
<link rel="icon" href="imagens/Logo.jpg">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="text-center p-3 mb-0 bg-dark bg-gradient text-white" style="height: 100vh; width: 100vw;">
		<br>
		<h1><font color="#FFCC00">Produção Esperada</font></h1>
		<h2><font color="#FFCC00">Dados Cliente</font></h2>
		<form name="frmProd"
			action="calcProdEsp?idcid=<%=request.getParameter("cid")%>">
			<!--  <input type="text" name="nomecliente" placeholder="Nome Cliente/Empresa" class="form-label" style="width: 320px;"><br>-->
			<select name="cid" class="form-select-sm" style="width: 280px;">
				<%
				for (int i = 0; i < listacid.size(); i++) {
				%>
				<option value="<%=listacid.get(i).getIdcid()%>"><%=listacid.get(i).getNomecid()%></option>
				<%
				}
				%>
			</select>
					 
			<input type="text" name="nummod" placeholder="Número de módulos" class="form-label" style="width: 210px;"> 
			<input type="text" name="potmod" placeholder="Potência dos módulos (W)" class="form-label" style="width: 210px;"> 
			<input type="text" name="efi" placeholder="Eficiência (%)" class="form-label" style="width: 210px;">
			<!--  <br><br>
			
			<h2><font color="#FFCC00">Produção (kWh)</font></h2>
			<input type="text" name="prodjan" placeholder="Janeiro" class="form-label">
			<input type="text" name="prodfev" placeholder="Fevereiro" class="form-label">
			<input type="text" name="prodmar" placeholder="Março" class="form-label">
			<input type="text" name="prodabr" placeholder="Abril" class="form-label">
			<input type="text" name="prodmai" placeholder="Maio" class="form-label">
			<input type="text" name="prodjun" placeholder="Junho" class="form-label">
			<input type="text" name="prodjul" placeholder="Julho" class="form-label">
			<input type="text" name="prodago" placeholder="Agosto" class="form-label">
			<input type="text" name="prodset" placeholder="Setembro" class="form-label">
			<input type="text" name="prodout" placeholder="Outubro" class="form-label">
			<input type="text" name="prodnov" placeholder="Novembro" class="form-label">
			<input type="text" name="proddez" placeholder="Dezembro" class="form-label">-->
			
			<input type="button" value="Calcular" class="btn btn-primary" onClick="validarprodesp()">
		</form>

		<br>
		<br> <a href="main" class="btn btn-primary">Nova Cidade</a> <br>
		<br> <a href="index" class="btn btn-primary">Voltar</a>
		<script src="validador.js"></script>
	</div>
</body>
</html>