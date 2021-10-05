package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import connection.FabricaConexao;

public class SelectLike {

    public static void main(String[] args) throws SQLException {
        Scanner in = new Scanner(System.in);
        Connection conexao = FabricaConexao.getConnection();
        String sql = "SELECT * FROM PESSOAS WHERE NOME LIKE ?";
        System.out.print("Filtro: ");
        String pesquisa = in.nextLine();

        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, "%" + pesquisa + "%");
        ResultSet resultado = stmt.executeQuery();

        List<Pessoa> pessoas = new ArrayList<>();
        while (resultado.next()) {
            int codigo = resultado.getInt("codigo");
            String nome = resultado.getString("nome");
            pessoas.add(new Pessoa(codigo, nome));
        }

        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.getCodigo() + " ==> " + pessoa.getNome());
        }

        in.close();
        stmt.close();
        conexao.close();
    }
}
