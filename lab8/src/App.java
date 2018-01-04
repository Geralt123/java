
import java.io.*;
import java.net.*;
import java.util.Scanner;


public class App {

    public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
        //port musi być przekazany jako argument do programu
        short port = Short.parseShort(args[0]);
        //rozpoczęcie nasłuchiwania na porcie port,
        try(ServerSocket srv = new ServerSocket(port)){
            //przyjęcie nadchodzącego połączenia
            Socket s = srv.accept();
            System.out.print("new connection accepted: ");
            System.out.println(s.getInetAddress());
            new Thread(new SockReader(s)).start();
        }
    }
}

class SockReader implements Runnable {
    private Scanner in;
    private PrintStream out;
    private Socket s;

    public SockReader(Socket s) throws IOException {
        this(s.getInputStream(),s.getOutputStream());
        this.s = s;
    }

    public SockReader(InputStream input,OutputStream output) {
        in = new Scanner(input);
        out = new PrintStream(output);
    }

    private void msg(String msg) {
        System.out.print("SRV: ");
        System.out.println(msg);
    }


    BufferedReader stdIn = new BufferedReader(
            new InputStreamReader(System.in));

    public void run() {
        msg("new connection");
        while( (!Thread.currentThread().isInterrupted()) && in.hasNext() ) {
            String line = in.nextLine();
            msg(line);
            try {
                out.println(stdIn.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            out.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        msg("connection closed");
    }
}