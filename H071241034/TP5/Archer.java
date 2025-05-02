// Subclass Archer mewarisi Hero
public class Archer extends Hero {
    public Archer(String name) {
        super(name, 100, 15); // Memanggil konstruktor Hero dengan super()
    }

    // Override method attack()
    @Override
    public void attack() {
        System.out.println(name + " memanah dari kejauhan! Kekuatan: " + attackPower);
    }
}
   
