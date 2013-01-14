import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.autumn.chat.dataModule.AutumnPacket;


public class test {
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		AutumnPacket autumnPacket = new AutumnPacket();
		autumnPacket.setId("1");
		autumnPacket.setIp("ddd");
		autumnPacket.setType(1);
		autumnPacket.setMessage("aaaaa");
		Socket socket = new Socket("127.0.0.1", 11111);	
		OutputStream os = socket.getOutputStream();
		BufferedOutputStream netOut = new BufferedOutputStream(os);
		ObjectOutputStream oos = new ObjectOutputStream(netOut);
		int i=0;
		while(i++<10){
			oos.writeObject(autumnPacket);
			oos.flush();
		}
		oos.close();
		netOut.close();
		os.close();
		socket.close();
	}
}
