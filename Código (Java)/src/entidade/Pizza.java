
package entidade;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import moduloconexao.Conexao;

public class Pizza extends Prato {
    
    private String molho;
    private String recheio;
    private String cobertura;

    public Pizza() {
        super();
    }

    public String getMolho() {
        return molho;
    }

    public void setMolho(String molho) {
        this.molho = molho;
    }

    public String getRecheio() {
        return recheio;
    }

    public void setRecheio(String recheio) {
        this.recheio = recheio;
    }

    public String getCobertura() {
        return cobertura;
    }

    public void setCobertura(String cobertura) {
        this.cobertura = cobertura;
    }
    
    public void cadastrarPizza(Pizza pizza){
        
        String sql = "insert into pizza (cobertura, recheio, molho, peso, preco, fk_PEDIDO_idPedido) value (?,?,?,?,?,1)";
        PreparedStatement ps = null;
        
        try {
            ps = Conexao.conectar().prepareStatement(sql);
            
            ps.setString(1, getCobertura());
            ps.setString(2, getRecheio());
            ps.setString(3, getMolho());
            ps.setFloat(4, getPeso());
            ps.setFloat(5, getPreco());
            //ps.setInt(6, pizza.getPedido());
            
            ps.execute();
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Pizza.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
}
