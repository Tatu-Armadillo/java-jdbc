package crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import connection.FabricaConexao;

public class NovaPessoa {
    
    public static void main(String[] args) throws SQLException {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Informe o nome: ");
        String nome = entrada.nextLine();

        Connection conexao = FabricaConexao.getConnection();
        String sql = "INSERT INTO PESSOAS (NOME) VALUES (?)";
        PreparedStatement stmt =  conexao.prepareStatement(sql);
        stmt.setString(1, nome);
        stmt.execute();

        System.out.println(sql);
        entrada.close();
        conexao.close();
    }
}
