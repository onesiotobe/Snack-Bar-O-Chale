
package entidade;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import moduloconexao.Conexao;

public class Lanche extends Prato {
    
    private String pao;
    private String recheio;
    private String molho;

    public Lanche() {
        super();
    }

    public String getPao() {
        return pao;
    }

    public void setPao(String pao) {
        this.pao = pao;
    }

    public String getRecheio() {
        return recheio;
    }

    public void setRecheio(String recheio) {
        this.recheio = recheio;
    }

    public String getMolho() {
        return molho;
    }

    public void setMolho(String molho) {
        this.molho = molho;
    }   
        
    public void cadastrarLanche(Lanche lanche){
        
        String sql = "insert into lanche (molho, recheio, pao, peso, preco, fk_PEDIDO_idPedido) value (?,?,?,?,?,1)";
        PreparedStatement ps = null;
        
        try {
            ps = Conexao.conectar().prepareStatement(sql);
            
            ps.setString(1, getMolho());
            ps.setString(2, getRecheio());
            ps.setString(3, getPao());
            ps.setFloat(4, getPeso());
            ps.setFloat(5, getPreco());
            //ps.setInt(6, getPedido());
            
            ps.execute();
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Lanche.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
}
