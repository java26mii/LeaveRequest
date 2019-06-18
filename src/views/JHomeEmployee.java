/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.EmployeeController;
import controllers.EmployeeRoleController;
import controllers.JobController;
import controllers.LeaveRequestController;
import controllers.LeaveRequestStatusController;
import controllers.RoleController;
import icontrollers.IEmployeeController;
import icontrollers.IEmployeeRoleController;
import icontrollers.IJobController;
import icontrollers.ILeaveRequestController;
import icontrollers.ILeaveRequestStatusController;
import icontrollers.IRoleController;
import java.util.ArrayList;
import java.util.List;
import models.*;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author Arif Fridasari
 */
public class JHomeEmployee extends javax.swing.JFrame {
    SessionFactory factory = HibernateUtil.getSessionFactory();
    IEmployeeController iac = new EmployeeController(factory);
    IJobController ijc = new JobController(factory);
    ILeaveRequestController ilrc = new LeaveRequestController(factory);
    ILeaveRequestStatusController ilrsc = new LeaveRequestStatusController(factory);
    IEmployeeRoleController ierc = new EmployeeRoleController(factory);
    IRoleController irc = new RoleController(factory);
    
    public JHomeEmployee() {
        initComponents();
        EmployeeSession emps = new EmployeeSession();
        String idRole = "";
        String role = "";
        for (EmployeeRole employeeRole : ierc.search(emps.getIdEmp())) {
            role = employeeRole.getRole().getName();
        }
         
        lblGreeting.setText("Hai, "+emps.getNameEmp()+" !");
        lblUser.setText(emps.getIdEmp());
        lblUser.setVisible(false);
        
        boolean admin = false;
        boolean manager = false;
        if (role.equals("Admin")) {
            admin = true;
            manager = false;
        }else if(role.equals("Manager")){
            manager = true;
            admin = false;
        }
        
        buttonEmp.setVisible(admin);
        lblEmpMng.setVisible(admin);
        buttonManager.setVisible(manager);
        lblManager.setVisible(manager);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLHome = new javax.swing.JLayeredPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        FormRequest = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        information = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        buttonEmp = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lblGreeting = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        uploadPhoto = new javax.swing.JButton();
        lblEmpMng = new javax.swing.JLabel();
        history = new javax.swing.JButton();
        lblUser = new javax.swing.JLabel();
        lblManager = new javax.swing.JLabel();
        buttonManager = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setName("home"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1370, 1116));

