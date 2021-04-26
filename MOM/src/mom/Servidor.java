/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mom;

/**
 *
 * @author walte
 */
public class Servidor {
    static Conector servidor;
   public static void main(String[] args){
       VentanaServidor server = new VentanaServidor();
       server.main();
   }
   public void iniciar(){
       servidor = new Conector();
       servidor.start();
   }
}
