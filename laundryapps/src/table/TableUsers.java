package table;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import model.User;  // 

public class TableUsers extends AbstractTableModel {

    private List<User> ls;
    private String[] columnNames = {"ID", "Name", "Username", "Password"};

    public TableUsers(List<User> ls) {
        this.ls = ls;
    }

    @Override
    public int getRowCount() {
        return ls.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        User u = ls.get(rowIndex);
        switch (columnIndex) {
            case 0: return u.getId();
            case 1: return u.getNama();
            case 2: return u.getUsername();
            case 3: return u.getPassword();
            default: return null;
        }
    }

    
    public void setList(List<User> ls) {
        this.ls = ls;
        fireTableDataChanged();
    }

    public User getUserAt(int rowIndex) {
        return ls.get(rowIndex);
    }
}
