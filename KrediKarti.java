import java.util.Random;;
public class KrediKarti {
    private long kartNo;
    double guncelBorc;
    double kullanilabilirLimit;
    public KrediKarti(){}

    public KrediKarti(double limit, double guncelBorc, double kullanilabilirLimit) {
        this.kullanilabilirLimit = kullanilabilirLimit;
        setkartNo();
    }

    public long getkartNo() {
        return kartNo;
    }

    public void setkartNo() {
        int numDigits = 11;
        long lowerBound = (long) Math.pow(10, numDigits - 1);
        long upperBound = (long) Math.pow(10, numDigits) - 1;
        Random random = new Random();
        this.kartNo = lowerBound + (long) (random.nextDouble() * (upperBound - lowerBound));
    }
    
    public double getKullanilabilirLimit(){
        return this.kullanilabilirLimit;
    }

    public String toString() {
        return "kartNo=" + kartNo + ", guncelBorc=" + guncelBorc + "limit=" + kullanilabilirLimit;
    }

    
}
