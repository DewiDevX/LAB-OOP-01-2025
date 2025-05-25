package DownloadFile;

public class Result {
    int fileId;
    int duration;
    String threadName;
    String status;

    public Result(int fileId, int duration, String threadName, String status) {
        this.fileId = fileId;
        this.duration = duration;
        this.threadName = threadName;
        this.status = status;
    }
}

