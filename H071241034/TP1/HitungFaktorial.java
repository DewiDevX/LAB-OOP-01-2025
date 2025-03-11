import java.util.Scanner;

public class HitungFaktorial{
    // Method rekursif untuk menghitung faktorial
    static int faktorial(int angka) {
        if (angka == 0 || angka == 1) {
            return 1;
        } else {
            return angka * faktorial(angka - 1);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Meminta input pengguna
        System.out.print("Masukkan bilangan: ");
        int n = input.nextInt();
        
        // Menghitung dan menampilkan hasil
        int hasil = faktorial(n);
        System.out.println(" " + hasil);
        
        input.close();
    }
}
