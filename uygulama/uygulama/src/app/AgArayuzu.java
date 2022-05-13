package app;

import database.KullaniciDogrulama;
import database.KullaniciEkle;

import java.util.Scanner;

public class AgArayuzu implements  IAgArayuzu {
    private static AgArayuzu ourInstance;

    public static AgArayuzu getInstance() {
        if (ourInstance == null)
            ourInstance = new AgArayuzu();
        return ourInstance;
    }

    private AgArayuzu() {}

    @Override
    public void IslemYap(String kullaniciAdi) {
        Scanner sc = new Scanner(System.in);
        O_KullaniciBilgileri.getInstance().BilgiGetir(10, true, kullaniciAdi);  //bilgileri getirilmesi istediğim kullanıcının bilgileri getirilir
        String cevap = "";
        int sicaklik=0;
        do {
            System.out.println("\nYapmak istediğiniz işlemi seçiniz..: ");
            System.out.println("1- Sıcaklığı Görüntüle\n2-Soğutucuyu Aç\n3-Soğutucuyu Kapat");
            int cevap2 = sc.nextInt();
            switch (cevap2) {
                case 1:
                    sicaklik=SicaklikAlgilayici.getInstance().SicaklikOku();
                    System.out.println("Sıcaklık..:" + sicaklik);                               //sıcaklık yazdırılır
                    break;
                case 2:
                    O_BilgiGetir.getInstance().BilgiGetir(sicaklik, Eyleyici.getInstance().SogutucuAc(sicaklik), kullaniciAdi); //soğutucu açılır ve soğutucunun durum güncellemesi yapılır
                    break;
                case 3:
                    O_BilgiGetir.getInstance().BilgiGetir(sicaklik, Eyleyici.getInstance().SogutucuKapa(),kullaniciAdi); //soğutucu kapatılır ve soğutucunun durum güncellemesi yapılır
                    break;

                default:
                    System.out.println("Gerçersiz Seçim Yaptınız");
                    break;

            }
            System.out.println("İşleminize devam etmek istiyor musunuz?..(e/h)");
            cevap = sc.next();
            System.out.println("\n");
        } while (!(cevap.equals("h")));
    }

    @Override
    public void KullaniciIslemleri(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Lütfen Yapmak İstediğiniz İşleminizi Seçiniz..:" +
                "\n1-Kayıtlı Kullanıcı İşlemleri" +
                "\n2-Kaydol");
        int cvp=sc.nextInt();
        if(cvp==1) {
            System.out.println("Kullanıcı Adınız..:");
            String kullaniciAdi = sc.nextLine();
            kullaniciAdi = sc.nextLine();
            System.out.println("Şifrenizi Giriniz..:");
            String sifre = sc.nextLine();

            if (KullaniciDogrulama.getInstance().KullaniciDogrula(kullaniciAdi, sifre) == true) {  //eğer kullanıcı doğrulaması yapılmışsa
                IslemYap(kullaniciAdi); //kullanıcı işlemlerini yapsın
            }
        }
        else if(cvp==2){ //eğer yeni kullanıcı kaydı oluyorsa
            boolean deneme= KullaniciEkle.getInstance().KullaniciEkleme(); //önce kayıt olsun
            if(deneme==true)
                IslemYap(KullaniciEkle.getInstance().getKullaniciAdi()); //daha sonra işlemlerini yapsın
        }
        else
            System.out.println("Geçersiz seçim yaptınız.");
    }
}
