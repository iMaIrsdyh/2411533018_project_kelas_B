package model;

import DAO.LayananRepo;
import table.TableLayanan;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class LayananFrame extends JFrame {
    private JTextField txtNama, txtHarga;
    private JButton btnSave, btnUpdate, btnDelete, btnCancel;
    private JTable tableLayanan;

    private LayananRepo repo = new LayananRepo();
    private List<Layanan> ls;
    private String id;

    public LayananFrame() {
        initComponents();
        loadTable();
        initActions();
    }

    private void initComponents() {
        setTitle("LAYANAN");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel main = new JPanel(new BorderLayout(10,10));
        getContentPane().add(main);

        JPanel input = new JPanel(new GridBagLayout());
        input.setBorder(BorderFactory.createTitledBorder("Form Layanan"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);

        // Nama
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.WEST;
        input.add(new JLabel("Nama Layanan"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtNama = new JTextField(20);
        input.add(txtNama, gbc);

        // Harga
        gbc.gridx = 0; gbc.gridy = 1; gbc.fill = GridBagConstraints.NONE;
        input.add(new JLabel("Harga"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtHarga = new JTextField(20);
        input.add(txtHarga, gbc);

        // Buttons
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        btnSave = new JButton("Save");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");
        btnCancel = new JButton("Cancel");
        btnPanel.add(btnSave); btnPanel.add(btnUpdate); btnPanel.add(btnDelete); btnPanel.add(btnCancel);

        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        input.add(btnPanel, gbc);

        main.add(input, BorderLayout.NORTH);

        // Table
        tableLayanan = new JTable();
        JScrollPane sp = new JScrollPane(tableLayanan);
        sp.setBorder(BorderFactory.createTitledBorder("Data Layanan"));
        main.add(sp, BorderLayout.CENTER);
    }

    private void reset() {
        txtNama.setText("");
        txtHarga.setText("");
        id = null;
    }

    private void loadTable() {
        ls = repo.show();
        TableLayanan tu = new TableLayanan(ls);
        tableLayanan.setModel(tu);
        tableLayanan.getTableHeader().setVisible(true);
    }

    private void initActions() {
        btnSave.addActionListener(e -> {
            try {
                Layanan l = new Layanan();
                l.setId(String.valueOf(System.currentTimeMillis()));
                l.setNamaLayanan(txtNama.getText());
                l.setHarga(Double.parseDouble(txtHarga.getText()));

                repo.save(l);
                reset();
                loadTable();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Harga harus angka.");
            }
        });

        btnUpdate.addActionListener(e -> {
            if (id != null) {
                try {
                    Layanan l = new Layanan();
                    l.setId(id);
                    l.setNamaLayanan(txtNama.getText());
                    l.setHarga(Double.parseDouble(txtHarga.getText()));

                    repo.update(l);
                    reset();
                    loadTable();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Harga harus angka.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Silahkan pilih data yang akan diupdate!");
            }
        });

        btnDelete.addActionListener(e -> {
            if (id != null) {
                int confirm = JOptionPane.showConfirmDialog(this, "Yakin akan menghapus?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    repo.delete(id);
                    reset();
                    loadTable();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Silahkan pilih data yang akan dihapus!");
            }
        });

        btnCancel.addActionListener(e -> reset());

        tableLayanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tableLayanan.getSelectedRow();
                if (row >= 0) {
                    id = tableLayanan.getValueAt(row, 0).toString();
                    txtNama.setText(tableLayanan.getValueAt(row, 1).toString());
                    txtHarga.setText(tableLayanan.getValueAt(row, 2).toString());
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LayananFrame().setVisible(true);
        });
    }
}
