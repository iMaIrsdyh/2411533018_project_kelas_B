package PEKAN1;

//Karimah Irsyadiyah
//2411533018

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainApp extends JFrame {
    public MainApp() {
        setTitle("Laundry Management System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();

        // CUSTOMER 
        JTextField txtCustId = new JTextField();
        JTextField txtCustNama = new JTextField();
        JTextField txtCustAlamat = new JTextField();
        JTextField txtCustHp = new JTextField();

        JButton btnCustSave = new JButton("Simpan");
        JButton btnCustReset = new JButton("Reset");

        JPanel panelCustomer = new JPanel(new GridLayout(5, 2, 5, 5));
        panelCustomer.add(new JLabel("ID Customer:"));
        panelCustomer.add(txtCustId);
        panelCustomer.add(new JLabel("Nama:"));
        panelCustomer.add(txtCustNama);
        panelCustomer.add(new JLabel("Alamat:"));
        panelCustomer.add(txtCustAlamat);
        panelCustomer.add(new JLabel("Nomor HP:"));
        panelCustomer.add(txtCustHp);
        panelCustomer.add(btnCustSave);
        panelCustomer.add(btnCustReset);

        // Event tombol Customer
        btnCustSave.addActionListener(e -> {
            System.out.println("=== Data Customer ===");
            System.out.println("ID: " + txtCustId.getText());
            System.out.println("Nama: " + txtCustNama.getText());
            System.out.println("Alamat: " + txtCustAlamat.getText());
            System.out.println("Nomor HP: " + txtCustHp.getText());
            JOptionPane.showMessageDialog(this, "Data Customer berhasil disimpan!");
        });

        btnCustReset.addActionListener(e -> {
            txtCustId.setText("");
            txtCustNama.setText("");
            txtCustAlamat.setText("");
            txtCustHp.setText("");
        });

        //SERVICE 
        JTextField txtServId = new JTextField();
        JTextField txtServJenis = new JTextField();
        JTextField txtServHarga = new JTextField();
        JTextField txtServStatus = new JTextField();

        JButton btnServSave = new JButton("Simpan");
        JButton btnServReset = new JButton("Reset");

        JPanel panelService = new JPanel(new GridLayout(5, 2, 5, 5));
        panelService.add(new JLabel("ID Service:"));
        panelService.add(txtServId);
        panelService.add(new JLabel("Jenis:"));
        panelService.add(txtServJenis);
        panelService.add(new JLabel("Harga:"));
        panelService.add(txtServHarga);
        panelService.add(new JLabel("Status:"));
        panelService.add(txtServStatus);
        panelService.add(btnServSave);
        panelService.add(btnServReset);

        // Event tombol Service
        btnServSave.addActionListener(e -> {
            System.out.println("=== Data Service ===");
            System.out.println("ID: " + txtServId.getText());
            System.out.println("Jenis: " + txtServJenis.getText());
            System.out.println("Harga: " + txtServHarga.getText());
            System.out.println("Status: " + txtServStatus.getText());
            JOptionPane.showMessageDialog(this, "Data Service berhasil disimpan!");
        });

        btnServReset.addActionListener(e -> {
            txtServId.setText("");
            txtServJenis.setText("");
            txtServHarga.setText("");
            txtServStatus.setText("");
        });

        // ORDER 
        JTextField txtOrderId = new JTextField();
        JTextField txtOrderCust = new JTextField();
        JTextField txtOrderServ = new JTextField();
        JTextField txtOrderTotal = new JTextField();
        JTextField txtOrderTanggal = new JTextField();

        JButton btnOrderSave = new JButton("Simpan");
        JButton btnOrderReset = new JButton("Reset");

        JPanel panelOrder = new JPanel(new GridLayout(6, 2, 5, 5));
        panelOrder.add(new JLabel("ID Order:"));
        panelOrder.add(txtOrderId);
        panelOrder.add(new JLabel("ID Customer:"));
        panelOrder.add(txtOrderCust);
        panelOrder.add(new JLabel("ID Service:"));
        panelOrder.add(txtOrderServ);
        panelOrder.add(new JLabel("Total:"));
        panelOrder.add(txtOrderTotal);
        panelOrder.add(new JLabel("Tanggal:"));
        panelOrder.add(txtOrderTanggal);
        panelOrder.add(btnOrderSave);
        panelOrder.add(btnOrderReset);

        // Event tombol Order
        btnOrderSave.addActionListener(e -> {
            System.out.println("=== Data Order ===");
            System.out.println("ID: " + txtOrderId.getText());
            System.out.println("ID Customer: " + txtOrderCust.getText());
            System.out.println("ID Service: " + txtOrderServ.getText());
            System.out.println("Total: " + txtOrderTotal.getText());
            System.out.println("Tanggal: " + txtOrderTanggal.getText());
            JOptionPane.showMessageDialog(this, "Data Order berhasil disimpan!");
        });

        btnOrderReset.addActionListener(e -> {
            txtOrderId.setText("");
            txtOrderCust.setText("");
            txtOrderServ.setText("");
            txtOrderTotal.setText("");
            txtOrderTanggal.setText("");
        });

        // TAMBAH TAB 
        tabbedPane.addTab("Customer", panelCustomer);
        tabbedPane.addTab("Service", panelService);
        tabbedPane.addTab("Order", panelOrder);

        add(tabbedPane);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainApp().setVisible(true);
        });
    }
}
