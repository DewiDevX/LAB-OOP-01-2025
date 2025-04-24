package login_app.models;

public class Hobby {
    // Array 2 dimensi berisi daftar hobi dan kategorinya
    private static String[][] daftarHobi = {
        {"berenang", "olahraga air"},
        {"lari", "olahraga"},
        {"membaca", "kegiatan santai"},
        {"menulis", "ekspresi diri"},
        {"memasak", "kegiatan rumah tangga"},
        {"bersepeda", "olahraga"},
        {"melukis", "seni"},
        {"bermain musik", "hiburan"},
        {"memancing", "kegiatan outdoor"},
        {"berkebun", "kegiatan alam"}
    };

    // Method untuk mengambil kategori dari sebuah hobi yang dimasukkan pengguna
    public static String getKategoriHobi(String hobi) {
        // Loop untuk mencari hobi dalam array
        for (String[] item : daftarHobi) {
            // Jika nama hobi cocok (tidak peduli huruf besar/kecil)
            if (item[0].equalsIgnoreCase(hobi)) {
                // Kembalikan kategori dari hobi tersebut
                return item[1];
            }
        }
        // Jika tidak ditemukan, kembalikan pesan default
        return "Kategori tidak ditemukan";
    }

    // Method untuk menampilkan semua daftar hobi beserta kategorinya
    public static void tampilkanDaftarHobi() {
        System.out.println("Daftar Hobi yang Bisa Dipilih:");
        // Loop melalui semua item dalam array
        for (String[] item : daftarHobi) {
            // Tampilkan nama hobi dan kategorinya
            System.out.println("- " + item[0] + " = " + item[1]);
        }
    }
}
