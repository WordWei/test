import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

/**
 * Created by Administrator on 2018/3/24.
 */
public class Send implements Runnable{

    private DatagramSocket datagramSocket;


    public Send(DatagramSocket datagramSocket) throws SocketException {
        this.datagramSocket = datagramSocket;
    }

    @Override
    public void run() {
        try {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String line = null;

            while((line=bufferedReader.readLine())!=null){
                byte[] buf = line.getBytes();
                DatagramPacket datagramPacket =
                        new DatagramPacket(buf,buf.length, InetAddress.getByName("192.168.31.254"),10000);

                datagramSocket.send(datagramPacket);
                if("886".equals(line)){
                    break;
                }
            }
            datagramSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
