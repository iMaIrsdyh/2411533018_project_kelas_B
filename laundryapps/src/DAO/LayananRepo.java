package DAO;

import config.Database;
import model.Layanan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LayananRepo implements LayananDAO {
    private Connection conn;

    public LayananRepo() {
        conn = Database.koneksi();
    }

    @Override
    public void save(Layanan l) {
        String sql = "INSERT INTO layanan(id, nama_layanan, harga) VALUES(?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            if (l.getId() == null) l.setId(String.valueOf(System.currentTimeMillis()));
            ps.setString(1, l.getId());
            ps.setString(2, l.getNamaLayanan());
            ps.setDouble(3, l.getHarga());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Layanan l) {
        String sql = "UPDATE layanan SET nama_layanan = ?, harga = ? WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, l.getNamaLayanan());
            ps.setDouble(2, l.getHarga());
            ps.setString(3, l.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM layanan WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Layanan> show() {
        List<Layanan> list = new ArrayList<>();
        String sql = "SELECT * FROM layanan";
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Layanan l = new Layanan();
                l.setId(rs.getString("id"));
                l.setNamaLayanan(rs.getString("nama_layanan"));
                l.setHarga(rs.getDouble("harga"));
                list.add(l);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
