
package moduloconexao;

import java.sql.*; 

public class Conexao {
    
    private static final String url = "jdbc:mysql://localhost:3306/db_scv";
    private static final String user = "root";
    private static final String senha = "";
    
    private static Connection con;
    
    public static Connection conectar(){
        
        try{
            if (con == null) {
                con = DriverManager.getConnection(url, user,senha);
                return con;
            }
            else{
                return con;
            }
        }catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}