public class Book extends LibraryItem {
    private String author;

    public Book(String title, int itemId, String author) {
        super(title, itemId);
        this.author = author;
    }

    @Override
    public String getDescription() {
        return "Buku: " + title + " oleh " + author + ", ID: " + itemId;
    }

    @Override
    public String borrowItem(int days) {
        if (isBorrowed) {
            return "Item \"" + title + "\" sudah dipinjam oleh anggota lain.";
        }
        if (days > 14) {
            return "Gagal meminjam: Maksimal peminjaman adalah 14 hari.";
        }
        isBorrowed = true;
        return "Item \"" + title + "\" berhasil dipinjam selama " + days + " hari.";
    }

    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 10000;
    }
}
