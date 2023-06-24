/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package clinicmanagement;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.WindowConstants;

/**
 *
 * @author Dell
 */
public class ThemCD extends javax.swing.JDialog {

    private static String CMND = "";
    public ThemCD(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
    }
    public ThemCD(java.awt.Frame parent, boolean modal, String CMND) {
        super(parent, modal);
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        this.CMND = CMND;
        getContentPane().setBackground(Color.white);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LUU = new javax.swing.JButton();
        TROLAI = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ten = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        LUU.setBackground(new java.awt.Color(255, 204, 204));
        LUU.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        LUU.setForeground(new java.awt.Color(0, 99, 28));
        LUU.setText("Lưu");
        LUU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LUUMouseClicked(evt);
            }
        });

        TROLAI.setBackground(new java.awt.Color(255, 204, 204));
        TROLAI.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        TROLAI.setForeground(new java.awt.Color(0, 99, 28));
        TROLAI.setText("Quay lại");
        TROLAI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TROLAIMouseClicked(evt);
            }
        });
        TROLAI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TROLAIActionPerformed(evt);
            }
        });

        ten.setColumns(20);
        ten.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ten.setRows(5);
        jScrollPane1.setViewportView(ten);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("THÊM CÁCH DÙNG");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(LUU, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TROLAI)
                .addGap(66, 66, 66))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LUU)
                    .addComponent(TROLAI))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public int LUU()throws SQLException{
        DatabaseConnection DTBC = new DatabaseConnection();
        Connection conn = DTBC.getConnection(this);
        Statement stm = conn.createStatement();
        
        
        String tencd = ten.getText();
        ResultSet rs = stm.executeQuery("SELECT TenCachDung from CACHDUNG   ");
        boolean kt = false;
        int socd = 0;
        while(rs.next()){
            if(rs.getString("TenCachDung").equals(tencd)) kt =true;
            socd++;
        }
        String macd = "CD" + String.valueOf(socd+1);
        rs = stm.executeQuery("SELECT MaCachDung from CACHDUNG   ");
        while(rs.next()){
            if(rs.getString("MaCachDung").equals(macd)) {
                socd++;
                macd = "CD" + String.valueOf(socd+1);
            }            
        }
        if(!kt) stm.executeUpdate("INSERT INTO CACHDUNG  VALUES ( N'" + macd +"',N'" + tencd +  "');");
        else {
            JOptionPane.showMessageDialog(this, "Cách dùng này đã có", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return 0;
        }
        stm.close();
        conn.close();
        return 1;
    }
    private void LUUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LUUMouseClicked
        try
        {
            if(LUU()==1) JOptionPane.showMessageDialog(this, "bạn đã lưu thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new DanhSachCachDung(CMND).setVisible(true);
                }
            });
            this.dispose();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(this, e.toString(), "Lỗi kết nối cơ sở dữ liệu", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_LUUMouseClicked

    private void TROLAIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TROLAIMouseClicked
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DanhSachCachDung dialog = new DanhSachCachDung(CMND);
                dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                for (WindowListener wl : dialog.getWindowListeners()) {
                    dialog.removeWindowListener(wl);
                }
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                        dialog.dispose();
                        MedicineUsageManagement frame = new MedicineUsageManagement(CMND);
                        frame.setVisible(true);
                    }
                });
                dialog.setVisible(true);
            }
        });
        this.dispose();
    }//GEN-LAST:event_TROLAIMouseClicked

    private void TROLAIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TROLAIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TROLAIActionPerformed

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
            java.util.logging.Logger.getLogger(ThemCD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemCD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemCD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemCD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ThemCD dialog = new ThemCD(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton LUU;
    private javax.swing.JButton TROLAI;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea ten;
    // End of variables declaration//GEN-END:variables
}
