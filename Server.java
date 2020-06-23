import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(1235);
            Socket s = ss.accept();
            DataInputStream data = new DataInputStream(s.getInputStream());
            String dStr = (String)data.readUTF();
            System.out.println(dStr);

            File file = new File("Score.txt");
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fr);
            br.write(dStr);
            br.close();
            //ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}