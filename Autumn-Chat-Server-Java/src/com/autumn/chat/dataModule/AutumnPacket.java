package com.autumn.chat.dataModule;

import java.io.Serializable;

/** 
 * @author Happut-WangFei
 * @version 
 * @time 2012-11-30 ����10:56:12
 */
/**
 * ϵͳ�ײ���-��Ϣ���丸��
 * 
 */
public class AutumnPacket implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4048622577800201617L;
	/**
	 * ip��ַ
	 */
	private String ip;
	/**
	 * id��ʾ
	 */
	private String id;
	/**
	 * ��Ϣ����
	 */
	private String Message;

	/**
	 * ��Ϣ����
	 */
	private int type;

	public AutumnPacket(String id,String ip,String message,int type){
		this.id = id;
		this.ip = ip;
		this.Message = message;
		this.type = type;
	}
	
	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}
}
