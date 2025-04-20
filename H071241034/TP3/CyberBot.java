public class CyberBot {
    String nama;
    int energi;
    Senjata senjata;

    CyberBot() {
        nama = "BotAnonim";
        energi = 50;
        senjata = new Senjata();
    }

    CyberBot(String nama, int energi, Senjata senjata) {
        this.nama = nama;
        this.energi = energi;
        this.senjata = senjata;
    }

    void serang(CyberBot target) {
        System.out.println(nama + " menyerang " + target.nama + " dengan " + senjata.nama);
        target.energi -= senjata.damage;
    }

    void isiUlang() {
        energi += 20;
        System.out.println(nama + " mengisi ulang energi menjadi " + energi);
    }

    void status() {
        System.out.println("Nama\t: " + nama);
        System.out.println("Energi\t: " + energi);
        System.out.println("Senjata\t: " + senjata.nama + " (Damage: " + senjata.damage + ")");
        System.out.println("-----------------------------------");
    }
}
