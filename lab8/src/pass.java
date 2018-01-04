

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class pass {
    public static void main(String[] args) throws IOException {

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            echoSocket = new Socket("localhost", 3000);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: localhost.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                    + "the connection to: localhost.");
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(
                new InputStreamReader(System.in));
        String userInput;

        out.println("szymon;");
        int len = Integer.parseInt(in.readLine());
        System.out.println(len);


        ArrayList<Integer> chara = new ArrayList<Integer>();
        StringBuilder buf = new StringBuilder();
        for (int j = 65; j<91; j++) {
            for (int i = 0; i < len; i++) {
                buf.append((char) j);
            }
            out.println("szymon;" + buf.toString());
            int q =Integer.parseInt(in.readLine());
            if (q>0){
                chara.set(j,len-q);
            }

            buf.delete(0,len);
        }
        for (int j = 97; j<123; j++) {
            for (int i = 0; i < len; i++) {
                buf.append((char) j);
            }
            out.println("szymon;" + buf.toString());
            int q =Integer.parseInt(in.readLine());
            if (q>0){
                chara.set(j, len-q);
            }
            buf.delete(0,len);
        }

        StringBuilder fin = new StringBuilder();
        int leni;
        while(fin.length()==len){
            for (int j=65; j<91; j++){
                int nb = chara.get(j);
                if (nb >0){
                    for (int i=0 ; i<fin.length()+1; i++){
                        leni = len - fin.toString().length();
                        fin.setCharAt(i,(char) j);
                        out.println("szymon"+fin.toString());
                        if (leni>=Integer.parseInt(in.readLine())){
                            fin.deleteCharAt(i);
                        }
                    }
                }
            }
            for (int j=97; j<123; j++){
                int nb = chara.get(j);
                if (nb >0){
                    for (int i=0 ; i<fin.length()+1; i++){
                        leni = len - fin.toString().length();
                        fin.setCharAt(i,(char) j);
                        out.println("szymon"+fin.toString());
                        if (leni>=Integer.parseInt(in.readLine())){
                            fin.deleteCharAt(i);
                        }
                    }
                }
            }
        }


        System.out.println(fin.toString());
        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();
    }
}

