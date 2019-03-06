/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.voting;
import java.sql.*;
import javax.swing.*;
public class VotterLogin extends javax.swing.JFrame {

    private Connection con=null;
   private PreparedStatement pst=null;
   private ResultSet rs=null;
   
    public VotterLogin() {
        init();
    }
    private void init(){
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Log In");
        ImageIcon icon=new ImageIcon("image/1.png");        
        setIconImage(icon.getImage());
        con=DbConnect.DbConnect();
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        submit = new javax.swing.JButton();
        uname = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        passView = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 0, -1, 469));

        submit.setBackground(new java.awt.Color(255, 255, 51));
        submit.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        jPanel1.add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 110, 40));

        uname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        uname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 255), 2));
        uname.setCaretColor(new java.awt.Color(51, 51, 255));
        jPanel1.add(uname, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 220, 238, 32));

        pass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 255), 2));
        pass.setCaretColor(new java.awt.Color(0, 0, 255));
        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });
        jPanel1.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 281, 238, 34));

        passView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/view-20.png"))); // NOI18N
        passView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                passViewMousePressed(evt);
            }
        });
        jPanel1.add(passView, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, 20, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("but you are voter only click the voter button ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/login-form3.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 450));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        if(uname.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Please Fill the username Field.");
        }
        else if(pass.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Please Fill the username Field.");
        }
        else{
            String query="select * from admin where uname=? and pass=?";
            try {
                pst=con.prepareStatement(query);
                pst.setString(1, uname.getText());
                pst.setString(2, pass.getText());
                int id;
                rs=pst.executeQuery();
                if(rs.next()){
                    id=rs.getInt("id");
                    Lodding obj=new Lodding(id);
                    obj.setUpLoading();
                    obj.setVisible(true);
                    this.hide();

                }else{
                    JOptionPane.showMessageDialog(this, "Sorry your usename and password are not valid try again");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
            }finally{
                try {
                    rs.close();
                    pst.close();
                } catch (Exception e) {
                }
            }
        }
    }//GEN-LAST:event_submitActionPerformed

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passActionPerformed
    static int a=0;
    private void passViewMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passViewMousePressed
        if(a==0){
            pass.setEchoChar((char)0);
            a++;
        }else{
            pass.setEchoChar('*');
            a=0;
        }
    }//GEN-LAST:event_passViewMousePressed

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
            java.util.logging.Logger.getLogger(VotterLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VotterLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VotterLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VotterLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VotterLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField pass;
    private javax.swing.JLabel passView;
    private javax.swing.JButton submit;
    private javax.swing.JTextField uname;
    // End of variables declaration//GEN-END:variables
}
