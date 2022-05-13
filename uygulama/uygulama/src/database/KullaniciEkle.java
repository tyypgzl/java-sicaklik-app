package database;

import java.sql.*;
import java.util.Scanner;

public class KullaniciEkle implements IKullaniciEkle{
    private static KullaniciEkle ourInstance;
    public static KullaniciEkle getInstance() {
        if(ourInstance==null)
            ourInstance=new KullaniciEkle();
        return ourInstance;
    }

    private KullaniciEkle(){}

    private String kullaniciAdi;

    @Override
    public boolean KullaniciEkleme(){

        try {
            //veritabanı bağlantısı yapılır
            String jdbcURL="jdbc:postgresql://localhost:5432/sogutucu";
            Connection conn = DriverManager.getConnection(jdbcURL, "postgres", "123456");
            Scanner sc= new Scanner(System.in);

            System.out.println("Kullanici Adinizi Giriniz...: ");
            String ka=sc.nextLine();
            System.out.println("Adinizi Giriniz...: ");
            String ad=sc.nextLine();
            System.out.println("Soyainizi Giriniz...: ");
            String soyad=sc.nextLine();
            System.out.println("Şifrenizi Giriniz...: ");
            String sifre=sc.nextLine();

            kullaniciAdi=ka;
            String sql2 = "SELECT \"KullaniciAdi\" FROM \"Kullanici\" ";
            String sql= "INSERT INTO  \"Kullanici\" (\"KullaniciAdi\",\"Ad\",\"Soyadı\",\"sifre\") VALUES(?,?,?,?) ";

            //kullanıcıadi unique olduğundan seçilen kullanıcı adının daha önceden alınmamış olması gerekir.
            //bunun için tüm veritabanı taranır eğer eşleşme bulunmamışsa kayıda devam edilir.
            //eğer kayıt tamamlanamazsa false döner
            //tamamlanırsa true döner.

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql2);
            while (rs.next()) {
                String kAdi = rs.getString("KullaniciAdi");
                if(kAdi.equals(ka)){
                    System.out.println("Böyle bir kullanıcı zaten mevcut, yeni bir kullanıcı adı seçiniz.");
                    return false;
                }
            }

            PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, ka);
            pstmt.setString(2, ad);
            pstmt.setString(3, soyad);
            pstmt.setString(4, sifre);
            pstmt.executeUpdate();

            conn.close();
            pstmt.close();
            rs.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;

    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }
}
