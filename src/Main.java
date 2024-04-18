import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;





public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        SenderAndReceiver sr = new SenderAndReceiver();

        sr.receive();
    }
}
