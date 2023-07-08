/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIs;

/**
 *
 * @author Luminescenents
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Helper.*;
import GUIs.editBahanBaku;

public class NewClass extends JFrame {

    private JTable table;
    private DefaultTableModel tableModel;
    editBahanBaku editBahan = new editBahanBaku();
    private JFrame frame;
    public NewClass() {
        // Membuat model tabel
        String[] columnNames = {"Name", "Age", "Delete"};
        tableModel = new DefaultTableModel(columnNames, 0);

        // Menambahkan data ke dalam tabel
        tableModel.addRow(new Object[]{"1", 25, "Delete"});
        tableModel.addRow(new Object[]{"2", 30, "Delete"});
        tableModel.addRow(new Object[]{"3", 35, "Delete"});

        // Membuat JTable dengan model yang telah dibuat
        table = new JTable(tableModel);

        // Mengatur render dan editor khusus untuk kolom "Delete"
        table.getColumnModel().getColumn(2).setCellRenderer(new Helper.ButtonRenderer());
        table.getColumnModel().getColumn(2).setCellEditor(new Helper.ButtonEditor(tableModel, table, "bahan_baku","id_bahan_baku"));
        

        // Menambahkan JTable ke dalam JFrame
        add(new JScrollPane(table));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

//    // TableCellRenderer untuk menggambar tombol pada kolom "Delete"
//    class ButtonRenderer extends JButton implements TableCellRenderer {
//
//        public ButtonRenderer() {
//            setOpaque(true);
//        }
//
//        @Override
//        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//            setText(value.toString());
//            return this;
//        }
//    }
//
//    // TableCellEditor untuk menangani klik tombol pada kolom "Delete"
//    class ButtonEditor extends DefaultCellEditor {
//
//        private JButton button;
//
//        public ButtonEditor() {
//            super(new JTextField());
//            setClickCountToStart(1);
//
//            button = new JButton();
//            button.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    fireEditingStopped();
//                    int row = table.getSelectedRow();
//                    if (row != -1) {
//                        // Menghapus baris yang dipilih dari tabel
//                        tableModel.removeRow(row);
//                    }
//                }
//            });
//        }
//
//        @Override
//        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
//            button.setText(value.toString());
//            return button;
//        }
//    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new NewClass();
            }
        });
    }
}
