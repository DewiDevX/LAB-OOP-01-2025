import java.util.*;

public class CariAngka2D {
    public static void main(String[] args) {
        int[][] nums = new int[3][3];
        Random rand = new Random() ;
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                nums[i][j] = rand.nextInt(9) + 1;
            }
        }
        System.out.println("Array nums:");
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }


        try {
            int target = input.nextInt();

            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[i].length; j++) {
                    if (nums[i][j] == target) {
                        System.out.println("Ditemukan di posisi [" + i + "][" + j + "]");
                        return; // Langsung keluar setelah ketemu
                    }
                }
            }
            System.out.println("Angka tidak ditemukan.");
        } catch (Exception e) {
            System.out.println("Input harus angka!");
        } finally {
            input.close();
        }
    }
}

