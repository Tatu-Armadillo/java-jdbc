package connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class FabricaConexao {
    public static Connection getConnection() {
        try {
            Properties prop = getProperties();
            final String stringDeConexao = prop.getProperty("banco.url");
            final String usauario = prop.getProperty("banco.usuario");
            final String senha = prop.getProperty("banco.senha");
            return DriverManager.getConnection(stringDeConexao, usauario, senha);
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Properties getProperties() throws IOException {
        Properties prop = new Properties();
        String caminho = "connection.properties";
        prop.load(FabricaConexao.class.getResourceAsStream(caminho));
        return prop;
    }
}
