package br.com.soc.sistema.dao.examesrealizados;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.EventLogger;

import br.com.soc.sistema.dao.Dao;
import br.com.soc.sistema.exception.BusinessException;
import br.com.soc.sistema.vo.ExameRealizadoVo;

public class ExameRealizadoDao extends Dao {
    public void insertExameRealizado(ExameRealizadoVo examerealizadoVo) {
        
        String query = "INSERT INTO exame_realizado (id_exame, id_funcionario, dt_exame_realizado) VALUES (?, ?, ?)";
        try (
            Connection con = getConexao();
            PreparedStatement ps = con.prepareStatement(query)
        ) {
            ps.setLong(1, Long.parseLong(examerealizadoVo.getExameId()));
            ps.setLong(2, Long.parseLong(examerealizadoVo.getFuncionarioId()));
            ps.setDate(3, new Date(transformarStringParaMilisegundos(examerealizadoVo.getData())));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public boolean validarDuplicidade(ExameRealizadoVo examerealizadoVo) throws ParseException {
        StringBuilder query = new StringBuilder("SELECT COUNT(*) as count FROM exame_realizado WHERE id_exame = ? AND id_funcionario = ? AND dt_exame_realizado = ?");
        
        try (Connection con = getConexao();
             PreparedStatement ps = con.prepareStatement(query.toString())) {

            ps.setLong(1, Long.parseLong(examerealizadoVo.getExameId()));
            ps.setLong(2, Long.parseLong(examerealizadoVo.getFuncionarioId()));
            ps.setDate(3, new java.sql.Date(transformarStringParaMilisegundos(examerealizadoVo.getData())));
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next() && rs.getInt("count") > 0) {
                    throw new IllegalStateException("Registro duplicado encontrado para o exame, funcionário e data informados.");
                }
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            throw new BusinessException("Erro ao validar duplicidade", e);
        }

        return false;
    }


    public List<ExameRealizadoVo> findAllExamesRealizados(String dataInicio, String dataFinal) {
        String query = "SELECT er.rowid, er.id_funcionario, er.id_exame, f.nm_funcionario, e.nm_exame, er.dt_exame_realizado FROM exame_realizado er LEFT JOIN funcionario f ON f.rowid = er.id_funcionario LEFT JOIN exame e ON e.rowid = er.id_exame";
        
        if (dataInicio != null && dataFinal != null) {
        	query = query + " WHERE er.dt_exame_realizado BETWEEN ? AND ?";
        }
        
        try (
            Connection con = getConexao();
            PreparedStatement ps = con.prepareStatement(query);
        ) {
            if (dataInicio != null && dataFinal != null) {
                ps.setDate(1, new java.sql.Date(transformarStringParaMilisegundos(dataInicio)));
                ps.setDate(2, new java.sql.Date(transformarStringParaMilisegundos(dataFinal)));
            }
        	
            try (ResultSet rs = ps.executeQuery()) {
            	List<ExameRealizadoVo> examesRealizados = new ArrayList<>();
                while (rs.next()) {
                    ExameRealizadoVo vo = new ExameRealizadoVo();
                    vo.setRowid(rs.getString("rowid"));
                    vo.setFuncionarioId(rs.getString("id_funcionario"));
                    vo.setExameId(rs.getString("id_exame"));
                    vo.setFuncionarioNome(rs.getString("nm_funcionario"));
                    vo.setExameNome(rs.getString("nm_exame"));
                    vo.setData(formatarStringData(rs.getString("dt_exame_realizado")));
                    examesRealizados.add(vo);
                }
                return examesRealizados;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public List<ExameRealizadoVo> findAllByNome(String nome) {
        String query = "SELECT er.rowid, er.id_exame, er.id_funcionario, er.dt_exame_realizado, e.nm_exame, f.nm_funcionario " +
                       "FROM exame_realizado er " +
                       "LEFT JOIN exame e ON e.rowid = er.id_exame " +
                       "LEFT JOIN funcionario f ON f.rowid = er.id_funcionario " +
                       "WHERE f.nm_funcionario LIKE ?";
        try (
            Connection con = getConexao();
            PreparedStatement ps = con.prepareStatement(query)
        ) {
            ps.setString(1, "%" + nome + "%");
            try (ResultSet rs = ps.executeQuery()) {
                List<ExameRealizadoVo> examesRealizados = new ArrayList<>();
                while (rs.next()) {
                    ExameRealizadoVo vo = new ExameRealizadoVo();
                    vo.setRowid(rs.getString("rowid"));
                    vo.setFuncionarioId(rs.getString("id_funcionario"));
                    vo.setExameId(rs.getString("id_exame"));
                    vo.setFuncionarioNome(rs.getString("nm_funcionario"));
                    vo.setExameNome(rs.getString("nm_exame"));
                    vo.setData(formatarStringData(rs.getString("dt_exame_realizado")));
                    examesRealizados.add(vo);
                }
                return examesRealizados;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public ExameRealizadoVo findByCodigo(Integer codigo) {
        String query = "SELECT er.rowid, er.id_exame, er.id_funcionario, er.dt_exame_realizado, e.nm_exame, f.nm_funcionario " +
                       "FROM exame_realizado er " +
                       "LEFT JOIN exame e ON e.rowid = er.id_exame " +
                       "LEFT JOIN funcionario f ON f.rowid = er.id_funcionario " +
                       "WHERE er.rowid = ?";
        try (
            Connection con = getConexao();
            PreparedStatement ps = con.prepareStatement(query)
        ) {
            ps.setInt(1, codigo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ExameRealizadoVo vo = new ExameRealizadoVo();
                    vo.setRowid(rs.getString("rowid"));
                    vo.setFuncionarioId(rs.getString("id_funcionario"));
                    vo.setExameId(rs.getString("id_exame"));
                    vo.setFuncionarioNome(rs.getString("nm_funcionario"));
                    vo.setExameNome(rs.getString("nm_exame"));
                    vo.setData(formatarStringData(rs.getString("dt_exame_realizado")));
                    return vo;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    
    public void editarExameRealizado(ExameRealizadoVo examerealizadoVo) {
        String query = "UPDATE exame_realizado SET id_exame = ?, id_funcionario = ?, dt_exame_realizado = ? WHERE rowid = ?";
        try (
            Connection con = getConexao();
            PreparedStatement ps = con.prepareStatement(query)
        ) {
            ps.setLong(1, Long.parseLong(examerealizadoVo.getExameId()));
            ps.setLong(2, Long.parseLong(examerealizadoVo.getFuncionarioId()));
            ps.setDate(3, new Date(transformarStringParaMilisegundos(examerealizadoVo.getData())));
            ps.setString(4, examerealizadoVo.getRowid());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void excluirExamesRealizadoPorFuncionario(String funcionarioId) {
        String query = "DELETE FROM exame_realizado WHERE id_funcionario = ?";
        try (
            Connection con = getConexao();
            PreparedStatement ps = con.prepareStatement(query)
        ) {
            ps.setString(1, funcionarioId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirExamesRealizados(ExameRealizadoVo examerealizadoVo) {
        String query = "DELETE FROM exame_realizado WHERE rowid = ?";
        try (
            Connection con = getConexao();
            PreparedStatement ps = con.prepareStatement(query)
        ) {
            ps.setString(1, examerealizadoVo.getRowid());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private String formatarStringData(String data) {
    	try {
    		java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(data);
        	String date = new SimpleDateFormat("dd/MM/yyyy").format(utilDate);
        	return date;
    	} catch (Exception ex) {
    		return null;
    	}
    }
    
    private Long transformarStringParaMilisegundos(String data) {
    	try {
    		java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(data);
        	return utilDate.getTime();
    	} catch (Exception ex) {
    		return null;
    	}
    }

}
