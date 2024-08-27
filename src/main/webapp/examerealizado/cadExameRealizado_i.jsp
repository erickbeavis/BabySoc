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
			<s:form action="/novoExamesRealizados.action">

				<div class="card mt-5">
					<div class="card-header">
						<div class="row">
							<div class="col-sm-5">
								<s:url action="todosExamesRealizados" var="todos"/>
								<a href="${todos}" class="btn btn-success" >ExamesRealizados</a>
							</div>
							
							<div class="col-sm">
								<h5 class="card-title">Novo ExamesRealizados</h5>
							</div>
						</div>
					</div>
					
					<div class="card-body">
						
					<div class="row align-items-center">
							<label for="nome" class="col-sm-2 col-form-label text-center">
								Nome do Funcionario:
							</label>	

							<div class="col-sm-5">
								<s:select
									cssClass="form-select"
									id="nome"
									name="exameRealizadoVo.funcionarioId" 
									list="%{funcionarios}" 
									headerKey=""  
									headerValue="" 
									listKey="rowid"
									listValueKey="nome"
									value=""
								/>
							</div>
					</div>
					<div class="row align-items-center mt-3">
							<label for="nome" class="col-sm-2 col-form-label text-center">
								Exame:
							</label>	

							<div class="col-sm-5">
								<s:select
									cssClass="form-select"
									id="nome"
									name="exameRealizadoVo.exameId" 
									list="%{exames}" 
									headerKey=""  
									headerValue="" 
									listKey="rowid"
									listValueKey="nome"
									value=""
								/>
							</div>
					</div>
					
					<div class="row align-items-center mt-3">
							<label for="id" class="col-sm-2 col-form-label text-center">
								Data do exame:
							</label>	

							<div class="col-sm-2">
								<input type="date" class="form-control" id="data" name="exameRealizadoVo.data" />					
							</div>
						</div>
					</div>

					<div class="card-footer">
						<div class="form-row">
							<button class="btn btn-primary col-sm-4 offset-sm-1">Salvar</button>
							<button type="reset" class="btn btn-secondary col-sm-4 offset-sm-2">Limpar Formulario</button>
						</div>
					</div>
				</div>
			</s:form>			
		</div>
		
		<script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
	</body>
</html>