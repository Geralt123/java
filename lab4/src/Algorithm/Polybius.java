package Algorithm;

public class Polybius implements Algorithm {

    String literki = new String("ABCDEFGHIKLMNOPQRSTUVWXYZ");

    public String encrypt(String input) {
        StringBuilder output = new StringBuilder();
        for(int i = 0; i < input.length(); i++) {
            int c = input.charAt(i);
            if(c >= 'a' && c <= 'z')
                {c-=32;}
            if(c=='J'){
                c='I';
            }
            for (int j=0;j<25;j++){
                if (c==literki.charAt(j)){
                    output.append((j%5)+1);
                    output.append((j/5)+1);
        }}}
        return output.toString();
    }

    public String decrypt(String input) {
        StringBuilder output = new StringBuilder();
        for(int i = 0; i < input.length()/2; i++) {
            int c = input.charAt(2*i);
            int d = input.charAt((2*i)+1);
            output.append(literki.charAt(((d-49)*5)+c-49));
                }
        return output.toString();
    }}