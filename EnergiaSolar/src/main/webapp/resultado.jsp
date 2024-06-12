<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="utf-8">
<title>Resultado Produção Esperada</title>
<link rel="icon" href="imagens/Logo.jpg">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="text-center p-3 mb-0 bg-dark bg-gradient" style="height: 100vh; width: 100vw;">
		<br>
		<h1><font color="#FFCC00">Resultado Produção Esperada</font></h1>
		<h2><font color="#FFCC00">Irradiação na Cidade Selecionada</font></h2>
		<table class="table table-striped table-hover">
			<thead class="table-secondary">
				<tr align="center">
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
				<tr align="center">
					<td>
						<%
						out.println(request.getAttribute("nomecid"));
						%>
					</td>
					<td>
						<%
						out.println(request.getAttribute("janeiro"));
						%>
					</td>
					<td>
						<%
						out.println(request.getAttribute("fevereiro"));
						%>
					</td>
					<td>
						<%
						out.println(request.getAttribute("marco"));
						%>
					</td>
					<td>
						<%
						out.println(request.getAttribute("abril"));
						%>
					</td>
					<td>
						<%
						out.println(request.getAttribute("maio"));
						%>
					</td>
					<td>
						<%
						out.println(request.getAttribute("junho"));
						%>
					</td>
					<td>
						<%
						out.println(request.getAttribute("julho"));
						%>
					</td>
					<td>
						<%
						out.println(request.getAttribute("agosto"));
						%>
					</td>
					<td>
						<%
						out.println(request.getAttribute("setembro"));
						%>
					</td>
					<td>
						<%
						out.println(request.getAttribute("outubro"));
						%>
					</td>
					<td>
						<%
						out.println(request.getAttribute("novembro"));
						%>
					</td>
					<td>
						<%
						out.println(request.getAttribute("dezembro"));
						%>
					</td>
					<td>
						<%
						out.println(request.getAttribute("media"));
						%>
					</td>
				</tr>
			</tbody>
		</table>
		<br>
		 
		<font color="#FFCC00" size="5">
			<b>
				Número de Módulos: <% out.println(request.getAttribute("nummod"));%> <br>
				Potência dos Módulos: <% out.println(request.getAttribute("potmod"));%>	W <br>
				Potência Instalada:	<% out.println(request.getAttribute("potencia"));%>	kWp <br>
			</b>
		</font>

		<h2><font color="#FFCC00">Produção Esperada</font></h2>
		<table class="table table-striped table-hover">
			<thead class="table-secondary">
				<tr align="center">
					<th>Eficiência</th>
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
					<th>Soma</th>
				</tr>
			</thead>
			<tbody class="table-light" style="background-color: #fff;">
				<tr align="center">
					<td><% out.println(request.getAttribute("efic"));%>%</td>
					<td><% out.println(request.getAttribute("espjan"));%></td>
					<td><% out.println(request.getAttribute("espfev"));%></td>
					<td><% out.println(request.getAttribute("espmar"));%></td>
					<td><% out.println(request.getAttribute("espabr"));%></td>
					<td><% out.println(request.getAttribute("espmai"));%></td>
					<td><% out.println(request.getAttribute("espjun"));%></td>
					<td><% out.println(request.getAttribute("espjul"));%></td>
					<td><% out.println(request.getAttribute("espago"));%></td>
					<td><% out.println(request.getAttribute("espset"));%></td>
					<td><% out.println(request.getAttribute("espout"));%></td>
					<td><% out.println(request.getAttribute("espnov"));%></td>
					<td><% out.println(request.getAttribute("espdez"));%></td>
					<td><% out.println(request.getAttribute("espmedia"));%></td>
					<td><% out.println(request.getAttribute("espsoma"));%></td>
				</tr>
			</tbody>
		</table>

		<br>
		<br> <a href="prodesp" class="btn btn-primary">Voltar</a>
	</div>
</body>
</html>