import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by Administrator on 2018/3/24.
 */
public class Chat {

    public static void main(String[] args) throws SocketException {

        DatagramSocket send = new DatagramSocket();
        DatagramSocket rece = new DatagramSocket(10000);

        new Thread(new Send(send)).start();
        new Thread(new Rece(rece)).start();

    }

}
