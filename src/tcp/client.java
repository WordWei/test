package tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Administrator on 2018/3/25.
 */
public class client {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("192.168.31.254",10004);

        OutputStream outputStream = socket.getOutputStream();

    }
}
