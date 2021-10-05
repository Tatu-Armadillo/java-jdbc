package crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import connection.FabricaConexao;

public class AlterarPessoa {
    public static void main(String[] args) throws SQLException {
        Scanner in = new Scanner(System.in);
        Connection conexao = FabricaConexao.getConnection();
        String sql = "UPDATE PESSOAS SET NOME = (?) WHERE CODIGO = ?";
        System.out.print("Novo nome: ");
        String nome = in.nextLine();
        System.out.print("Codigo: ");
        int codigo = in.nextInt();
        
        PreparedStatement stmt =  conexao.prepareStatement(sql);
        stmt.setString(1, nome);
        stmt.setInt(2, codigo);
        stmt.execute();

        in.close();
        stmt.close();
        conexao.close();

        System.out.println(sql);
        stmt.close();
        conexao.close();
    }
}
