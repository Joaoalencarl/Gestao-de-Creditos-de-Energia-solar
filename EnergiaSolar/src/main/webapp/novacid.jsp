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

<link rel="icon" href="imagens/Logo.jpg">
<link rel="stylesheet" href="style.css">
<meta charset="utf-8">
<title>Cidades</title>
</head>
<body>
	<div class="text-center p-3 mb-0 bg-dark bg-gradient" style="height: auto; width: auto;">
		<br>
		<h1>
			<font color="#FFCC00">Cidades</font>
		</h1>
		<h2>
			<font color="#FFCC00">Inserir Nova Cidade</font>
		</h2>
		<form name="frmCidade" action="insert">
			<input type="text" name="nomecid" placeholder="Nome Cidade"
				class="form-label" style="width: 320px;">
			<h2>
				<font color="#FFCC00">Inserir Irradiações</font>
			</h2>
			<input type="text" name="janeiro" placeholder="Janeiro"
				class="form-label"> <input type="text" name="fevereiro"
				placeholder="Fevereiro" class="form-label"> <input type="text"
				name="marco" placeholder="Março" class="form-label"> <input
				type="text" name="abril" placeholder="Abril" class="form-label">
			<input type="text" name="maio" placeholder="Maio" class="form-label">
			<input type="text" name="junho" placeholder="Junho" class="form-label">
			<input type="text" name="julho" placeholder="Julho" class="form-label">
			<input type="text" name="agosto" placeholder="Agosto" class="form-label">
			<input type="text" name="setembro" placeholder="Setembro"
				class="form-label"> <input type="text" name="outubro"
				placeholder="Outubro" class="form-label"> <input type="text"
				name="novembro" placeholder="Novembro" class="form-label"> <input
				type="text" name="dezembro" placeholder="Dezembro" class="form-label">
			<br> <input type="button" value="Adicionar" class="btn btn-primary"
				onclick="validarcidades()">
		</form>
		<br>
		<form action="select?idcid=<%=request.getParameter("selecionado")%>">
			<select name="selecionado" class="form-select-sm" style="width: 280px;">
				<%
				for (int i = 0; i < listacid.size(); i++) {
				%>
				<option value="<%=listacid.get(i).getIdcid()%>"><%=listacid.get(i).getNomecid()%></option>
				<%
				}
				%>
			</select> <input type="submit" value="Editar" class="btn btn-primary">
		</form>
		<br>
		<form action="delete?idcid=<%=request.getParameter("selecionado2")%>">
			<select name="selecionado2" class="form-select-sm" style="width: 280px;">
				<%for (int i = 0; i < listacid.size(); i++) {%>
					<option value="<%=listacid.get(i).getIdcid()%>"><%=listacid.get(i).getNomecid()%></option>
				<%}%>
			</select> <input type="submit" value="Excluir" class="btn btn-danger"
				onClick="javascript:confirmarcidade(<%=request.getParameter("selecionado2")%>)">
		</form>
		<br>
		<table class="table table-striped table-hover">
			<thead class="table-secondary">
				<tr align="center">
					<th>Id</th>
					<th>Cidade</th>
					<th>Janeiro</th>
					<th>Fevereiro</th>
					<th>Março</th>
					<th>Abril</th>
					<th>Maio</th>
					<th>Junho</th>
					<th>Julho</th>
					<th>Agosto</th>
					<th>Setembro</th>
					<th>Outubro</th>
					<th>Novembro</th>
					<th>Dezembro</th>
					<th>Média</th>
				</tr>
			</thead>
			<tbody class="table-light" style="background-color: #fff;">
				<%
				for (int i = 0; i < listacid.size(); i++) {
				%>
				<tr align="center">
					<td><%=listacid.get(i).getIdcid()%></td>
					<td><%=listacid.get(i).getNomecid()%></td>
					<td><%=listacid.get(i).getJaneiro()%></td>
					<td><%=listacid.get(i).getFevereiro()%></td>
					<td><%=listacid.get(i).getMarco()%></td>
					<td><%=listacid.get(i).getAbril()%></td>
					<td><%=listacid.get(i).getMaio()%></td>
					<td><%=listacid.get(i).getJunho()%></td>
					<td><%=listacid.get(i).getJulho()%></td>
					<td><%=listacid.get(i).getAgosto()%></td>
					<td><%=listacid.get(i).getSetembro()%></td>
					<td><%=listacid.get(i).getOutubro()%></td>
					<td><%=listacid.get(i).getNovembro()%></td>
					<td><%=listacid.get(i).getDezembro()%></td>
					<td><%=listacid.get(i).getMedia()%></td>
				</tr>
				<%}%>
			</tbody>
		</table>
		<br> <a href="prodesp" class="btn btn-primary">Voltar</a>
		<script src="validador.js"></script>
		<script src="confirmador.js"></script>
	</div>
</body>
</html>