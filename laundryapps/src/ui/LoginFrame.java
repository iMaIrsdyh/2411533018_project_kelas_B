package ui;

import model.User;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;

public class LoginFrame extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;

    public LoginFrame() {
        setTitle("Laundry Apps");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JLabel lblTitle = new JLabel("Laundry Apps");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblTitle.setBounds(150, 20, 98, 30);
        getContentPane().add(lblTitle);

        JLabel lblDesc = new JLabel("Males aja nyuci, biar kami cuciin");
        lblDesc.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblDesc.setBounds(110, 50, 173, 20);
        getContentPane().add(lblDesc);

        JLabel lblUser = new JLabel("Username");
        lblUser.setBounds(50, 100, 100, 20);
        getContentPane().add(lblUser);

        txtUsername = new JTextField();
        txtUsername.setBounds(150, 100, 150, 25);
        getContentPane().add(txtUsername);

        JLabel lblPass = new JLabel("Password");
        lblPass.setBounds(50, 140, 100, 20);
        getContentPane().add(lblPass);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(150, 140, 150, 25);
        getContentPane().add(txtPassword);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(150, 180, 150, 30);
        getContentPane().add(btnLogin);

        // Action Login
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password = new String(txtPassword.getPassword());

                if (User.login(username, password)) {
                    new MainFrame().setVisible(true);
                    dispose(); // menutup login frame
                } else {
                    JOptionPane.showMessageDialog(null, "Login Gagal!");
                }
            }
        });
    }

    public static void main(String[] args) {
        new LoginFrame().setVisible(true);
    }
}
