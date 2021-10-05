package crud;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.FabricaConexao;

public class ConsultarPessoas {

    public static void main(String[] args) throws SQLException {
        Connection conexao = FabricaConexao.getConnection();
        String sql = "SELECT * FROM PESSOAS";

        Statement stmt = conexao.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);

        List<Pessoa> pessoas = new ArrayList<>();

        while (resultado.next()) {
            int codigo = resultado.getInt("codigo");
            String nome = resultado.getString("nome");
            pessoas.add(new Pessoa(codigo, nome));
        }

        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.getCodigo() + " ==> " + pessoa.getNome());
        }

        stmt.close();
        conexao.close();
    }
}
