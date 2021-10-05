package connection;
import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {

    public static void main(String[] args) throws SQLException {
        Connection conexao = FabricaConexao.getConnection(); 
        System.out.println("Conexão Efetuada co Sucesso!");
        conexao.close();
    }
}
