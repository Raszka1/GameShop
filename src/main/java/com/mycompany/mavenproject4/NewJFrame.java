package com.mycompany.mavenproject4;
import com.mycompany.mavenproject4.GameDialog;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Comparator;

import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Zuzanna Raszka
 */
public final class NewJFrame extends javax.swing.JFrame {
    
    private DefaultTableModel model;
    
    //Przyciski
    private JButton addButton;
    private JButton deleteButton;
    
    private boolean ascending = true;

    
    public NewJFrame() {
        setTitle("GameShop");
        //Inicjowanie i ładowanie danych  
        initComponents();
        //loadDataAsync();
        // Metoda do konfiguracji tabeli
        setupTable();  
        displayGamesInTable();
           
        //add(addButton);// Ładowanie danych gier do tabeli
    }

    //Ustawianie nazw kolumn
    private void setupTable() {
    model = new DefaultTableModel();
    model.addColumn("Tytuł");
    model.addColumn("Platforma");
    model.addColumn("Rok wydania");
    model.addColumn("Cena");
    model.addColumn("Producent");
    model.addColumn("Ocena");
    TbShowGame.setModel(model);
    setupTableSorting();
    }
    
    //Podpięcie pozyskanych danych do odpowiednich pól w tabeli
    public void displayGamesInTable() {
        model = (DefaultTableModel) TbShowGame.getModel();
        model.setRowCount(0);  // Usuwa wszystkie istniejące wiersze, zapewniając czystą tabelę do załadowania danych

        List<Gra> gry = Mavenproject4.getBazaDanych(); // Pobieranie danych
        for (Gra gra : gry) {
            Object[] row = new Object[6];  // Tablica obiektów, każdy obiekt odpowiada kolumnie w tabeli
            row[0] = gra.getTytul();
            row[1] = gra.getPlatforma();
            row[2] = gra.getRokWydania();
            row[3] = gra.getCena() + " zł";
            row[4] = gra.getProducent();
            row[5] = gra.getOcena();

            model.addRow(row);  // Dodanie wiersza do modelu tabeli
            }
    }
           
    //Metoda do odświeżania tabeli po dodaniu nowego rekordu
    public void refreshTable() {
    // Pobranie modelu tabeli
    DefaultTableModel model = (DefaultTableModel) TbShowGame.getModel();
    model.setRowCount(0); // Usunięcie starych danych

    // Załadowanie nowych danych
    List<Gra> gry = Mavenproject4.getBazaDanych();
    for (Gra gra : gry) {
        model.addRow(new Object[]{gra.getTytul(), gra.getPlatforma(), gra.getRokWydania(), gra.getCena(), gra.getProducent(), gra.getOcena()});
        }
    }
    
    //Asynchroniczne pobieranie danych
     
