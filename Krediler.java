import java.util.Scanner;
import java.util.Random;
public class Krediler {
    Scanner input= new Scanner(System.in);
    private long  krediId;
    double krediMiktari;
    double taksitMiktari;
    private long musteriNo; 
    public Krediler(long musteriNo, double krediMiktari){
        setKrediId();
        this.musteriNo=musteriNo;
        this.krediMiktari=krediMiktari;
    }
    //musteri numarasina gore musteriye ait kredi bilgilerini yazdiracagiz.
    
    public void setKrediId(){
        int numDigits = 5;
        long lowerBound = (long) Math.pow(10, numDigits - 1);
        long upperBound = (long) Math.pow(10, numDigits) - 1;
        Random random = new Random();
        this.krediId = lowerBound + (long) (random.nextDouble() * (upperBound - lowerBound));
    }

    public double getKrediId(){
        return this.krediId;
    }

    
    public void kampanya(double krediKartiLimit)
    { 
        if
        (krediKartiLimit>10000){
        
            System.out.println("Yillik gelirinizin 2 katini oraninca kredi almak isterseniz 'evet' , istemiyorsaniz 'hayir' yazin:");
            String kampanyaKabul= input.nextLine();
            if(kampanyaKabul.equals("evet")){
                System.out.println("Alabileceginiz kredi limiti 10000 TL arttirildi. 24 ay taksitle odeyebilirsiniz.");
                krediMiktari = krediMiktari+10000;
            }
            else{
                System.out.println("Kampanya reddedildi.");
            }
        }
    }//kampanya

    public String toString() {
        return "\n Kredi ID: "+ this.krediId + "\n Alinabilecek kredi miktari: "+ this.krediMiktari;
    }
}
