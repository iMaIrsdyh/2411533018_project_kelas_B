package model;

//Karimah Irsyadiyah
//2411533018

public class Pelanggan {
    private String id;
    private String nama;
    private String alamat;
    private String noHp;

    public Pelanggan(String id2, String nama2, String alamat2, String noHp2) {
		// TODO Auto-generated constructor stub
	}
	public Pelanggan() {
		// TODO Auto-generated constructor stub
	}
	public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getAlamat() { return alamat; }
    public void setAlamat(String alamat) { this.alamat = alamat; }

    public String getNoHp() { return noHp; }
    public void setNoHp(String noHp) { this.noHp = noHp; }
}
