package Client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Point;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ClientForm extends JFrame {

	private JPanel contentPane;
	public JLabel label;
	public JTextField txtIP;
	public JLabel label_1;
	public JTextField txtPort;
	public JLabel label_2;
	public JTextField txtUser;
	public JButton btnLogin;
	public JButton btnClose;
	public JScrollPane scrollPane;
	public JPanel panelTables;

	
	JCheckBox [][] jCheckBoxs;
	CheckboxItemChanged ckItemChanged=new CheckboxItemChanged();
	public JButton btnMeachine;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientForm frame = new ClientForm();
					frame.setVisible(true);
					ClientService.getClientService().setForm(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientForm() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("IP");
		label.setFont(new Font("????", Font.PLAIN, 12));
		label.setBounds(9, 13, 19, 21);
		contentPane.add(label);
		
		txtIP = new JTextField();
		txtIP.setText("127.0.0.1");
		txtIP.setColumns(10);
		txtIP.setBounds(28, 13, 70, 21);
		contentPane.add(txtIP);
		
		label_1 = new JLabel("\u7AEF\u53E3");
		label_1.setFont(new Font("????", Font.PLAIN, 12));
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(104, 16, 34, 15);
		contentPane.add(label_1);
		
		txtPort = new JTextField();
		txtPort.setText("8800");
		txtPort.setColumns(10);
		txtPort.setBounds(141, 13, 41, 21);
		contentPane.add(txtPort);
		
		label_2 = new JLabel("\u7528\u6237\u540D");
		label_2.setFont(new Font("????", Font.PLAIN, 12));
		label_2.setHorizontalAlignment(SwingConstants.RIGHT); 
		label_2.setBounds(184, 16, 49, 15);
		contentPane.add(label_2);
		
		txtUser = new JTextField();
		txtUser.setColumns(10);
		txtUser.setBounds(235, 13, 57, 21);
		contentPane.add(txtUser);
		
		btnLogin = new JButton("\u767B\u5F55");
		btnLogin.addActionListener(new BtnLoginActionListener());
		btnLogin.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLogin.setBounds(302, 12, 66, 23);
		contentPane.add(btnLogin);
		
		btnClose = new JButton("\u9000\u51FA");
		btnClose.addActionListener(new BtnCloseActionListener());
		btnClose.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnClose.setBounds(370, 12, 66, 23);
		contentPane.add(btnClose);
		
		scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("????", Font.PLAIN, 12));
		scrollPane.setBorder(new TitledBorder(null, "\u6E38\u620F\u684C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setBounds(1, 78, 435, 392);
		contentPane.add(scrollPane);
		
		panelTables = new JPanel();
		panelTables.setLocation(new Point(10, 10));
		panelTables.setBackground(UIManager.getColor("Button.select"));
		scrollPane.setViewportView(panelTables);
		panelTables.setLayout(new GridLayout(6, 2, 5, 5));
		
		btnMeachine = new JButton("\u4EBA\u673A\u5BF9\u5F08");
		btnMeachine.addActionListener(new BtnMeachineActionListener());
		btnMeachine.setBounds(302, 38, 134, 27);
		contentPane.add(btnMeachine);
	}
	
	public void setCheckBoxCount(int count){
		jCheckBoxs=new JCheckBox[count][2];
	}
	public void addTable(int i,String s1,String s2){
		//
		//
		JPanel jp = new JPanel();
		jp.setBackground(Color.WHITE);			
		jp.setLayout(new GridLayout(0, 3, 0, 0));
		
		jCheckBoxs[i][0] = new JCheckBox();
		jCheckBoxs[i][0].setBackground(Color.WHITE);
		jCheckBoxs[i][0].setHorizontalAlignment(SwingConstants.RIGHT);
		jCheckBoxs[i][0].setText("???");
		jCheckBoxs[i][0].setName(i+"|0");	//	???????????????????????????????+???????????
		if (s1.equals("1"))  //???????????????????????CHeckbox ????????ó??????
		{
			jCheckBoxs[i][0].setSelected(true);
			jCheckBoxs[i][0].setEnabled(false);
		}		
		jp.add(jCheckBoxs[i][0]);

		//??????????logo
		JLabel lbImag = new JLabel("");//??????????logo
		Image img=new ImageIcon("img\\board.jpg").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		lbImag.setIcon(new ImageIcon(img));
		lbImag.setHorizontalAlignment(SwingConstants.CENTER);
		jp.add(lbImag);
		
		
		jCheckBoxs[i][1] = new JCheckBox();
		jCheckBoxs[i][1].setBackground(Color.WHITE);
		jCheckBoxs[i][1].setHorizontalAlignment(SwingConstants.LEFT);
		jCheckBoxs[i][1].setText("??");
		jCheckBoxs[i][1].setName(i+"|1");
		if (s2.equals("1")) //???????????????????????CHeckbox ????????ó??????
		{
			jCheckBoxs[i][1].setSelected(true);
			jCheckBoxs[i][1].setEnabled(false);
		}
		jp.add(jCheckBoxs[i][1]);
		
		
		jCheckBoxs[i][0].addItemListener(ckItemChanged);  //??????????????????????
		jCheckBoxs[i][1].addItemListener(ckItemChanged);  //?????????????????????
	
		panelTables.add(jp);
		panelTables.revalidate();
		
	}

	public void updateTable(int i,int side,String flag){
		//
		jCheckBoxs[i][side].removeItemListener(ckItemChanged);
		
		if (flag.equals("1")) {
			jCheckBoxs[i][side].setSelected(true);
			jCheckBoxs[i][side].setEnabled(false);
		}
		else
		{
			jCheckBoxs[i][side].setSelected(false);
			jCheckBoxs[i][side].setEnabled(true);
		}
		jCheckBoxs[i][side].addItemListener(ckItemChanged);	
	}
	private class BtnLoginActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String IP=txtIP.getText().trim();
			int port =Integer.parseInt(txtPort.getText().trim());
			String sUser=txtUser.getText().trim();
			ClientService.getClientService().connect(IP, port, sUser);
			//btnLogin.setEnabled(false);
		}
		
	}
	
   private class CheckboxItemChanged implements ItemListener{		
		public void itemStateChanged(ItemEvent e) {
			JCheckBox jcBox=(JCheckBox)e.getSource();
			if (jcBox.isSelected()) {
				//SELECT@tableIndex@side
				String str="SELECT|"+jcBox.getName();
				ClientService.getClientService().getClientGame().sendMSG(str);
				jcBox.setEnabled(false);
			}
		}
	}
   private class BtnCloseActionListener implements ActionListener {
   	public void actionPerformed(ActionEvent arg0) {
   		panelTables.removeAll();
   		panelTables.repaint();
   	//CLOSE|name
   		String str="CLOSE|"+ClientService.getClientService().getClientGame().getName();
		ClientService.getClientService().getClientGame().sendMSG(str);
		ClientService.getClientService().getClientGame().closeSocket();
		btnLogin.setEnabled(true);
   	}
   	
   }
   private class BtnMeachineActionListener implements ActionListener {
   	public void actionPerformed(ActionEvent e) {
   		ClientService.getClientService().meachineGame();
   		//GameForm gf=new GameForm(0, 3);
   		//gf.setVisible(true);
   	}
   }
}
