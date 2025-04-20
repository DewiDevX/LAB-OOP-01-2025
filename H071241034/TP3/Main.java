public class Main {
    public static void main(String[] args) {
        Senjata laser = new Senjata("Laser", 15);
        Senjata misil = new Senjata("Misil", 20);

        CyberBot bot1 = new CyberBot("DewiX", 50, laser);
        CyberBot bot2 = new CyberBot();

        bot1.status();
        bot2.status();

        bot1.serang(bot2);
        bot2.status();

        bot2.isiUlang();
        bot2.status();
    }
}
