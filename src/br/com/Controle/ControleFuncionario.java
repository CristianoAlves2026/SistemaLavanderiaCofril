/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Controle;

import br.com.ConexaoBancoDados.ConexaoSql;
import br.com.Modelo.ModeloFuncionario;
import br.com.Modelo.ModeloOcorrencia;
import java.sql.*;
import javax.swing.JOptionPane;

public class ControleFuncionario {

    ConexaoSql conexao = new ConexaoSql();
    public static final int MYSQL_DUPLICATE_PK = 1062;
    String informacao;

    public void salvar(ModeloFuncionario modelo) {
        conexao.getConexaoSql();

        try {

            PreparedStatement pst = conexao.connection.prepareStatement("insert into funcionarios (fun_cod, fun_num, fun_nome, fun_sexo, fun_emp_cod, fun_dep_cod, fun_tam_cod, fun_obs, fun_qtd_mudas, fun_data_cadastro, fun_admissao, fun_car_cod, fun_telefone, fun_cpf, fun_apelido, fun_status, fun_nascimento) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, modelo.getFuncod());
            pst.setInt(2, modelo.getFunnum());
            pst.setString(3, modelo.getFunnome());
            pst.setString(4, modelo.getFunsexo());
            pst.setInt(5, modelo.getFunempcod());
            pst.setInt(6, modelo.getFundepcod());
            pst.setInt(7, modelo.getFuntamcod());
            pst.setString(8, modelo.getFunobs());
            pst.setInt(9, modelo.getFunqtdmudas());
            pst.setDate(10, new java.sql.Date(modelo.getFundatacadastro().getTime()));
            pst.setDate(11, new java.sql.Date(modelo.getFunadmissao().getTime()));
            pst.setInt(12, modelo.getFuncarcod());
            pst.setString(13, modelo.getFuntelefone());
            pst.setString(14, modelo.getFuncpf());
            pst.setString(15, modelo.getFunapelido());
            pst.setString(16, modelo.getFunstatus());
            pst.setDate(17, new java.sql.Date(modelo.getNascimento().getTime()));
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados cadastrados com sucesso!");

        } catch (SQLException ex) {

            if (ex.getErrorCode() == MYSQL_DUPLICATE_PK) {
                JOptionPane.showMessageDialog(null, "Número do funcionário já Cadastrado. \n \n" + ex);
            } else {
                JOptionPane.showMessageDialog(null, "Erro na gravação dos dados \n \n " + ex);

            }
        }
    }

    public void editar(ModeloFuncionario modeloeditar) {
        conexao.getConexaoSql();

        try {

            PreparedStatement pst = conexao.connection.prepareStatement("update funcionarios set fun_num=?, fun_nome=?, fun_sexo=?, fun_emp_cod=?, fun_dep_cod=?, fun_tam_cod=?, fun_obs=?, fun_qtd_mudas=?, fun_data_cadastro=?, fun_admissao=?, fun_car_cod=?, fun_telefone=?, fun_cpf=?, fun_apelido=?, fun_status=?, fun_nascimento=? where fun_cod=?");
            pst.setInt(1, modeloeditar.getFunnum());
            pst.setString(2, modeloeditar.getFunnome());
            pst.setString(3, modeloeditar.getFunsexo());
            pst.setInt(4, modeloeditar.getFunempcod());
            pst.setInt(5, modeloeditar.getFundepcod());
            pst.setInt(6, modeloeditar.getFuntamcod());
            pst.setString(7, modeloeditar.getFunobs());
            pst.setInt(8, modeloeditar.getFunqtdmudas());
            pst.setDate(9, new java.sql.Date(modeloeditar.getFundatacadastro().getTime()));
            pst.setDate(10, new java.sql.Date(modeloeditar.getFunadmissao().getTime()));
            //pst.setDate(11, new java.sql.Date(modeloeditar.getFundemissao().getTime()));
            pst.setInt(11, modeloeditar.getFuncarcod());
            pst.setString(12, modeloeditar.getFuntelefone());
            pst.setString(13, modeloeditar.getFuncpf());
            pst.setString(14, modeloeditar.getFunapelido());
            pst.setString(15, modeloeditar.getFunstatus());
            pst.setDate(16, new java.sql.Date(modeloeditar.getNascimento().getTime()));
            pst.setInt(17, modeloeditar.getFuncod());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados alterados com sucessos. \n \n");
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro na alteração do dados. \n \n" + ex);
        }

        conexao.FecharConexao();

    }

    public void excluir(ModeloFuncionario modeloexcluir) {
        conexao.getConexaoSql();
        try {

            PreparedStatement pst = conexao.connection.prepareStatement("delete from funcionarios where fun_cod=?");
            pst.setInt(1, modeloexcluir.getFuncod());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso. \n \n ");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir dados. \n \n " + ex);
        }

        conexao.FecharConexao();
    }

