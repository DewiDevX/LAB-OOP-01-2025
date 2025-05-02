// Subclass Wizard mewarisi Hero
public class Wizard extends Hero {
    public Wizard(String name) {
        super(name, 80, 20); // Memanggil konstruktor Hero dengan super()
    }

    // Override method attack()
    @Override
    public void attack() {
        System.out.println(name + " melemparkan sihir api! Kekuatan: " + attackPower);
    }
}
