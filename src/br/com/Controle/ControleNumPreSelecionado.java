package br.com.Controle;

import br.com.ConexaoBancoDados.ConexaoSql;
import br.com.Modelo.ModeloNumPreSelecionado;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ControleNumPreSelecionado {
    ConexaoSql conexao = new ConexaoSql();

    public void desmarcaNumPre(ModeloNumPreSelecionado numeropre) {
    // Usamos o comando exato que você precisa
    String sql = "DELETE FROM numero_pre_selecionado WHERE numero_pre = ?";

    try {
        conexao.getConexaoSql();
        // Verificação de segurança: a conexão está aberta?
        if (conexao.connection == null || conexao.connection.isClosed()) {
            System.err.println("ERRO: Conexão com o banco está fechada antes do DELETE!");
            return;
        }

        PreparedStatement pst = conexao.connection.prepareStatement(sql);
        pst.setInt(1, numeropre.getNumeroPre());

        int resultado = pst.executeUpdate();

        // LOG CRÍTICO: Se imprimir 0, o número 32 não existe na tabela 'numero_pre_selecionado'
        // ou o nome da coluna no banco não é 'numero_pre'
        //System.out.println(">>> TENTATIVA DE EXCLUSÃO: " + numeropre.getNumeroPre());
        //System.out.println(">>> LINHAS AFETADAS NO BANCO: " + resultado);

        pst.close();

    } catch (SQLException ex) {
        System.err.println("ERRO SQL ao deletar o número " + numeropre.getNumeroPre());
        ex.printStackTrace();
    } finally {
        conexao.FecharConexao();
    }
}
    
    public boolean isStatusOk(int numero) {
        boolean estaOk = false;
        conexao.getConexaoSql();
        try {
            // Consulta sem aspas para campos numéricos
            conexao.executaSql("SELECT status FROM numero_pre_selecionado WHERE numero_pre = " + numero);
            if (conexao.rs.next()) {
                estaOk = "OK".equalsIgnoreCase(conexao.rs.getString("status"));
            }
        } catch (SQLException e) {
            estaOk = false;
        } finally {
            conexao.FecharConexao();
        }
        return estaOk;
    }

    
    // GRAVA OU ATUALIZA A RESERVA (Quando você clica no Checkbox)
    public void marcaNumPre(ModeloNumPreSelecionado numeropre) {
        conexao.getConexaoSql();
        try {
            // Tenta dar Update, se não existir, o usuário pode implementar o Insert
            PreparedStatement pst = conexao.connection.prepareStatement(
                "INSERT INTO numero_pre_selecionado (numero_pre, status) VALUES (?, 'OK') " +
                "ON DUPLICATE KEY UPDATE status = 'OK'"); 
            // Nota: O 'ON DUPLICATE' depende do seu banco (MySQL). Se for outro, use UPDATE comum.
            pst.setInt(1, numeropre.getNumeroPre());
            pst.execute();
        } catch (SQLException ex) {
            System.err.println("Erro ao marcar: " + ex.getMessage());
        } finally {
            conexao.FecharConexao();
        }
    }
}