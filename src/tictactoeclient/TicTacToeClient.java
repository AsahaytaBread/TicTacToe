/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeclient;

import java.net.Socket;
import java.io.*;
import javax.swing.*;

/**
 *
 * @author hmyou
 */
public class TicTacToeClient {

    static String IP = "127.0.0.1";
    static int port = 8888;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        board playgame = new board(IP,port);
        playgame.setVisible(true);
        
      

    }
    
}
