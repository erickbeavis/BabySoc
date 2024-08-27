package br.com.soc.sistema.action.relatorio;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import br.com.soc.sistema.business.RelatorioBusiness;
import br.com.soc.sistema.infra.Action;
import br.com.soc.sistema.vo.ExameRealizadoVo;
import br.com.soc.sistema.vo.RelatorioVo;

public class RelatorioAction extends Action {
	private RelatorioVo relatorioVo = new RelatorioVo();
	private RelatorioBusiness business = new RelatorioBusiness();
	
	private String filename;
	private InputStream inputStream;
	private int contentLength;
	
	private List<ExameRealizadoVo> examesRealizados;
	
	public String download() throws IOException {
		inputStream = business.gerarExcel(relatorioVo.getDataInicio(), relatorioVo.getDataFinal());
		contentLength = inputStream.available();
		
		filename = String.format("relatorio-%s-%s.xlsx", relatorioVo.getDataInicio(), relatorioVo.getDataFinal());
 
        return VIEW_EXCEL;
    }
	
	public String visualizar() {
		if (relatorioVo.getDataInicio() != null && relatorioVo.getDataFinal() != null) {
			examesRealizados = business.obterExamesRealizadosPorPeriodo(relatorioVo.getDataInicio(), relatorioVo.getDataFinal());
			return VIEW_HTML;
		}
		
		return SUCCESS;
	}

	public RelatorioVo getRelatorioVo() {
		return relatorioVo;
	}

	public void setRelatorioVo(RelatorioVo relatorioVo) {
		this.relatorioVo = relatorioVo;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getContentLength() {
		return contentLength;
	}

	public void setContentLength(int contentLength) {
		this.contentLength = contentLength;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public List<ExameRealizadoVo> getExamesRealizados() {
		return examesRealizados;
	}

	public void setExamesRealizados(List<ExameRealizadoVo> examesRealizados) {
		this.examesRealizados = examesRealizados;
	}
}