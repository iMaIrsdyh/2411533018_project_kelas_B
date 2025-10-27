package pratikum5;

//Class Pesawat turunan dari Kendaraan dan mengimplementasikan dua interface
class Pesawat extends Kendaraan implements TransportasiUdara, Maskapai {

 public Pesawat(String merk, String model, int tahunProduksi) {
     super(merk, model, tahunProduksi);
 }

 @Override
 public void nyalakanMesin() {
     System.out.println("Nyalakan Mesin: Bersiap lepas landas");
 }

 @Override
 public String jenisBahanBakar() {
     return "Avtur";
 }

 @Override
 public void jenisPenerbangan() {
     System.out.println("Jenis Penerbangan: Domestik");
 }

 @Override
 public String namaMaskapai() {
     return "Garuda";
 }
}