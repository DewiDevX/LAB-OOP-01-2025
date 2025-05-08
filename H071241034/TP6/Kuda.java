public class Kuda extends Kendaraan implements IBergerak{
    String jenisKuda;
    double beratKuda;
    double kecepatan;

    public Kuda(String merek, String model) {
        super(merek, model);
    }

    public String getJenisKuda() {
        return jenisKuda;
    }

    public void setJenisKuda(String jenisKuda) {
        this.jenisKuda = jenisKuda;
    }

    public double getBeratKuda() {
        return beratKuda;
    }

    public void setBeratKuda(double beratKuda) {
        this.beratKuda = beratKuda;
    }

    public double getKecepatan() {
        return kecepatan;
    }

    public void setKecepatan(double kecepatan) {
        this.kecepatan = kecepatan;
    }

    
    @Override
    public double hitungPajak() {
        return 0;
    }

    @Override
    public String getTipeKendaraan() {
        return "Kuda";
    }

    @Override
    public boolean mulai() {
        System.out.println("Kuda berlari");
        return true;
    }

    @Override
    public boolean berhenti() {
        System.out.println("Kuda berhenti berlari");
        return false;
    }
}