    public ModeloFuncionario buscaFuncionario(ModeloFuncionario objmodfunc) {
        conexao.getConexaoSql();

        conexao.executaSql("select f.fun_cod, f.fun_num, f.fun_nome, f.fun_apelido, e.emp_razao, c.car_descricao, d.dep_descricao from funcionarios as f inner join empresas as e on f.fun_emp_cod = e.emp_cod inner join cargos as c on f.fun_car_cod = c.car_cod inner join departamentos as d on f.fun_dep_cod = dep_cod where fun_nome like '%" + objmodfunc.getPesquisa() + "%';");
        try {
            conexao.rs.first();
            objmodfunc.setFuncod(conexao.rs.getInt("fun_cod"));
            objmodfunc.setFunnum(conexao.rs.getInt("fun_num"));
            objmodfunc.setFunnome(conexao.rs.getString("fun_nome"));
            objmodfunc.setFunapelido(conexao.rs.getString("fun_apelido"));
            objmodfunc.setDescricao_empresa(conexao.rs.getString("emp_razao"));
            objmodfunc.setDescricao_cargo(conexao.rs.getString("car_descricao"));
            objmodfunc.setDescricao_departamento(conexao.rs.getString("dep_descricao"));

        } catch (SQLException e) {
            objmodfunc.setFuncod(-1);
            JOptionPane.showMessageDialog(null, "Funcionário não encontrado \n \n");
        }

        conexao.FecharConexao();
        return objmodfunc;
    }

    public ModeloFuncionario buscaCodigoFuncionario(ModeloFuncionario objmodfunc) {
        conexao.getConexaoSql();

        conexao.executaSql("select f.fun_cod, f.fun_num, f.fun_nome, f.fun_apelido, f.fun_admissao, f.fun_nascimento, e.emp_razao, c.car_descricao, d.dep_descricao from funcionarios as f inner join empresas as e on f.fun_emp_cod = e.emp_cod inner join cargos as c on f.fun_car_cod = c.car_cod inner join departamentos as d on f.fun_dep_cod = dep_cod where fun_num = '" + objmodfunc.getFunnum() + "';");
        try {
            conexao.rs.first();
            objmodfunc.setFuncod(conexao.rs.getInt("fun_cod"));
            objmodfunc.setFunnum(conexao.rs.getInt("fun_num"));
            objmodfunc.setFunnome(conexao.rs.getString("fun_nome"));
            objmodfunc.setFunapelido(conexao.rs.getString("fun_apelido"));
            objmodfunc.setDescricao_empresa(conexao.rs.getString("emp_razao"));
            objmodfunc.setDescricao_cargo(conexao.rs.getString("car_descricao"));
            objmodfunc.setDescricao_departamento(conexao.rs.getString("dep_descricao"));
            objmodfunc.setFunadmissao(conexao.rs.getDate("f.fun_admissao"));
            objmodfunc.setNascimento(conexao.rs.getDate("f.fun_nascimento"));
            
            
        } catch (SQLException e) {
            objmodfunc.setFuncod(-1);
            JOptionPane.showMessageDialog(null, "Número de funcionário não encontrado \n \n");
        }

        conexao.FecharConexao();
        return objmodfunc;
    }
    
