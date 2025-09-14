package model;

import DAO.PelangganRepo;
import table.TablePelanggan;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PelangganFrame extends JFrame {
    private JTextField txtNama, txtAlamat, txtNoHp;
    private JButton btnSave, btnUpdate, btnDelete, btnCancel;
    private JTable tablePelanggan;

    private PelangganRepo repo = new PelangganRepo();
    private List<Pelanggan> ls;
    private String id;

    public PelangganFrame() {
        initComponents();
        loadTable();
        initActions();
    }

    private void initComponents() {
        setTitle("PELANGGAN");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel main = new JPanel(new BorderLayout(10,10));
        getContentPane().add(main);

        JPanel input = new JPanel(new GridBagLayout());
        input.setBorder(BorderFactory.createTitledBorder("Form Pelanggan"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);

        // Nama
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.WEST;
        input.add(new JLabel("Nama"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtNama = new JTextField(25);
        input.add(txtNama, gbc);

        // Alamat
        gbc.gridx = 0; gbc.gridy = 1; gbc.fill = GridBagConstraints.NONE;
        input.add(new JLabel("Alamat"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtAlamat = new JTextField(25);
        input.add(txtAlamat, gbc);

        // No HP
        gbc.gridx = 0; gbc.gridy = 2; gbc.fill = GridBagConstraints.NONE;
        input.add(new JLabel("No HP"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtNoHp = new JTextField(25);
        input.add(txtNoHp, gbc);

        // Buttons
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        btnSave = new JButton("Save");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");
        btnCancel = new JButton("Cancel");
        btnPanel.add(btnSave); btnPanel.add(btnUpdate); btnPanel.add(btnDelete); btnPanel.add(btnCancel);

        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        input.add(btnPanel, gbc);

        main.add(input, BorderLayout.NORTH);

        tablePelanggan = new JTable();
        JScrollPane sp = new JScrollPane(tablePelanggan);
        sp.setBorder(BorderFactory.createTitledBorder("Data Pelanggan"));
        main.add(sp, BorderLayout.CENTER);
    }

    private void reset() {
        txtNama.setText("");
        txtAlamat.setText("");
        txtNoHp.setText("");
        id = null;
    }

    private void loadTable() {
        ls = repo.show();
        TablePelanggan tp = new TablePelanggan(ls);
        tablePelanggan.setModel(tp);
        tablePelanggan.getTableHeader().setVisible(true);
    }

    private void initActions() {
        btnSave.addActionListener(e -> {
            Pelanggan p = new Pelanggan();
            p.setId(String.valueOf(System.currentTimeMillis()));
            p.setNama(txtNama.getText());
            p.setAlamat(txtAlamat.getText());
            p.setNoHp(txtNoHp.getText());

            repo.save(p);
            reset();
            loadTable();
        });

        btnUpdate.addActionListener(e -> {
            if (id != null) {
                Pelanggan p = new Pelanggan();
                p.setId(id);
                p.setNama(txtNama.getText());
                p.setAlamat(txtAlamat.getText());
                p.setNoHp(txtNoHp.getText());

                repo.update(p);
                reset();
                loadTable();
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

        tablePelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tablePelanggan.getSelectedRow();
                if (row >= 0) {
                    id = tablePelanggan.getValueAt(row, 0).toString();
                    txtNama.setText(tablePelanggan.getValueAt(row, 1).toString());
                    txtAlamat.setText(tablePelanggan.getValueAt(row, 2).toString());
                    txtNoHp.setText(tablePelanggan.getValueAt(row, 3).toString());
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PelangganFrame().setVisible(true));
    }
}
