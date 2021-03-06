
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thealien
 */
public class Terminal extends javax.swing.JFrame {

    /** Creates new form Terminal
     * @param site
     * @param proXy */
    public Terminal(String site,Proxy proXy) {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Terminal - AlienX");
        getRootPane().setDefaultButton(btnCMD);
        this.proxy = proXy;
        this.site = site;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCMD = new javax.swing.JTextField();
        btnCMD = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtShow = new javax.swing.JTextArea();
        jInfo = new javax.swing.JLabel();

        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        jLabel1.setText("Command");

        txtCMD.setText("ls -la");

        btnCMD.setText("Submit");
        btnCMD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCMDActionPerformed(evt);
            }
        });

        txtShow.setEditable(false);
        txtShow.setBackground(new java.awt.Color(0, 0, 0));
        txtShow.setColumns(20);
        txtShow.setForeground(new java.awt.Color(51, 255, 51));
        txtShow.setRows(5);
        txtShow.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jScrollPane1.setViewportView(txtShow);

        jInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jInfo.setText("Coded by Ijaz Ur Rahim ( Muhammad Ibraheem )");
        jInfo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCMD, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCMD)))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCMD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCMD))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jInfo))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCMDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCMDActionPerformed
        // TODO add your handling code here:
        if(txtCMD.getText().equals("exit"))
            this.dispose();
        else
        try{
            String contents = URLEncoder.encode(txtCMD.getText());
            URL url = new URL(site+contents);
            if(proxy!=null)
                conn = (HttpURLConnection) url.openConnection(proxy);
            else
                conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(10000);
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder result1 = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                result1.append(line+"\n");
            }
            br.close();
            txtShow.setText(result1.toString());
        }catch(IOException ex){
            jInfo.setText("Please Check Your Internet Connection");
            new java.util.Timer().schedule( 
            new java.util.TimerTask() {
                @Override
                public void run() {
                    jInfo.setText("Coded by Ijaz Ur Rahim ( Muhammad Ibraheem )");
                }
            },
              2000);
        }
    }//GEN-LAST:event_btnCMDActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Terminal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Terminal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Terminal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Terminal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Terminal("",null).setVisible(true);
            }
        });
    }
    private String site;
    private Proxy proxy;
    private HttpURLConnection conn;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCMD;
    private javax.swing.JLabel jInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCMD;
    private javax.swing.JTextArea txtShow;
    // End of variables declaration//GEN-END:variables

}
