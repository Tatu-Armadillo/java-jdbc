package dao;

public class TesteDAO {
    
    public static void main(String[] args) {
        DAO dao = new DAO();
        String sql = "INSERT INTO PESSOAS (NOME) VALUES (?)";
        System.out.println(dao.incluir(sql, "Angela Alves"));

        dao.close();
        System.out.println("Dados adicionados");
    }
}
