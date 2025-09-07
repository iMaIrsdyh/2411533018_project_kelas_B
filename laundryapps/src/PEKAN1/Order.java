package PEKAN1;
 //Karimah Irsyadiyah
//2411533018

public class Order {
    private String id;
    private String id_costumer;
    private String id_service;
    private String id_user;
    private double total;
    private String tanggal;
    private String tanggal_selesai;
    private String status;
    private String status_pembayaran;

    public Order() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getId_costumer() { return id_costumer; }
    public void setId_costumer(String id_costumer) { this.id_costumer = id_costumer; }

    public String getId_service() { return id_service; }
    public void setId_service(String id_service) { this.id_service = id_service; }

    public String getId_user() { return id_user; }
    public void setId_user(String id_user) { this.id_user = id_user; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public String getTanggal() { return tanggal; }
    public void setTanggal(String tanggal) { this.tanggal = tanggal; }

    public String getTanggal_selesai() { return tanggal_selesai; }
    public void setTanggal_selesai(String tanggal_selesai) { this.tanggal_selesai = tanggal_selesai; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getStatus_pembayaran() { return status_pembayaran; }
    public void setStatus_pembayaran(String status_pembayaran) { this.status_pembayaran = status_pembayaran; }
}
