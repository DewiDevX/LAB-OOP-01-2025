package login_app;

import java.util.ArrayList;
import java.util.Scanner;

import login_app.models.Hobby;
import login_app.models.Profile;// Import class Profile
import login_app.models.User;// Import class User
import login_app.utils.StringUtils;// Import fungsi utilitas StringUtils 

public class Main {
    private static ArrayList<User> listUser = new ArrayList<>();
    private static ArrayList<Profile> listUserProfile = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    

    public static void main(String[] args) {
        runApp();
    }

    private static void runApp() {
        System.out.println("-------------------------");
        System.out.println("Aplikasi Login Sederhana");
        System.out.println("-------------------------");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Lupa Password");

        int selectMenu = 0;
        while (true) {
            System.out.print("> ");
            try {
                selectMenu = Integer.parseInt(sc.nextLine());
                if (selectMenu >= 1 && selectMenu <= 3) {
                    break;
                } else {
                    System.out.println("Pilih menu 1 - 3!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka!");
            }
        }

        switch (selectMenu) {
            case 1:
                showLoginMenu();
                break;
            case 2:
                showRegisterMenu();
                break;
            case 3:
                showForgotPasswordMenu();
                break;
        }
    }

    private static void showLoginMenu() {
        System.out.println("-------------------------");
        System.out.println("Login");
        System.out.println("Masukkan Username");
        System.out.print("> ");
        String username = sc.nextLine();

        int userIndex = -1;
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getUsername().equals(username)) {
                userIndex = i;
                break;
            }
        }

        if (userIndex != -1) {
            User user = listUser.get(userIndex);

            if (user.isBlocked()) {
                System.out.println("Akun ini telah diblokir. Silakan reset password.");
                runApp();
                return;
            }

            System.out.println("Password");
            System.out.print("> ");
            String password = sc.nextLine();

            boolean isPasswordMatch = user.getPassword().equals(password);

            if (isPasswordMatch) {
                System.out.println("Berhasil Login");
                showDetailUser(listUserProfile.get(userIndex));
                System.exit(0);
            } else {
                System.out.println("Password Salah! Akun diblokir.");
                user.setBlocked(true); // langsung blokir setelah 1x salah
            }
        } else {
            System.out.println("Username tidak ditemukan");
        }

        runApp();
    }

    private static void showRegisterMenu() {
        System.out.println("-------------------------");
        System.out.println("REGISTER");

        String username;
        while (true) {
            username = inputNonEmpty("Username");
            if (isUsernameTaken(username)) {
                System.out.println("Username sudah digunakan, silakan pilih yang lain.");
            } else {
                break;
            }
        }

        String password;
        while (true) {
            password = inputNonEmpty("Password");
            if (password.length() < 8) {
                System.out.println("Password harus minimal 8 karakter!");
            } else {
                break;
            }
        }

        User user = new User(username, password);
        Profile profile = new Profile();

        String fullName = inputNonEmpty("Nama Lengkap");

        int age = 0;
        while (true) {
            System.out.println("Umur");
            System.out.print("> ");
            String input = sc.nextLine();
            try {
                age = Integer.parseInt(input);
                if (age <= 0) {
                    System.out.println("Umur harus lebih dari 0.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Umur harus berupa angka!");
            }
        }

        Hobby.tampilkanDaftarHobi(); // Menampilkan daftar hobi
        String hobby = "";
        while (true) {
            System.out.println("Pilih Hobi (masukkan nama hobi):");
            System.out.print("> ");
            hobby = sc.nextLine();
            if (Hobby.getKategoriHobi(hobby).equals("Kategori tidak ditemukan")) {
                System.out.println("Hobi tidak valid, silakan pilih dari daftar yang tersedia.");
            } else {
                break;
            }
        }
        profile.setFullName(fullName);
        profile.setAge(age);
        profile.setHobby(hobby);
        profile.setNickName(StringUtils.generateNickName(fullName));

        listUser.add(user);
        listUserProfile.add(profile);

        System.out.println("-------------------------");
        System.out.println("Berhasil Membuat User Baru!!");

        runApp();
    }

    private static void showForgotPasswordMenu() {
        System.out.println("-------------------------");
        System.out.println("Lupa Password");

        System.out.println("Masukkan Username:");
        System.out.print("> ");
        String username = sc.nextLine();

        int userIndex = -1;
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getUsername().equals(username)) {
                userIndex = i;
                break;
            }
        }

        if (userIndex == -1) {
            System.out.println("Username tidak ditemukan.");
            runApp();
            return;
        }

        User user = listUser.get(userIndex);

        if (!user.isBlocked()) {
            System.out.println("Akun belum diblokir. Gunakan fitur login.");
            runApp();
            return;
        }

        Profile profile = listUserProfile.get(userIndex);

        System.out.println("Untuk reset password, jawab pertanyaan berikut:");
        System.out.println("Nama Lengkap:");
        System.out.print("> ");
        String fullName = sc.nextLine();
        System.out.println("Hobby:");
        System.out.print("> ");
        String hobby = sc.nextLine();

        if (profile.getFullName().equalsIgnoreCase(fullName) &&
            profile.getHobby().equalsIgnoreCase(hobby)) {

            String newPassword;
            while (true) {
                System.out.println("Masukkan password baru (minimal 8 karakter):");
                System.out.print("> ");
                newPassword = sc.nextLine();
                if (newPassword.length() >= 8) break;
                System.out.println("Password terlalu pendek!");
            }

            user.setPassword(newPassword);
            user.setBlocked(false);
            System.out.println("Password berhasil direset. Silakan login.");
        } else {
            System.out.println("Data verifikasi salah. Tidak dapat reset password.");
        }

        runApp();
    }

    private static void showDetailUser(Profile profile) {
        System.out.println("-------------------------");
        System.out.println("PROFILE");
        System.out.println("Nama Lengkap : " + profile.getFullName());
        System.out.println("Nickname     : " + profile.getNickName());
        System.out.println("Umur         : " + profile.getAge());
        System.out.println("Hobby        : " + profile.getHobby());
        System.out.println("-------------------------");
    }

    private static String inputNonEmpty(String prompt) {
        String input;
        do {
            System.out.println(prompt);
            System.out.print("> ");
            input = sc.nextLine();
            if (input.trim().isEmpty()) {
                System.out.println("Input tidak boleh kosong!");
            }
        } while (input.trim().isEmpty());
        return input;
    }

    private static boolean isUsernameTaken(String username) {
        for (User user : listUser) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
}
