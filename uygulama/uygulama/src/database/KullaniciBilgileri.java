package database;
import java.sql.*;


public class KullaniciBilgileri implements  IKullaniciBilgileri{

    private static KullaniciBilgileri ourInstance;

    public static KullaniciBilgileri getInstance() {
        if(ourInstance==null)
            ourInstance=new KullaniciBilgileri();
        return ourInstance;
    }

    private KullaniciBilgileri(){}

    @Override
    public void KullaniciBilgileriniGetir(String kullaniciAdi){
        try {
            //postgres://YourUserName:YourPassword@YourHostname:5432/YourDatabaseName
            String jdbcURL="jdbc:postgresql://localhost:5432/sogutucu";
            Connection conn = DriverManager.getConnection(jdbcURL, "postgres", "123456");
            String sql = "SELECT \"KullaniciID\", \"KullaniciAdi\", \"Ad\", \"Soyadı\" FROM \"Kullanici\" ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            conn.close();

            while (rs.next()) {
                String kI= rs.getString("KullaniciID");
                String Ad = rs.getString("Ad");
                String soyad = rs.getString("Soyadı");
                String kAdi = rs.getString("KullaniciAdi");

                if(kAdi.equals(kullaniciAdi)){
                    System.out.println("Kullanıcı ID..: " + kI+
                            "\nKullanıcı Adı..:" + kAdi+
                            "\nAdı..:"+ Ad+
                            "\nAd-Soyad..:"+ soyad);
                }
            }
            rs.close();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
