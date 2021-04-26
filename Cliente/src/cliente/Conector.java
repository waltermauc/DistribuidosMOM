/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.Socket;

/**
 *
 * @author walte
 */
public class Conector extends Thread {

    private Socket socket;
    private InputStreamReader entradaSocket;
    private DataOutputStream salida;
    private BufferedReader entrada;
    final int puerto = 8181;
    String ip;

    public Conector(String ip) {
        this.ip = ip;
    }
    

    public void run() {
        String texto;

        try {

            socket = new Socket(ip, 21);
            entradaSocket = new InputStreamReader(socket.getInputStream());
            entrada = new BufferedReader(entradaSocket);
            salida = new DataOutputStream(socket.getOutputStream());
            salida.writeUTF("Conectando - \n");

            while (true) {
                texto = this.entrada.readLine();
                ventanaCliente.textAreaSer.setText(ventanaCliente.textAreaSer.getText() + "\n" + texto);
            }
        } catch (IOException ex) {
            System.out.println("ERROR DE LECTURA");
        }

    }
    public void enviarMensaje(String mensaje) {
        try {
            salida.writeUTF(mensaje+"\n");
        } catch (IOException ex) {
            System.out.println("ERROR DE MENSAJE");
        }
    }

    public void desconectar() {
        try {
            socket.close();
           
        } catch (IOException ex) {
            System.out.println("ERROR AL DESCONECTAR");
        }
    }

}
