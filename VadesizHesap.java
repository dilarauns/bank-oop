public class VadesizHesap  extends BankaHesap {
    private int hesapTuru;
    private double vadesizBakiye;
    

    public VadesizHesap(){}
    // vadesiz bakiye kullanicidan alinacak
    //
    public VadesizHesap(double toplamBakiye, String hesapBilgisi, int hesapTuru, double vadesizBakiye) {
        super(toplamBakiye, hesapBilgisi);
        this.hesapTuru = hesapTuru;
        
        setVadesizBakiye(vadesizBakiye);
    }

    public int getHesapTuru() {
        return hesapTuru;
    }

    public void setHesapTuru(int hesapTuru) {
        this.hesapTuru = hesapTuru;
    }

    public double getVadesizBakiye() {
        return vadesizBakiye;
    }

    public void setVadesizBakiye(double vadesizBakiye) {
       this.vadesizBakiye = vadesizBakiye;
    }

    public String toString() {
        String hesapTuruStr = this.hesapTuru == 1 ? "Maas Hesabi" : "Normal Hesap";
        
        return "Toplam bakiye:"+ this.getToplamBakiye() + "\nhesapTuru: " + hesapTuruStr
        + "\nVadesiz bakiye: " + vadesizBakiye + "\n Iban: "+ this.getIban() ;
    }
}

    

