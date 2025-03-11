import java.util.Scanner;

public class KonversiTanggal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        try {
            // Minta pengguna input tanggal
            System.out.print("Masukkan tanggal (dd-mm-yy): ");
            String tanggal = input.nextLine();
            
            // Pisah tanggal jadi hari, bulan, dan tahun
            String[] bagian = tanggal.split("-");
            
            int hari = Integer.parseInt(bagian[0]);
            int bulan = Integer.parseInt(bagian[1]);
            int tahun = Integer.parseInt(bagian[2]);
    
            
            // Konversi tahun ke format 4 digit
            tahun += (tahun <= 23) ? 2000 : 1900;
            
            // Array nama bulan
            String[] namaBulan = {
                "Januari", "Februari", "Maret", "April", "Mei", "Juni",
                "Juli", "Agustus", "September", "Oktober", "November", "Desember"
            };
            
            // Cek validitas bulan
            if (bulan < 1 || bulan > 12) {
                System.out.println("Bulan tidak valid!");
            } else {
                // Tampilkan hasil konversi
                System.out.println("Output : " + hari + " " + namaBulan[bulan - 1] + " " + tahun);
            }
        } catch (Exception e) {
            System.out.println("Format input salah! Gunakan format dd-mm-yy.");
        }
        
        input.close();
    }
}

