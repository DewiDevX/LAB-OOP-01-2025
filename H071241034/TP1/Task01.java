import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Masukkan Judul Film: ");
        String judul = input.nextLine();
        
        
        String hasil = "";
        for (String kata : judul.split(" ")) {
            if (!kata.isEmpty()) {
                hasil += kata.substring(0, 1).toUpperCase() + kata.substring(1).toLowerCase() + " ";
 
            }
        }
        
        System.out.println( hasil.trim());
        
        input.close();
    }
}
