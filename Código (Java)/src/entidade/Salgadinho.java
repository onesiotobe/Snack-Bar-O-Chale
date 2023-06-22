
package entidade;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import moduloconexao.Conexao;

public class Salgadinho extends Prato {
    
    private String massa;
    private String recheio;
    private String tipo;

    public Salgadinho() {
        super();
    }

    public Salgadinho(String massa, String recheio, String tipo) {
        this.massa = massa;
        this.recheio = recheio;
        this.tipo = tipo;
    }

    public String getMassa() {
        return massa;
    }

    public void setMassa(String massa) {
        this.massa = massa;
    }

    public String getRecheio() {
        return recheio;
    }

    public void setRecheio(String recheio) {
        this.recheio = recheio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void cadastrarSalgadinho(Salgadinho salgadinho){

    String sql = "insert into salgadinho (tipo, recheio, massa, peso, preco, fk_PEDIDO_idPedido) value (?,?,?,?,?,1)";
    PreparedStatement ps = null;

    try {
        ps = Conexao.conectar().prepareStatement(sql);

        ps.setString(1, getTipo());
        ps.setString(2, getRecheio());
        ps.setString(3, getMassa());
        ps.setFloat(4, getPeso());
        ps.setFloat(5, getPreco());
        //ps.setInt(6, getPedido());

        ps.execute();
        ps.close();

    } catch (SQLException ex) {
        Logger.getLogger(Salgadinho.class.getName()).log(Level.SEVERE, null, ex);
    }  
}
    
}
