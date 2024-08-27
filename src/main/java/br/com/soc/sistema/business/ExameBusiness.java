package br.com.soc.sistema.business;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.soc.sistema.dao.exames.ExameDao;
import br.com.soc.sistema.exception.BusinessException;
import br.com.soc.sistema.filter.ExameFilter;
import br.com.soc.sistema.vo.ExameVo;

public class ExameBusiness {
	private Logger logger = LogManager.getLogger();
	private static final String FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO = "Foi informado um caracter no lugar de um numero";

	private ExameDao dao;
	
	public ExameBusiness() {
		this.dao = new ExameDao();
	}
	
	public List<ExameVo> trazerTodosOsExames(){
		return dao.findAllExames();
	}	
	
	public void salvarExame(ExameVo exameVo) {
		try {
			if(exameVo.getNome().isEmpty())
				throw new IllegalArgumentException("Nome nao pode ser em branco");
			
			dao.insertExame(exameVo);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BusinessException("Nao foi possivel realizar a inclusao do registro");
		}
		
	}
	
	public void editarExames(ExameVo exameVo) {
	    try {
			if (exameVo.getRowid() == null || exameVo.getRowid().isEmpty())
				throw new IllegalArgumentException("ID nao pode ser em branco");

			if(exameVo.getNome() == null || exameVo.getNome().isEmpty())
				throw new IllegalArgumentException("Nome nao pode ser em branco");

			dao.editarExame(exameVo);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BusinessException("Nao foi possivel realizar a edição do registro");
		}
	}
	
	public void excluirExames(ExameVo exameVo) {
       try {
			if (exameVo.getRowid() == null || exameVo.getRowid().isEmpty())
				throw new IllegalArgumentException("ID nao pode ser em branco");
			
			 Integer exameId = Integer.parseInt(exameVo.getRowid());
			
			 if (dao.exameAssociado(exameId)) {
		            throw new BusinessException("Exame não pode ser excluído, pois está associado a um ou mais funcionários.");
		        }
			
			dao.excluirExames(exameVo);
	   } catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BusinessException("Nao foi possivel realizar a exclusão do registro");
	   }
    }
	
	public List<ExameVo> filtrarExames(ExameFilter filter){
		List<ExameVo> exames = new ArrayList<>();
		
		switch (filter.getOpcoesCombo()) {
			case ID:
				try {
					Integer codigo = Integer.parseInt(filter.getValorBusca());
					exames.add(dao.findByCodigo(codigo));
				}catch (NumberFormatException e) {
					throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
				}
			break;

			case NOME:
				exames.addAll(dao.findAllByNome(filter.getValorBusca()));
			break;
		}
		
		return exames;
	}
	
	public ExameVo buscarExamePor(String codigo) {
		try {
			Integer cod = Integer.parseInt(codigo);
			return dao.findByCodigo(cod);
		}catch (NumberFormatException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BusinessException("Nao foi possivel realizar a busca do registro");
		} 
	}
}
