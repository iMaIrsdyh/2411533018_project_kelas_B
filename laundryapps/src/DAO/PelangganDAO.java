package DAO;

import model.Pelanggan;
import java.util.List;

public interface PelangganDAO {
    void save(Pelanggan p);
    void update(Pelanggan p);
    void delete(String id);
    List<Pelanggan> show();
}
