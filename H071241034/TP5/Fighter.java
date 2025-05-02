// Subclass Fighter mewarisi Hero dan menggunakan this()
public class Fighter extends Hero {
    public Fighter(String name) {
        super(name, 120, 18); // Konstruktor default dengan super()
    }

    // public Fighter(String name) {
    //     this(); // Memanggil konstruktor default menggunakan this()
    //     this.name = name;
    // }

    // Override method attack()
    @Override
    public void attack() {
        System.out.println(name + " menebas musuh dengan pedang! Kekuatan: " + attackPower);
    }
}

