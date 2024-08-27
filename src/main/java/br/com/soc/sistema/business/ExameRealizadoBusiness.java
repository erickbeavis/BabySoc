package br.com.soc.sistema.business;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.soc.sistema.dao.exames.ExameDao;
import br.com.soc.sistema.dao.examesrealizados.ExameRealizadoDao;
import br.com.soc.sistema.dao.funcionarios.FuncionarioDao;
import br.com.soc.sistema.exception.BusinessException;
import br.com.soc.sistema.filter.ExameRealizadoFilter;
import br.com.soc.sistema.vo.ExameRealizadoVo;
import br.com.soc.sistema.vo.ExameVo;
import br.com.soc.sistema.vo.FuncionarioVo;

public class ExameRealizadoBusiness {
    private Logger logger = LogManager.getLogger();
    private static final String FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO = "Foi informado um caracter no lugar de um numero";

    private ExameRealizadoDao exameRealizadoDao;
    private FuncionarioDao funcionarioDao;
    private ExameDao exameDao;

    public ExameRealizadoBusiness() {
        this.exameRealizadoDao = new ExameRealizadoDao();
        this.funcionarioDao = new FuncionarioDao();
        this.exameDao = new ExameDao();
    }

    public List<ExameRealizadoVo> trazerTodosOsExamesRealizados() {
        return exameRealizadoDao.findAllExamesRealizados(null, null);
    }
    
    public List<ExameRealizadoVo> trazerExamesRealizadosPorPeriodo(String dataInicio, String dataFinal) {
        return exameRealizadoDao.findAllExamesRealizados(dataInicio, dataFinal);
    }

    public void salvarExameRealizado(ExameRealizadoVo examerealizadoVo) {
        try {
            if (examerealizadoVo.getFuncionarioId() == null || examerealizadoVo.getFuncionarioId().isEmpty())
                throw new IllegalArgumentException("Funcionario nao pode ser em branco");
            
            if (examerealizadoVo.getExameId() == null || examerealizadoVo.getExameId().isEmpty())
                throw new IllegalArgumentException("Exame nao pode ser em branco");
            
            if (examerealizadoVo.getData() == null || examerealizadoVo.getData().isEmpty())
                throw new IllegalArgumentException("Data nao pode ser em branco");

            exameRealizadoDao.validarDuplicidade(examerealizadoVo);
            exameRealizadoDao.insertExameRealizado(examerealizadoVo);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BusinessException("Nao foi possivel realizar a inclusao do registro");
        }
    }

    public void editarExamesRealizados(ExameRealizadoVo examerealizadoVo) {
        try {
            if (examerealizadoVo.getFuncionarioId() == null || examerealizadoVo.getFuncionarioId().isEmpty())
                throw new IllegalArgumentException("Funcionario nao pode ser em branco");
            
            if (examerealizadoVo.getExameId() == null || examerealizadoVo.getExameId().isEmpty())
                throw new IllegalArgumentException("Exame nao pode ser em branco");
            
            if (examerealizadoVo.getData() == null || examerealizadoVo.getData().isEmpty())
                throw new IllegalArgumentException("Data nao pode ser em branco");
            
            if (examerealizadoVo.getRowid() == null || examerealizadoVo.getRowid().isEmpty())
                throw new IllegalArgumentException("ID nao pode ser em branco");

            exameRealizadoDao.editarExameRealizado(examerealizadoVo);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BusinessException("Nao foi possivel realizar a edição do registro");
        }
    }

    public void excluirExamesRealizados(ExameRealizadoVo examerealizadoVo) {
        try {
            if (examerealizadoVo.getRowid() == null || examerealizadoVo.getRowid().isEmpty())
                throw new IllegalArgumentException("ID nao pode ser em branco");

            exameRealizadoDao.excluirExamesRealizados(examerealizadoVo);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BusinessException("Nao foi possivel realizar a exclusão do registro");
        }
    }

    public List<ExameRealizadoVo> filtrarExamesRealizados(ExameRealizadoFilter filter) {
        List<ExameRealizadoVo> examesrealizados = new ArrayList<>();

        switch (filter.getOpcoesCombo()) {
            case ID:
                try {
                    Integer codigo = Integer.parseInt(filter.getValorBusca());
                    examesrealizados.add(exameRealizadoDao.findByCodigo(codigo));
                } catch (NumberFormatException e) {
                    throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
                }
                break;

            case NOME:
                examesrealizados.addAll(exameRealizadoDao.findAllByNome(filter.getValorBusca()));
                break;
        }

        return examesrealizados;
    }

    public ExameRealizadoVo buscarExameRealizadoPor(String codigo) {
        try {
            Integer cod = Integer.parseInt(codigo);
            return exameRealizadoDao.findByCodigo(cod);
        } catch (NumberFormatException e) {
            logger.error(e.getMessage(), e);
            throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BusinessException("Nao foi possivel realizar a busca do registro");
        }
    }

	public List<FuncionarioVo> listarFuncionarios(){
		return funcionarioDao.findAllFuncionarios();
	}

    public List<ExameVo> listarExames() {
        return exameDao.findAllExames();
    }
}
