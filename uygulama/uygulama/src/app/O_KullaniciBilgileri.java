package app;

import database.KullaniciBilgileri;

public class O_KullaniciBilgileri implements  IObserver {
    private static O_KullaniciBilgileri ourInstance;

    public static O_KullaniciBilgileri getInstance() {
        if(ourInstance==null)
            ourInstance  = new O_KullaniciBilgileri();
        return ourInstance;
    }

    private O_KullaniciBilgileri(){}

    @Override
    public void BilgiGetir(int sicaklik, boolean sogutucu, String kullaniciAdi) {
        KullaniciBilgileri.getInstance().KullaniciBilgileriniGetir(kullaniciAdi); //Veri tabanından kullanıcı bilgileri alınır
    }
}
