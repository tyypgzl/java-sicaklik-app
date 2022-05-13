package app;

import java.util.Random;

public class SicaklikAlgilayici implements  ISıcaklıkAlgılayıcıFactory {
    private static SicaklikAlgilayici ourInstance;
    private int sicaklik;


    public static SicaklikAlgilayici getInstance() {
        if(ourInstance==null)
            ourInstance = new SicaklikAlgilayici();
        return ourInstance;
    }



    public int SicaklikOku(){
        Random rnd= new Random();
        sicaklik=rnd.nextInt(100);
        return sicaklik;
    }

    @Override
    public SicaklikAlgilayici factoryMethod() {
          SicaklikAlgilayici sıcaklıkAlgilayici=new SicaklikAlgilayici();



          return  sıcaklıkAlgilayici;
    }
}
