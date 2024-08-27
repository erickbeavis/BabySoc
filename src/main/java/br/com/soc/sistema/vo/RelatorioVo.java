package br.com.soc.sistema.vo;

public class RelatorioVo {
	private String dataInicio;
	private String dataFinal;
	
	public RelatorioVo() {}

	public RelatorioVo(String dataInicio, String dataFinal) {
		this.dataInicio = dataInicio;
		this.dataFinal = dataFinal;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}
}
