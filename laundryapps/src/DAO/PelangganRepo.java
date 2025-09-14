package DAO;

import config.Database;
import model.Pelanggan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PelangganRepo implements PelangganDAO {
    private Connection conn;

    public PelangganRepo() {
        conn = Database.koneksi();
    }

    @Override
    public void save(Pelanggan p) {
        String sql = "INSERT INTO pelanggan(id, nama, alamat, no_hp) VALUES(?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            if (p.getId() == null) p.setId(String.valueOf(System.currentTimeMillis()));
            ps.setString(1, p.getId());
            ps.setString(2, p.getNama());
            ps.setString(3, p.getAlamat());
            ps.setString(4, p.getNoHp());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Pelanggan p) {
        String sql = "UPDATE pelanggan SET nama = ?, alamat = ?, no_hp = ? WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getNama());
            ps.setString(2, p.getAlamat());
            ps.setString(3, p.getNoHp());
            ps.setString(4, p.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM pelanggan WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Pelanggan> show() {
        List<Pelanggan> list = new ArrayList<>();
        String sql = "SELECT * FROM pelanggan";
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Pelanggan p = new Pelanggan();
                p.setId(rs.getString("id"));
                p.setNama(rs.getString("nama"));
                p.setAlamat(rs.getString("alamat"));
                p.setNoHp(rs.getString("no_hp"));
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
