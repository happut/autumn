package com.autumn.chat.server.ui;    

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.autumn.chat.server.net.ServerThread;

/** 
 * @author Happut-WangFei
 * @version 
 * @time 2012-12-5 下午09:02:01
 */
public class MainWindow extends JFrame{
	private static MainWindow mainWindow;
	
	private JButton startButton;
	private JButton stopButton;
	private ServerThread serverThread;
	private Container container;
	private JTextField portText;
	
	private JLabel info;
	
	public JLabel getInfo() {
		return info;
	}
	private JPanel mainPanel;
	
	public MainWindow(){
		mainWindow = this;
		
		init();
		container.add(mainPanel);
		setVisible(true);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static MainWindow getInstance() {
		if (mainWindow == null) {
			mainWindow = new MainWindow();
		}
		return mainWindow;
	}

	private void init() {
		portText = new JTextField(10);
		info = new JLabel("1111");
		
		startButton = new JButton("打开服务器");
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(portText.getText().equals("")){
					JOptionPane.showMessageDialog(getInstance(),"请输入端口号");
				}else {
					serverThread = new ServerThread(Integer.parseInt(portText.getText()));
					serverThread.start();
					startButton.setEnabled(false);
					stopButton.setEnabled(true);					
				}
			}
		});
		stopButton = new JButton("停止服务器");
		stopButton.setEnabled(false);
		stopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				serverThread.stopServer();
				startButton.setEnabled(true);
				stopButton.setEnabled(false);
			}
		});

		container = getContentPane();
		mainPanel = new JPanel();
		mainPanel.add(startButton);
		mainPanel.add(stopButton);
		mainPanel.add(portText);
	}
	public static void main(String[] args) {
		new MainWindow();
	}
}
  
