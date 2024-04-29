/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codefier;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import codefier.DatabaseConnection;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;




/**
 *
 * @author User
 */
public class menu extends javax.swing.JFrame {
    
    private Connection connection;
    
    DefaultTableModel tableModel;
    CardLayout cardLayout;

    /**
     * Creates new form menu
     */
    public menu() {
        initComponents();
        
        //dES
        int D;
        
        connection = DatabaseConnection.getConnection();
        
        
       
        cardLayout = (CardLayout)(pnlcards.getLayout());
        
        
       
    
        tableModel = new DefaultTableModel(
            new Object [][] {
                {null, null}, // Initial row
            },
            new String [] {
                "POD NO.", "Remark"
            }
        );
        addtable = new JTable(tableModel);
        
        //addtable designs
        addtable.getTableHeader().setReorderingAllowed(false);
        addtable.setIntercellSpacing(new Dimension(0, 0)); // Example setting, adjust as needed
        addtable.setRowHeight(25); // Example setting, adjust as needed
        addtable.setSelectionBackground(new Color(255, 255, 153));
        // Add the addtable to the JScrollPane
        jScrollPane1.setViewportView(addtable);

        // Add a TableModelListener to addtable
        // Add a TableModelListener to handle both row addition and empty row removal
        tableModel.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                // Remove the listener temporarily to prevent recursion
                tableModel.removeTableModelListener(this);

                // Check if the last row is reached
                if ((e.getLastRow() + 1) == tableModel.getRowCount()) {
                    Object[] emptyRowData = new Object[tableModel.getColumnCount()]; // Create an array with size equal to the number of columns
                    tableModel.addRow(emptyRowData);
                }

                // Re-add the listener
                tableModel.addTableModelListener(this);
            }


//        tableModel.addTableModelListener(new TableModelListener() {
//            @Override
//            public void tableChanged(TableModelEvent e) {
//                // Check if the last row is being edited (for row addition)
//                if (e.getType() == TableModelEvent.UPDATE && e.getLastRow() == tableModel.getRowCount() - 1) {
//                    int firstCol = 0; // Index of the first column
//                    int lastRow = tableModel.getRowCount() - 1;
//                    // Check if the first column of the last row is filled
//                    if (tableModel.getValueAt(lastRow, firstCol) != null && !tableModel.getValueAt(lastRow, firstCol).toString().isEmpty()) {
//                        // Add a new row
//                        Object[] rowData = {null, null}; // Adjust as per your column count and data types
//                        tableModel.addRow(rowData);
//                    }
//                }
//                // Check if the table model has changed due to cell editing (for empty row removal)
//                if (e.getType() == TableModelEvent.UPDATE) {
//                    int rowCount = tableModel.getRowCount();
//                    // Iterate through each row except the last one
//                    for (int i = 0; i < rowCount - 1; i++) {
//                        // Check if the row is empty
//                        boolean isEmpty = true;
//                        for (int j = 0; j < tableModel.getColumnCount(); j++) {
//                            Object value = tableModel.getValueAt(i, j);
//                            if (value != null && !value.toString().isEmpty()) {
//                                isEmpty = false;
//                                break;
//                            }
//                        }
//                        // If the row is empty, remove it
//                        if (isEmpty) {
//                            tableModel.removeRow(i);
//                            // Decrement the row count and index to adjust for the removed row
//                            rowCount--;
//                            i--;
//                        }
//                    }
//                }
//            }
//        });
//
//        
//        addtable.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//                    int lastColumn = addtable.getColumnCount() - 1;
//                    int currentRow = addtable.getSelectedRow();
//                    int currentColumn = addtable.getSelectedColumn();
//
//                    if (currentColumn == lastColumn) {
//                        // Check if we are in the last row
//                        if (currentRow < addtable.getRowCount() - 1) {
//                            // Move selection to the first column of the next row
//                            addtable.changeSelection(currentRow + 1, 0, false, false);
//                            // Request focus for the first column of the next row
//                            addtable.requestFocusInWindow();
//                            addtable.editCellAt(currentRow + 1, 0);
//                        } else {
//                            // Add a new row
//                            Object[] rowData = {null, null}; // Adjust as per your column count and data types
//                            tableModel.addRow(rowData);
//
//                            // Move selection to the first column of the new row
//                            addtable.changeSelection(currentRow + 1, 0, false, false);
//                            // Request focus for the first column of the new row
//                            addtable.requestFocusInWindow();
//                            addtable.editCellAt(currentRow + 1, 0);
//                        }
//                        e.consume(); // Consume the Enter key event
//                    }
//                }
//            }
        });
