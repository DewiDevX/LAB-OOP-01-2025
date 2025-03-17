// Class Alamat
 class Alamat {
    String jalan;
    String kota;

    // Method untuk mendapatkan alamat lengkap
    public String getAlamatLengkap() {
        return jalan + ", " + kota;
    }
}

// Class Mahasima
class Mahasiswa {
    String nama;
    String nim;
    Alamat alamat;

    // Method getter untuk nama
    public String getNama() {
        return nama;
    }

    // Method getter untuk NIM
    public String getNim() {
        return nim;
    }

    // Method getter untuk alamat
    public String getAlamat() {
        return alamat.getAlamatLengkap();
    }
}

// Class Main
 class Main {
    public static void main(String[] args) {
        // Membuat objek Alamat
        Alamat alamat = new Alamat();
        alamat.jalan = "Tamalamea Indah";
        alamat.kota = "Makassar";

        // Membuat objek Mahasima
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.alamat = alamat;
        mahasiswa.nama = "dwiii";
        mahasiswa.nim = "H071241034";

        // Menampilkan informasi mahasiswa
        System.out.println("Nama: " + mahasiswa.getNama());
        System.out.println("Nim: " + mahasiswa.getNim());
        System.out.println("Alamat: " + mahasiswa.getAlamat());
    }
}