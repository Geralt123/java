package Comparator;

public class Comp {
    public static boolean wiekszy (Pracownik pier, Pracownik drugi){
        if (pier.brutto>drugi.brutto){
            return true;
        }
        else {
            return false;
        }
    }
}
