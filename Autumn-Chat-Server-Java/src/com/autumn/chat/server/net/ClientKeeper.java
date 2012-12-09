package com.autumn.chat.server.net;    

import java.net.Socket;

import com.autumn.chat.dataModule.AutumnPacket;
import com.autumn.chat.server.ui.MainWindow;

/** 
 * @author Happut-WangFei
 * @version 
 * @time 2012-11-30 ����11:02:39
 */
public class ClientKeeper{
	private Socket sock;
	private ReceiveThread rec;
	private SendThread send;
	public ClientKeeper(Socket socket){
		this.sock = socket;
		MainWindow.getInstance().addInfo(sock.getInetAddress().getHostAddress(),"�յ�����"+sock.getInetAddress().getHostAddress()+"����Ϣ��");
		rec = new ReceiveThread(this,true);
		send = new SendThread(this,true);
		//MainWindow.getInstance().addInfo("�յ���Ϣ");
	}
	public Socket getSock() {
		return sock;
	}
	public void setSock(Socket sock) {
		this.sock = sock;
	}
	public void sendPacket(AutumnPacket autumnPacket){
		send.send(autumnPacket);
	}
	public void stopClient(){
		rec.stop();
		send.stop();
	}
}
  
