/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post;

import e.voting.DbConnect;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

import java.sql.*;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
public class ManagePost extends javax.swing.JFrame {

    Connection con=null;
   PreparedStatement pst=null;
   ResultSet rs=null;
   int setId;
   String query=null;
   
   private static ManagePost obj=null;
    public ManagePost() {
        initComponents();
        setTitle("Add Post");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);        
        con=DbConnect.DbConnect();
        UpdateTable();
    }
    public static ManagePost getObj(){
    if(obj==null){
        obj=new ManagePost();
        
    }return obj;
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnnew = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblinfo = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        btnnew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/163_plus_add_new-20.png"))); // NOI18N
        btnnew.setText("new ");
        btnnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnewActionPerformed(evt);
            }
        });

        btnedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/831-20.png"))); // NOI18N
        btnedit.setText("Edit");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        btndelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/trash-circle-red-20.png"))); // NOI18N
        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        tblinfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblinfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblinfoMouseClicked(evt);
            }
        });
        tblinfo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblinfoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblinfo);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Post Information");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(btnnew)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnedit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btndelete)
                .addContainerGap(89, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnnew)
                    .addComponent(btnedit)
                    .addComponent(btndelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnewActionPerformed
        AddPost obj=new AddPost();
        obj.setVisible(true);
        this.hide();
    }//GEN-LAST:event_btnnewActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
       if(setId==0){
           JOptionPane.showMessageDialog(this, "Please Choose the Post", "Error", JOptionPane.ERROR_MESSAGE);
       }else{
           
           AddPost b=new AddPost(setId);
           b.setVisible(true);
           this.hide();
       }
    }//GEN-LAST:event_btneditActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
       if(setId==0){
           JOptionPane.showMessageDialog(this, "Please Choose the Post", "Error", JOptionPane.ERROR_MESSAGE);
       }else{
            int c=JOptionPane.showConfirmDialog(this, "Do you want to delete Post","Delete",JOptionPane.YES_NO_OPTION);
            if(c==0){
                query="DELETE FROM `post` WHERE id="+setId;
                try {
                    pst=con.prepareStatement(query);
                    if(pst.execute()){
                        JOptionPane.showMessageDialog(this, "Can not be Deleted Post");
                    }else{
                        JOptionPane.showMessageDialog(this, "Delete Post Successfully");
                        UpdateTable();
                    }
                } catch (Exception e) {
                }
            }
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void tblinfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblinfoMouseClicked
         try {
            int row =tblinfo.getSelectedRow();            
            String tableClick = (tblinfo.getModel().getValueAt(row, 0).toString());
            setId=Integer.parseInt(tableClick);
            String mysql = "select * from admin where id="+setId;
            pst = con.prepareStatement(mysql);
            rs = pst.executeQuery();
            if (rs.next()) {
                setId=rs.getInt("id");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
    }//GEN-LAST:event_tblinfoMouseClicked

    private void tblinfoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblinfoKeyReleased
       try {
            int row =tblinfo.getSelectedRow();            
            String tableClick = (tblinfo.getModel().getValueAt(row, 0).toString());
            setId=Integer.parseInt(tableClick);
            String mysql = "select * from admin where id="+setId;
            pst = con.prepareStatement(mysql);
            rs = pst.executeQuery();
            if (rs.next()) {
                setId=rs.getInt("id");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
    }//GEN-LAST:event_tblinfoKeyReleased

    private void UpdateTable(){
        try {              
              String mysql="SELECT `id` as 'ID:', `post` as 'Post', `description` as 'Post Description', status as 'Status' FROM `post` ";
              //JOptionPane.showMessageDialog(rootPane, mysql);
              pst=con.prepareStatement(mysql);
              rs=pst.executeQuery();
              tblinfo.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
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
            java.util.logging.Logger.getLogger(ManagePost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagePost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagePost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagePost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagePost().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnnew;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblinfo;
    // End of variables declaration//GEN-END:variables
}