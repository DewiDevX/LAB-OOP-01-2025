package DownloadFile;

import java.util.*;
import java.util.concurrent.*;

public class Main {

    static int successfulDownloads = 0;
    static int completedDownloads = 0;
    static int totalFiles;
    static boolean allDone = false;
    static ArrayList<Result> results = new ArrayList<>();



    //TODO 1  Merekam hasil download (Success/Timeout) dan menyimpan ke list results
    public static synchronized void recordResult(int fileId, int duration, String threadName) {
        completedDownloads++;
        String status = duration <= 2 ? "Success" : "Timeout";
        if (status.equals("Success")) {
            successfulDownloads++;
        }
        results.add(new Result(fileId, duration, threadName, status));
    }
 
    public static void main(String[] args) {

        // TODO 2 meminta input dari user untuk jumlah file
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of files to download: ");
        totalFiles = scanner.nextInt();
        scanner.close();
        // TODO 3  untuk membuat dua  execuator
        ExecutorService downloadExecutor = Executors.newFixedThreadPool(3);
        ExecutorService uiExecutor = Executors.newSingleThreadExecutor();

        long startTime = System.currentTimeMillis();
        
        //TODO 4 Menampilkan “Downloading files... (Xs)” setiap detik hingga semua selesai 
        uiExecutor.execute(() -> {
            int seconds = 1;
            while (!allDone) {
                System.out.println("Downloading files... (" + seconds + "s)");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                seconds++;
            }
            System.out.println("Downloading completed!");
        });
         
    //TODO 5 Simulasi download dengan random 1–3 detik

        for (int i = 1; i <= totalFiles; i++) {
            int fileId = i;
            downloadExecutor.execute(() -> {
                String threadName = Thread.currentThread().getName();
                int duration = new Random().nextInt(3) + 1; // 1-3 detik
                try {
                    Thread.sleep(duration * 1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                recordResult(fileId, duration, threadName);
            });
        }
        //TODO 6 tdk menerima task baru setelah semua dikirim
        downloadExecutor.shutdown();

        //TODO7 tunggu proses di downloadEcuator selesai
        try {
            downloadExecutor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        // TODO 8 untuk hentikan ui stlah selesai dowload 
        allDone = true;
        uiExecutor.shutdown();
        try {
            uiExecutor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        long endTime = System.currentTimeMillis();
        int totalTime = (int) ((endTime - startTime) / 1000);

        System.out.println("--------------------------------------------------");
        System.out.println("                  Detailed Report                 ");
        System.out.println("--------------------------------------------------");
        System.out.printf("%-8s | %-18s | %-8s | %-8s%n",
                "File ID", "Thread", "Duration", "Status");
        System.out.println("--------------------------------------------------");

        results.sort(Comparator.comparingInt(r -> r.fileId));

        for (Result r : results) {
            System.out.printf("%-8d | %-18s | %-8s | %-8s%n",
                    r.fileId, r.threadName, r.duration + "s", r.status);
        }

        System.out.println("--------------------------------------------------");
        System.out.println("                     Summary                      ");
        System.out.println("--------------------------------------------------");
        System.out.println("Successful downloads : " + successfulDownloads);
        System.out.println("Failed downloads     : " + (totalFiles - successfulDownloads));
        System.out.printf("Total time           : %ds%n", totalTime);
    }
}
