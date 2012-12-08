import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.autumn.chat.client.dataModule.AutumnPacket;


public class test {
	public static void main(String[] args) throws UnknownHostException, IOException {
		AutumnPacket autumnPacket = new AutumnPacket();
		autumnPacket.setId("1");
		autumnPacket.setIp("ddd");
		autumnPacket.setType(1);
		autumnPacket.setMessage("aaaaa");
		
		
		Socket socket = new Socket("127.0.0.1", 11111);
		
	}
}
