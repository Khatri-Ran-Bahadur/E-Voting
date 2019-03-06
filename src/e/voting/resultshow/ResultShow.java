/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.voting.resultshow;

import e.voting.DbConnect;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ResultShow extends javax.swing.JFrame {
    private String mysql;
    private PreparedStatement pst;
    private Connection con = null;
    private ResultSet rs = null;
    private static ResultShow obj=null;
    String query=null;
    /**
     * Creates new form ResultShow
     */
    public ResultShow() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        con=DbConnect.DbConnect();
        mayor();
        upmayor();
        adhakshay();
        member1();
        member2();
        mahila();
        dalit();
        
    }
   
    public static ResultShow getObj(){
        if(obj==null){
            obj=new ResultShow();

        }return obj;
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
    
     private void mayor(){
         query="SELECT\n" +
"candidiate.post,\n" +
"candidiate.fullname,\n" +
"candidiate.party,\n" +
"candidiate.pimage,\n" +
"COUNT(votecount.vote)\n" +
"FROM\n" +
"candidiate\n" +
"INNER JOIN votecount ON votecount.party = candidiate.party AND votecount.candidiate_name = candidiate.fullname Where candidiate.post='Mayor' ORDER BY votecount.candidiate_name";
         System.err.println(query);
         
         try {
             pst=con.prepareStatement(query);
             rs=pst.executeQuery();
             if(rs.next()){
                 mayername.setText(rs.getString("candidiate.fullname"));
                 mparty.setText(rs.getString("candidiate.party"));
                 mtotal.setText(rs.getString("COUNT(votecount.vote)"));
                 byte[] imageData = rs.getBytes("candidiate.pimage");
            ImageIcon format = new ImageIcon(scaledImage(imageData, mimage.getWidth(), mimage.getHeight()));
            mimage.setIcon(format);
             }
         } catch (Exception e) {
             JOptionPane.showMessageDialog(rootPane, e);
         }
     }
     private void upmayor(){
         query="SELECT\n" +
"candidiate.post,\n" +
"candidiate.fullname,\n" +
"candidiate.party,\n" +
"candidiate.pimage,\n" +
"COUNT(votecount.vote)\n" +
"FROM\n" +
"candidiate\n" +
"INNER JOIN votecount ON votecount.party = candidiate.party AND votecount.candidiate_name = candidiate.fullname Where candidiate.post='Upmayor' ORDER BY votecount.candidiate_name";
         System.err.println(query);
         
         try {
             pst=con.prepareStatement(query);
             rs=pst.executeQuery();
             if(rs.next()){
                 uname.setText(rs.getString("candidiate.fullname"));
                 uparty.setText(rs.getString("candidiate.party"));
                 utotal.setText(rs.getString("COUNT(votecount.vote)"));
                 byte[] imageData = rs.getBytes("candidiate.pimage");
            ImageIcon format = new ImageIcon(scaledImage(imageData, uimage.getWidth(), uimage.getHeight()));
            uimage.setIcon(format);
             }
         } catch (Exception e) {
             JOptionPane.showMessageDialog(rootPane, e);
         }
     }
     private void adhakshay(){
         query="SELECT\n" +
"candidiate.post,\n" +
"candidiate.fullname,\n" +
"candidiate.party,\n" +
"candidiate.pimage,\n" +
"COUNT(votecount.vote)\n" +
"FROM\n" +
"candidiate\n" +
"INNER JOIN votecount ON votecount.party = candidiate.party AND votecount.candidiate_name = candidiate.fullname Where candidiate.post='Ward Chairperson' ORDER BY votecount.candidiate_name";
         System.err.println(query);
         
         try {
             pst=con.prepareStatement(query);
             rs=pst.executeQuery();
             if(rs.next()){
                 wname.setText(rs.getString("candidiate.fullname"));
                 wparty.setText(rs.getString("candidiate.party"));
                 wtotal.setText(rs.getString("COUNT(votecount.vote)"));
                 byte[] imageData = rs.getBytes("candidiate.pimage");
            ImageIcon format = new ImageIcon(scaledImage(imageData, wimage.getWidth(), wimage.getHeight()));
            wimage.setIcon(format);
             }
         } catch (Exception e) {
             JOptionPane.showMessageDialog(rootPane, e);
         }
     }
     private void member1(){
         query="SELECT\n" +
"candidiate.post,\n" +
"candidiate.fullname,\n" +
"candidiate.party,\n" +
"candidiate.pimage,\n" +
"COUNT(votecount.vote)\n" +
"FROM\n" +
"candidiate\n" +
"INNER JOIN votecount ON votecount.party = candidiate.party AND votecount.candidiate_name = candidiate.fullname Where candidiate.post='Member 1' ORDER BY votecount.candidiate_name";
         System.err.println(query);
         
         try {
             pst=con.prepareStatement(query);
             rs=pst.executeQuery();
             if(rs.next()){
                 m1name.setText(rs.getString("candidiate.fullname"));
                 m1party.setText(rs.getString("candidiate.party"));
                 m1total.setText(rs.getString("COUNT(votecount.vote)"));
                 byte[] imageData = rs.getBytes("candidiate.pimage");
            ImageIcon format = new ImageIcon(scaledImage(imageData, meimage.getWidth(), meimage.getHeight()));
            meimage.setIcon(format);
             }
         } catch (Exception e) {
             JOptionPane.showMessageDialog(rootPane, e);
         }
     }
    private void member2(){
        query="SELECT\n" +
"candidiate.post,\n" +
"candidiate.fullname,\n" +
"candidiate.party,\n" +
"candidiate.pimage,\n" +
"COUNT(votecount.vote)\n" +
"FROM\n" +
"candidiate\n" +
"INNER JOIN votecount ON votecount.party = candidiate.party AND votecount.candidiate_name = candidiate.fullname Where candidiate.post='Member 2' ORDER BY votecount.candidiate_name";
         System.err.println(query);
         
         try {
             pst=con.prepareStatement(query);
             rs=pst.executeQuery();
             if(rs.next()){
                 m2name.setText(rs.getString("candidiate.fullname"));
                 m2party.setText(rs.getString("candidiate.party"));
                 m2total.setText(rs.getString("COUNT(votecount.vote)"));
                 byte[] imageData = rs.getBytes("candidiate.pimage");
            ImageIcon format = new ImageIcon(scaledImage(imageData, m2eimage.getWidth(), m2eimage.getHeight()));
            m2eimage.setIcon(format);
             }
         } catch (Exception e) {
             JOptionPane.showMessageDialog(rootPane, e);
         }
    }
    private void mahila(){
        query="SELECT\n" +
"candidiate.post,\n" +
"candidiate.fullname,\n" +
"candidiate.party,\n" +
"candidiate.pimage,\n" +
"COUNT(votecount.vote)\n" +
"FROM\n" +
"candidiate\n" +
"INNER JOIN votecount ON votecount.party = candidiate.party AND votecount.candidiate_name = candidiate.fullname Where candidiate.post='Female Member' ORDER BY votecount.candidiate_name";
         System.err.println(query);
         
         try {
             pst=con.prepareStatement(query);
             rs=pst.executeQuery();
             if(rs.next()){
                 f1name.setText(rs.getString("candidiate.fullname"));
                 f1party.setText(rs.getString("candidiate.party"));
                 f1total.setText(rs.getString("COUNT(votecount.vote)"));
                 byte[] imageData = rs.getBytes("candidiate.pimage");
            ImageIcon format = new ImageIcon(scaledImage(imageData, feimage.getWidth(), feimage.getHeight()));
            feimage.setIcon(format);
             }
         } catch (Exception e) {
             JOptionPane.showMessageDialog(rootPane, e);
         }
    }
    private void dalit(){
        query="SELECT\n" +
"candidiate.post,\n" +
"candidiate.fullname,\n" +
"candidiate.party,\n" +
"candidiate.pimage,\n" +
"COUNT(votecount.vote)\n" +
"FROM\n" +
"candidiate\n" +
"INNER JOIN votecount ON votecount.party = candidiate.party AND votecount.candidiate_name = candidiate.fullname Where candidiate.post='Dalit Female Member' ORDER BY votecount.candidiate_name";
         System.err.println(query);
         
         try {
             pst=con.prepareStatement(query);
             rs=pst.executeQuery();
             if(rs.next()){
                 f2name.setText(rs.getString("candidiate.fullname"));
                 f2party.setText(rs.getString("candidiate.party"));
                 f2total.setText(rs.getString("COUNT(votecount.vote)"));
                 byte[] imageData = rs.getBytes("candidiate.pimage");
            ImageIcon format = new ImageIcon(scaledImage(imageData, f2image.getWidth(), f2image.getHeight()));
            fe2image.setIcon(format);
             }
         } catch (Exception e) {
             JOptionPane.showMessageDialog(rootPane, e);
         }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        mimage = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        uimage = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        wimage = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        m1image = new javax.swing.JPanel();
        meimage = new javax.swing.JLabel();
        m2image = new javax.swing.JPanel();
        m2eimage = new javax.swing.JLabel();
        f1image = new javax.swing.JPanel();
        feimage = new javax.swing.JLabel();
        f2image = new javax.swing.JPanel();
        fe2image = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        uname = new javax.swing.JLabel();
        wtotal = new javax.swing.JLabel();
        mparty = new javax.swing.JLabel();
        mtotal = new javax.swing.JLabel();
        utotal = new javax.swing.JLabel();
        mayername = new javax.swing.JLabel();
        uparty = new javax.swing.JLabel();
        wparty = new javax.swing.JLabel();
        wname = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        m2total = new javax.swing.JLabel();
        f1total = new javax.swing.JLabel();
        f2total = new javax.swing.JLabel();
        m1total = new javax.swing.JLabel();
        m1name = new javax.swing.JLabel();
        m1party = new javax.swing.JLabel();
        m2party = new javax.swing.JLabel();
        m2name = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        f1party = new javax.swing.JLabel();
        f1name = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        f2party = new javax.swing.JLabel();
        f2name = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel6.setBackground(new java.awt.Color(0, 102, 204));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 51, 255));

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel35.setText("Winner Candidiates");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(381, 381, 381)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(452, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 0, 1050, 50));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 10, 450));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Wodachairperson:");
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Total Vote:");
        jPanel6.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 90, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Upmayor:");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Member 1");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText(" Name:");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 60, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Party:");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, -1, -1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(mimage, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mimage, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 170, 130));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText(" Name:");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 530, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Party:");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 410, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Total Vote:");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 450, 90, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Name:");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Party:");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Total Vote:");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 90, -1));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(uimage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(uimage, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 170, 130));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(wimage, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(wimage, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 170, 140));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Mayor:");
        jPanel6.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Female Member 1");
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 350, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Female Member 2");
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 500, -1, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setText("Party:");
        jPanel6.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setText("Total Vote:");
        jPanel6.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 90, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setText(" Name:");
        jPanel6.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, -1, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setText("Party:");
        jPanel6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, -1, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel26.setText("Total Vote:");
        jPanel6.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 90, -1));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel28.setText(" Name:");
        jPanel6.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 380, -1, -1));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel29.setText("Party:");
        jPanel6.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 570, -1, -1));

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel30.setText("Party:");
        jPanel6.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 260, -1, -1));

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel31.setText("Total Vote:");
        jPanel6.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 610, 90, -1));

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel32.setText("Total Vote:");
        jPanel6.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 300, 90, -1));

        javax.swing.GroupLayout m1imageLayout = new javax.swing.GroupLayout(m1image);
        m1image.setLayout(m1imageLayout);
        m1imageLayout.setHorizontalGroup(
            m1imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(meimage, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        m1imageLayout.setVerticalGroup(
            m1imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(meimage, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );

        jPanel6.add(m1image, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 60, 160, 140));

        javax.swing.GroupLayout m2imageLayout = new javax.swing.GroupLayout(m2image);
        m2image.setLayout(m2imageLayout);
        m2imageLayout.setHorizontalGroup(
            m2imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(m2eimage, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        m2imageLayout.setVerticalGroup(
            m2imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(m2eimage, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );

        jPanel6.add(m2image, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 220, 160, 130));

        javax.swing.GroupLayout f1imageLayout = new javax.swing.GroupLayout(f1image);
        f1image.setLayout(f1imageLayout);
        f1imageLayout.setHorizontalGroup(
            f1imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(feimage, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        f1imageLayout.setVerticalGroup(
            f1imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(feimage, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );

        jPanel6.add(f1image, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 360, 160, 130));

        javax.swing.GroupLayout f2imageLayout = new javax.swing.GroupLayout(f2image);
        f2image.setLayout(f2imageLayout);
        f2imageLayout.setHorizontalGroup(
            f2imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fe2image, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        f2imageLayout.setVerticalGroup(
            f2imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fe2image, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );

        jPanel6.add(f2image, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 500, 160, 140));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 530, 10));

        jPanel12.setBackground(new java.awt.Color(0, 204, 0));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setText("Name:");
        jPanel12.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        uname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        uname.setText("jLabel38");
        jPanel12.add(uname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 180, 30));

        wtotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        wtotal.setText("jLabel38");
        jPanel12.add(wtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 170, 30));

        mparty.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mparty.setText("jLabel38");
        jPanel12.add(mparty, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 180, 30));

        mtotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mtotal.setText("jLabel38");
        jPanel12.add(mtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 180, 30));

        utotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        utotal.setText("jLabel38");
        jPanel12.add(utotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 180, 30));

        mayername.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mayername.setText("jLabel38");
        jPanel12.add(mayername, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 180, 30));

        uparty.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        uparty.setText("jLabel38");
        jPanel12.add(uparty, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 180, 30));

        wparty.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        wparty.setText("jLabel38");
        jPanel12.add(wparty, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 170, 30));

        wname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        wname.setText("jLabel38");
        jPanel12.add(wname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 170, 30));

        jPanel6.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 320, 430));

        jPanel13.setBackground(new java.awt.Color(0, 204, 0));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        m2total.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        m2total.setText("jLabel38");
        jPanel13.add(m2total, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 130, 30));

        f1total.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        f1total.setText("jLabel38");
        jPanel13.add(f1total, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, 130, 30));

        f2total.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        f2total.setText("jLabel38");
        jPanel13.add(f2total, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 560, 130, 30));

        m1total.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        m1total.setText("jLabel38");
        jPanel13.add(m1total, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 130, 30));

        m1name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        m1name.setText("jLabel38");
        jPanel13.add(m1name, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 130, 30));

        m1party.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        m1party.setText("jLabel38");
        jPanel13.add(m1party, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 130, 30));

        m2party.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        m2party.setText("jLabel38");
        jPanel13.add(m2party, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 130, 30));

        m2name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        m2name.setText("jLabel38");
        jPanel13.add(m2name, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 167, 130, 30));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel27.setText(" Name:");
        jPanel13.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, -1, -1));

        f1party.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        f1party.setText("jLabel38");
        jPanel13.add(f1party, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 130, 30));

        f1name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        f1name.setText("jLabel38");
        jPanel13.add(f1name, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 130, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Member 1");
        jPanel13.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        f2party.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        f2party.setText("jLabel38");
        jPanel13.add(f2party, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 520, 130, 30));

        f2name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        f2name.setText("jLabel38");
        jPanel13.add(f2name, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 477, 130, 30));

        jPanel6.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 320, 600));

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/shutterstock_234376006-500x315.jpg"))); // NOI18N
        jPanel6.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 500, 140));

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/shutterstock_234376006-500x315.jpg"))); // NOI18N
        jPanel6.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 500, 140));

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel36.setText("Name:");
        jPanel6.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel37.setText("Name:");
        jPanel6.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ResultShow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResultShow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResultShow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResultShow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResultShow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel f1image;
    private javax.swing.JLabel f1name;
    private javax.swing.JLabel f1party;
    private javax.swing.JLabel f1total;
    private javax.swing.JPanel f2image;
    private javax.swing.JLabel f2name;
    private javax.swing.JLabel f2party;
    private javax.swing.JLabel f2total;
    private javax.swing.JLabel fe2image;
    private javax.swing.JLabel feimage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel m1image;
    private javax.swing.JLabel m1name;
    private javax.swing.JLabel m1party;
    private javax.swing.JLabel m1total;
    private javax.swing.JLabel m2eimage;
    private javax.swing.JPanel m2image;
    private javax.swing.JLabel m2name;
    private javax.swing.JLabel m2party;
    private javax.swing.JLabel m2total;
    private javax.swing.JLabel mayername;
    private javax.swing.JLabel meimage;
    private javax.swing.JLabel mimage;
    private javax.swing.JLabel mparty;
    private javax.swing.JLabel mtotal;
    private javax.swing.JLabel uimage;
    private javax.swing.JLabel uname;
    private javax.swing.JLabel uparty;
    private javax.swing.JLabel utotal;
    private javax.swing.JLabel wimage;
    private javax.swing.JLabel wname;
    private javax.swing.JLabel wparty;
    private javax.swing.JLabel wtotal;
    // End of variables declaration//GEN-END:variables
}
