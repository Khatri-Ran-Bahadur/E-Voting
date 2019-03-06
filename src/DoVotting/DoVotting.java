/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoVotting;

import e.voting.DbConnect;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;


public class DoVotting extends javax.swing.JFrame {

    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    String voter_id="1";
    String query=null;
    
    public DoVotting() {
       init();
    }
    public DoVotting(String id){
        voter_id=id;
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
        FillField();
   }
   
   private void FillField(){
       String query1="SELECT * FROM `party`";
       
       mayer.addItem("Select Mayor");
       upmayer.addItem("Select Upmayor");
       wodaadhakshay.addItem("Select Ward Chairperson");
       sadasya1.addItem("Select Member 1");
       sadhasya2.addItem("Select Member 2");
       mahilasadhasya.addItem("Select Female Member");
       dalitmahila.addItem("Select Dalit Female Member");
       
       try {
           pst=con.prepareStatement(query1);
           rs=pst.executeQuery();
           while(rs.next()){
               mayer.addItem(rs.getString("name"));
                upmayer.addItem(rs.getString("name"));
                wodaadhakshay.addItem(rs.getString("name"));
                sadasya1.addItem(rs.getString("name"));
                sadhasya2.addItem(rs.getString("name"));
                mahilasadhasya.addItem(rs.getString("name"));
                dalitmahila.addItem(rs.getString("name"));
           }
           
           
       } catch (Exception e) {
           //JOptionPane.showMessageDialog(rootPane, e);
       }
       
   }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        mayer = new javax.swing.JComboBox<>();
        upmayer = new javax.swing.JComboBox<>();
        wodaadhakshay = new javax.swing.JComboBox<>();
        sadasya1 = new javax.swing.JComboBox<>();
        sadhasya2 = new javax.swing.JComboBox<>();
        mahilasadhasya = new javax.swing.JComboBox<>();
        dalitmahila = new javax.swing.JComboBox<>();
        can1 = new javax.swing.JComboBox<>();
        can2 = new javax.swing.JComboBox<>();
        can3 = new javax.swing.JComboBox<>();
        can4 = new javax.swing.JComboBox<>();
        can5 = new javax.swing.JComboBox<>();
        can6 = new javax.swing.JComboBox<>();
        can7 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        vote = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Dalit Mahila Sadhasya:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 180, 34));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Meyar:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 60, 34));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Upameyar:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 90, 34));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Woda adhakshay:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 140, 34));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Sadhasya 2:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 100, 34));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Sadhasya 1:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 100, 34));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Mahila Sadhasya:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 140, 34));

        mayer.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                mayerItemStateChanged(evt);
            }
        });
        mayer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mayerMouseClicked(evt);
            }
        });
        jPanel1.add(mayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 130, 30));

        upmayer.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                upmayerItemStateChanged(evt);
            }
        });
        jPanel1.add(upmayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 130, 30));

        wodaadhakshay.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                wodaadhakshayItemStateChanged(evt);
            }
        });
        jPanel1.add(wodaadhakshay, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 130, 30));

        sadasya1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                sadasya1ItemStateChanged(evt);
            }
        });
        jPanel1.add(sadasya1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 130, 30));

        sadhasya2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                sadhasya2ItemStateChanged(evt);
            }
        });
        jPanel1.add(sadhasya2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 130, 30));

        mahilasadhasya.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                mahilasadhasyaItemStateChanged(evt);
            }
        });
        jPanel1.add(mahilasadhasya, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, 130, 30));

        dalitmahila.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                dalitmahilaItemStateChanged(evt);
            }
        });
        jPanel1.add(dalitmahila, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 430, 130, 30));

        can1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                can1ItemStateChanged(evt);
            }
        });
        jPanel1.add(can1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 140, 30));

        can2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                can2ItemStateChanged(evt);
            }
        });
        jPanel1.add(can2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 140, 30));

        can3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                can3ItemStateChanged(evt);
            }
        });
        jPanel1.add(can3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 140, 30));

        can4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                can4ItemStateChanged(evt);
            }
        });
        jPanel1.add(can4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 140, 30));

        can5.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                can5ItemStateChanged(evt);
            }
        });
        jPanel1.add(can5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 140, 30));

        can6.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                can6ItemStateChanged(evt);
            }
        });
        jPanel1.add(can6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, 140, 30));

        can7.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                can7ItemStateChanged(evt);
            }
        });
        jPanel1.add(can7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, 140, 30));

        jPanel2.setBackground(new java.awt.Color(0, 0, 255));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Select Candidiate And Vote Them");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(247, 247, 247)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(253, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 60));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Candidiate");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 120, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Party");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 100, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204)), "Image"));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/vote.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, 200, 180));

        vote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Save_Icon-24.png"))); // NOI18N
        vote.setText("vote");
        vote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voteActionPerformed(evt);
            }
        });
        jPanel1.add(vote, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 490, 80, 30));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 10, 490));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 770, 10));

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

    private void mayerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mayerMouseClicked
        
    }//GEN-LAST:event_mayerMouseClicked

    private void mayerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_mayerItemStateChanged
       can1.removeAllItems();
       can1.addItem("Select Candidite");
        query="SELECT * FROM `candidiate` WHERE party='"+mayer.getSelectedItem()+"' and post='Mayor'";
        try {
           pst=con.prepareStatement(query);
           rs=pst.executeQuery();
           while(rs.next()){
               can1.addItem(rs.getString("fullname"));               
           }
           
           
       } catch (Exception e) {
           //JOptionPane.showMessageDialog(rootPane, e);
       }
    }//GEN-LAST:event_mayerItemStateChanged

    private void upmayerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_upmayerItemStateChanged
       can2.removeAllItems();
       can2.addItem("Select Candidite");
        query="SELECT * FROM `candidiate` WHERE party='"+upmayer.getSelectedItem()+"' and post='Upmayor'";
        try {
           pst=con.prepareStatement(query);
           rs=pst.executeQuery();
           while(rs.next()){
               can2.addItem(rs.getString("fullname"));               
           }           
       } catch (Exception e) {
          // JOptionPane.showMessageDialog(rootPane, e);
       }
    }//GEN-LAST:event_upmayerItemStateChanged

    private void wodaadhakshayItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_wodaadhakshayItemStateChanged
        can3.removeAllItems();
       can3.addItem("Select Candidite");
        query="SELECT * FROM `candidiate` WHERE party='"+wodaadhakshay.getSelectedItem()+"' and post='Ward Chairperson'";
        try {
           pst=con.prepareStatement(query);
           rs=pst.executeQuery();
           while(rs.next()){
               can3.addItem(rs.getString("fullname"));               
           }           
       } catch (Exception e) {
           //JOptionPane.showMessageDialog(rootPane, e);
       }
    }//GEN-LAST:event_wodaadhakshayItemStateChanged

    private void sadasya1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_sadasya1ItemStateChanged
        can4.removeAllItems();
       can4.addItem("Select Candidite");
        query="SELECT * FROM `candidiate` WHERE party='"+sadasya1.getSelectedItem()+"' and post='Member 1'";
        try {
           pst=con.prepareStatement(query);
           rs=pst.executeQuery();
           while(rs.next()){
               can4.addItem(rs.getString("fullname"));               
           }           
       } catch (Exception e) {
           //JOptionPane.showMessageDialog(rootPane, e);
       }
    }//GEN-LAST:event_sadasya1ItemStateChanged

    private void sadhasya2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_sadhasya2ItemStateChanged
       can5.removeAllItems();
       can5.addItem("Select Candidite");
        query="SELECT * FROM `candidiate` WHERE party='"+sadhasya2.getSelectedItem()+"' and post='Member 2'";
        try {
           pst=con.prepareStatement(query);
           rs=pst.executeQuery();
           while(rs.next()){
               can5.addItem(rs.getString("fullname"));               
           }           
       } catch (Exception e) {
          // JOptionPane.showMessageDialog(rootPane, e);
       }
    }//GEN-LAST:event_sadhasya2ItemStateChanged

    private void mahilasadhasyaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_mahilasadhasyaItemStateChanged
        can6.removeAllItems();
       can6.addItem("Select Candidite");
        query="SELECT * FROM `candidiate` WHERE party='"+mahilasadhasya.getSelectedItem()+"' and post='Female Member'";
        try {
           pst=con.prepareStatement(query);
           rs=pst.executeQuery();
           while(rs.next()){
               can6.addItem(rs.getString("fullname"));               
           }           
       } catch (Exception e) {
          // JOptionPane.showMessageDialog(rootPane, e);
       }
    }//GEN-LAST:event_mahilasadhasyaItemStateChanged

    private void dalitmahilaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_dalitmahilaItemStateChanged
        can7.removeAllItems();
       can7.addItem("Select Candidite");
        query="SELECT * FROM `candidiate` WHERE party='"+dalitmahila.getSelectedItem()+"' and post='Dalit Female Member'";
        try {
           pst=con.prepareStatement(query);
           rs=pst.executeQuery();
           while(rs.next()){
               can7.addItem(rs.getString("fullname"));               
           }           
       } catch (Exception e) {
           //JOptionPane.showMessageDialog(rootPane, e);
       }
    }//GEN-LAST:event_dalitmahilaItemStateChanged

    private void voteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voteActionPerformed
        
        doVote();
    }//GEN-LAST:event_voteActionPerformed

    private void can1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_can1ItemStateChanged
       getImage((String) can1.getSelectedItem());
    }//GEN-LAST:event_can1ItemStateChanged

    private void can2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_can2ItemStateChanged
        getImage((String) can2.getSelectedItem());
    }//GEN-LAST:event_can2ItemStateChanged

    private void can3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_can3ItemStateChanged
        getImage((String) can3.getSelectedItem());
    }//GEN-LAST:event_can3ItemStateChanged

    private void can4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_can4ItemStateChanged
        getImage((String) can4.getSelectedItem());
    }//GEN-LAST:event_can4ItemStateChanged

    private void can5ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_can5ItemStateChanged
       getImage((String) can5.getSelectedItem());
    }//GEN-LAST:event_can5ItemStateChanged

    private void can6ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_can6ItemStateChanged
       getImage((String) can6.getSelectedItem());
    }//GEN-LAST:event_can6ItemStateChanged

    private void can7ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_can7ItemStateChanged
        getImage((String) can7.getSelectedItem());
    }//GEN-LAST:event_can7ItemStateChanged
    private void doVote(){
        
        if(formValidation()==true && checkIdVotedOrNot()==true){
            
        query="INSERT INTO `votecount`(`id`, `party`, `candidiate_name`, `vote`) VALUES (null,'"+mayer.getSelectedItem()+"','"+can1.getSelectedItem()+"',1)";
        String query1="INSERT INTO `votecount`(`id`, `party`, `candidiate_name`, `vote`) VALUES (null,'"+upmayer.getSelectedItem()+"','"+can2.getSelectedItem()+"',1)";
        String query2="INSERT INTO `votecount`(`id`, `party`, `candidiate_name`, `vote`) VALUES (null,'"+wodaadhakshay.getSelectedItem()+"','"+can3.getSelectedItem()+"',1)";
        String query3="INSERT INTO `votecount`(`id`, `party`, `candidiate_name`, `vote`) VALUES (null,'"+sadasya1.getSelectedItem()+"','"+can4.getSelectedItem()+"',1)";
        String query4="INSERT INTO `votecount`(`id`, `party`, `candidiate_name`, `vote`) VALUES (null,'"+sadhasya2.getSelectedItem()+"','"+can5.getSelectedItem()+"',1)";
        String query5="INSERT INTO `votecount`(`id`, `party`, `candidiate_name`, `vote`) VALUES (null,'"+mahilasadhasya.getSelectedItem()+"','"+can6.getSelectedItem()+"',1)";
        String query6="INSERT INTO `votecount`(`id`, `party`, `candidiate_name`, `vote`) VALUES (null,'"+dalitmahila.getSelectedItem()+"','"+can7.getSelectedItem()+"',1)";
       
       try {
            pst=con.prepareStatement(query);
            PreparedStatement pst1,pst2,pst3,pst4,pst5,pst6;
            pst1=con.prepareStatement(query1);
            pst2=con.prepareStatement(query2);
            pst3=con.prepareStatement(query3);
            pst4=con.prepareStatement(query4);
            pst5=con.prepareStatement(query5);
            pst6=con.prepareStatement(query6);
            
            if(pst.execute() || pst1.execute() || pst2.execute() || pst3.execute() ||pst4.execute() || pst5.execute() ||pst6.execute()){
                
            }else{
                JOptionPane.showMessageDialog(this, "Successfully Voted ");
                rs.close();
                pst.close();
                String query7="UPDATE `voter` SET `check_voted`=0 WHERE voter_id='"+voter_id+"'";
                try {
                    pst=con.prepareStatement(query7);
                    pst.execute();
                } catch (Exception e) {
                }
                
            }
        } catch (Exception e) {
           // JOptionPane.showMessageDialog(this, e);
        }
        }
    }
    
    private boolean formValidation(){
        
       
        if(mayer.getSelectedItem().equals("Select Mayor")){
            JOptionPane.showMessageDialog(this, "Please Select Party for Mayor ","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }else if(upmayer.getSelectedItem().equals("Select Upmayor")){
            JOptionPane.showMessageDialog(this, "Please Select Party for Upmayor","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }else if(wodaadhakshay.getSelectedItem().equals("Select Ward Chairperson")){
            JOptionPane.showMessageDialog(this, "Please Select Partyfor Ward Chairperson","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }else if(sadasya1.getSelectedItem().equals("Select Member 1")){
            JOptionPane.showMessageDialog(this, "Please Select Party for Member 1","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }else if(sadhasya2.getSelectedItem().equals("Select Member 2")){
            JOptionPane.showMessageDialog(this, "Please Select Party for Member 2","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }else if(mahilasadhasya.getSelectedItem().equals("Select Female Member")){
            JOptionPane.showMessageDialog(this, "Please Select Party for Female Member","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }else if(dalitmahila.getSelectedItem().equals("Select Dalit Female Member")){
            JOptionPane.showMessageDialog(this, "Please Select Party for Dalit Female Member","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        
        else if(can1.getSelectedItem().equals("Select Candidite")){
            JOptionPane.showMessageDialog(this, "Please Select Party for Mayor ","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }else if(can2.getSelectedItem().equals("Select Candidite")){
            JOptionPane.showMessageDialog(this, "Please Select Party for Upmayor","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }else if(can3.getSelectedItem().equals("Select Candidite")){
            JOptionPane.showMessageDialog(this, "Please Select Party for Ward Chairperson","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }else if(can4.getSelectedItem().equals("Select Candidite")){
            JOptionPane.showMessageDialog(this, "Please Select Party for Member 1","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }else if(can5.getSelectedItem().equals("Select Candidite")){
            JOptionPane.showMessageDialog(this, "Please Select Party for Member 1","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }else if(can6.getSelectedItem().equals("Select Candidite")){
            JOptionPane.showMessageDialog(this, "Please Select Party for Female Member 1","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }else if(can7.getSelectedItem().equals("Select Candidite")){
            JOptionPane.showMessageDialog(this, "Please Select Party for Dalit Female Member","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        } else{
            return true;
        }
    }
   
    
    private boolean checkIdVotedOrNot(){
       String query="select * from voter where voter_id='"+voter_id+"' and check_voted=0";
       try {
           pst=con.prepareStatement(query);
           rs=pst.executeQuery();
           if(rs.next()){
               JOptionPane.showMessageDialog(this, "You are already Voted");
               return false;
               
           }else{
               return true;
               
           }
       } catch (Exception e) {
           JOptionPane.showMessageDialog(rootPane, e);
           return false;
       }
   }
    
    private void getImage(String key){
        
            //JOptionPane.showMessageDialog(rootPane, key);
        query="select I from candidiate where fullname='"+key+"'";
        try {
            pst=con.prepareStatement(query);
            rs=pst.executeQuery();
            if(rs.next()){
                byte[] imageData = rs.getBytes("pimage");
            ImageIcon format = new ImageIcon(scaledImage(imageData, image.getWidth(), image.getHeight()));
            image.setIcon(format);
            }
            
        } catch (Exception e) {
           //JOptionPane.showMessageDialog(rootPane, e);
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
            java.util.logging.Logger.getLogger(DoVotting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoVotting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoVotting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoVotting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoVotting().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> can1;
    private javax.swing.JComboBox<String> can2;
    private javax.swing.JComboBox<String> can3;
    private javax.swing.JComboBox<String> can4;
    private javax.swing.JComboBox<String> can5;
    private javax.swing.JComboBox<String> can6;
    private javax.swing.JComboBox<String> can7;
    private javax.swing.JComboBox<String> dalitmahila;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JComboBox<String> mahilasadhasya;
    private javax.swing.JComboBox<String> mayer;
    private javax.swing.JComboBox<String> sadasya1;
    private javax.swing.JComboBox<String> sadhasya2;
    private javax.swing.JComboBox<String> upmayer;
    private javax.swing.JButton vote;
    private javax.swing.JComboBox<String> wodaadhakshay;
    // End of variables declaration//GEN-END:variables
}
