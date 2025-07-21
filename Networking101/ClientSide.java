package Networking101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSide {
    private Socket sosket;
    private PrintWriter pw;
    private BufferedReader br;

    public ClientSide(Socket socket){
        this.sosket = socket;

        //WE CONNECT AN INPUTSTREAM WITH BUFFERRED READER USING AN INPUTSTREAMREADER SINCE ONE IS 8 AND ONE IS A 16 BITS
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        new ClientSide(new Socket("localhost", 2000)).run();
    }

    public void run(){
        try {
            pw.println("Hello world of Networking");
            System.out.println(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            pw.close();

            try {
                br.close();
                sosket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }


}
