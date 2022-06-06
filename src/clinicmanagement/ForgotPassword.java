/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package clinicmanagement;

import static clinicmanagement.ClinicManagement.cipher;
import static clinicmanagement.ClinicManagement.decrypt;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

/**
 *
 * @author ASUS
 */
public class ForgotPassword extends javax.swing.JDialog {

    private static String CMND = "";
    String encodedKey = "1v9BaydNlB2uI58JTO4HlQ==";
    static Cipher cipher;

    public ForgotPassword(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

    }

    public String EncryptPassword(String s) throws Exception {
        byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
        SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
        cipher = Cipher.getInstance("AES");
        return encrypt(s, originalKey);
    }

    public ForgotPassword(java.awt.Frame parent, boolean modal, String TaiKhoan) {
        super(parent, modal);
        initComponents();
        CMND = TaiKhoan;
        MatKhau.setText("Mật khẩu mới");
        NhapLaiMatKhau.setText("Nhập lại mật khẩu");
        MatKhau.setEchoChar((char) 0);
        NhapLaiMatKhau.setEchoChar((char) 0);
        MatKhau.setForeground(new Color(153, 153, 153));
        NhapLaiMatKhau.setForeground(new Color(153, 153, 153));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        RetriveData();
    }

    public static String encrypt(String plainText, SecretKey secretKey)
            throws Exception {
        byte[] plainTextByte = plainText.getBytes();
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedByte = cipher.doFinal(plainTextByte);
        Base64.Encoder encoder = Base64.getEncoder();
        String encryptedText = encoder.encodeToString(encryptedByte);
        return encryptedText;
    }

    private void RetriveData() {
        jLabel1.setText(CMND);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Email = new customview.PlaceholderTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        MatKhau = new javax.swing.JPasswordField();
        NhapLaiMatKhau = new javax.swing.JPasswordField();
        ThayDoi = new javax.swing.JButton();
        BackGround = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 498));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Email.setToolTipText("");
        Email.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Email.setPlaceholder("Email");
        getContentPane().add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 320, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Tài khoản: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 0));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, -1, -1));

        MatKhau.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        MatKhau.setText("Mật khẩu");
        MatKhau.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                MatKhauFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                MatKhauFocusLost(evt);
            }
        });
        getContentPane().add(MatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 320, -1));

        NhapLaiMatKhau.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        NhapLaiMatKhau.setText("Mật khẩu");
        NhapLaiMatKhau.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                NhapLaiMatKhauFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                NhapLaiMatKhauFocusLost(evt);
            }
        });
        getContentPane().add(NhapLaiMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 320, -1));

        ThayDoi.setBackground(new java.awt.Color(239, 132, 83));
        ThayDoi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ThayDoi.setForeground(new java.awt.Color(240, 240, 240));
        ThayDoi.setText("Đổi Mật Khẩu");
        ThayDoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ThayDoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ThayDoiMouseClicked(evt);
            }
        });
        ThayDoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThayDoiActionPerformed(evt);
            }
        });
        getContentPane().add(ThayDoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 360, 140, 40));

        BackGround.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BackGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/277314017_1607857956260423_4203521708542983050_n.png"))); // NOI18N
        BackGround.setMaximumSize(new java.awt.Dimension(800, 535));
        BackGround.setMinimumSize(new java.awt.Dimension(800, 535));
        BackGround.setPreferredSize(new java.awt.Dimension(800, 535));
        getContentPane().add(BackGround, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -100, 1240, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MatKhauFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MatKhauFocusGained

        MatKhau.setEchoChar('\u25CF');
        String password = String.valueOf(MatKhau.getPassword());
        if (password.equals("Mật khẩu mới")) {
            MatKhau.setText("");
            MatKhau.setForeground(Color.black);
        }
    }//GEN-LAST:event_MatKhauFocusGained

    private void MatKhauFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MatKhauFocusLost
        String password = String.valueOf(MatKhau.getPassword());

        if (password.equals("password") || password.toLowerCase().equals("")) {
            MatKhau.setText("Mật khẩu mới");
            MatKhau.setEchoChar((char) 0);
            MatKhau.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_MatKhauFocusLost

    private void NhapLaiMatKhauFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NhapLaiMatKhauFocusGained
        NhapLaiMatKhau.setEchoChar('\u25CF');
        String password = String.valueOf(NhapLaiMatKhau.getPassword());
        if (password.equals("Nhập lại mật khẩu")) {
            NhapLaiMatKhau.setText("");
            NhapLaiMatKhau.setForeground(Color.black);
        }
    }//GEN-LAST:event_NhapLaiMatKhauFocusGained

    private void NhapLaiMatKhauFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NhapLaiMatKhauFocusLost
        String password = String.valueOf(MatKhau.getPassword());

        if (password.equals("password") || password.toLowerCase().equals("")) {
            NhapLaiMatKhau.setText("Nhập lại mật khẩu");
            NhapLaiMatKhau.setEchoChar((char) 0);
        }

    }//GEN-LAST:event_NhapLaiMatKhauFocusLost

    private void ThayDoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThayDoiMouseClicked

    }//GEN-LAST:event_ThayDoiMouseClicked

    private void ThayDoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThayDoiActionPerformed
        try {
            DatabaseConnection DTBC = new DatabaseConnection();
            Connection conn = DTBC.getConnection(this);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT Email FROM NHANVIEN "
                    + "WHERE CMND = '" + CMND + "'");
            if (rs.next()) {
                String SQLEmail = rs.getString("Email");
                if (SQLEmail == null ? Email.getText() == null : SQLEmail.equals(Email.getText())) {
                    if (String.valueOf(MatKhau.getPassword()) == null ? String.valueOf(NhapLaiMatKhau.getPassword()) == null : String.valueOf(MatKhau.getPassword()).equals(String.valueOf(NhapLaiMatKhau.getPassword()))) {
                        try {
                            String ep = EncryptPassword(String.valueOf(MatKhau.getPassword()));
                            stm.execute("UPDATE NHANVIEN SET Matkhau = '" + ep + "' WHERE CMND = '" + CMND + "'");
                            JOptionPane.showMessageDialog(this, "Đã đổi mật khẩu thành công");
                            this.dispose();
                            ClinicManagement cm = new ClinicManagement();
                            cm.setVisible(true);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(this, ex.toString(), "Lỗi kết nối cơ sở dữ liệu", ERROR_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Sai Email", "Lỗi kết nối cơ sở dữ liệu", ERROR_MESSAGE);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Lỗi kết nối cơ sở dữ liệu", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ThayDoiActionPerformed

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
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ForgotPassword dialog = new ForgotPassword(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackGround;
    private customview.PlaceholderTextField Email;
    private javax.swing.JPasswordField MatKhau;
    private javax.swing.JPasswordField NhapLaiMatKhau;
    private javax.swing.JButton ThayDoi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
