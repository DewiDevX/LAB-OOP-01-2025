// Kelas utama dengan method main
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Pilih karakter:");
        System.out.println("1. Archer");
        System.out.println("2. Wizard");
        System.out.println("3. Fighter");
        System.out.print("Masukkan pilihan: "); 
        int pilih = sc.nextInt(); sc.nextLine();

        if (pilih !=1 && pilih!=2 && pilih!=3){
            System.out.println("Pilihan tidak valid.");
            sc.close();
            return;
        }    
        

        // Input nama karakter
        System.out.print("Masukkan nama karakter: ");
        String nama = sc.nextLine();

        // Buat objek karakter sesuai pilihan
        Hero hero = switch (pilih) {
            case 1 -> new Archer(nama);
            case 2 -> new Wizard(nama);
            case 3 -> new Fighter(nama);
            default -> null;
        };


        // Menu aksi
        while (true) {
            System.out.println("\nMenu:\n1. Serang\n2. Keluar");
            System.out.print("Pilih aksi: ");
            int menu = sc.nextInt();
            if (menu == 1) hero.attack();
            else if (menu == 2) {
                System.out.println("Game selesai!");
                break;
            }
        }
        sc.close();
    }
}

