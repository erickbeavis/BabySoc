<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title><s:text name="Exames Realizados"/></title>
		<link rel='stylesheet' href='webjars/bootstrap/5.1.3/css/bootstrap.min.css'>
	</head>
	<body class="bg-secondary">	
		<%@include file="../../include/header.jsp" %>
		<div class="container mt-4">
			<div class="row">
				<table class="table table-light table-striped align-middle">
					<thead>
						<tr>
							<th style="background-color: blue; color: white; font-weight: bold">CD_FUNCIONARIO</th>
							<th style="background-color: blue; color: white; font-weight: bold">NM_FUNCIONARIO</th>
							<th style="background-color: blue; color: white; font-weight: bold">CD_EXAME</th>
							<th style="background-color: blue; color: white; font-weight: bold">NM_EXAME</th>
							<th style="background-color: blue; color: white; font-weight: bold">DT_EXAME_REALIZADO</th>
						</tr>
					</thead>
					
					<tbody>
						<s:iterator value="examesRealizados">
							<tr>
								<td>${funcionarioId}</td>
								<td>${funcionarioNome}</td>
								<td>${exameId}</td>
								<td>${exameNome}</td>
								<td>${data}</td>
							</tr>
						</s:iterator>
					</tbody>
					
					<tfoot class="table-secondary">
						<tr>
							<td colspan="5">
								<a id="download-excel" class="btn btn-success">EXPORTAR</a>
							</td>
						</tr>
					</tfoot>				
				</table>
			</div>

			<div class="row">
			
			</div>
		</div>

	<script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
	<script>
		const downloadExcel = document.querySelector("#download-excel");
		const url = new URL(window.location.href);
		url.pathname = "avaliacao/downloadRelatorio.action";
		
		downloadExcel.href = url.toString();
	</script>
	</body>
</html>