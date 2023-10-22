import java.util.Date;
import java.util.Random;

public class BankaHesap {
    private String iban;
    private Date hesapAcilisTarihi;
    private double toplamBakiye;
    private String hesapBilgisi;
    private Double islemMiktar;
    private int hesapTuru; // 1 --> maas, 2 --> normal
    public BankaHesap() {}
    
    public BankaHesap(double toplamBakiye, String hesapBilgisi) {
        this.toplamBakiye=toplamBakiye;
        this.setIban();
        this.hesapBilgisi=hesapBilgisi;
    }
    public void setIban() {
        Random random = new Random();
        int numDigits = 22; 
        long lowerBound = (long)Math.pow(10, numDigits - 1); 
        long upperBound = (long)Math.pow(10, numDigits) - 1; 
        
        this.iban = "TR46" + Long.toString(lowerBound + (long)(random.nextDouble() * (upperBound - lowerBound))); }

    public String getIban() {
        return this.iban;
    }


  
    public void setToplamBakiye(double bakiye) {
        this.toplamBakiye=bakiye;
    }

    public double getToplamBakiye() {
        return this.toplamBakiye;
    }
    
    public String getHesapBilgisi() {
        return hesapBilgisi;
    }

    public void setHesapBilgisi(String hesapBilgisi) {
        this.hesapBilgisi = hesapBilgisi;
    }

    public void hesapGoruntuleme(){
      System.out.println(this.toString());
    }


    public String toString() {
        return "\nIban:"+ getIban() + "\nhesap bilgisi:"+ getHesapBilgisi()+ "\ntoplam bakiye:"+ getToplamBakiye()+ "\n";
    }
}
