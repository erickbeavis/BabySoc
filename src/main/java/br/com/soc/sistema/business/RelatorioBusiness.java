package br.com.soc.sistema.business;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import br.com.soc.sistema.vo.ExameRealizadoVo;

public class RelatorioBusiness {
	ExameRealizadoBusiness business = new ExameRealizadoBusiness();
	
	public List<ExameRealizadoVo> obterExamesRealizadosPorPeriodo(String dataInicio, String dataFinal) {
			return business.trazerExamesRealizadosPorPeriodo(dataInicio, dataFinal);
	}
	
	public InputStream gerarExcel(String dataInicio, String dataFinal) {
		List<ExameRealizadoVo> examesRealizados = business.trazerExamesRealizadosPorPeriodo(dataInicio, dataFinal);
		
		Workbook excel = new XSSFWorkbook();
		Sheet planilha = excel.createSheet("Exames Realizados");

		criarCabecalho(excel, planilha);
		
		int linhaIndex = 1;
		for (ExameRealizadoVo exameRealizado : examesRealizados) {
			Row linha = planilha.createRow(linhaIndex);
			
			Cell primeiraColuna = linha.createCell(0);
			primeiraColuna.setCellValue(exameRealizado.getFuncionarioId());
			
			Cell segundaColuna = linha.createCell(1);
			segundaColuna.setCellValue(exameRealizado.getFuncionarioNome());
			
			Cell terceiraColuna = linha.createCell(2);
			terceiraColuna.setCellValue(exameRealizado.getExameId());
			
			Cell quartaColuna = linha.createCell(3);
			quartaColuna.setCellValue(exameRealizado.getExameNome());
			
			Cell quintaColuna = linha.createCell(4);
			quintaColuna.setCellValue(exameRealizado.getData());
			
			
			linhaIndex++;
		}
		
		try {
	        ByteArrayOutputStream planilhaByte = new ByteArrayOutputStream();
	        excel.write(planilhaByte);
	        excel.close();
	        return new ByteArrayInputStream(planilhaByte.toByteArray());
	    } catch (IOException e) {
	        return null;
	    }
	}
	
	private void criarCabecalho(Workbook excel, Sheet planilha) {
		Row cabecalho = planilha.createRow(0);
		CellStyle estiloCabecalho = excel.createCellStyle();
		estiloCabecalho.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
		estiloCabecalho.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		XSSFFont fonte = ((XSSFWorkbook) excel).createFont();
		fonte.setFontName("Arial");
		fonte.setBold(true);
		fonte.setColor(IndexedColors.WHITE.getIndex());
		estiloCabecalho.setFont(fonte);
		
		Cell primeiraColuna = cabecalho.createCell(0);
		planilha.setColumnWidth(0, 20 * 256);
		primeiraColuna.setCellValue("CD_FUNCIONARIO");
		primeiraColuna.setCellStyle(estiloCabecalho);
		
		Cell segundaColuna = cabecalho.createCell(1);
		planilha.setColumnWidth(1, 30 * 256);
		segundaColuna.setCellValue("NM_FUNCIONARIO");
		segundaColuna.setCellStyle(estiloCabecalho);
		
		Cell terceiraColuna = cabecalho.createCell(2);
		planilha.setColumnWidth(2, 20 * 256);
		terceiraColuna.setCellValue("CD_EXAME");
		terceiraColuna.setCellStyle(estiloCabecalho);
		
		Cell quartaColuna = cabecalho.createCell(3);
		planilha.setColumnWidth(3, 30 * 256);
		quartaColuna.setCellValue("NM_EXAME");
		quartaColuna.setCellStyle(estiloCabecalho);
		
		Cell quintaColuna = cabecalho.createCell(4);
		planilha.setColumnWidth(4, 30 * 256);
		quintaColuna.setCellValue("DT_EXAME_REALIZADO");
		quintaColuna.setCellStyle(estiloCabecalho);
	}
}