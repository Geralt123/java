package Comparator;

public class Main {
    public static void main(String[] argv){
        Pracownik bob = new Pracownik();
        Pracownik tom = new Pracownik();
        Pracownik lan = new Pracownik();
        Pracownik man = new Pracownik();
        Pracownik[] pra = new Pracownik[4];
        Pracownik[] sort = new Pracownik[4];
        bob.brutto=1000.5;
        pra[0]=bob;
        tom.brutto=140.00;
        pra[1]=tom;
        lan.brutto=1400.20;
        pra[2]=lan;
        man.brutto=250.0;
        pra[3]=man;
        sort=Sort.pos(pra);
        for (int i = 0; i<4; i++){
            System.out.println(sort[i].getBrutto());
        }
    }
}
