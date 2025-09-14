package ui;

import model.LayananFrame;
import model.PelangganFrame;
import model.UserFrame;

import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Laundry Apps - Halaman Utama");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblTitle = new JLabel("Laundry Apps");
        lblTitle.setBounds(230, 20, 200, 30);
        add(lblTitle);

        // Tombol menu
        JButton btnPesanan = new JButton("PESANAN");
        btnPesanan.setBounds(100, 80, 150, 40);
        add(btnPesanan);

        JButton btnLayanan = new JButton("LAYANAN");
        btnLayanan.setBounds(300, 80, 150, 40);
        add(btnLayanan);

        JButton btnPelanggan = new JButton("PELANGGAN");
        btnPelanggan.setBounds(100, 140, 150, 40);
        add(btnPelanggan);

        JButton btnPengguna = new JButton("PENGGUNA");
        btnPengguna.setBounds(300, 140, 150, 40);
        add(btnPengguna);

        JButton btnLaporan = new JButton("LAPORAN");
        btnLaporan.setBounds(100, 200, 150, 40);
        add(btnLaporan);

        JButton btnProfile = new JButton("PROFILE");
        btnProfile.setBounds(300, 200, 150, 40);
        add(btnProfile);

        JButton btnKeluar = new JButton("KELUAR");
        btnKeluar.setBounds(200, 260, 150, 40);
        add(btnKeluar);

        // --- Action Buttons ---
        btnLayanan.addActionListener(e -> {
            new LayananFrame().setVisible(true);
        });

        btnPelanggan.addActionListener(e -> {
            new PelangganFrame().setVisible(true);
        });

        btnPengguna.addActionListener(e -> {
            new UserFrame().setVisible(true);
        });

        btnKeluar.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this, "Yakin mau keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                dispose(); // menutup aplikasi
            }
        });
    }
}
