import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.autumn.chat.dataModule.AutumnPacket;
import com.sun.java_cup.internal.runtime.Scanner;
import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;


public class test {
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		AutumnPacket autumnPacket = new AutumnPacket();
		autumnPacket.setId("1");
		autumnPacket.setIp("ddd");
		autumnPacket.setType(1);
		autumnPacket.setMessage("aaaaa");
		Socket socket = new Socket("127.0.0.1", 11111);	
OutputStream os = socket.getOutputStream();
		int i=0;
		while(i++<10){
		
			BufferedOutputStream netOut = new BufferedOutputStream(os);
			ObjectOutputStream oos = new ObjectOutputStream(netOut);
			oos.writeObject(autumnPacket);
			oos.close();
			netOut.close();
		
		}
		os.close();
		socket.close();
	}
}