        jLHome.setName("Home Leave Request"); // NOI18N
        jLHome.setPreferredSize(new java.awt.Dimension(1370, 1116));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Home ");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IconHome.png"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LogoMiiOk.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 954, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(121, 121, 121))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(153, 0, 0));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );

        FormRequest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/requestOke.png"))); // NOI18N
        FormRequest.setBorder(null);
        FormRequest.setBorderPainted(false);
        FormRequest.setContentAreaFilled(false);
        FormRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FormRequestActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("Form Request");

        information.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/informationOke.png"))); // NOI18N
        information.setBorder(null);
        information.setBorderPainted(false);
        information.setContentAreaFilled(false);
        information.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                informationActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel6.setText("Information");

        buttonEmp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/people-icon.png"))); // NOI18N
        buttonEmp.setBorder(null);
        buttonEmp.setBorderPainted(false);
        buttonEmp.setContentAreaFilled(false);
        buttonEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEmpActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setText("History");

        lblGreeting.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblGreeting.setText("Hai, User !");

        jPanel7.setBackground(new java.awt.Color(153, 0, 0));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );

        uploadPhoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconUser.png"))); // NOI18N
        uploadPhoto.setBorder(null);
        uploadPhoto.setBorderPainted(false);
        uploadPhoto.setContentAreaFilled(false);
        uploadPhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadPhotoActionPerformed(evt);
            }
        });

        lblEmpMng.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblEmpMng.setText("Employee Management");

        history.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/historyOke.png"))); // NOI18N
        history.setBorder(null);
        history.setBorderPainted(false);
        history.setContentAreaFilled(false);
        history.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historyActionPerformed(evt);
            }
        });

        lblUser.setText("id_user");
        lblUser.setEnabled(false);

        lblManager.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblManager.setText("Leave Management (Manager)");

        buttonManager.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/people-icon.png"))); // NOI18N
        buttonManager.setBorder(null);
        buttonManager.setBorderPainted(false);
        buttonManager.setContentAreaFilled(false);
        buttonManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonManagerActionPerformed(evt);
            }
        });

        jLHome.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLHome.setLayer(jPanel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLHome.setLayer(FormRequest, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLHome.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLHome.setLayer(information, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLHome.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLHome.setLayer(buttonEmp, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLHome.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLHome.setLayer(lblGreeting, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLHome.setLayer(jPanel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLHome.setLayer(uploadPhoto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLHome.setLayer(lblEmpMng, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLHome.setLayer(history, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLHome.setLayer(lblUser, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLHome.setLayer(lblManager, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLHome.setLayer(buttonManager, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLHomeLayout = new javax.swing.GroupLayout(jLHome);
        jLHome.setLayout(jLHomeLayout);
        jLHomeLayout.setHorizontalGroup(
            jLHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jLHomeLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jLHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(FormRequest)
                    .addComponent(jLabel1))
                .addGap(124, 124, 124)
                .addGroup(jLHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6)
                    .addComponent(information))
                .addGap(141, 141, 141)
                .addGroup(jLHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLHomeLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel5))
                    .addComponent(history))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jLHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLHomeLayout.createSequentialGroup()
                        .addGroup(jLHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(uploadPhoto)
                            .addComponent(lblGreeting, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLHomeLayout.createSequentialGroup()
                        .addComponent(lblUser)
                        .addGap(145, 145, 145))))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jLHomeLayout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addGroup(jLHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(buttonEmp)
                    .addComponent(lblEmpMng))
                .addGap(140, 140, 140)
                .addGroup(jLHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(buttonManager)
                    .addComponent(lblManager))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jLHomeLayout.setVerticalGroup(
            jLHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jLHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLHomeLayout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(FormRequest)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1))
                    .addGroup(jLHomeLayout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(uploadPhoto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblGreeting)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUser))
                    .addGroup(jLHomeLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101)
                        .addGroup(jLHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jLHomeLayout.createSequentialGroup()
                                .addComponent(information)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6))
                            .addGroup(jLHomeLayout.createSequentialGroup()
                                .addComponent(history)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addGroup(jLHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLHomeLayout.createSequentialGroup()
                        .addComponent(buttonEmp)
                        .addGap(18, 18, 18)
                        .addComponent(lblEmpMng))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLHomeLayout.createSequentialGroup()
                        .addComponent(buttonManager)
                        .addGap(18, 18, 18)
                        .addComponent(lblManager)))
                .addGap(64, 64, 64)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLHome, javax.swing.GroupLayout.PREFERRED_SIZE, 1395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLHome, javax.swing.GroupLayout.PREFERRED_SIZE, 938, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FormRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FormRequestActionPerformed
        JIRequestForm jIRequestForm = new JIRequestForm();
        this.jLHome.add(jIRequestForm);
        jIRequestForm.show();
    }//GEN-LAST:event_FormRequestActionPerformed

    private void informationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_informationActionPerformed
        String ide = lblUser.getText();
        Employee employee = iac.getById(ide);
        List<Job> jobs = new ArrayList();
        jobs = ijc.search(ide);
        String jobName = "";
        for (Job job : jobs) {
            jobName = job.getName();
        }
        String id = String.valueOf(employee.getId());
        String firstName = employee.getFirstName();
        String lastName = employee.getLastName();
        String email = employee.getEmail();
        String phoneNumber = String.valueOf("0" + employee.getPhoneNumber());
        String manager = String.valueOf(employee.getManager().getFirstName() + " " + employee.getManager().getLastName());
        String job = jobName;
        JIInformation jIInformation = new JIInformation(id, firstName, lastName, email, phoneNumber, manager, job);
        this.jLHome.add(jIInformation);
        jIInformation.show();
    }//GEN-LAST:event_informationActionPerformed

    private void buttonEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEmpActionPerformed
        JIEmployee jIEmployee = new JIEmployee();
        this.jLHome.add(jIEmployee);
        jIEmployee.show();
    }//GEN-LAST:event_buttonEmpActionPerformed

    private void uploadPhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadPhotoActionPerformed
        JIUploadFoto jIUploadFoto = new JIUploadFoto();
        this.jLHome.add(jIUploadFoto);
        jIUploadFoto.show();
    }//GEN-LAST:event_uploadPhotoActionPerformed

    private void historyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyActionPerformed
        JIHistory jIHistory = new JIHistory();
        this.jLHome.add(jIHistory);
        jIHistory.show();
    }//GEN-LAST:event_historyActionPerformed

    private void buttonManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonManagerActionPerformed
        String id = lblUser.getText();
        Employee employee = iac.getById(id);
        String name = employee.getFirstName()+" "+employee.getLastName();
        JHomeManager jHomeManager = new JHomeManager(id, name);
        jHomeManager.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonManagerActionPerformed

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
            java.util.logging.Logger.getLogger(JHomeEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JHomeEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JHomeEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JHomeEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JHomeEmployee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton FormRequest;
    private javax.swing.JButton buttonEmp;
    private javax.swing.JButton buttonManager;
    private javax.swing.JButton history;
    private javax.swing.JButton information;
    private javax.swing.JLayeredPane jLHome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lblEmpMng;
    private javax.swing.JLabel lblGreeting;
    private javax.swing.JLabel lblManager;
    private javax.swing.JLabel lblUser;
    private javax.swing.JButton uploadPhoto;
    // End of variables declaration//GEN-END:variables
}
