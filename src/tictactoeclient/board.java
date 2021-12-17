/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeclient;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author hmyou
 */
public class board extends javax.swing.JFrame {

    /**
     * Creates new form board
     * @param IP
     * @param port
     */
    static OutputStream outStream;
    static InputStream inStream;
    static ObjectOutputStream ooutStream;
    static ObjectInputStream oinStream;
    private static String xo;
    private static int YourScore =0;
    private static int OppScore =0;
    private boolean yourturn; 
    
    
    private void markBoard(String message){
        
            switch (message) {
                case "t1x":
                    if(jButton1.getText().equals("")){
                        jButton1.setText("X");
                        
                    }
                    break;
                case "t1o":
                    if(jButton1.getText().equals("")){
                        jButton1.setText("O");
                        
                    }
                    break;
                     case "t2x":
                    if(jButton2.getText().equals("")){
                        jButton2.setText("X");
                       
                    }
                    break;
                case "t2o":
                    if(jButton2.getText().equals("")){
                        jButton2.setText("O");
                       
                    }
                    break;
                     case "t3x":
                    if(jButton3.getText().equals("")){
                        jButton3.setText("X");
                    }
                    break;
                case "t3o":
                    if(jButton3.getText().equals("")){
                        jButton3.setText("O");
                    }
                    break;
                     case "t4x":
                    if(jButton4.getText().equals("")){
                        jButton4.setText("X");
                    }
                    break;
                case "t4o":
                    if(jButton4.getText().equals("")){
                        jButton4.setText("O");
                    }
                    break;
                     case "t5x":
                    if(jButton5.getText().equals("")){
                        jButton5.setText("X");
                        
                    }
                    break;
                case "t5o":
                    if(jButton5.getText().equals("")){
                        jButton5.setText("O");
                    }
                    break;
                     case "t6x":
                    if(jButton6.getText().equals("")){
                        jButton6.setText("X");
                    }
                    break;
                case "t6o":
                    if(jButton6.getText().equals("")){
                        jButton6.setText("O");
                    }
                    break;
                     case "t7x":
                    if(jButton7.getText().equals("")){
                        jButton7.setText("X");
                    }
                    break;
                case "t7o":
                    if(jButton7.getText().equals("")){
                        jButton7.setText("O");
                    }
                    break;
                     case "t8x":
                    if(jButton8.getText().equals("")){
                        jButton8.setText("X");
                        
                    }
                    break;
                case "t8o":
                    if(jButton8.getText().equals("")){
                        jButton8.setText("O");
                    }
                    break;
                     case "t9x":
                    if(jButton9.getText().equals("")){
                        jButton9.setText("X");
                    }
                    break;
                case "t9o":
                    if(jButton9.getText().equals("")){
                        jButton9.setText("O");
                    }
                    break;
                case "X wins":
                    clearBoard("X");
                    break;
                    
                case "O wins":
                    clearBoard("O");
                    break;
                    
                default:
                    break;
            }
            
    }
    private void changeTurn(){
        yourturn = !yourturn;
        
        if(yourturn == true)
            jLabel2.setText("Your Turn"); 
        else
            jLabel2.setText("Not Your Turn");
        
    }
    private void addScore(String winner){
        if(winner.equals(xo))
            jLabel3.setText("Your wins " + ++YourScore);
        else
            jLabel4.setText("Opponent's wins " + ++OppScore);
            
    }
    private void clearBoard(String m){
                
        jButton1.setText("");
        jButton2.setText("");
        jButton3.setText("");
        jButton4.setText("");
        jButton5.setText("");
        jButton6.setText("");
        jButton7.setText("");
        jButton8.setText("");
        jButton9.setText("");
        
        addScore(m);
    }
    
    private void startClient(String IP, int port){
          new Thread(() -> { 
          try{
                Socket socket=new Socket(IP,port);
                outStream=socket.getOutputStream();
                inStream=socket.getInputStream();
                ooutStream=new ObjectOutputStream(outStream);
                oinStream=new ObjectInputStream(inStream);
                xo = (String)oinStream.readObject();
                jLabel1.setText("You are " + xo);
                if(xo.equals("X")) {
                    jLabel2.setText("Your Turn");
                    yourturn = true;
                }
                    
                else{
                jLabel2.setText("Opponent's Turn");
                 yourturn = true;
               }
                    

                //System.out.printf("you are %s\n", xo);
                String prevMessage ="prev";
                while(true){
                    ooutStream.writeObject("list");
                    ooutStream.flush();
                    
                    String allmessages=(String)oinStream.readObject();
                    if(!allmessages.equals(prevMessage)){
                      
                         new Thread(() -> {
                            markBoard(allmessages);
                         }).start();
                         prevMessage = allmessages;
                    }
                   
                    
                    
                    
                    System.out.print(allmessages+"\n");
                    Thread.sleep(300);
                }
            }
            catch(IOException | ClassNotFoundException | InterruptedException e){System.out.print(e);}
           }).start();
          }
    
    
    public board(String IP,int port) {
      
        
        initComponents();
        startClient(IP,port);
   
        
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel1.setText("You are ");

        jLabel3.setText("Your wins: ");

        jLabel4.setText("Opponent's wins:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(158, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel3)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel4)))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if(jButton4.getText().equals("")){
         try {
            ooutStream.writeObject("T4"+xo);
            ooutStream.flush();
            
        }
        catch(IOException e){
            System.out.print(e);
        }
          changeTurn();
      } 
       
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(jButton1.getText().equals("")){
        try {
            ooutStream.writeObject("T1"+xo);
            ooutStream.flush();
          
        }
        catch(IOException  e){
                        System.out.print(e);

        }
         changeTurn();
      }
        
        //jButton1.setText("X");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(jButton2.getText().equals("")){
       try {
            ooutStream.writeObject("T2"+xo);
            ooutStream.flush();
            
        }
        catch(IOException  e){
                        System.out.print(e);

        }
        changeTurn();
     } 
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(jButton3.getText().equals("")){
        try {
            ooutStream.writeObject("T3"+xo);
            ooutStream.flush();
            
        }
        catch(IOException e){
                        System.out.print(e);

        }
         changeTurn();
      } 
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        if(jButton5.getText().equals("")){
         try {
            ooutStream.writeObject("T5"+xo);
            ooutStream.flush();
            
        }
        catch(IOException e){
                     System.out.print(e);
   
        }
          changeTurn();
      }
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        if(jButton6.getText().equals("")){
        
        try {
            ooutStream.writeObject("T6"+xo);
            ooutStream.flush();
            
        }
        catch(IOException e){
            System.out.print(e);
        }
         changeTurn();
      }
         
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        if(jButton7.getText().equals("")){
            try {
            ooutStream.writeObject("T7"+xo);
            ooutStream.flush();
           
            }
        catch(IOException e){ System.out.print(e); }
            
         changeTurn();
        }
            
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        if(jButton8.getText().equals("")){
        try {
            ooutStream.writeObject("T8"+xo);
            ooutStream.flush();
           
        }
        catch(IOException e){
                        System.out.print(e);

        }
        changeTurn();
      }
         
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        if(jButton9.getText().equals("")){
            
         try {
            ooutStream.writeObject("T9"+xo);
            ooutStream.flush();
            
        }
        catch(IOException e){
                        System.out.print(e);

        }changeTurn();
     }
        
        
    }//GEN-LAST:event_jButton9ActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
