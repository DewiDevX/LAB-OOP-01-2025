package TypeRacer;

class Typer extends Thread {
    private String botName, wordsTyped;
    private double wpm;
    private TypeRacer typeRacer;
    private long finishTime; // waktu selesai dalam milidetik

    public Typer(String botName, double wpm, TypeRacer typeRacer) {
        this.botName = botName;
        this.wpm = wpm;
        this.wordsTyped = "";
        this.typeRacer = typeRacer;
        this.finishTime = 0;
    }

    public void setBotName(String botName) {
        this.botName = botName;
    }

    public void setWpm(double wpm) {
        this.wpm = wpm;
    }

    public void addWordsTyped(String newWordsTyped) {
        this.wordsTyped += newWordsTyped + " ";
    }

    public String getWordsTyped() {
        return wordsTyped;
    }

    public String getBotName() {
        return botName;
    }

    public double getWpm() {
        return wpm;
    }
    
    public long getFinishTime() {
        return finishTime;
    }

    @Override
    public void run() {
        String[] wordsToType = typeRacer.getWordsToType().split(" ");

        // TODO (1)
        // Buatlah variable howLongToType yang memuat waktu yang diperlukan typer
        long howLongToType = (long) ((60.0 / wpm) * 1000); // dalam milidetik

        // Catat waktu mulai mengetik
        long startTime = System.currentTimeMillis();

        // TODO (2)
        // Buatlah perulangan untuk menambahkan kata dengan method
        // addWordToTyped setelah interval waktu sebanyak howLongToType
        for (String word : wordsToType) {
            try {
                Thread.sleep(howLongToType);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
            addWordsTyped(word);
        }

        this.addWordsTyped("(Selesai)");

        // Catat waktu selesai mengetik
        long endTime = System.currentTimeMillis();
        finishTime = endTime - startTime;

        // TODO (3)
        // Tambahkan typer yang telah selesai mengetik semua kata ke list typeRaceTabel 
        // yang ada di class typeRacer.
        typeRacer.addResult(this);
    }
}
