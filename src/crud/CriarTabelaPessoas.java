package crud;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import connection.FabricaConexao;

public class CriarTabelaPessoas {
    public static void main(String[] args) throws SQLException {
        Connection conexao = FabricaConexao.getConnection();
        
        String sql = "CREATE TABLE PESSOAS ("
         + "CODIGO INT AUTO_INCREMENT PRIMARY KEY,"   
         + "NOME VARCHAR(80) NOT NULL"
         +")";
        Statement stmt = conexao.createStatement();
        stmt.execute(sql);

        System.out.println("Tabela Criada com sucesso!");
        conexao.close();

        
    }
}
