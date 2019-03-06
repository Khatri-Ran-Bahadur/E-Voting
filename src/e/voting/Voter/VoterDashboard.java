/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package e.voting.Voter;

import DoVotting.DoVotting;
import e.voting.DbConnect;
import e.voting.Login;
import e.voting.resultshow.ResultShow;
import java.io.IOException;
import static java.lang.Thread.sleep;
import javax.swing.JOptionPane;

import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class VoterDashboard extends javax.swing.JFrame {

    
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    
   String voter_id=null;
   
    public VoterDashboard() {
        init();
    }
     public VoterDashboard(String id) {
        init();
        this.voter_id=id;
        //JOptionPane.showMessageDialog(this, id);
        
    }
    private void init(){
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Voting Dashboard");
        setLocationRelativeTo(null);
        con=DbConnect.DbConnect();
        Clock();
        
    }
    private void Clock(){
        Thread clock=new Thread(){
          public void run(){
            try {
                for(;;){
                Calendar cal = new GregorianCalendar();
        
                int day = cal.get(Calendar.DAY_OF_MONTH);
                int month = cal.get(Calendar.MONTH);
                int year = cal.get(Calendar.YEAR);
                date.setText("Current Date:" + day + "/" + (month + 1) + "/" + year);
                //time.setForeground(Color.White);

                int second = cal.get(Calendar.SECOND);
                int minute = cal.get(Calendar.MINUTE);
                int hour = cal.get(Calendar.HOUR);
                time.setText("Current Time:" + hour + ":" + minute + ":" + second);
              sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
          }
        };
        clock.start();
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jButton7 = new javax.swing.JButton();
        toolCandidiae = new javax.swing.JButton();
        manageAdmin = new javax.swing.JButton();
        manageVoter = new javax.swing.JButton();
        barResult = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        toolShowProfile = new javax.swing.JButton();
        btnvote = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        time = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        exitmenu = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        caninfo = new javax.swing.JMenuItem();
        manageCanMenu = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        toolAddparty = new javax.swing.JMenuItem();
        toolmanagePart = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        toolAddPost = new javax.swing.JMenuItem();
        toolManagePost = new javax.swing.JMenuItem();
        vote = new javax.swing.JMenu();
        votetool = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        viewResultMenu = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        onlinehelp = new javax.swing.JMenuItem();
        offlinehelp = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setBackground(new java.awt.Color(255, 204, 255));
        jToolBar1.setRollover(true);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/001_home-32.png"))); // NOI18N
        jButton7.setText("Home");
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton7);

        toolCandidiae.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/073_view_show-32.png"))); // NOI18N
        toolCandidiae.setText("Candidiate Information");
        toolCandidiae.setFocusable(false);
        toolCandidiae.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        toolCandidiae.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolCandidiae.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toolCandidiaeActionPerformed(evt);
            }
        });
        jToolBar1.add(toolCandidiae);

        manageAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/server-32.png"))); // NOI18N
        manageAdmin.setText("Party Information");
        manageAdmin.setFocusable(false);
        manageAdmin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        manageAdmin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        manageAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageAdminActionPerformed(evt);
            }
        });
        jToolBar1.add(manageAdmin);

        manageVoter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/server-32.png"))); // NOI18N
        manageVoter.setText("Post Information");
        manageVoter.setFocusable(false);
        manageVoter.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        manageVoter.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        manageVoter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageVoterActionPerformed(evt);
            }
        });
        jToolBar1.add(manageVoter);

        barResult.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/server-32.png"))); // NOI18N
        barResult.setText("Result");
        barResult.setFocusable(false);
        barResult.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        barResult.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barResultActionPerformed(evt);
            }
        });
        jToolBar1.add(barResult);

        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/49-32.png"))); // NOI18N
        logout.setText("Logout");
        logout.setFocusable(false);
        logout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        logout.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        jToolBar1.add(logout);

        toolShowProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/025 (1).png"))); // NOI18N
        toolShowProfile.setText("Profiles");
        toolShowProfile.setFocusable(false);
        toolShowProfile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        toolShowProfile.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolShowProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toolShowProfileActionPerformed(evt);
            }
        });
        jToolBar1.add(toolShowProfile);

        btnvote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Vote-32.png"))); // NOI18N
        btnvote.setText("Vote");
        btnvote.setFocusable(false);
        btnvote.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnvote.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnvote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvoteActionPerformed(evt);
            }
        });
        jToolBar1.add(btnvote);

        jPanel1.setBackground(new java.awt.Color(102, 255, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        time.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        time.setText("jLabel1");
        jPanel1.add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 60, 220, 50));

        date.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        date.setText("jLabel1");
        jPanel1.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 0, 220, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Electronic Voting");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, 280, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/people-give-vote-raise-his-hand-blue-background-illustration-67261399.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1300, 500));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/people-give-vote-raise-his-hand-blue-background-illustration-67261399.jpg"))); // NOI18N
        jLabel3.setText("jLabel2");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 500));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/people-give-vote-raise-his-hand-blue-background-illustration-67261399.jpg"))); // NOI18N
        jLabel4.setText("jLabel2");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 1300, 500));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/people-give-vote-raise-his-hand-blue-background-illustration-67261399.jpg"))); // NOI18N
        jLabel5.setText("jLabel2");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 1300, 500));

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/163_plus_add_new-20.png"))); // NOI18N
        jMenuItem1.setText("open");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Save");
        jMenu1.add(jMenuItem2);

        exitmenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        exitmenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/010_x-3-20.png"))); // NOI18N
        exitmenu.setText("Exit");
        exitmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitmenuActionPerformed(evt);
            }
        });
        jMenu1.add(exitmenu);

        jMenuBar1.add(jMenu1);

        jMenu5.setText("Candidiate Information");

        caninfo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        caninfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/UI_Blue_2_of_3_1-20.png"))); // NOI18N
        caninfo.setText("Create");
        caninfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caninfoActionPerformed(evt);
            }
        });
        jMenu5.add(caninfo);

        manageCanMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/server-20.png"))); // NOI18N
        manageCanMenu.setText("Manage");
        manageCanMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageCanMenuActionPerformed(evt);
            }
        });
        jMenu5.add(manageCanMenu);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Party Information");

        toolAddparty.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/163_plus_add_new-20.png"))); // NOI18N
        toolAddparty.setText("Add");
        toolAddparty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toolAddpartyActionPerformed(evt);
            }
        });
        jMenu6.add(toolAddparty);

        toolmanagePart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/business_corporate_group_office-36-24.png"))); // NOI18N
        toolmanagePart.setText("Manage");
        toolmanagePart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toolmanagePartActionPerformed(evt);
            }
        });
        jMenu6.add(toolmanagePart);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Post Informatio");

        toolAddPost.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/163_plus_add_new-20.png"))); // NOI18N
        toolAddPost.setText("Create");
        toolAddPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toolAddPostActionPerformed(evt);
            }
        });
        jMenu7.add(toolAddPost);

        toolManagePost.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/business_corporate_group_office-36-24.png"))); // NOI18N
        toolManagePost.setText("Information");
        toolManagePost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toolManagePostActionPerformed(evt);
            }
        });
        jMenu7.add(toolManagePost);

        jMenuBar1.add(jMenu7);

        vote.setText("Vote");
        vote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voteActionPerformed(evt);
            }
        });

        votetool.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Vote-20.png"))); // NOI18N
        votetool.setText("Vote");
        votetool.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                votetoolActionPerformed(evt);
            }
        });
        vote.add(votetool);

        jMenuBar1.add(vote);

        jMenu9.setText("Result");

        viewResultMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        viewResultMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/073_view_show-20.png"))); // NOI18N
        viewResultMenu.setText("View");
        viewResultMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewResultMenuActionPerformed(evt);
            }
        });
        jMenu9.add(viewResultMenu);

        jMenuBar1.add(jMenu9);

        jMenu3.setText("Help");

        onlinehelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/011 (3).png"))); // NOI18N
        onlinehelp.setText("Online Help");
        onlinehelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onlinehelpActionPerformed(evt);
            }
        });
        jMenu3.add(onlinehelp);

        offlinehelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/025 (3).png"))); // NOI18N
        offlinehelp.setText("Offline Help");
        offlinehelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                offlinehelpActionPerformed(evt);
            }
        });
        jMenu3.add(offlinehelp);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1348, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitmenuActionPerformed
        int c=JOptionPane.showConfirmDialog(this, "Do you really want to close ?","Message",JOptionPane.YES_NO_OPTION);
        if(c==0){
            setVisible(false);
        }
    }//GEN-LAST:event_exitmenuActionPerformed

    private void caninfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caninfoActionPerformed
        
    }//GEN-LAST:event_caninfoActionPerformed

    private void manageCanMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageCanMenuActionPerformed
        
    }//GEN-LAST:event_manageCanMenuActionPerformed

    private void toolAddpartyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolAddpartyActionPerformed
       
    }//GEN-LAST:event_toolAddpartyActionPerformed

    private void toolmanagePartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolmanagePartActionPerformed
        
    }//GEN-LAST:event_toolmanagePartActionPerformed

    private void toolAddPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolAddPostActionPerformed
        
    }//GEN-LAST:event_toolAddPostActionPerformed

    private void toolManagePostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolManagePostActionPerformed
       
    }//GEN-LAST:event_toolManagePostActionPerformed

    private void viewResultMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewResultMenuActionPerformed
        ResultShow.getObj().setVisible(true);
    }//GEN-LAST:event_viewResultMenuActionPerformed

    private void toolCandidiaeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolCandidiaeActionPerformed
        
    }//GEN-LAST:event_toolCandidiaeActionPerformed

    private void manageAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageAdminActionPerformed
       
    }//GEN-LAST:event_manageAdminActionPerformed

    private void manageVoterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageVoterActionPerformed
        VoterInformation.getObj().setVisible(true);
    }//GEN-LAST:event_manageVoterActionPerformed

    private void barResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barResultActionPerformed
        ResultShow.getObj().setVisible(true);
    }//GEN-LAST:event_barResultActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        int c=JOptionPane.showConfirmDialog(this, "Do you really want to Log Out ?","Message",JOptionPane.YES_NO_OPTION);
        if(c==0){
            setVisible(false);
            Login obj=new Login();
            obj.setVisible(true);
        }
    }//GEN-LAST:event_logoutActionPerformed

    private void toolShowProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolShowProfileActionPerformed
        
    }//GEN-LAST:event_toolShowProfileActionPerformed

    private void btnvoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvoteActionPerformed
        
       if(checkIdVotedOrNot()==true){
            DoVotting obj=new DoVotting(voter_id);
            obj.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "You are already Votted!");
        }
    }//GEN-LAST:event_btnvoteActionPerformed

    private void voteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voteActionPerformed
      
    }//GEN-LAST:event_voteActionPerformed

    private void votetoolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_votetoolActionPerformed
        if(checkIdVotedOrNot()==true){
            DoVotting obj=new DoVotting(voter_id);
            obj.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "You are already Votted!");
        }
    }//GEN-LAST:event_votetoolActionPerformed

    private void offlinehelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_offlinehelpActionPerformed
         try {
            Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "File\\About.pdf");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error Opening File!!");
        }
    }//GEN-LAST:event_offlinehelpActionPerformed

    private void onlinehelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onlinehelpActionPerformed
        try {
            // TODO add your handling code here:
            String url = "https://www.youtube.com/channel/UCdPK2jZJA2pR_6tl9m-kKCw?sub_confirmation=1";
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
    }//GEN-LAST:event_onlinehelpActionPerformed

   private boolean checkIdVotedOrNot(){
       String query="select * from voter where voter_id='"+voter_id+"' and check_voted=0";
       try {
           pst=con.prepareStatement(query);
           rs=pst.executeQuery();
           if(rs.next()){
               return false;
               
           }else{
               return true;
               
           }
       } catch (Exception e) {
           JOptionPane.showMessageDialog(rootPane, e);
           return false;
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
            java.util.logging.Logger.getLogger(VoterDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VoterDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VoterDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VoterDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VoterDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton barResult;
    private javax.swing.JButton btnvote;
    private javax.swing.JMenuItem caninfo;
    private javax.swing.JLabel date;
    private javax.swing.JMenuItem exitmenu;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton logout;
    private javax.swing.JButton manageAdmin;
    private javax.swing.JMenuItem manageCanMenu;
    private javax.swing.JButton manageVoter;
    private javax.swing.JMenuItem offlinehelp;
    private javax.swing.JMenuItem onlinehelp;
    private javax.swing.JLabel time;
    private javax.swing.JMenuItem toolAddPost;
    private javax.swing.JMenuItem toolAddparty;
    private javax.swing.JButton toolCandidiae;
    private javax.swing.JMenuItem toolManagePost;
    private javax.swing.JButton toolShowProfile;
    private javax.swing.JMenuItem toolmanagePart;
    private javax.swing.JMenuItem viewResultMenu;
    private javax.swing.JMenu vote;
    private javax.swing.JMenuItem votetool;
    // End of variables declaration//GEN-END:variables

}
