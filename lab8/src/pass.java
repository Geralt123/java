

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Collection;

public class pass {
    public static void main(String[] args) throws IOException {

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            echoSocket = new Socket("localhost", 6666);
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

        out.println("login");
        in.readLine();
        out.println("");
        int len = Integer.parseInt(in.readLine());


        ArrayList<Integer> chara = new ArrayList<Integer>(256);
        for (int i = 0; i < 256; i++) {
            chara.add(0);
        }
        StringBuilder buf = new StringBuilder();
        for (int j = 65; j < 91; j++) {
            for (int i = 0; i < len; i++) {
                buf.append((char) j);
            }
            out.println(buf.toString());
            int q = Integer.parseInt(in.readLine());
            if (q > 0) {
                chara.set(j, len - q);
            }

            buf.delete(0, len);
        }
        for (int j = 97; j < 123; j++) {
            for (int i = 0; i < len; i++) {
                buf.append((char) j);
            }
            out.println(buf.toString());
            int q = Integer.parseInt(in.readLine());
            if (q > 0) {
                chara.set(j, len - q);
            }
            buf.delete(0, len);
        }

        int leni = 0;
        int nb;
        String a = new String();


        for (int j = 65; j < 91; j++) {
            nb = chara.get(j);
            if (nb > 0) {
                for (int i = 0; i < (buf.length()) + 1; i++) {
                    if (nb == 0) {
                        break;
                    }
                    leni = buf.length();
                    buf.insert(i, (char) j);
                    out.println(buf.toString());
                    a = in.readLine();
                    if (a.equals("!@#PASSWORD_CORRECT")) {
                        System.out.println(buf.toString());
                        out.close();
                        in.close();
                        stdIn.close();
                        echoSocket.close();
                        System.exit(0);
                    }
                    if (leni >= len - Integer.parseInt(a)) {
                        buf.deleteCharAt(i);
                    } else nb--;
                }
            }
        }

        for (int j = 97; j < 123; j++) {
            nb = chara.get(j);
            if (nb > 0) {
                for (int i = 0; i < (buf.length()) + 1; i++) {
                    if (nb == 0) {
                        break;
                    }
                    leni = buf.length();
                    buf.insert(i, (char) j);
                    out.println(buf.toString());
                    a = in.readLine();
                    if (a.equals("!@#PASSWORD_CORRECT")) {
                        System.out.println(buf.toString());
                        out.close();
                        in.close();
                        stdIn.close();
                        echoSocket.close();
                        System.exit(0);
                    }
                    if (leni >= len - Integer.parseInt(a)) {
                        buf.deleteCharAt(i);
                    } else nb--;
                }
            }
        }

    }
}


