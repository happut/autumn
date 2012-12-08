package com.autumn.chat.client.dataModule;

import java.io.Serializable;

/** 
 * @author Happut-WangFei
 * @version 
 * @time 2012-11-30 下午10:56:12
 */
/**
 * 系统底层类-信息传输父类
 * 
 */
public class AutumnPacket implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ip地址
	 */
	private String ip;
	/**
	 * id标示
	 */
	private String id;
	/**
	 * 消息内容
	 */
	private String Message;

	/**
	 * 消息类型
	 */
	private int type;

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
