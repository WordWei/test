import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by Administrator on 2018/3/24.
 */
public class Rece implements Runnable{
    private DatagramSocket datagramSocket;

    Rece(DatagramSocket datagramSocket){
        this.datagramSocket = datagramSocket;
    }

    @Override
    public void run() {



        try {

            while(true){

                byte[] buf = new byte[1024];
                DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
                datagramSocket.receive(datagramPacket);

                String name = datagramPacket.getAddress().toString();
                int  port = datagramPacket.getPort();
                String text = new String(datagramPacket.getData(),0,datagramPacket.getLength());

                System.out.println(name+":"+text);

                if(text.equals("886")){
                    System.out.println(name+"退出聊天室！");

                }
            }



        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
