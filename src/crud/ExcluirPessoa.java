package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import connection.FabricaConexao;

public class ExcluirPessoa {

    public static void main(String[] args) throws SQLException {
        Scanner entrada = new Scanner(System.in);

        Connection connection = FabricaConexao.getConnection();
        String sql = "DELETE FROM PESSOAS WHERE CODIGO = ?";
        System.out.print("Informe o codigo: ");
        int codigo = entrada.nextInt();

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, codigo);

        if (stmt.executeUpdate() > 0) {
            System.out.println("Pessoa excluida com sucesso");
        } else {
            System.out.println("Ninguem foi excluido");
        }

        connection.close();
        entrada.close();
    }
}