//        
        



    }
    @Override
    public void dispose() {
        super.dispose();
        DatabaseConnection.closeConnection();
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
        jButton3 = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        pnlcards = new javax.swing.JPanel();
        AddPOPnl = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        addtable = new javax.swing.JTable();
        addposavebtn = new javax.swing.JButton();
        addpoclearbtn = new javax.swing.JButton();
        POListPnl = new javax.swing.JPanel();
        HistoryPnl = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jButton3.setText("jButton1");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jButton1.setText("Add PO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("PO List");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("History");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(jButton1)
                .addGap(30, 30, 30)
                .addComponent(jButton2)
                .addGap(29, 29, 29)
                .addComponent(jButton4)
                .addContainerGap(206, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jPanel2);

        pnlcards.setLayout(new java.awt.CardLayout());

        AddPOPnl.setBackground(new java.awt.Color(204, 204, 204));

        addtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "", "POD NO.", "Remark"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        addtable.setRowHeight(25);
        addtable.setSelectionBackground(new java.awt.Color(255, 255, 153));
        addtable.getTableHeader().setReorderingAllowed(false);
        addtable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                addtableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(addtable);

        addposavebtn.setText("Save");
        addposavebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addposavebtnActionPerformed(evt);
            }
        });

        addpoclearbtn.setText("Clear");
        addpoclearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addpoclearbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AddPOPnlLayout = new javax.swing.GroupLayout(AddPOPnl);
        AddPOPnl.setLayout(AddPOPnlLayout);
        AddPOPnlLayout.setHorizontalGroup(
            AddPOPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddPOPnlLayout.createSequentialGroup()
                .addGroup(AddPOPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddPOPnlLayout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(addpoclearbtn)
                        .addGap(129, 129, 129)
                        .addComponent(addposavebtn))
                    .addGroup(AddPOPnlLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        AddPOPnlLayout.setVerticalGroup(
            AddPOPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddPOPnlLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AddPOPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addposavebtn)
                    .addComponent(addpoclearbtn))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pnlcards.add(AddPOPnl, "card2");

        POListPnl.setBackground(new java.awt.Color(255, 153, 204));
        POListPnl.setName(""); // NOI18N

        javax.swing.GroupLayout POListPnlLayout = new javax.swing.GroupLayout(POListPnl);
        POListPnl.setLayout(POListPnlLayout);
        POListPnlLayout.setHorizontalGroup(
            POListPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );
        POListPnlLayout.setVerticalGroup(
            POListPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 475, Short.MAX_VALUE)
        );

        pnlcards.add(POListPnl, "card3");

        HistoryPnl.setBackground(new java.awt.Color(153, 255, 153));

        javax.swing.GroupLayout HistoryPnlLayout = new javax.swing.GroupLayout(HistoryPnl);
        HistoryPnl.setLayout(HistoryPnlLayout);
        HistoryPnlLayout.setHorizontalGroup(
            HistoryPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );
        HistoryPnlLayout.setVerticalGroup(
            HistoryPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 475, Short.MAX_VALUE)
        );

        pnlcards.add(HistoryPnl, "card4");

        jSplitPane1.setRightComponent(pnlcards);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        cardLayout.show(pnlcards, "card2");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        cardLayout.show(pnlcards, "card3");
        System.out.println("Whyy");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        cardLayout.show(pnlcards, "card4");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void addtableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addtableKeyPressed
       
    }//GEN-LAST:event_addtableKeyPressed

    private void addpoclearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addpoclearbtnActionPerformed
        tableModel.setRowCount(0); // Clear all existing rows
        tableModel.setRowCount(2);

    }//GEN-LAST:event_addpoclearbtnActionPerformed

    private void addposavebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addposavebtnActionPerformed
        Date currentDate = new Date();
        Timestamp timestamp = new Timestamp(currentDate.getTime());

        for (int i = 0; i < tableModel.getRowCount(); i++) {
            // Extract data from the current row
            String podNo = (String) tableModel.getValueAt(i, 0); // Assuming the first column contains the POD NO.
            String remark = (String) tableModel.getValueAt(i, 1); // Assuming the second column contains the Remark

            // Check if both values are not null or empty
            if (podNo != null && !podNo.isEmpty()) {
                Connection connection = DatabaseConnection.getConnection();

                try {
                    // Prepare a SQL INSERT statement
                    String sql = "INSERT INTO po (po_no, remark, date_time) VALUES (?, ?, ?)";

                    // Create a PreparedStatement object to execute the SQL statement
                    PreparedStatement pst = connection.prepareStatement(sql);

                    // Set the values for the PreparedStatement parameters
                    pst.setString(1, podNo);
                    pst.setString(2, remark);
                    pst.setTimestamp(3, timestamp);

                    // Execute the INSERT statement
                    int rowsInserted = pst.executeUpdate();

                    if (rowsInserted > 0) {
                        System.out.println("Data inserted successfully.");
                        int rowCount = tableModel.getRowCount();
        // Remove all rows except the first one
                        for (i = rowCount - 1; i > 0; i--) {
                            tableModel.removeRow(i);
                        }
                        // Clear data in the first row
                        for (i = 0; i < tableModel.getColumnCount(); i++) {
                            tableModel.setValueAt(null, 0, i);
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    // Close the connection
                    DatabaseConnection.closeConnection();
                }
            }
        }
    }//GEN-LAST:event_addposavebtnActionPerformed

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
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddPOPnl;
    private javax.swing.JPanel HistoryPnl;
    private javax.swing.JPanel POListPnl;
    private javax.swing.JButton addpoclearbtn;
    private javax.swing.JButton addposavebtn;
    private javax.swing.JTable addtable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel pnlcards;
    // End of variables declaration//GEN-END:variables
}
