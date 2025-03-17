class Cuboid {
    double height;
    double width;
    double length;

    double getVolume() {
        // Menghitung volume balok
        return height * width * length;
    }
}

public class Main {
    public static void main(String[] args) {
        Cuboid cuboid = new Cuboid();
        
        // Mengatur nilai height, width, dan length
        cuboid.height = 15.0;
        cuboid.width = 20.0;
        cuboid.length = 15.0;

        // Menampilkan volume balok
        System.out.printf("Volume = %.2f%n", cuboid.getVolume());
    }
} 