    public ModeloFuncionario buscaCodigoFuncionarioSemErro(ModeloFuncionario objmodfunc) {
        // não da mensagem de erro caso não encontre o codigo. serve para uso evento key pressed do jtextfild
        conexao.getConexaoSql();

        conexao.executaSql("select f.fun_cod, f.fun_num, f.fun_nome, f.fun_apelido, f.fun_admissao, f.fun_nascimento, e.emp_razao, c.car_descricao, d.dep_descricao from funcionarios as f inner join empresas as e on f.fun_emp_cod = e.emp_cod inner join cargos as c on f.fun_car_cod = c.car_cod inner join departamentos as d on f.fun_dep_cod = dep_cod where fun_num = '" + objmodfunc.getFunnum() + "';");
        try {
            conexao.rs.first();
            objmodfunc.setFuncod(conexao.rs.getInt("fun_cod"));
            objmodfunc.setFunnum(conexao.rs.getInt("fun_num"));
            objmodfunc.setFunnome(conexao.rs.getString("fun_nome"));
            objmodfunc.setFunapelido(conexao.rs.getString("fun_apelido"));
            objmodfunc.setDescricao_empresa(conexao.rs.getString("emp_razao"));
            objmodfunc.setDescricao_cargo(conexao.rs.getString("car_descricao"));
            objmodfunc.setDescricao_departamento(conexao.rs.getString("dep_descricao"));
            objmodfunc.setFunadmissao(conexao.rs.getDate("f.fun_admissao"));
            objmodfunc.setNascimento(conexao.rs.getDate("f.fun_nascimento"));
            
            
        } catch (SQLException e) {
            objmodfunc.setFuncod(-1);
            //JOptionPane.showMessageDialog(null, "Número de funcionário não encontrado \n \n");
        }

        conexao.FecharConexao();
        return objmodfunc;
    }
     public ModeloFuncionario buscaIDFuncionario(ModeloFuncionario objmodfunc) {
        conexao.getConexaoSql();

        conexao.executaSql("select f.fun_cod, f.fun_num, f.fun_nome, f.fun_apelido, e.emp_razao, c.car_descricao, d.dep_descricao from funcionarios as f inner join empresas as e on f.fun_emp_cod = e.emp_cod inner join cargos as c on f.fun_car_cod = c.car_cod inner join departamentos as d on f.fun_dep_cod = dep_cod where fun_cod = '" + objmodfunc.getFuncod() + "';");
        try {
            conexao.rs.first();
            objmodfunc.setFuncod(conexao.rs.getInt("fun_cod"));
            objmodfunc.setFunnum(conexao.rs.getInt("fun_num"));
            objmodfunc.setFunnome(conexao.rs.getString("fun_nome"));
            objmodfunc.setFunapelido(conexao.rs.getString("fun_apelido"));
            objmodfunc.setDescricao_empresa(conexao.rs.getString("emp_razao"));
            objmodfunc.setDescricao_cargo(conexao.rs.getString("car_descricao"));
            objmodfunc.setDescricao_departamento(conexao.rs.getString("dep_descricao"));

        } catch (SQLException e) {
            objmodfunc.setFuncod(-1);
            JOptionPane.showMessageDialog(null, "Número de funcionário não encontrado \n \n");
        }

        conexao.FecharConexao();
        return objmodfunc;
    }

    public void salvarOcorrencias(ModeloOcorrencia modoco) {
        conexao.getConexaoSql();

        try {

            PreparedStatement pst = conexao.connection.prepareStatement("insert into ocorrencias (oco_num, oco_data, oco_descricao, oco_acao, id_func) values (?,?,?,?,?)");
            pst.setInt(1, modoco.getNumero());
            pst.setDate(2, new java.sql.Date(modoco.getData().getTime()));
            pst.setString(3, modoco.getDescricao());
            pst.setString(4, modoco.getAcao());
            pst.setInt(5, modoco.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Ocorrência cadastrada com sucesso!");

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro na gravação da ocorrência \n \n " + ex);

        }
    }

    public void excluirOcorrencia(ModeloOcorrencia modoco) {
        conexao.getConexaoSql();
        try {

            PreparedStatement pst = conexao.connection.prepareStatement("delete from ocorrencias where oco_cod=?");
            pst.setInt(1, modoco.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Ocorrência excluida com sucesso. \n \n ");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir ocorrência. \n \n " + ex);
        }

        conexao.FecharConexao();
    }

    public void editaAcao(ModeloOcorrencia modoco) {
        conexao.getConexaoSql();

        try {

            PreparedStatement pst = conexao.connection.prepareStatement("update ocorrencias set oco_acao=? where oco_cod=?");
            pst.setString(1, modoco.getAcao());
            pst.setInt(2, modoco.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Ação modificada com sucesso. \n \n");
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Erro ao modificar ação. \n \n" + ex);
        }

        conexao.FecharConexao();
    }

}
