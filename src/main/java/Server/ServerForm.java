package Server;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.*;

public class ServerForm extends JFrame {

	private JPanel contentPane;
	public JScrollPane scrollPane;
	public JLabel label;
	public JTextField txtCount;
	public JButton btnStart;
	public JButton btnStop;
	public JTextArea txtLog;
	public JLabel label_1;
	public JTextField txtPort;

	ServerSocket server;
	ServerListener sListener;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerForm frame = new ServerForm();
					frame.setVisible(true);
					GameService.getgameService().setForm(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ServerForm() {
		setTitle("\u6E38\u620F\u670D\u52A1\u5668");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(new TitledBorder(null, "\u65E5\u5FD7\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setBounds(0, 0, 419, 403);
		contentPane.add(scrollPane);
		
		txtLog = new JTextArea();
		txtLog.setLineWrap(true);
		txtLog.setEditable(false);
		scrollPane.setViewportView(txtLog);
		
		label = new JLabel();
		label.setText("\u5F00\u653E\u6E38\u620F\u684C\u6570\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 12));
		label.setBounds(12, 415, 84, 15);
		contentPane.add(label);
		
		txtCount = new JTextField();
		txtCount.setText("8");
		txtCount.setFont(new Font("宋体", Font.PLAIN, 12));
		txtCount.setBounds(92, 412, 32, 21);
		contentPane.add(txtCount);
		
		btnStart = new JButton("\u5F00\u542F\u670D\u52A1");
		btnStart.addActionListener(new BtnStartActionListener());
		btnStart.setFont(new Font("宋体", Font.PLAIN, 12));
		btnStart.setBounds(246, 412, 84, 21);
		contentPane.add(btnStart);
		
		btnStop = new JButton("\u505C\u6B62\u670D\u52A1");
		btnStop.addActionListener(new BtnStopActionListener());
		btnStop.setFont(new Font("宋体", Font.PLAIN, 12));
		btnStop.setBounds(334, 412, 84, 21);
		contentPane.add(btnStop);
		
		label_1 = new JLabel();
		label_1.setText("\u7AEF\u53E3\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 12));
		label_1.setBounds(129, 414, 41, 15);
		contentPane.add(label_1);
		
		txtPort = new JTextField();
		txtPort.setText("8800");
		txtPort.setFont(new Font("宋体", Font.PLAIN, 12));
		txtPort.setBounds(165, 412, 52, 21);
		contentPane.add(txtPort);
	}
	private class BtnStartActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			try {
				int port =Integer.parseInt(txtPort.getText().trim());
				int count=Integer.parseInt(txtCount.getText().trim());
				//生成游戏桌
				GameService.getgameService().genGameTables(count);
				server=new ServerSocket(port);
				sListener=new ServerListener(server);
				sListener.start();
				GameService.getgameService().setLogTxt("服务器已启动...");
				
			} catch (Exception ee) {
				ee.printStackTrace();
			}
		}
	}
	private class BtnStopActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				sListener.stopListener();
				if(server!=null)
				   server.close();
				GameService.getgameService().setLogTxt("服务器已停止！");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
