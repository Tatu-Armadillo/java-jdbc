package crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.FabricaConexao;

public class AlterarPessoa {
    public static void main(String[] args) throws SQLException {
        Connection conexao = FabricaConexao.getConnection();
        String sql = "UPDATE PESSOAS SET NOME = (?) WHERE CODIGO = ?";
        String nome = "Dedo";
        int codigo = 1;

        PreparedStatement stmt =  conexao.prepareStatement(sql);
        stmt.setString(1, nome);
        stmt.setInt(2, codigo);
        stmt.execute();

        System.out.println(sql);
        stmt.close();
        conexao.close();
    }
}
