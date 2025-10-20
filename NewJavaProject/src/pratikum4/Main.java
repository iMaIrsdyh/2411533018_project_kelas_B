package pratikum4;

public class Main {
    public static void main(String[] args) {
        // Membuat beberapa objek buku
        Book novel = new Novel("Laskar Pelangi", "Andrea Hirata", "Drama");
        Book magazine = new Magazine("National Geographic", "Various Authors", "Science");
        Book textbook = new Textbook("Pemrograman Java", "Anonimous", "Informatika");

        // Membuat objek user
        User user = new User("iMa");

        // Menampilkan detail buku (polymorphism)
        System.out.println("=== Detail Buku ===");
        user.viewBookDetails(novel);
        System.out.println();
        user.viewBookDetails(magazine);
        System.out.println();
        user.viewBookDetails(textbook);
        System.out.println();

        // Proses peminjaman
        System.out.println("=== Proses Peminjaman Buku ===");
        user.borrowBook(novel);
        user.borrowBook(magazine);

        // Menampilkan status buku setelah dipinjam
        System.out.println("\nStatus Buku Setelah Dipinjam:");
        System.out.println(novel.getTitle() + " tersedia: " + novel.isAvailable());
        System.out.println(magazine.getTitle() + " tersedia: " + magazine.isAvailable());

        // Proses pengembalian
        System.out.println("\n=== Proses Pengembalian Buku ===");
        user.returnBook(novel);

        // Menampilkan status buku setelah dikembalikan
        System.out.println("\nStatus Buku Setelah Dikembalikan:");
        System.out.println(novel.getTitle() + " tersedia: " + novel.isAvailable());
    }
}


