package DAO;

import model.Layanan;
import java.util.List;

public interface LayananDAO {
    void save(Layanan l);
    void update(Layanan l);
    void delete(String id);
    List<Layanan> show();
}
