package Comparator;

import java.util.LinkedList;

public class Sort {
    private static Pracownik jan = new Pracownik();
    private static Pracownik tan = new Pracownik();

    public static Pracownik[] pos (Pracownik[] npos){
        for (int i=0; i<npos.length; i++){
            for (int j=0; j<npos.length-1; j++){
                if (Comp.wiekszy(npos[j],npos[j+1])){

                }
                else {
                    jan=npos[j];
                    tan=npos[j+1];
                    npos[j]=tan;
                    npos[j+1]=jan;
                }
            }
        }
        return npos;
    }
}