    //Sortowanie za pomocą oceny
    private void toggleSortOcena() {
        TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) TbShowGame.getRowSorter();
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        int columnIndexToSort = 5; // Index of the column to sort (Ocena)
        if (ascending) {
            sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.DESCENDING));
        } else {
            sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));
        }
        ascending = !ascending; // Toggle the order for next use
        sorter.setSortKeys(sortKeys);
        sorter.sort();
    }
    
     //Sortowanie za pomocą oceny
    private void toggleSortRoku() {
        TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) TbShowGame.getRowSorter();
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        int columnIndexToSort = 2; // Index of the column to sort (Ocena)
        if (ascending) {
            sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.DESCENDING));
        } else {
            sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));
        }
        ascending = !ascending; // Toggle the order for next use
        sorter.setSortKeys(sortKeys);
        sorter.sort();
    }
    
    private void setupTableSorting() {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(model);
        TbShowGame.setRowSorter(sorter);
        sorter.setComparator(5, new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return Double.compare(o1, o2);
            }
        });
    }
    
    private void showGameDetails() {
        int selectedRow = TbShowGame.getSelectedRow();
        if (selectedRow >= 0) {
            String details = "Tytuł: " + TbShowGame.getValueAt(selectedRow, 0)
                + "\nPlatforma: " + TbShowGame.getValueAt(selectedRow, 1)
                + "\nRok Wydania: " + TbShowGame.getValueAt(selectedRow, 2)
                + "\nCena: " + TbShowGame.getValueAt(selectedRow, 3)
                + "\nProducent: " + TbShowGame.getValueAt(selectedRow, 4)
                + "\nOcena: " + TbShowGame.getValueAt(selectedRow, 5);
            JOptionPane.showMessageDialog(this, details, "Szczegóły Gry", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Proszę zaznaczyć rekord.", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        TbShowGame = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        BtnAdd = new java.awt.Button();
        DeleteButton = new java.awt.Button();
        BtnSort = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        BtnSortRok = new javax.swing.JButton();
        BtnViewDetails = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(244, 250, 255));
        setForeground(java.awt.Color.white);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TbShowGame.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(TbShowGame);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 97, 640, 400));

        jLabel1.setFont(new java.awt.Font("Lucida Console", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(17, 42, 70));
        jLabel1.setText("GameShop");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 130, 40));

        jPanel1.setBackground(new java.awt.Color(124, 198, 254));

        BtnAdd.setActionCommand("addButton");
        BtnAdd.setBackground(new java.awt.Color(135, 137, 192));
        BtnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtnAdd.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        BtnAdd.setLabel("Dodaj grę");
        BtnAdd.setName(""); // NOI18N
        BtnAdd.setPreferredSize(new java.awt.Dimension(70, 30));
        BtnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnAddMouseClicked(evt);
            }
        });

        DeleteButton.setActionCommand("deleteButton");
        DeleteButton.setBackground(new java.awt.Color(135, 137, 192));
        DeleteButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DeleteButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        DeleteButton.setLabel("Usuń gre");
        DeleteButton.setName(""); // NOI18N
        DeleteButton.setPreferredSize(new java.awt.Dimension(70, 30));
        DeleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteButtonMouseClicked(evt);
            }
        });

        BtnSort.setBackground(new java.awt.Color(135, 137, 192));
        BtnSort.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BtnSort.setForeground(new java.awt.Color(0, 0, 0));
        BtnSort.setText("Ocena");
        BtnSort.setBorder(null);
        BtnSort.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnSortMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Sortowanie");

        BtnSortRok.setBackground(new java.awt.Color(135, 137, 192));
        BtnSortRok.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BtnSortRok.setForeground(new java.awt.Color(0, 0, 0));
        BtnSortRok.setText("Rok Produkcji");
        BtnSortRok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnSortRokMouseClicked(evt);
            }
        });

        BtnViewDetails.setBackground(new java.awt.Color(135, 137, 192));
        BtnViewDetails.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BtnViewDetails.setForeground(new java.awt.Color(0, 0, 0));
        BtnViewDetails.setText("Szczegóły");
        BtnViewDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnViewDetailsMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Szczegóły Gier");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(19, 19, 19))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BtnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DeleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(BtnSort, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(BtnSortRok, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(BtnViewDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnSort, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnSortRok, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnViewDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        BtnAdd.getAccessibleContext().setAccessibleName("addButton");
        DeleteButton.getAccessibleContext().setAccessibleName("deleteButton");

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Zdarzenie BtnAdd_Click
    private void BtnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAddMouseClicked
        openAddGameDialog();
    }//GEN-LAST:event_BtnAddMouseClicked

    //Zdarzenie BtnDelete_Click
    private void DeleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteButtonMouseClicked
        deleteSelectedGame();
    }//GEN-LAST:event_DeleteButtonMouseClicked

    //Zdarzenie BtnSort_Click - Ocena
    private void BtnSortMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnSortMouseClicked
        toggleSortOcena();
    }//GEN-LAST:event_BtnSortMouseClicked

    private void BtnSortRokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnSortRokMouseClicked
        toggleSortRoku();
    }//GEN-LAST:event_BtnSortRokMouseClicked

    private void BtnViewDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnViewDetailsMouseClicked
        showGameDetails();
    }//GEN-LAST:event_BtnViewDetailsMouseClicked

    //Funkcja która otwiera okno Popup zaprojektowane na podstawei pliku GameDialog
    private void openAddGameDialog() {
        GameDialog gameDialog = new GameDialog(this);
        gameDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                refreshTable();  // Metoda odświeżająca tabelę
            }
            });
        gameDialog.setVisible(true);
    }
    
    //Funkcja do usuwania zaznaczonych pozycji z tabelii
    private void deleteSelectedGame() {
        int row = TbShowGame.getSelectedRow();
        if (row >= 0) {
            String gameTitle = model.getValueAt(row, 0).toString(); 

            // Usunięcie z bazy danych
            Mavenproject4.usunZBazy(gameTitle);

            // Usunięcie z modelu tabeli
            model.removeRow(row);
        } 
        else {
            JOptionPane.showMessageDialog(this, "Proszę wybrać grę do usunięcia.");
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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
                
                
            }
        });
        
       
        /* Create and display the form */
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button BtnAdd;
    private javax.swing.JButton BtnSort;
    private javax.swing.JButton BtnSortRok;
    private javax.swing.JButton BtnViewDetails;
    private java.awt.Button DeleteButton;
    private javax.swing.JTable TbShowGame;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

}
