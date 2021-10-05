package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
    public static Connection getConnection() throws SQLException {
        try {
            final String stringDeConexao = "jdbc:mysql://localhost:3306/teste?verfyServerCertificate=false&userSSL=true";
            final String usauario = "root";
            final String senha = "root";
            return DriverManager.getConnection(stringDeConexao, usauario, senha);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
