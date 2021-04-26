/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mom;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author walte
 */
public class Conector extends Thread {

    private Socket socket;
    private ServerSocket srvSocket;
    private InputStreamReader entradaSocket;
    private DataOutputStream salida;
    private BufferedReader entrada;


    public void run() {
        String texto;

        try {
            srvSocket = new ServerSocket(21);
            socket = srvSocket.accept();

            entradaSocket = new InputStreamReader(socket.getInputStream());
            entrada = new BufferedReader(entradaSocket);
            salida = new DataOutputStream(socket.getOutputStream());

            while (true) {
                texto = this.entrada.readLine();
                VentanaServidor.textAreaSer.setText(VentanaServidor.textAreaSer.getText()+ "\n" + texto);
            }
        } catch (IOException ex) {
            System.out.println("ERROR DE LECTURA");
        }

    }

    public void enviarMensaje(String mensaje) {
        try {
            salida.writeUTF(mensaje + "\n");
        } catch (IOException ex) {
            System.out.println("ERROR DE MENSAJE");
        }
    }

    public void desconectar() {
        try {
            socket.close();
            srvSocket.close();
        } catch (IOException ex) {
            System.out.println("ERROR AL DESCONECTAR");
        }
    }

}
