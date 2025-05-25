package TypeRacer;

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class TypeRacer {
    private String wordsToType;
    private ArrayList<Typer> rareContestant = new ArrayList<>();
    private ArrayList<Result> rareStanding = new ArrayList<>();

    public String getWordsToType() {
        return wordsToType;
    }

    public ArrayList<Typer> getRareContestant() {
        return rareContestant;
    }

    
    private String[] wordsToTypeList = {
            "Di Bikini Bottom ada Spongebob Squarepants, dia memang keren suka main drumband",
            "Dia jadi koki masaknya krabby patty, menjalani hari hidup bersama Garry",
            "Ayo sama-sama sebutkan nama-nama makhluk dalam sana di Bikini Bottom jaya",
            "Namun ada juga namanya Patrick Star, walau dia cetar tapi hidupnya liar",
            "Tinggal dalam batu tapi suka membantu, sayang hanya satu otaknya itu buntu"
    };

    public void setNewWordsToType() {
        Random random = new Random();
        int angkaRandom = random.nextInt(wordsToTypeList.length);
        wordsToType = wordsToTypeList[angkaRandom];
    }

    // TODO (4)
    // Buat method addResult yang digunakan untuk menambahkan typer yang sudah selesai,
    // dengan waktu nyata penyelesaian dari typer (dalam detik).
    public void addResult(Typer typer) {
    //  waktu nyata finish dari Typer, konversi ke detik
    int timeTakenInSeconds = (int) (typer.getFinishTime() / 1000);
    rareStanding.add(new Result(typer.getBotName(), timeTakenInSeconds));
}

    private void printRaceStanding() {
        System.out.println("\nKlasemen Akhir Type Racer");
        System.out.println("=========================\n");

        // TODO (5)
        // Tampilkan klasemen akhir dari kompetisi, dengan format
        // {posisi}. {nama} = {waktu penyelesaian dalam detik} detik
        Collections.sort(rareStanding, (a, b) -> Integer.compare(a.getFinishTime(), b.getFinishTime()));
        int posisi = 1;
        for (Result r : rareStanding) {
            System.out.println(posisi + ". " + r.getName() + " = " + r.getFinishTime() + " detik");
            posisi++;
        }
    }

    public void startRace() {
        // TODO (6)
        // Jalankan kompetisi untuk tiap kontestan
        for (Typer t : rareContestant) {
            t.start();
        }
    }

    // TODO (7)
    // selama semua peserta belum selesai maka tampilkan typing progress-nya setiap
    // 2 detik, dengan format:
    // Typing Progress ...
    // ===================
    // {nama kontestan} => {text yang telah dia ketik}
    // {nama kontestan} => {text yang telah dia ketik}
    // {nama kontestan} => {text yang telah dia ketik}
    public void displayRaceStandingPeriodically() throws InterruptedException {
        boolean allFinished = false;
        Thread.sleep(2000);
 
        while (!allFinished) {
            allFinished = true;

            System.out.println("\nTyping Progress ...");
            System.out.println("===================");

            for (Typer t : rareContestant) {
                System.out.println(t.getBotName() + " => " + t.getWordsTyped());
                if (!t.getWordsTyped().contains("(Selesai)")) {
                    allFinished = false;
                }
            }

            if (!allFinished) {
                Thread.sleep(2000);
            }
        }

        // TODO (8)
        // Setelah semua typer selesai, tampilkan race standing setelah semua typer
        // selesai
        printRaceStanding();
    }
}
