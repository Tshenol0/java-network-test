package Networking101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSide {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(2000);

        System.out.println("Waiting for connection");
        //Socket socket = ss.accept();
        run(ss.accept()); //blocking on IO

        System.out.println("A connection has been made.");

    }

    public static void run(Socket socket) throws IOException {
       PrintWriter pw = new PrintWriter(socket.getOutputStream());
       BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

       String fromClient = br.readLine();
       StringBuilder sb = new StringBuilder(fromClient);
       String revered = sb.reverse().toString();
       pw.println(revered+ " this is from blessings machine");
       pw.close();
       br.close();
       socket.close();
    }
}
