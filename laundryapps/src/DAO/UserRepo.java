package DAO;

import java.sql.*;
import java.util.*;
import model.User;
import config.Database;

public class UserRepo implements UserDAO {

    private Connection connection;
    private final String insert = "INSERT INTO user (name, username, password) VALUES (?,?,?)";
    private final String select = "SELECT * FROM user";
    private final String delete = "DELETE FROM user WHERE id=?";
    private final String update = "UPDATE user SET name=?, username=?, password=? WHERE id=?";

    public UserRepo() {
        this.connection = Database.koneksi();
    }

    @Override
    public void save(User user) {
        try {
            PreparedStatement st = connection.prepareStatement(insert);
            st.setString(1, user.getNama());
            st.setString(2, user.getUsername());
            st.setString(3, user.getPassword());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> show() {
        List<User> ls = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getString("id"));
                user.setNama(rs.getString("name"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                ls.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ls;
    }

    @Override
    public void update(User user) {
        try {
            PreparedStatement st = connection.prepareStatement(update);
            st.setString(1, user.getNama());
            st.setString(2, user.getUsername());
            st.setString(3, user.getPassword());
            st.setString(4, user.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        try {
            PreparedStatement st = connection.prepareStatement(delete);
            st.setString(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
