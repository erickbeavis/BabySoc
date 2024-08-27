package br.com.soc.sistema.business;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.soc.sistema.dao.examesrealizados.ExameRealizadoDao;
import br.com.soc.sistema.dao.funcionarios.FuncionarioDao;
import br.com.soc.sistema.exception.BusinessException;
import br.com.soc.sistema.filter.FuncionarioFilter;
import br.com.soc.sistema.vo.FuncionarioVo;

public class FuncionarioBusiness {
	private Logger logger = LogManager.getLogger();
	private static final String FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO = "Foi informado um caracter no lugar de um numero";

	private FuncionarioDao dao;
	private ExameRealizadoDao exameRealizadoDao;
	
	public FuncionarioBusiness() {
		this.dao = new FuncionarioDao();
		this.exameRealizadoDao = new ExameRealizadoDao();
	}
	
	public List<FuncionarioVo> trazerTodosOsFuncionarios(){
		return dao.findAllFuncionarios();
	}	
	
	public void salvarFuncionario(FuncionarioVo funcionarioVo) {
		try {
			if(funcionarioVo.getNome().isEmpty())
				throw new IllegalArgumentException("Nome nao pode ser em branco");
			
			dao.insertFuncionario(funcionarioVo);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BusinessException("Nao foi possivel realizar a inclusao do registro");
		}
	}
	
	public void editarFuncionarios(FuncionarioVo funcionarioVo) {
	    try {
			if (funcionarioVo.getRowid() == null || funcionarioVo.getRowid().isEmpty())
				throw new IllegalArgumentException("ID nao pode ser em branco");

			if(funcionarioVo.getNome() == null || funcionarioVo.getNome().isEmpty())
				throw new IllegalArgumentException("Nome nao pode ser em branco");

			dao.editarFuncionario(funcionarioVo);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BusinessException("Nao foi possivel realizar a edição do registro");
		}
	}
	
	public void excluirFuncionarios(FuncionarioVo funcionarioVo) {
       try {
			if (funcionarioVo.getRowid() == null || funcionarioVo.getRowid().isEmpty())
				throw new IllegalArgumentException("ID nao pode ser em branco");

			dao.excluirFuncionarios(funcionarioVo);
			exameRealizadoDao.excluirExamesRealizadoPorFuncionario(funcionarioVo.getRowid());
	   } catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BusinessException("Nao foi possivel realizar a exclusão do registro");
	   }
    }
	
	public List<FuncionarioVo> filtrarFuncionarios(FuncionarioFilter filter){
		List<FuncionarioVo> funcionarios = new ArrayList<>();
		
		switch (filter.getOpcoesCombo()) {
			case ID:
				try {
					Integer codigo = Integer.parseInt(filter.getValorBusca());
					funcionarios.add(dao.findByCodigo(codigo));
				}catch (NumberFormatException e) {
					throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
				}
			break;

			case NOME:
				funcionarios.addAll(dao.findAllByNome(filter.getValorBusca()));
			break;
		}
		
		return funcionarios;
	}
	
	public FuncionarioVo buscarFuncionarioPor(String codigo) {
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
