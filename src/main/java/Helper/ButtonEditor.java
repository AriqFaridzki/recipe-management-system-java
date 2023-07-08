/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import GUIs.editBahanBaku;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import GUIs.editBahanBaku;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author Luminescenents
 */
public class ButtonEditor extends DefaultCellEditor {
        TableConfig config = new TableConfig();
        editBahanBaku bahanPage;
       private JFrame frame;

        private JButton button;
        private DefaultTableModel tableModel; 
        private JTable theTableLmao;
        private String targettedDBTable;
        private String targettedDBTableColumn;

        public ButtonEditor(DefaultTableModel tableModel, JTable theTableLmao, String targettedDBTable, String targettedDBTableColumn) {
            super(new JTextField());
            setClickCountToStart(1);

               this.tableModel = tableModel;
               this.theTableLmao = theTableLmao;
               this.targettedDBTable = targettedDBTable;
               this.targettedDBTableColumn = targettedDBTableColumn;
            button = new JButton();
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                    int row = theTableLmao.getSelectedRow();
                    String valueId =(String) theTableLmao.getValueAt(row, 0);

//                    System.out.println(config.getDbTableId(targettedDBTable, targettedDBTableColumn, valueId));
                    if (row != -1) {
                        // Menghapus baris yang dipilih dari tabel
                      
                        tableModel.removeRow(row);
                    }
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            button.setText(value.toString());
            return button;
        }
    }