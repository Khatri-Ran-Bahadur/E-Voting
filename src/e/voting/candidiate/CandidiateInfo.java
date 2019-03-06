
package e.voting.candidiate;

import e.voting.DbConnect;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


public class CandidiateInfo extends javax.swing.JFrame {

    private static CandidiateInfo obj=null;
    public CandidiateInfo() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        setTitle("Candidiate Information");
        
        conn=DbConnect.DbConnect();
        updateVoterInfo();
    }
 public static CandidiateInfo getObj(){
         if(obj==null){
             obj=new CandidiateInfo();
         }return obj;
     }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        canInfo = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        img = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Edit = new javax.swing.JButton();
        AddNew = new javax.swing.JButton();
        search_by = new javax.swing.JComboBox<>();
        btndelete = new javax.swing.JButton();
        btnstatus = new javax.swing.JButton();
        btnprint = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        canInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        canInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                canInfoMouseClicked(evt);
            }
        });
        canInfo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                canInfoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(canInfo);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 229, 1140, 270));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(img, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(img, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(938, 22, -1, 200));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Search Candidiate");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 197, 133, 24));

        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });
        jPanel1.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(775, 199, 153, 24));

        jLabel2.setBackground(new java.awt.Color(0, 153, 153));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("            Candidiate Information");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 280, 30));

        Edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/document-20.png"))); // NOI18N
        Edit.setText("EDIT");
        Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditActionPerformed(evt);
            }
        });
        jPanel1.add(Edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 88, -1));

        AddNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/163_plus_add_new-20.png"))); // NOI18N
        AddNew.setText("ADD NEW");
        AddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNewActionPerformed(evt);
            }
        });
        jPanel1.add(AddNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        search_by.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name", "District", "Muncipality", " " }));
        jPanel1.add(search_by, new org.netbeans.lib.awtextra.AbsoluteConstraints(686, 198, 79, 26));

        btndelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/trash-circle-red-20.png"))); // NOI18N
        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, -1, 30));

        btnstatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/business_corporate_group_office-14-16.png"))); // NOI18N
        btnstatus.setText("Status");
        btnstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnstatusActionPerformed(evt);
            }
        });
        jPanel1.add(btnstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 90, 30));

        btnprint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Printer-24.png"))); // NOI18N
        btnprint.setText("Print");
        btnprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprintActionPerformed(evt);
            }
        });
        jPanel1.add(btnprint, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 90, 30));

        jPanel3.setBackground(new java.awt.Color(0, 153, 204));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1140, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 60));

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1140, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 1140, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/28586f0e1fe7dfe.jpg"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 800, 230));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/28586f0e1fe7dfe.jpg"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 230));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void setId(int id){
        can_id=id;
    }
    private int getId(){
        return can_id;
    }
    
    private Image scaledImage(byte[] img, int w, int h) {
        BufferedImage resizeImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        try {
            Graphics2D g2 = resizeImage.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

            //convert the byte array back to buffered image
            ByteArrayInputStream in = new ByteArrayInputStream(img);
            BufferedImage bImageFromConvert = ImageIO.read(in);

            g2.drawImage(bImageFromConvert, 0, 0, w, h, null);
            g2.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
        return resizeImage;
    }
    
    private void Search(String key){
         String value=search.getText();
         /*Name
            District
             Muncipality
         */
          if(key.equals("Name")){
              if(value.equals("")){
                  String s=" ";
                    getValue(s);
              }else{
                String s="where fullname like '"+value+"%'";
                getValue(s);
              }
          }
          if(key.equals("District")){
              if(value.equals("")){
                  String s=" ";
                    getValue(s);
              }else{
                String s="where district like '"+value+"%'";
                getValue(s);
              }
          }
          if(key.equals("Muncipality")){
              if(value.equals("")){
                  String s=" ";
                    getValue(s);
              }else{
                String s="where nagarpalika like '"+value+"%'";
                getValue(s);
              }
          }
          
          
    }
    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
       String s=(String)search_by.getSelectedItem();
        Search(s);
    }//GEN-LAST:event_searchKeyReleased

    private void canInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canInfoMouseClicked
        try {
            int row = canInfo.getSelectedRow();            
            String tableClick = (canInfo.getModel().getValueAt(row, 0).toString());
            setId(Integer.parseInt(tableClick));
            String mysql = "select * from candidiate where id='" + tableClick + "'";
            pst = conn.prepareStatement(mysql);
            rs = pst.executeQuery();
            if (rs.next()) {
                getValue();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
    }//GEN-LAST:event_canInfoMouseClicked

    private void canInfoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_canInfoKeyReleased
        try {
            int row = canInfo.getSelectedRow();            
            String tableClick = (canInfo.getModel().getValueAt(row, 0).toString());
            setId(Integer.parseInt(tableClick));
            String mysql = "select * from candidiate where id='" + tableClick + "'";
            pst = conn.prepareStatement(mysql);
            rs = pst.executeQuery();
            if (rs.next()) {
                getValue();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
    }//GEN-LAST:event_canInfoKeyReleased

    private void AddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNewActionPerformed
        AddCandidiate b=new AddCandidiate();
        b.setVisible(true);
        this.hide();
        
    }//GEN-LAST:event_AddNewActionPerformed

    private void EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActionPerformed
        if(can_id==0){
            JOptionPane.showMessageDialog(this, "Please Choose the Candidiate", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            
            int c=JOptionPane.showConfirmDialog(this, "Do you want to Edit Information","Delete",JOptionPane.YES_NO_OPTION);
            if(c==0){
                AddCandidiate b=new AddCandidiate(can_id);
                b.setVisible(true);
                this.hide();
            }
        }
        
    }//GEN-LAST:event_EditActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        if(can_id==0){
           JOptionPane.showMessageDialog(this, "Please Choose the Candidiate", "Error", JOptionPane.ERROR_MESSAGE);
       }else{
            int c=JOptionPane.showConfirmDialog(this, "Do you want to delete Information","Delete",JOptionPane.YES_NO_OPTION);
            if(c==0){
                query="DELETE FROM `candidiate` WHERE id="+can_id;
                try {
                    pst=conn.prepareStatement(query);
                    if(pst.execute()){
                        JOptionPane.showMessageDialog(this, "Can not be Deleted Account");
                    }else{
                        JOptionPane.showMessageDialog(this, "Delete Account Successfully");
                        updateVoterInfo();
                    }
                } catch (Exception e) {
                }
            }
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnstatusActionPerformed
        
        
        if(can_id==0){
           JOptionPane.showMessageDialog(this, "Please Choose the Candidiate", "Error", JOptionPane.ERROR_MESSAGE);
       }else{
            int c=JOptionPane.showConfirmDialog(this, "Do you want to change Status","Delete",JOptionPane.YES_NO_OPTION);
            if(c==0){
                int row = canInfo.getSelectedRow();            
                String tableClick = (canInfo.getModel().getValueAt(row, 12).toString());
                String key;
                    if(tableClick.equals("Active")){
                        key= "Inacive";
                    }else{
                        key="Active";
                    }
                query="UPDATE `candidiate` SET `status`='"+key+"' WHERE id="+can_id;
                try {
                    pst=conn.prepareStatement(query);                   
                    if(pst.execute()){
                        
                    }else{
                        getValue("");
                        JOptionPane.showMessageDialog(this, "Status successfully !");
                        
                    }
                } catch (Exception e) {
                    //JOptionPane.showMessageDialog(rootPane, e);
                }
            }
        }
    }//GEN-LAST:event_btnstatusActionPerformed

    private void btnprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprintActionPerformed
       
    }//GEN-LAST:event_btnprintActionPerformed
    private void getValue(){
         try {
             byte[] imageData = rs.getBytes("pimage");
            ImageIcon format = new ImageIcon(scaledImage(imageData, img.getWidth(), img.getHeight()));
            img.setIcon(format);            
        } catch (Exception e) {
        }
    }
   private void updateVoterInfo(){
       String s="";
       getValue(s);
   }
   private void getValue(String key){
       try {              
              String mysql="SELECT id as 'ID:', fullname as 'Full Name', dob as 'DOB', gender as 'Gender',country as 'Country', pardesh as 'Pardesh', district as"
                      + " 'District', nagarpalika as 'Muncipality', oda as 'Woda No', post as 'Post',party as 'Party',pimage as 'Image', status as 'Status' From candidiate "+key;
              //JOptionPane.showMessageDialog(rootPane, mysql);
              pst=conn.prepareStatement(mysql);
              rs=pst.executeQuery();
              canInfo.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
   }
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
            java.util.logging.Logger.getLogger(CandidiateInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CandidiateInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CandidiateInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CandidiateInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CandidiateInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddNew;
    private javax.swing.JButton Edit;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnprint;
    private javax.swing.JButton btnstatus;
    private javax.swing.JTable canInfo;
    private javax.swing.JLabel img;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField search;
    private javax.swing.JComboBox<String> search_by;
    // End of variables declaration//GEN-END:variables
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    String query;
    int can_id=0;
    
}
