package GUIs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ResepApp extends javax.swing.JFrame {
    private List<JTextField> bahanFields;
    private JButton tambahSlotButton;
    private JButton tambahResepButton;
    private JPanel bahanPanel;

    private List<JComboBox<String>> bahanComboBoxes;
    private List<String> bahanSelectedItems;

    public ResepApp() {
        bahanFields = new ArrayList<>();
        initComponents();
    }

    private void initComponents() {
        bahanComboBoxes = new ArrayList<>();
        bahanSelectedItems = new ArrayList<>();

        tambahSlotButton = new JButton("Tambah Slot");
        tambahResepButton = new JButton("Tambah Resep");
        bahanPanel = new JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Resep App");

        bahanPanel.setLayout(new BoxLayout(bahanPanel, BoxLayout.Y_AXIS));

        tambahSlotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> bahanComboBox = new JComboBox<>();
                bahanComboBoxes.add(bahanComboBox);
                bahanPanel.add(bahanComboBox);
                bahanPanel.revalidate();
                bahanPanel.repaint();
            }
        });

        tambahResepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bahanSelectedItems.clear();
                for (JComboBox<String> bahanComboBox : bahanComboBoxes) {
                    String selectedItem = (String) bahanComboBox.getSelectedItem();
                    bahanSelectedItems.add(selectedItem);
                }
                // Lakukan operasi INSERT ke database menggunakan bahanSelectedItems

                JOptionPane.showMessageDialog(null, "Resep berhasil ditambahkan!");
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(bahanPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(tambahSlotButton)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(tambahResepButton)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(bahanPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(tambahSlotButton)
                                        .addComponent(tambahResepButton))
                                .addContainerGap())
        );

        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResepApp().setVisible(true);
            }
        });
    }
}
