package table;

import model.Pelanggan;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TablePelanggan extends AbstractTableModel {
    private List<Pelanggan> list;
    private String[] columns = {"ID", "Nama", "Alamat", "No HP"};

    public TablePelanggan(List<Pelanggan> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pelanggan p = list.get(rowIndex);
        switch (columnIndex) {
            case 0: return p.getId();
            case 1: return p.getNama();
            case 2: return p.getAlamat();
            case 3: return p.getNoHp();
            default: return null;
        }
    }
}
