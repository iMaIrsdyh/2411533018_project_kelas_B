package Tugas;

public class Service {
	String id, jenis, status;
	double harga;
	

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getJenis() {
		return jenis;
	}


	public void setJenis(String jenis) {
		this.jenis = jenis;
	}


	public double getHarga() {
		return harga;
	}


	public void setHarga(double string) {
		this.harga = string;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public static void main(String[] args) {
        
		Service layanan = new Service();
		
		layanan.setId("2411533018");
		layanan.setJenis("Laundry Express");
		layanan.setHarga(20000);
		layanan.setStatus("Lunas");
		
		System.out.println("ID Service: " + layanan.getId());
		System.out.println("Jenis: " + layanan.getJenis());
		System.out.println("Harga: " + layanan.getHarga());
		System.out.println("Status: " +layanan.getStatus());
		    }

}