package table;

import model.Layanan;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableLayanan extends AbstractTableModel {
    private List<Layanan> list;
    private String[] columns = {"ID", "Nama Layanan", "Harga"};

    public TableLayanan(List<Layanan> list) {
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
        Layanan l = list.get(rowIndex);
        switch (columnIndex) {
            case 0: return l.getId();
            case 1: return l.getNamaLayanan();
            case 2: return l.getHarga();
            default: return null;
        }
    }
}
