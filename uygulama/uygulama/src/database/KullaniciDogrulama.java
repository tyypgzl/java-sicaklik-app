package database;

import java.sql.*;

public class KullaniciDogrulama implements IKullaniciDogrulama {
    private static KullaniciDogrulama ourInstance;

    public static KullaniciDogrulama getInstance() {
        if (ourInstance == null)
            ourInstance = new KullaniciDogrulama();
        return ourInstance;
    }

    private KullaniciDogrulama() {}

    @Override
    public boolean KullaniciDogrula(String kullaniciAdi, String sifre) {

        try {
            //veritabanı bağlantısı yapılır
            String jdbcURL="jdbc:postgresql://localhost:5432/sogutucu";
            Connection conn = DriverManager.getConnection(jdbcURL, "postgres", "123456");
            String sql = "SELECT  \"KullaniciAdi\", \"sifre\" FROM \"Kullanici\" ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            conn.close();

            //tüm veritabanı taranır ve girilen kullanıcı adı ve şifre aranır. Eşleşme varsa true döner yoksa false döner.
            while (rs.next()) {
                String kAdi = rs.getString("KullaniciAdi");
                String s = rs.getString("sifre");

                if (kAdi.equals(kullaniciAdi) && s.equals(sifre)) {
                    System.out.println("Kullanıcı Doğrulandı\n");
                    return true;
                }
            }
            rs.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
