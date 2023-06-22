
package entidade;

import java.util.*;

public class SistemaControleVendas {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        System.out.println("---------------------------------------------------------- Bem-Vindo  ao Snack Bar 'O CHALE' ----------------------------------------------------------"); 
        
        try {
            
            Pedido pedido = new Pedido();
            
            Prato prato = new Prato();
            
            Pizza pizza = new Pizza();
            Lanche lanche = new Lanche();
            Salgadinho salgadinho = new Salgadinho();
         
            System.out.print("\nInforme o seu nome: ");
            String cliente = ler.next();

            System.out.print("Informe o seu numero de telefone: ");
            String telefone = ler.next();

            pedido.setCliente(cliente);
            pedido.setTelefone(telefone);
            
            pedido.cadastrarPedido(pedido);
                            
            System.out.print("\nQuantos pratos vai querer?: ");
            int numPratos = ler.nextInt();
            
            for (int i = 0; i < numPratos; i++) {

                System.out.println("\nPRATO: "+(i+1));
            
                System.out.println("\n[1]Pizza - 1.000kz/Kg \n[2] Lanche - 500kz/Kg \n[3] Salgadinho - 1000kz/Kg");
                System.out.print("\nO que vai querer?: ");
                int opcaoMenu = ler.nextInt();

                switch (opcaoMenu) {
                    case 1:
                        pizza.setNome("Pizza");
                        // COMPLEMENTOS DO PRATO
                        System.err.println("\n[Coberturas Disponiveis]: Atum, Peperoni");
                        System.out.println("Informe a Cobertura: ");
                        String coberturaP = ler.next();

                        System.err.println("\n[Recheios Disponiveis]: Calabresa, Portuguesa e Marguerita");
                        System.out.println("Informe o Recheio: ");
                        String recheioP = ler.next();

                        System.err.println("\n[Molhos Disponiveis]: Tomate, Mostarda e Pesto");
                        System.out.println("Informe o Molho: ");
                        String molhoP = ler.next();

                        System.out.println("\nInforme o peso(kg) do prato: ");
                        float pesoP = ler.nextFloat();

                        float precoP = pesoP*1000;

                        pizza.setCobertura(coberturaP);
                        pizza.setRecheio(recheioP);
                        pizza.setMolho(molhoP);
                        pizza.setPeso(pesoP);
                        pizza.setPreco(precoP);
                        //pz.setPedido(1);

                        pizza.cadastrarPizza(pizza);

                        // ADICIONAR PIZZA AO PRATO
                        pedido.getPrato().add(pizza);

                        break;
                        
                    case 2:
                        lanche.setNome("Lanche");
                        // COMPLEMENTOS DO PRATO
                        System.err.println("\n[Molhos Disponiveis]: Ketchup e Mayonese");
                        System.out.println("Informe o Molho: ");
                        String molhoL = ler.next();
                        
                        System.err.println("\n[Recheios Disponiveis]: Baycon, Presunto e Fiambre");
                        System.out.println("Informe o Recheio: ");
                        String recheioL = ler.next();
                        
                        System.err.println("\n[Paes Disponiveis]: Frances, Carcaca e Burro");
                        System.out.println("Informe o tipo de Pao: ");
                        String pao = ler.next();

                        System.out.println("\nInforme o peso(kg) do prato: ");
                        float pesoL = ler.nextFloat();

                        float precoL = pesoL*500;
                        
                        lanche.setMolho(molhoL);
                        lanche.setRecheio(recheioL);
                        lanche.setPao(pao); 
                        lanche.setPeso(pesoL);
                        lanche.setPreco(precoL);
                        //pz.setPedido(1);

                        lanche.cadastrarLanche(lanche);

                        // ADICIONAR LANCHE AO PRATO
                        pedido.getPrato().add(lanche);

                        break;
                    
                    case 3:
                        salgadinho.setNome("Salgadinho");
                        // COMPLEMENTOS DO PRATO
                        System.err.println("\n[Tipos Disponiveis]: Frito e Assado");
                        System.out.println("Informe o Tipo: ");
                        String tipo = ler.next();
                        
                        System.err.println("\n[Recheios Disponiveis]: Chourico, Salsicha e Mortadela");
                        System.out.println("Informe o Recheio: ");
                        String recheioS = ler.next();
                        
                        System.err.println("\n[Massas Disponiveis]: Simples");
                        System.out.println("Informe o tipo de Massa: ");
                        String massa = ler.next();

                        System.out.println("\nInforme o peso(kg) do prato: ");
                        float pesoS = ler.nextFloat();

                        float precoS = pesoS*100;
                        
                        salgadinho.setTipo(tipo);
                        salgadinho.setRecheio(recheioS);
                        salgadinho.setMassa(massa); 
                        salgadinho.setPeso(pesoS);
                        salgadinho.setPreco(precoS);
                        //pz.setPedido(1);

                        salgadinho.cadastrarSalgadinho(salgadinho);

                        // ADICIONAR SALGADINHO AO PRATO
                        pedido.getPrato().add(salgadinho);

                        break;
                } 
            }
            
            pedido.mostrarFatura(numPratos, pizza, lanche, salgadinho);
            
            System.err.println("\n*Total a pagar: "+pedido.calcularTotal()+" AOA");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------");
            
            System.out.println("\nInsira o valor");
            float valorPagar = ler.nextFloat();
            
            if (valorPagar == pedido.calcularTotal()) {
                System.out.println("\nSem troco a receber");            
            }
            else if (valorPagar > pedido.calcularTotal()){
                System.out.println("\nSeu troco e de: "+(valorPagar-pedido.calcularTotal())+" AOA");
            }
            else if (valorPagar < pedido.calcularTotal()){
                System.out.println("\nDinheiro Insuficiente! Faltando "+(pedido.calcularTotal()-valorPagar)+" AOA");
            }
            
        } catch (InputMismatchException e) {
            System.err.println("A escolha de itens e feita com base aos numeros!");
            System.err.println("Dado inválido!");
        }      
    }  
}
