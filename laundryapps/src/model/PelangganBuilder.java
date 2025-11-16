package model;

//Karimah Irsyadiyah
//2411533018

public class PelangganBuilder {
    private String id;
    private String nama;
    private String alamat;
    private String noHp;

    public PelangganBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public PelangganBuilder setNama(String nama) {
        this.nama = nama;
        return this;
    }

    public PelangganBuilder setAlamat(String alamat) {
        this.alamat = alamat;
        return this;
    }

    public PelangganBuilder setNoHp(String noHp) {
        this.noHp = noHp;
        return this;
    }

    public Pelanggan build() {
        return new Pelanggan(id, nama, alamat, noHp);
    }
}
