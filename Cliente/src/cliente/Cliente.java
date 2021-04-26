/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

/**
 *
 * @author walte
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    static Conector cliente;
    public static void main(String[] args) {
        ventanaCliente cliente = new ventanaCliente();
        cliente.setVisible(true);
        
    }
    
    public void iniciar(String ip){
        cliente = new Conector(ip);
        cliente.start();
    }
}
