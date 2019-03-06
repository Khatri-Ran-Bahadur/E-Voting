/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.voting.candidiate;

import e.voting.DbConnect;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class AddCandidiate extends javax.swing.JFrame {
    private int can_id=0; 
    private static AddCandidiate obj=null;
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    String query=null;
    
    public AddCandidiate() {       
        init();   
        btnupdate.setEnabled(false);
    }
     public AddCandidiate(int id) {
        init();
        can_id=id;
        save.setEnabled(false);
        btnupdate.setEnabled(true);
        Update(id);
                
    }
     private void init(){
         initComponents();
         con = DbConnect.DbConnect();
         setLocationRelativeTo(null);
         setTitle("Add Candidiate");
         setResizable(false);
         fillAddressDefault();
         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

         
     }
     public static AddCandidiate getObj(){
         if(obj==null){
             obj=new AddCandidiate();
         }return obj;
     }
     
     private void fillAddressDefault(){
        district.removeAllItems();
        muncipality.removeAllItems();
        post.removeAllItems();
        party.removeAllItems();
        district.addItem("Select District");
        muncipality.addItem("Select Muncipality/VDC");
        post.addItem("Select Post");
        party.addItem("Select Party");
        query="select * from district";
        try {
            pst=con.prepareStatement(query);
            rs=pst.executeQuery();
            while(rs.next()){
                district.addItem(rs.getString("districtname"));
            }
        } catch (Exception e) {
        }
        String query1="select * from muncipality";
        try {
            pst=con.prepareStatement(query1);
            rs=pst.executeQuery();
            while(rs.next()){
                muncipality.addItem(rs.getString("muncipalityname"));
            }
        } catch (Exception e) {
        }
        String postquery="select * from post";
         try {
             pst=con.prepareStatement(postquery);
            rs=pst.executeQuery();
            while(rs.next()){
                post.addItem(rs.getString("post"));
            }
         } catch (Exception e) {
             JOptionPane.showMessageDialog(rootPane, e);
         }
         String partyquery="select * from party";
         try {
             pst=con.prepareStatement(partyquery);
            rs=pst.executeQuery();
            while(rs.next()){
                party.addItem(rs.getString("name"));
            }
         } catch (Exception e) {
             JOptionPane.showMessageDialog(rootPane, e);
         }
    }
    private void fillAddress(String key){
       district.removeAllItems();
        district.addItem("Select District");
        query="SELECT district.districtname FROM district INNER JOIN pardesh ON pardesh.id = district.pardesh_id where pname='"+key+"'";
        try {
            pst=con.prepareStatement(query);
            rs=pst.executeQuery();
            while(rs.next()){
               
                district.addItem(rs.getString("district.districtname"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    
     private void formValidation(){
        if(txtfullname.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Please fill Full Name","Error",JOptionPane.ERROR_MESSAGE);
        }else if(party.getSelectedItem().equals("Select Party")){
            JOptionPane.showMessageDialog(this, "Please Select Country","Error",JOptionPane.ERROR_MESSAGE);
        }else if(post.getSelectedItem().equals("Select Post")){
            JOptionPane.showMessageDialog(this, "Please Select Country","Error",JOptionPane.ERROR_MESSAGE);
        }else if(country.getSelectedItem().equals("Select Country")){
            JOptionPane.showMessageDialog(this, "Please Select Country","Error",JOptionPane.ERROR_MESSAGE);
        }
        else if(pardesh.getSelectedItem().equals("Select Pardesh")){
            JOptionPane.showMessageDialog(this, "Please Select Pardesh","Error",JOptionPane.ERROR_MESSAGE);
        }else if(district.getSelectedItem().equals("Select District")){
            JOptionPane.showMessageDialog(this, "Please Select District","Error",JOptionPane.ERROR_MESSAGE);
        }else if(muncipality.getSelectedItem().equals("Select Muncipality")){
            JOptionPane.showMessageDialog(this, "Please Select Muncipality","Error",JOptionPane.ERROR_MESSAGE);
        }else if(wodano.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Please Fill the Woda No","Error",JOptionPane.ERROR_MESSAGE);
        }
            
        
    }
     

     public void Update(int id){
         query="select * from candidiate where id="+id;
        
        try {
            pst=con.prepareStatement(query);
           
            rs=pst.executeQuery();
            if(rs.next()){
                can_id=rs.getInt("id");
                txtfullname.setText(rs.getString("fullname"));
                
                String dateValue = rs.getString("dob");
                java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateValue);

                dob.setDate(date);
                if(rs.getString("gender").equals("Male")){
                    male.setSelected(true);
                    female.setSelected(false);
                }else{
                    female.setSelected(true);
                    male.setSelected(false);
                }
                country.setSelectedIndex(0);
                pardesh.setSelectedIndex(0);
                district.setSelectedIndex(0);
                muncipality.setSelectedIndex(0);
                
                 wodano.setText(rs.getString("oda"));
                 if(rs.getString("status").equals("Active")){
                    active.setSelected(true);
                    inactive.setSelected(false);
                }else{
                    inactive.setSelected(true);
                    active.setSelected(false);
                }
                byte[] imageData = rs.getBytes("pimage");
                ImageIcon format = new ImageIcon(scaledImage(imageData, image.getWidth(), image.getHeight()));
                image.setIcon(format);
                country.setSelectedIndex(1);
                pardesh.setSelectedIndex(1);
                
                save.setEnabled(false);
                btnupdate.setEnabled(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
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
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtfullname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        dob = new com.toedter.calendar.JDateChooser();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        wodano = new javax.swing.JTextField();
        district = new javax.swing.JComboBox<>();
        muncipality = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        path = new javax.swing.JTextField();
        btnupload = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        save = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        pardesh = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        country = new javax.swing.JComboBox<>();
        party = new javax.swing.JComboBox<>();
        post = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        active = new javax.swing.JRadioButton();
        inactive = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Add Candidite");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(364, 364, 364)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtfullname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfullnameActionPerformed(evt);
            }
        });
        jPanel2.add(txtfullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 160, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("  Full Name:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 10, 90, 25));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Date Of Birth:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, 25));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("   Gender:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 77, 25));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Party:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 50, 25));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("  Post:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 50, 25));
        jPanel2.add(dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 115, 30));

        male.setText("Male");
        male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleActionPerformed(evt);
            }
        });
        jPanel2.add(male, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 63, -1));

        female.setText("Female");
        female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleActionPerformed(evt);
            }
        });
        jPanel2.add(female, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Status:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, 60, 25));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Country:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 11, 74, 25));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("District:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 85, 60, 25));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Muncipality/VDC");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(329, 136, 122, 25));

        wodano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wodanoActionPerformed(evt);
            }
        });
        jPanel2.add(wodano, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 168, 60, 25));

        district.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                districtItemStateChanged(evt);
            }
        });
        district.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                districtActionPerformed(evt);
            }
        });
        jPanel2.add(district, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 84, 130, 30));

        jPanel2.add(muncipality, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 129, 130, 32));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(image, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(614, 11, 210, 170));

        path.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pathActionPerformed(evt);
            }
        });
        jPanel2.add(path, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 190, 130, 30));

        btnupload.setBackground(new java.awt.Color(255, 255, 0));
        btnupload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Save_Icon-24.png"))); // NOI18N
        btnupload.setText("upload");
        btnupload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnuploadActionPerformed(evt);
            }
        });
        jPanel2.add(btnupload, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 190, 90, -1));

        btnNew.setBackground(new java.awt.Color(255, 255, 51));
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/163_plus_add_new-20.png"))); // NOI18N
        btnNew.setText("New Add");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        jPanel2.add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, -1, 38));

        btnView.setBackground(new java.awt.Color(255, 255, 0));
        btnView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/073_view_show-20.png"))); // NOI18N
        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        jPanel2.add(btnView, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 80, 38));

        save.setBackground(new java.awt.Color(255, 255, 51));
        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Save_Icon-24.png"))); // NOI18N
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jPanel2.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, 90, 39));

        btnClear.setBackground(new java.awt.Color(255, 255, 51));
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/831-20.png"))); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel2.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, 90, 39));

        btnupdate.setBackground(new java.awt.Color(255, 255, 0));
        btnupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/document-20.png"))); // NOI18N
        btnupdate.setText("Update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        jPanel2.add(btnupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 320, -1, 39));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Pardesh:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 45, 74, 25));

        pardesh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Pardesh", "Koshi Pradesh", "Madhesh Pradesh", "Bagmati Pradesh", "Gandaki Pradesh", "Lumbini Pradesh", "Karnali Pradesh" }));
        pardesh.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                pardeshItemStateChanged(evt);
            }
        });
        jPanel2.add(pardesh, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 46, 130, 32));

        jPanel4.setBackground(new java.awt.Color(0, 51, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 5, 300));

        jPanel5.setBackground(new java.awt.Color(51, 51, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 850, 10));

        jPanel6.setBackground(new java.awt.Color(0, 0, 204));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 310, 10, 60));

        jPanel7.setBackground(new java.awt.Color(0, 0, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 310, 10, 60));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel15.setText("Please All Field are required and Image is Also Upload thank you");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, 390, 30));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/download.jpg"))); // NOI18N
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 120, 60));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/download.jpg"))); // NOI18N
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 310, 100, 60));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/download.jpg"))); // NOI18N
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 120, 60));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/calm-reflective-water-background_bjnehswwh__F0000.png"))); // NOI18N
        jLabel19.setText("jLabel19");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 304, 630, 70));

        country.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Country", "Nepal", "India", "US", "Germany", "China", "Hongkong", "Bhutan", "Pakistan", "Afaganistan", " " }));
        jPanel2.add(country, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 10, 130, 30));

        party.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(party, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 160, 30));

        post.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(post, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 160, 30));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("Woda No:");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 166, 84, 25));

        active.setText("Active");
        active.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activeActionPerformed(evt);
            }
        });
        jPanel2.add(active, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, 63, -1));

        inactive.setText("Inactive");
        inactive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inactiveActionPerformed(evt);
            }
        });
        jPanel2.add(inactive, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtfullnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfullnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfullnameActionPerformed

    private void maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleActionPerformed
        female.setSelected(false);
    }//GEN-LAST:event_maleActionPerformed

    private void femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleActionPerformed
        male.setSelected(false);
    }//GEN-LAST:event_femaleActionPerformed

    private void wodanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wodanoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wodanoActionPerformed

    private void districtItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_districtItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_districtItemStateChanged

    private void districtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_districtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_districtActionPerformed

    private void pathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pathActionPerformed

    private void btnuploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnuploadActionPerformed
        JFileChooser chooser=new JFileChooser();
        chooser.showOpenDialog(null);
        File f= chooser.getSelectedFile();
        fileName=f.getAbsolutePath();
        path.setText(fileName);
        try {
            FileInputStream fis = new FileInputStream(f);
            ByteArrayOutputStream bAOS = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bAOS.write(buf, 0, readNum);
            }
            personImg = bAOS.toByteArray();
            byte[] citizone = personImg;
            ImageIcon formats = new ImageIcon(scaledImage(citizone, image.getWidth(), image.getHeight()));
            image.setIcon(formats);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnuploadActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        
        txtfullname.setText("");
        
        wodano.setText("");
        male.setSelected(false);
        female.setSelected(false);
        country.setSelectedIndex(0);
        post.setSelectedIndex(0);
        party.setSelectedIndex(0);
        save.setEnabled(true);
        btnupdate.setEnabled(false);
        
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        this.hide();
        CandidiateInfo obj=new CandidiateInfo();
        obj.setVisible(true);
    }//GEN-LAST:event_btnViewActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        formValidation();
        query="INSERT INTO `candidiate`(`id`, `fullname`, `dob`, `gender`, `country`, `pardesh`, `district`, `nagarpalika`, `oda`, `post`,"
                + " `party`, `pimage`, `status`) VALUES (null,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
            String date = dcn.format(dob.getDate() );
            
            pst=con.prepareStatement(query);
            pst.setString(1, txtfullname.getText());
            
            pst.setString(2, date);

            if(male.isSelected()){
                pst.setString(3, "Male");
            }else if(female.isSelected()){
                pst.setString(3, "Female");
            }else{
                JOptionPane.showMessageDialog(this, "Please select gender","Error",JOptionPane.ERROR_MESSAGE);
            }

            pst.setString(4, (String) country.getSelectedItem());
            pst.setString(5, (String) pardesh.getSelectedItem() );
            pst.setString(6, (String) district.getSelectedItem());
            pst.setString(7, (String) muncipality.getSelectedItem());
            pst.setString(8, wodano.getText());
            pst.setString(9, (String) post.getSelectedItem());
            pst.setString(10, (String) party.getSelectedItem());
            pst.setBytes(11,personImg);
            if(active.isSelected()){
                pst.setString(12, "Active");
            }else if(inactive.isSelected()){
                pst.setString(12, "Inactive");
            }else{
                
                JOptionPane.showMessageDialog(this, "Please select Status","Error",JOptionPane.ERROR_MESSAGE);
            }
            
            if(pst.execute()){
                JOptionPane.showMessageDialog(this, "Not Registered");
            }else{
                rs.close();
                pst.close();
                save.setEnabled(false);
                btnupdate.setEnabled(true);                
                JOptionPane.showMessageDialog(this, "candidiate Registered");
                String setidquery="select * from `candidiate` fname='"+txtfullname.getText()+"'";
                try {
                    pst=con.prepareStatement(query);
                    rs=pst.executeQuery();
                    if(rs.next()){
                        can_id=rs.getInt("id");
                    }
                } catch (Exception e) {
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_saveActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtfullname.setText("");
        
        wodano.setText("");
        male.setSelected(false);
        female.setSelected(false);
        country.setSelectedIndex(0);
        post.setSelectedIndex(0);
        party.setSelectedIndex(0);
        save.setEnabled(true);
        btnupdate.setEnabled(false);
        

    }//GEN-LAST:event_btnClearActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        formValidation();
        query="UPDATE `candidiate` SET `fullname`=?,`dob`=?,`gender`=?,`country`=?,`pardesh`=?,"
                + "`district`=?,`nagarpalika`=?,`oda`=?,`post`=?,`party`=?,`pimage`=?,`status`=? WHERE id="+can_id;
        try {
            SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
            String date = dcn.format(dob.getDate() );
            
            pst=con.prepareStatement(query);
            pst.setString(1, txtfullname.getText());
           
            pst.setString(2, date);

            if(male.isSelected()){
                pst.setString(3, "Male");
            }else if(female.isSelected()){
                pst.setString(3, "Female");
            }else{
                JOptionPane.showMessageDialog(this, "Please select gender","Error",JOptionPane.ERROR_MESSAGE);
            }

            pst.setString(4, (String) country.getSelectedItem());
            pst.setString(5, (String) pardesh.getSelectedItem() );
            pst.setString(6, (String) district.getSelectedItem());
            pst.setString(7, (String) muncipality.getSelectedItem());
            pst.setString(8, wodano.getText());
            pst.setString(9, (String) post.getSelectedItem());
            pst.setString(10, (String) party.getSelectedItem());
            pst.setBytes(11,personImg);
            if(active.isSelected()){
                pst.setString(12, "Active");
            }else if(inactive.isSelected()){
                pst.setString(12, "Inactive");
            }else{
                
                JOptionPane.showMessageDialog(this, "Please select Status","Error",JOptionPane.ERROR_MESSAGE);
            }
            
            if(pst.execute()){
                JOptionPane.showMessageDialog(this, "Not Updated!");
            }else{
                save.setEnabled(false);
                btnupdate.setEnabled(true);
                JOptionPane.showMessageDialog(this, "candidiate Updated Successfully!");

            }

        } catch (Exception e) {
        }

    }//GEN-LAST:event_btnupdateActionPerformed

    private void pardeshItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_pardeshItemStateChanged
        String key=(String) pardesh.getSelectedItem();

        if(pardesh.getSelectedItem().equals("Koshi Pradesh")){
            fillAddress(key);
        }else if(pardesh.getSelectedItem().equals("Madhesh Pradesh")){
            fillAddress(key);
        }
        else if(pardesh.getSelectedItem().equals("Bagmati Pradesh")){
            fillAddress(key);
        }
        else if(pardesh.getSelectedItem().equals("Gandaki Pradesh")){
            fillAddress(key);
        }
        else if(pardesh.getSelectedItem().equals("Lumbini Pradesh")){
            fillAddress(key);
        }
        else if(pardesh.getSelectedItem().equals("Karnali Pradesh")){
            fillAddress(key);
        }
        else if(pardesh.getSelectedItem().equals("Sudur Paschim Pradesh")){
            fillAddress(key);
        }
        else{
            fillAddress("");
        }

    }//GEN-LAST:event_pardeshItemStateChanged

    private void activeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activeActionPerformed
        inactive.setSelected(false);
    }//GEN-LAST:event_activeActionPerformed

    private void inactiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inactiveActionPerformed
        active.setSelected(false);
    }//GEN-LAST:event_inactiveActionPerformed
   
  
     
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
            java.util.logging.Logger.getLogger(AddCandidiate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddCandidiate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddCandidiate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCandidiate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddCandidiate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton active;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnView;
    private javax.swing.JButton btnupdate;
    private javax.swing.JButton btnupload;
    private javax.swing.JComboBox<String> country;
    private javax.swing.JComboBox<String> district;
    private com.toedter.calendar.JDateChooser dob;
    private javax.swing.JRadioButton female;
    private javax.swing.JLabel image;
    private javax.swing.JRadioButton inactive;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JRadioButton male;
    private javax.swing.JComboBox<String> muncipality;
    private javax.swing.JComboBox<String> pardesh;
    private javax.swing.JComboBox<String> party;
    private javax.swing.JTextField path;
    private javax.swing.JComboBox<String> post;
    private javax.swing.JButton save;
    private javax.swing.JTextField txtfullname;
    private javax.swing.JTextField wodano;
    // End of variables declaration//GEN-END:variables

    
    String fileName=null;
    int s=0;
    
    private String filePath = null;
    private byte[] personImg = null;
    
}
