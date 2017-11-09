package Algorithm;

public class Main {
    public static void main(String[] args) {
        ROT11 rot11 = new ROT11();
        Polybius pol = new Polybius();
        String name = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String encrypted = rot11.encrypt(name);
        System.out.println(encrypted);
        String decrypted = rot11.decrypt(encrypted);
        System.out.println(decrypted);
        System.out.println(pol.encrypt(name));
        System.out.println(pol.decrypt(pol.encrypt(name)));
    }
}
