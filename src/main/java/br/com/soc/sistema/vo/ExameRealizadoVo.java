package br.com.soc.sistema.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExameRealizadoVo {
    private String rowid;
    private String funcionarioId;
    private String exameId;
    private String data;
    
    private String funcionarioNome;
    private String exameNome;
    
    public ExameRealizadoVo() {
    	
    }
    
	public ExameRealizadoVo(String rowid, String funcionarioId, String exameId, String data) {
		this.rowid = rowid;
		this.funcionarioId = funcionarioId;
		this.exameId = exameId;
		this.data = data;
	}
	
	public String paraInputData() {
		try {
    		Date utilDate = new SimpleDateFormat("dd/MM/yyyy").parse(data);
        	String date = new SimpleDateFormat("yyyy-MM-dd").format(utilDate);
        	return date;
    	} catch (Exception ex) {
    		return null;
    	}
	}

	public String getRowid() {
		return rowid;
	}

	public void setRowid(String rowid) {
		this.rowid = rowid;
	}

	public String getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(String funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public String getExameId() {
		return exameId;
	}

	public void setExameId(String exameId) {
		this.exameId = exameId;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ExameRealizadoVo [rowid=" + rowid + ", funcionarioId=" + funcionarioId + ", exameId=" + exameId
				+ ", data=" + data + "]";
	}

	public String getFuncionarioNome() {
		return funcionarioNome;
	}

	public void setFuncionarioNome(String funcionarioNome) {
		this.funcionarioNome = funcionarioNome;
	}

	public String getExameNome() {
		return exameNome;
	}

	public void setExameNome(String exameNome) {
		this.exameNome = exameNome;
	}
}
