package app;

public class O_BilgiGetir implements  IObserver{

    private static O_BilgiGetir ourInstance;

    public static O_BilgiGetir getInstance() {
        if(ourInstance==null)
            ourInstance=new O_BilgiGetir();
        return ourInstance;
    }

    private O_BilgiGetir() {}

    @Override
    public void BilgiGetir(int sicaklik, boolean sogutucu, String kullaniciAdi){
        sicaklik=MerkeziBirim.getInstance().SicaklikKontrol(sicaklik);  //Merkez Birimden en son sıcaklık alınır
        System.out.println("Akıllı Cihazınızın\n"+
                "Güncel Sıcaklığı..:"+ sicaklik+ "°C");

        if(sogutucu==true)
            System.out.println("Soğutucunun durumu..: Soğutucu Açık");
        else
            System.out.println("Soğutucunun durumu..: Soğutucu Kapalı");
    }
}
