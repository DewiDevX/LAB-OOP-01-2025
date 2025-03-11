import java.util.Scanner;

public class ValidasiPasswordAlternatif {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        // Validasi password menggunakan regex
        if (isPasswordValid(password)) {
            System.out.println("Password valid");
        } else {
            System.out.println("Password tidak valid");
        }

        scanner.close();
    }

    // Metode untuk memvalidasi password menggunakan regex
    public static boolean isPasswordValid(String password) {
        // Regex untuk memeriksa:
        // - Minimal 8 karakter
        // - Setidaknya satu huruf besar
        // - Setidaknya satu huruf kecil
        // - Setidaknya satu angka
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}$";
        return password.matches(regex);
    }
}