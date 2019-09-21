
package fotball;

import fotball.CreateTree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JOptionPane;
import org.omg.CORBA.INTERNAL;

public class Main extends javax.swing.JFrame {

    public Main() {
        initComponents();
    }
    public class Threading implements Runnable{

        @Override
        public void run() {
            try{
                String input;
            Socket socket = new Socket(Host.getText(), Integer.parseInt(port.getText()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw.write("I:"+"Gorohak");
            pw.flush();
            while(true){
            char[] data=new char[26];
            br.read(data,0,26); 
            input=new String(data);
            you.setText(input.substring(16,21));
            opponent.setText(input.substring(21,26));
               // System.out.println(input);                
            CreateTree aC =new CreateTree();
            aC.CreateTree(input);
            pw.write(aC.bestMove);
            pw.flush();
            }
            }
             catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + Host.getText());
            System.exit(1);
        }
        
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        port = new javax.swing.JTextField();
        Host = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        you = new javax.swing.JLabel();
        opponent = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        port.setText("55000");

        Host.setText("127.0.0.1");

        jButton1.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 51));
        jButton1.setText("Start");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("portNumber");

        jLabel2.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setText("HostName");

        jButton2.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 0, 51));
        jButton2.setText("exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("Score");

        jLabel4.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 0, 51));
        jLabel4.setText("You");

        jLabel5.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 0, 51));
        jLabel5.setText("Opponent");

        you.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        you.setForeground(new java.awt.Color(204, 0, 0));
        you.setText("0");

        opponent.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        opponent.setForeground(new java.awt.Color(204, 0, 0));
        opponent.setText("0");

        jLabel8.setText("VS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(port, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Host))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(you)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(65, 65, 65)
                        .addComponent(opponent)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(172, 172, 172))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(you)
                    .addComponent(opponent)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Host, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         Thread a=new Thread(new Threading());
          a.start();
//        String hostName = Host.getText();  // or Ip address of Server
//        int portNumber = Integer.parseInt(port.getText()); // for Example    ya har porti ke doost darid va khali mibashad        
//            long time1,time2;
//            int i=0;
//            int bestmove,option;            
//             String input="6938P"; 
//                 int rowWe =Integer.parseInt(input.substring(0, 1));
//                 int columnWe=Integer.parseInt(input.substring(1, 2));
//                 int rowYou=Integer.parseInt(input.substring(2, 3));
//                 int ColumnYou=Integer.parseInt(input.substring(3, 4));
//                 String SahebTop=input.substring(4, 5);                             
//            while( i<6 ){
//                time1= System.nanoTime();
//                System.out.println();
//                System.out.println();
//                System.out.println("i = "+i);                              
//             CreateTree a =new CreateTree();
//             a.CreateTree(input); 
//             bestmove=Integer.parseInt(a.bestMove);;
//             switch(bestmove){
//                 case 0:                                             
//                        input=String.valueOf(rowWe)+String.valueOf(columnWe)+ String.valueOf(rowYou)+String.valueOf(ColumnYou)+ "P";                    
//                     break;
//                 case 1:
//                     if(rowWe>1){
//                         rowWe--;
//                         input=String.valueOf(rowWe)+String.valueOf(columnWe)+ String.valueOf(rowYou)+String.valueOf(ColumnYou)+"P"; 
//                     }
//                     break;
//                     case 2:
//                         if(rowWe<6){
//                             rowWe++;
//                             input=String.valueOf(rowWe)+String.valueOf(columnWe)+ String.valueOf(rowYou)+String.valueOf(ColumnYou)+ "P"; 
//                         }
//                          break;
//                         case 3:
//                             if(columnWe>1){
//                                 columnWe--;
//                                 input=String.valueOf(rowWe)+String.valueOf(columnWe)+ String.valueOf(rowYou)+String.valueOf(ColumnYou)+ "P"; 
//                             }
//                              break;
//                    case 4:
//                        if(columnWe<9){
//                            columnWe++;
//                            input=String.valueOf(rowWe)+String.valueOf(columnWe)+ String.valueOf(rowYou)+String.valueOf(ColumnYou)+ "P"; 
//                        }
//                         break;
//             }         
//             i++;
//                time2= System.nanoTime();
//              System.out.println( (time2-time1)/1000000 + " ms");             
//            }        
            
            
           
            
                               
    }//GEN-LAST:event_jButton1ActionPerformed

    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(1);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Host;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel opponent;
    private javax.swing.JTextField port;
    private javax.swing.JLabel you;
    // End of variables declaration//GEN-END:variables
}
