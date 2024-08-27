package br.com.soc.sistema.action.exame_realizado;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.soc.sistema.business.ExameRealizadoBusiness;
import br.com.soc.sistema.filter.ExameRealizadoFilter;
import br.com.soc.sistema.infra.Action;
import br.com.soc.sistema.infra.OpcoesComboBuscarExamesRealizados;
import br.com.soc.sistema.vo.ExameRealizadoVo;
import br.com.soc.sistema.vo.ExameVo;
import br.com.soc.sistema.vo.FuncionarioVo;

public class ExameRealizadoAction extends Action {
    private List<ExameRealizadoVo> examesRealizados = new ArrayList<>();
    private ExameRealizadoBusiness business = new ExameRealizadoBusiness();
    private ExameRealizadoFilter filtrar = new ExameRealizadoFilter();
    private ExameRealizadoVo exameRealizadoVo = new ExameRealizadoVo();
    private List<FuncionarioVo> funcionarios = new ArrayList<>();
    private List<ExameVo> exames = new ArrayList<>();
    
    public String todos() {
        examesRealizados.addAll(business.trazerTodosOsExamesRealizados());	
        return SUCCESS;
    }
    
    public String filtrar() {
        if(filtrar.isNullOpcoesCombo())
            return REDIRECT;
        
        examesRealizados = business.filtrarExamesRealizados(filtrar);
        
        return SUCCESS;
    }
    
    public String novo() {
        if(exameRealizadoVo.getFuncionarioId() == null || exameRealizadoVo.getExameId() == null || exameRealizadoVo.getData() == null) {
            funcionarios.addAll(business.listarFuncionarios());
            exames.addAll(business.listarExames());
            
            return INPUT;
        }
        
        business.salvarExameRealizado(exameRealizadoVo);
        return REDIRECT;
    }
    
    public String editar() {
		if (exameRealizadoVo.getFuncionarioId() != null && exameRealizadoVo.getExameId() != null && exameRealizadoVo.getData() != null && exameRealizadoVo.getRowid() != null) {
			business.editarExamesRealizados(exameRealizadoVo);
			return REDIRECT;
		}

		if (exameRealizadoVo.getRowid() != null) {
			exameRealizadoVo = business.buscarExameRealizadoPor(exameRealizadoVo.getRowid());
            funcionarios.addAll(business.listarFuncionarios());
            exames.addAll(business.listarExames());
		}
		
		return EDITAR;
    }
    
    public String excluir() {
        business.excluirExamesRealizados(exameRealizadoVo);
        return REDIRECT;
    }
    
    public List<OpcoesComboBuscarExamesRealizados> getListaOpcoesCombo(){
        return Arrays.asList(OpcoesComboBuscarExamesRealizados.values());
    }
    
    public List<ExameRealizadoVo> getExamesRealizados() {
        return examesRealizados;
    }

    public void setExamesRealizados(List<ExameRealizadoVo> examesrealizados) {
        this.examesRealizados = examesrealizados;
    }

    public ExameRealizadoFilter getFiltrar() {
        return filtrar;
    }

    public void setFiltrar(ExameRealizadoFilter filtrar) {
        this.filtrar = filtrar;
    }

    public ExameRealizadoVo getExameRealizadoVo() {
        return exameRealizadoVo;
    }

    public void setExameRealizadoVo(ExameRealizadoVo examerealizadoVo) {
        this.exameRealizadoVo = examerealizadoVo;
    }

    
    public List<FuncionarioVo> getFuncionarios() {
        return funcionarios;
    }

    
    public void setFuncionarios(List<FuncionarioVo> funcionarios) {
        this.funcionarios = funcionarios;
    }

	public List<ExameVo> getExames() {
		return exames;
	}

	public void setExames(List<ExameVo> exames) {
		this.exames = exames;
	}
}
