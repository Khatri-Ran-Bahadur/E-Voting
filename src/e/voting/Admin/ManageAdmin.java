/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.voting.Admin;

import e.voting.DbConnect;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.*;
import java.text.*;
import java.awt.print.*;
import java.text.MessageFormat;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;


public class ManageAdmin extends javax.swing.JFrame {

    static ManageAdmin obj=null;
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    String query=null;
    int setId;
    
    
    public ManageAdmin() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Information of Admin");
        setLocationRelativeTo(null);
        con=DbConnect.DbConnect();
        setResizable(false);
        UpdateTable();
    }
public static ManageAdmin getObj(){
         if(obj==null){
             obj=new ManageAdmin();
         }return obj;
     }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        admin_tblinfo = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnProfile = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        admin_tblinfo.setBackground(new java.awt.Color(153, 255, 153));
        admin_tblinfo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        admin_tblinfo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        admin_tblinfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        admin_tblinfo.setAlignmentX(0.9F);
        admin_tblinfo.setAlignmentY(0.9F);
        admin_tblinfo.setRowHeight(21);
        admin_tblinfo.setSelectionBackground(new java.awt.Color(102, 255, 255));
        admin_tblinfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admin_tblinfoMouseClicked(evt);
            }
        });
        admin_tblinfo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                admin_tblinfoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(admin_tblinfo);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 1030, 290));

        jPanel1.setBackground(new java.awt.Color(51, 204, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Information of Admin");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(458, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(290, 290, 290))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 50));

        jPanel2.setBackground(new java.awt.Color(153, 51, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Image", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/image (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 198, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 158, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 50, 210, 190));

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));

        btnNew.setBackground(new java.awt.Color(255, 255, 51));
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/163_plus_add_new-20.png"))); // NOI18N
        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(255, 255, 51));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/831-20.png"))); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 255, 0));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/trash-circle-red-20.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnProfile.setBackground(new java.awt.Color(255, 255, 51));
        btnProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/025 (3).png"))); // NOI18N
        btnProfile.setText("Profiles");
        btnProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfileActionPerformed(evt);
            }
        });

        btnPrint.setBackground(new java.awt.Color(255, 255, 51));
        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Printer-24.png"))); // NOI18N
        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Search");

        search.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        search.setText(" Search By Username...");
        search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchMouseClicked(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnPrint, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(btnProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 820, 60));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/hert.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1050, 140));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/manageimage1.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void admin_tblinfoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_admin_tblinfoKeyReleased
       try {
            int row = admin_tblinfo.getSelectedRow();
            String tableClick = (admin_tblinfo.getModel().getValueAt(row, 0).toString());
            String mysql = "select * from admin where id='" + tableClick + "'";
            pst = con.prepareStatement(mysql);
            rs = pst.executeQuery();
            if (rs.next()) {
                getValue();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
    }//GEN-LAST:event_admin_tblinfoKeyReleased

    private void admin_tblinfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_tblinfoMouseClicked
        try {
            int row = admin_tblinfo.getSelectedRow();            
            String tableClick = (admin_tblinfo.getModel().getValueAt(row, 0).toString());
            setId=Integer.parseInt(tableClick);
            String mysql = "select * from admin where id="+setId;
            pst = con.prepareStatement(mysql);
            rs = pst.executeQuery();
            if (rs.next()) {
                getValue();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
    }//GEN-LAST:event_admin_tblinfoMouseClicked

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        AddAdmin.getObj().setVisible(true);
        this.hide();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if(setId==0){
           JOptionPane.showMessageDialog(this, "Please Choose the Admin", "Error", JOptionPane.ERROR_MESSAGE);
       }else{
           int c=JOptionPane.showConfirmDialog(this, "Do you want to Edit Information","Delete",JOptionPane.YES_NO_OPTION);
            if(c==0){
                AddAdmin b=new AddAdmin(setId);
                b.setVisible(true);
                this.hide();
            }
       }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if(setId==0){
           JOptionPane.showMessageDialog(this, "Please Choose the Admin", "Error", JOptionPane.ERROR_MESSAGE);
       }else{
            int c=JOptionPane.showConfirmDialog(this, "Do you want to delete account","Delete",JOptionPane.YES_NO_OPTION);
            if(c==0){
                query="DELETE FROM `admin` WHERE id="+setId;
                try {
                    pst=con.prepareStatement(query);
                    if(pst.execute()){
                        JOptionPane.showMessageDialog(this, "Can not be Deleted Account");
                    }else{
                        JOptionPane.showMessageDialog(this, "Delete Account Successfully");
                        UpdateTable();
                    }
                } catch (Exception e) {
                }
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileActionPerformed
       if(setId==0){
           JOptionPane.showMessageDialog(this, "Please Choose the Admin", "Error", JOptionPane.ERROR_MESSAGE);
       }else{
            Profile obj=new Profile(setId,1);
            obj.setVisible(true);
       }
    }//GEN-LAST:event_btnProfileActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
         MessageFormat header=new MessageFormat("Adminn Table");
            MessageFormat footer=new MessageFormat("Page{0,number,integer}");
        try {
           admin_tblinfo.print(JTable.PrintMode.NORMAL,header,footer);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }

/* next method

    PrinterJob job=PrinterJob.getPrinterJob();
    job.setJobName("Print Date");
    
    job.setPrintable(new Printable() {
        @Override
        public int print(Graphics graphics, PageFormat pageFormat, int pagNum) {
           if(pagNum>0){
               return Printable.NO_SUCH_PAGE;
           }
           Graphics2D g2=(Graphics2D)graphics;
           g2.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
           g2.scale(0.24, 0.24);
           admin_tblinfo.print(g2);
           return Printable.NO_SUCH_PAGE;
        }
    });
    
    boolean ok=job.printDialog();
    if(ok){
        try {
            job.print();
        } catch (Exception e) {
        }
    }
    */
    
    
    }//GEN-LAST:event_btnPrintActionPerformed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
       
        String key=search.getText();
        if(key.equals("")){
            key="";
            UpdateTable();
        }else{
            try {              
                  String mysql="SELECT `id` as 'ID:', `uname` as 'Username', `fullname` as 'Full Name', `dob` as 'Date Of Birth', `gender` as 'Gender', `fathername` as 'Father Name', `mothername` as 'Mother Name',`country` as 'Country', `district` as 'District', `pardesh` as 'Pardesh', `muncipality` as 'Muncipality', `woda` as 'Woda No', `image` as 'Image', `status` FROM `admin` where uname like '"+search.getText()+"%'";
                  //JOptionPane.showMessageDialog(rootPane, mysql);
                  pst=con.prepareStatement(mysql);
                  rs=pst.executeQuery();
                  admin_tblinfo.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);
            }
        }
    }//GEN-LAST:event_searchKeyReleased

    private void searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseClicked
        search.setText("");
    }//GEN-LAST:event_searchMouseClicked

    private void getValue(){
         try {
             setId=rs.getInt("id");
             byte[] imageData = rs.getBytes("image");
            ImageIcon format = new ImageIcon(scaledImage(imageData, image.getWidth(), image.getHeight()));
            image.setIcon(format);
            
        } catch (Exception e) {
        }
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
     
    private void UpdateTable(){
        try {              
              String mysql="SELECT `id` as 'ID:', `uname` as 'Username', `fullname` as 'Full Name', `dob` as 'Date Of Birth', `gender` as 'Gender', `fathername` as 'Father Name', `mothername` as 'Mother Name',`country` as 'Country', `district` as 'District', `pardesh` as 'Pardesh', `muncipality` as 'Muncipality', `woda` as 'Woda No', `image` as 'Image', `status` FROM `admin` ";
              //JOptionPane.showMessageDialog(rootPane, mysql);
              pst=con.prepareStatement(mysql);
              rs=pst.executeQuery();
              admin_tblinfo.setModel(DbUtils.resultSetToTableModel(rs));

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
            java.util.logging.Logger.getLogger(ManageAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable admin_tblinfo;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnProfile;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
