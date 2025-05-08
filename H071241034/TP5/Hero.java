// Superclass Hero
public abstract class Hero {
    String name;
    int health, attackPower;

    // Konstruktor dengan parameter
    public Hero(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    // Method attack default (akan dioverride oleh subclass)
    public abstract void attack();
}
