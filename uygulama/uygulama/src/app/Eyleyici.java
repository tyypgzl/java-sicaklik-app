package app;

public class Eyleyici implements  IEyleyici {
    private static Eyleyici ourInstance ;

    public static Eyleyici getInstance() {
        if(ourInstance==null)
            ourInstance = new Eyleyici();
        return ourInstance;
    }
    private final int sicaklik;

    private Eyleyici() {
        sicaklik= SicaklikAlgilayici.getInstance().SicaklikOku();
    }

    @Override
    public boolean SogutucuAc(int sicaklik){
        System.out.println("Soğutucu Açıldı");
        return true;
    }

    @Override
    public boolean SogutucuKapa() {
        System.out.println("Soğutucu Kapatıldı");
        return false;
    }
}
