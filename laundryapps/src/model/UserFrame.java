package model;

import DAO.UserRepo;
import table.TableUsers;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class UserFrame extends JFrame {

    // Deklarasi komponen
    private JTextField txtName;
    private JTextField txtUsername;
    private JTextField txtPassword;
    private JButton btnSave, btnUpdate, btnDelete, btnCancel;
    private JTable tableUsers;

    // DAO & Data
    UserRepo usr = new UserRepo();
    List<User> ls;
    public String id;

    public UserFrame() {
        initComponents();
        loadTable(); // langsung tampilkan data saat frame dibuka
        initActions(); // event handler tombol
    }

    private void initComponents() {
        setTitle("USERS");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel utama
        JPanel panelMain = new JPanel(new BorderLayout(10, 10));
        getContentPane().add(panelMain);

        // Panel input data
        JPanel panelInput = new JPanel(new GridBagLayout());
        panelInput.setBorder(BorderFactory.createTitledBorder("User Form"));

        GridBagConstraints gbc;

        // Label Name
        gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        panelInput.add(new JLabel("Name"), gbc);

        // TextField Name
        gbc = new GridBagConstraints();
        gbc.gridx = 1; gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtName = new JTextField(20);
        panelInput.add(txtName, gbc);

        // Label Username
        gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        panelInput.add(new JLabel("Username"), gbc);

        // TextField Username
        gbc = new GridBagConstraints();
        gbc.gridx = 1; gbc.gridy = 1;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtUsername = new JTextField(20);
        panelInput.add(txtUsername, gbc);

        // Label Password
        gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        panelInput.add(new JLabel("Password"), gbc);

        // TextField Password
        gbc = new GridBagConstraints();
        gbc.gridx = 1; gbc.gridy = 2;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtPassword = new JTextField(20);
        panelInput.add(txtPassword, gbc);

        // Panel tombol
        JPanel panelButton = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        btnSave = new JButton("Save");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");
        btnCancel = new JButton("Cancel");
        panelButton.add(btnSave);
        panelButton.add(btnUpdate);
        panelButton.add(btnDelete);
        panelButton.add(btnCancel);

        gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 5, 5, 5);
        panelInput.add(panelButton, gbc);

        panelMain.add(panelInput, BorderLayout.NORTH);

        // Tabel users
        tableUsers = new JTable();
        JScrollPane scrollPane = new JScrollPane(tableUsers);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Table Users"));
        panelMain.add(scrollPane, BorderLayout.CENTER);
    }

    // Method untuk clear input
    public void reset() {
        txtName.setText("");
        txtUsername.setText("");
        txtPassword.setText("");
        id = null;
    }

    // Method untuk tampilkan data di JTable
    public void loadTable() {
        ls = usr.show();
        TableUsers tu = new TableUsers(ls);
        tableUsers.setModel(tu);
        tableUsers.getTableHeader().setVisible(true);
    }

    // Event handler tombol & tabel
    private void initActions() {

        // Tombol SAVE
        btnSave.addActionListener(e -> {
            User user = new User();
            user.setNama(txtName.getText());
            user.setUsername(txtUsername.getText());
            user.setPassword(txtPassword.getText());

            usr.save(user);
            reset();
            loadTable();
        });

        // Tombol UPDATE
        btnUpdate.addActionListener(e -> {
            if (id != null) {
                User user = new User();
                user.setId(id);
                user.setNama(txtName.getText());
                user.setUsername(txtUsername.getText());
                user.setPassword(txtPassword.getText());

                usr.update(user);
                reset();
                loadTable();
            } else {
                JOptionPane.showMessageDialog(this, "Silahkan pilih data yang akan diupdate!");
            }
        });

        // Tombol DELETE
        btnDelete.addActionListener(e -> {
            if (id != null) {
                usr.delete(id);
                reset();
                loadTable();
            } else {
                JOptionPane.showMessageDialog(this, "Silahkan pilih data yang akan dihapus!");
            }
        });

        // Tombol CANCEL
        btnCancel.addActionListener(e -> reset());

        // Klik tabel isi form
        tableUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tableUsers.getSelectedRow();
                if (row >= 0) {
                    id = tableUsers.getValueAt(row, 0).toString();
                    txtName.setText(tableUsers.getValueAt(row, 1).toString());
                    txtUsername.setText(tableUsers.getValueAt(row, 2).toString());
                    txtPassword.setText(tableUsers.getValueAt(row, 3).toString());
                }
            }
        });
    }

    // Main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UserFrame frame = new UserFrame();
            frame.setVisible(true);
        });
    }
}
