/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de7_CLIENT;

import de7_server.SVFILE;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zLittleMasterz
 */
public class PNLFILE extends javax.swing.JPanel {

    private SVFILE file;
    private Color selectedColor = new Color(233,237,232);
    private Color normalColor = new Color(255,255,255);
    private Color enterColor = new Color(244,244,244);
    CLIENT clientForm;
    
    public PNLFILE(SVFILE svfile, CLIENT clientForm) {
        initComponents();
        this.file = svfile;
        this.clientForm = clientForm;

        lblName.setText(this.file.getName());
        if (this.file.getType() == 1) {
            lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de7_CLIENT/icons/fileIcon.png")));
        }
        if (this.file.getType() == 3) {
            lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de7_CLIENT/icons/diskIcon.png")));       
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

        lblIcon = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();

        setBackground(new java.awt.Color(244, 244, 244));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        setPreferredSize(new java.awt.Dimension(600, 50));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });

        lblIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de7_CLIENT/icons/folderIcon.png"))); // NOI18N

        lblName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblName.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        this.setBackground(enterColor);
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        this.setBackground(normalColor);
    }//GEN-LAST:event_formMouseExited

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

        if (evt.getClickCount() == 2 && evt.getButton() == MouseEvent.BUTTON1) {
            clientForm.setTxtPathURL(file.getAbsolutePath());
            try {
                clientForm.search();
            } catch (RemoteException ex) {
                Logger.getLogger(PNLFILE.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.clientForm.settxtBoxChiTiet(this);
    }//GEN-LAST:event_formMouseClicked

    public String getType() {
        if (this.file.getType()==1) {
            return "Tệp tin";
        }
        return "Thư mục";
    }

    public String getAbsolutePath() {
        return file.getAbsolutePath();
    }

    public String getName() {
        try {
            return file.getName();
        } catch (Exception e) {
        }
        return "none";
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblName;
    // End of variables declaration//GEN-END:variables
}
