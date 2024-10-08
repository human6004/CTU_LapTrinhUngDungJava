/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.myctu.javaswingmvccrudphamcuong.view;

import com.myctu.javaswingmvccrudphamcuong.controller.ProductController;
import com.myctu.javaswingmvccrudphamcuong.model.Product;
import com.myctu.javaswingmvccrudphamcuong.model.ProductDAO;
import com.myctu.javaswingmvccrudphamcuong.model.ProductTableModel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

/*import com.myctu.javaswingmvccrudphamcuong.model.Product;
import com.myctu.javaswingmvccrudphamcuong.model.ProductDAO_Demo;*/
/**
 *
 * @author ASUS
 */
public class ProductView extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public ProductView() {
        initComponents();
        customizeTableRendering(); // Gọi phương thức để tùy chỉnh bảng
//        run();
    }

    private void customizeTableRendering() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        // Căn giữa cho cột ID (cột đầu tiên)
        tbProduct.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

        // Căn giữa cho cột Số lượng (cột thứ ba)
        tbProduct.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

        tbProduct.getColumnModel().getColumn(0).setPreferredWidth(50);  // ID column (nhỏ lại)
        tbProduct.getColumnModel().getColumn(1).setPreferredWidth(150); // Product Name column
        tbProduct.getColumnModel().getColumn(2).setPreferredWidth(100); // Quantity column
    }

    private boolean validateProductData(String name, int quantity) {
        if (name.length() == 0 || quantity == 0) {
            return false;
        }
        return true;
    }

    //ĐỌC DỮ LIỆU TỪ TEXTFIELD  
    public Product getProductData() {
        int id = 0;
        try {
            id = Integer.parseInt(tfId.getText());
        } catch (NumberFormatException numberFormatException) {
            System.out.println("null id");
        }

        String name = tfProductName.getText();
        int quantity = 0;
        try {
            quantity = Integer.parseInt(tfQuantity.getText());
        } catch (NumberFormatException numberFormatException) {
        }
        
        //Check input
        if(!validateProductData(name, quantity)){
            JOptionPane.showMessageDialog(rootPane, "Invalid information <!>");
            return  null;
        }
        Product newProduct = new Product(id, name, quantity);

        return newProduct;
    }

    public void showListProduct(List<Product> products) {
        tableModel.setData(products);
    }
    
    public void fillInputForm(){
        int row = tbProduct.getSelectedRow();
        
        if(row >= 0){
            tfId.setText(tbProduct.getValueAt(row, 0).toString());
            tfProductName.setText(tbProduct.getValueAt(row, 1).toString());
            tfQuantity.setText(tbProduct.getValueAt(row, 2).toString());
        }
    }
    
//    private void run (){
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//        setVisible(true);
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnRecord = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lbId = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        lbProductName = new javax.swing.JLabel();
        tfProductName = new javax.swing.JTextField();
        lbQuantity = new javax.swing.JLabel();
        tfQuantity = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProduct = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel2.add(btnAdd);

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel2.add(btnEdit);

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel2.add(btnDelete);

        btnRecord.setText("Record");
        btnRecord.setEnabled(false);
        jPanel2.add(btnRecord);

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancel);

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        jPanel2.add(btnRefresh);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel3.setLayout(new java.awt.GridLayout(3, 2, 5, 5));

        lbId.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbId.setText("ID");
        jPanel3.add(lbId);

        tfId.setEnabled(false);
        tfId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdActionPerformed(evt);
            }
        });
        jPanel3.add(tfId);

        lbProductName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbProductName.setText("Product Name");
        jPanel3.add(lbProductName);

        tfProductName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfProductNameActionPerformed(evt);
            }
        });
        jPanel3.add(tfProductName);

        lbQuantity.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbQuantity.setText("Quantity");
        jPanel3.add(lbQuantity);

        tfQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfQuantityActionPerformed(evt);
            }
        });
        jPanel3.add(tfQuantity);

        jPanel1.add(jPanel3, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        tbProduct.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tableModel = new ProductTableModel();
        tbProduct.setModel(tableModel);
        tbProduct.setShowGrid(true);
        jScrollPane1.setViewportView(tbProduct);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
//        try {
//            // TODO add your handling code here:
//            System.out.println("add");
//            ProductDAO productDAO = new ProductDAO();
//            List<Product> products = productDAO.getListProducts();
//
//            System.out.println("Products loaded: " + products.size());  // In ra số lượng sản phẩm đã tải
//
//            tableModel.setData(products);
//        } catch (SQLException ex) {
//            Logger.getLogger(ProductView.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:      
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tfIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdActionPerformed

    private void tfProductNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfProductNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfProductNameActionPerformed

    private void tfQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfQuantityActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
//        // TODO add your handling code here:
//        int id = Integer.parseInt(tfId.getText());
//        String name = tfProductName.getText();
//        int quantity = Integer.parseInt(tfQuantity.getText());
//        Product updateProduct = new Product(id, name, quantity);
//        ProductDAO_Demo updateProductDAO = new ProductDAO_Demo();
//        updateProductDAO.edit(updateProduct);   
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRefreshActionPerformed

    public void addAddProductListener(ActionListener listener) {
        btnAdd.addActionListener(listener);
    }

    public void addTableSelecctionListener(ListSelectionListener listener){
        tbProduct.getSelectionModel().addListSelectionListener(listener);
    }
    
    public void addEditProductListener(ActionListener listener){
        btnEdit.addActionListener(listener);
    }
    
    public void addDeleteProductListener(ActionListener listener){
        btnDelete.addActionListener(listener);
    }
    
    public void addRefreshProductListener(ActionListener listener){
        btnRefresh.addActionListener(listener);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRecord;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbId;
    private javax.swing.JLabel lbProductName;
    private javax.swing.JLabel lbQuantity;
    private javax.swing.JTable tbProduct;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfProductName;
    private javax.swing.JTextField tfQuantity;
    // End of variables declaration//GEN-END:variables
    private ProductTableModel tableModel;
}
