package app;

public class MerkeziBirim implements IMerkeziBirim {

    private static MerkeziBirim ourInstance ;

    public static MerkeziBirim getInstance() {
        if(ourInstance==null)
            ourInstance=new MerkeziBirim();
        return ourInstance;
    }

    private MerkeziBirim(){}

    @Override
    public void Basla(){
        AgArayuzu.getInstance().KullaniciIslemleri();
    }

    @Override
    public int SicaklikKontrol(int sicaklik){
        if(sicaklik>= 50)
            sicaklik-= (sicaklik/2);
        else if(sicaklik < 50)
            System.out.println("Soğutucunun kapatılması tavsiye edilir.");

        return sicaklik;

    }

}
