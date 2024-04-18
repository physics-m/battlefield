import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SenderAndReceiver {

   public void send() throws IOException {

       //建立一个socket
       DatagramSocket socket = new DatagramSocket(52001,InetAddress.getByName("127.0.0.1"));
       //创建一个数据包
       String preSignal = "#Chat.Send#";
       String msg = "1.1";
       msg = msg + preSignal;
       InetAddress localhost = InetAddress.getByName("localhost");
       int port = 51001;
       DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, localhost, port);
       //发送数据包
       socket.send(packet);
       //关闭流
       socket.close();
   }

    public void receive() throws IOException, InterruptedException {
       while(true){
           Thread.sleep(2000);
           DatagramSocket socket = new DatagramSocket(52002,InetAddress.getByName("127.0.0.1"));
           //接收数据包
           byte[] bytes = new byte[2048];
           DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length);
           //阻塞接收
           socket.receive(packet);
           String msg = new String(packet.getData(),0,packet.getLength());
           System.out.println("接收到客户端发来的数据：" + msg);
           //关闭数据流
           socket.close();
       }

    }
}
