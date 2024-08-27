<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title><s:text name="label.titulo.pagina.cadastro"/></title>
		<link rel='stylesheet' href='webjars/bootstrap/5.1.3/css/bootstrap.min.css'>
	</head>
	<body class="bg-secondary">
		<%@include file="../../include/header.jsp" %>	
		<div class="container">
		
				<div class="card mt-5">
					<div class="card-header">
						<div class="row">
							<div class="col-sm">
								<h5 class="card-title">Relatorio Exames Realizados por Periodo</h5>
							</div>
						</div>
					</div>
					
					<div class="card-body">
					</div>
					<div class="row align-items-center mt-1">
							<label for="id" class="col-sm-2 col-form-label text-center">
								Data inicial:
							</label>	
					
							<div class="col-sm-2">
								<input type="date" class="form-control" id="data_inicio" />					
							</div>
							<div class="row align-items-center mt-2">
						</div>
					</div>
					<div class="row align-items-center mt-3">
							<label for="id" class="col-sm-2 col-form-label text-center">
								Data Final:
							</label>	
					
							<div class="col-sm-2">
								<input type="date" class="form-control" id="data_final" />					
							</div>
							<div class="row align-items-center mt-4">
						</div>
					</div>
					

					<div class="card-footer">
						<div class="form-row">
							<a class="btn btn-success col-sm-4 offset-sm-1 disabled" id="download_xlsx">Gerar em Excel</a>
							<a class="btn btn-primary col-sm-4 offset-sm-1 disabled" id="tela_html">Gerar em tela</a>
						</div>
					</div>
				</div>
			</div>
		
		<script>
			const dataInicio = document.querySelector("#data_inicio");
			const dataFinal = document.querySelector("#data_final");
			const linkDownload = document.querySelector("#download_xlsx");
			const telaHtml = document.querySelector("#tela_html");
			
			const atualizarDataNoLink = () => {
				const dataInicioValor = dataInicio.value;
				const dataFinalValor = dataFinal.value;
				
				linkDownload.href = "/avaliacao/downloadRelatorio.action?relatorioVo.dataInicio=" + dataInicioValor + "&relatorioVo.dataFinal=" + dataFinalValor;
				telaHtml.href = "/avaliacao/visualizarRelatorio.action?relatorioVo.dataInicio=" + dataInicioValor + "&relatorioVo.dataFinal=" + dataFinalValor;
				
				if (dataInicioValor && dataFinalValor) {
					linkDownload.classList.remove("disabled");
					telaHtml.classList.remove("disabled");
				} else {
					linkDownload.classList.add("disabled");
					telaHtml.classList.add("disabled");
				}
			}
			
			dataFinal.addEventListener("change", atualizarDataNoLink);
			dataInicio.addEventListener("change", atualizarDataNoLink);
		</script>
		<script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
	</body>
</html>