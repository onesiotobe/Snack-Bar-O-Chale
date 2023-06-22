
package entidade;

import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import moduloconexao.Conexao; 

public class Pedido {
    
    private String cliente;
    private String telefone;
    private ArrayList<Prato> prato = new ArrayList<>();

    public Pedido() {
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public ArrayList<Prato> getPrato() {
        return prato;
    }

    public void setPrato(ArrayList<Prato> prato) {
        this.prato = prato;
    }
    
    public float calcularTotal(){
        float totalPagar = 0;
        for (int i = 0; i < prato.size(); i++) {
            totalPagar += prato.get(i).getPreco(); 
        }
        return totalPagar;
    }
    
    public void mostrarFatura(int numPratos, Pizza pizza, Lanche lanche, Salgadinho salgadinho){
        
        System.out.println("--------------------------------------------------------- FATURA ---------------------------------------------------------");
        System.out.println("\n*Cliente: "+getCliente()+"\n*Telefone: "+getTelefone());
        System.out.println("\n*Qtd de pratos: "+numPratos);
        
        for (int i = 0; i < numPratos; i++) {

            if ((getPrato().get(i).getNome()).equals("Pizza")){
                System.out.println("\n*Prato "+(i+1)+": "+pizza.getNome());
                System.out.println("    Cobertura: "+pizza.getCobertura());
                System.out.println("    Molho: "+pizza.getMolho());
                System.out.println("    Recheio: "+pizza.getRecheio());
                System.out.println("    Peso: "+pizza.getPeso());
                System.out.println("    Preco: "+pizza.getPreco());
            }
            else if ((getPrato().get(i).getNome()).equals("Lanche")){
                System.out.println("\n*Prato "+(i+1)+": "+lanche.getNome());
                System.out.println("    Molho: "+lanche.getMolho());
                System.out.println("    Recheio: "+lanche.getRecheio());
                System.out.println("    Pao: "+lanche.getPao());
                System.out.println("    Peso: "+lanche.getPeso()+" Kg");
                System.out.println("    Preco: "+lanche.getPreco()+" AOA");
            }
            else if ((getPrato().get(i).getNome()).equals("Salgadinho")){
                System.out.println("\n*Prato "+(i+1)+": "+salgadinho.getNome());
                System.out.println("    Tipo: "+salgadinho.getTipo());
                System.out.println("    Recheio: "+salgadinho.getRecheio());
                System.out.println("    Massa: "+salgadinho.getMassa());
                System.out.println("    Peso: "+salgadinho.getPeso());
                System.out.println("    Preco: "+salgadinho.getPreco());
            }
        }
    }
    
    public void cadastrarPedido(Pedido pedido){
        String sql = "insert into pedido (cliente, telefone) value (?,?)";
        
        PreparedStatement ps = null;
        try {
            ps = Conexao.conectar().prepareStatement(sql);
            
            ps.setString(1, getCliente());
            ps.setString(2, getTelefone());
            
            ps.execute();
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
}
