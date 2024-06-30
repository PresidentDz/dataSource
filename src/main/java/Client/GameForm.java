package Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Font;

import javax.imageio.ImageTypeSpecifier;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameForm extends JFrame {

	private JPanel contentPane;
	public JPanel panel;
	public JPanel panel_1;

	
	JLabel [] lbNames=new JLabel[2]; //�ڷ���׷�����Ϸ������ 0���ڷ����ƣ�1���췽����
	public JPanel panelDraw;
	public JButton btnStart;
	public JButton btnClose;

	int gametableIndex;  //��¼��Ϸ���ı��
	int side;            //��Ϸ������λ��
	public JScrollPane scrollPane;
	public JTextArea txtLog;
	public JTextField txtSend;
	public JButton btnSend;
	
	boolean isMeachine;//�˻����ı�־
	boolean isStart; //��ʼ��Ϸ�ı��
	boolean isClick;  //������ӵĿ��ر���
	int ChessType; //��������  1���ڷ���2���췽    
					//�ڷ�1-�췽2-
					//1,������  
					//2��  3�e 4�� 5�� 6��7����˧	
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GameForm frame = new GameForm(0,1);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	 
	public GameForm(int tbIndex,int side) {
		setResizable(true);
		isMeachine=false;
		if(side==3){
			isMeachine=true;
			this.side=1;
		}
		if(side==0){
			setTitle("中国象棋");
			ChessType=1;
		}
			
		else{
			setTitle("中国象棋");
			ChessType=2;
		}
		if(!isMeachine){//side=3 �����˻�����ģʽ
			gametableIndex=tbIndex;
			this.side=side;	
		}
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1019, 695);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u9ED1\u65B9", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 130, 182);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lbNames[0] = new JLabel("");
		lbNames[0].setFont(new Font("宋体", Font.PLAIN, 12));
		lbNames[0].setBounds(37, 67, 54, 15);
		panel.add(lbNames[0]);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "�췽", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 202, 130, 182);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lbNames[1] = new JLabel("");
		lbNames[1].setFont(new Font("宋体", Font.PLAIN, 12));
		lbNames[1].setBounds(37, 67, 54, 15);
		panel_1.add(lbNames[1]);
		
		panelDraw = new picPanel();
		panelDraw.addMouseListener(new PanelDrawMouseListener());
		panelDraw.setBounds(173, 20, 575, 637);
		contentPane.add(panelDraw);
		
		btnClose = new JButton("\u9000\u51FA\u6E38\u620F");
		btnClose.addActionListener(new BtnCloseActionListener());
		btnClose.setFont(new Font("宋体", Font.PLAIN, 12));
		btnClose.setBounds(24, 494, 116, 29);
		contentPane.add(btnClose);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "\u6D88\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setBounds(778, 10, 213, 330);
		contentPane.add(scrollPane);
		
		txtLog = new JTextArea();
		txtLog.setLineWrap(true);
		txtLog.setEditable(false);
		txtLog.setBackground(Color.LIGHT_GRAY);
		scrollPane.setViewportView(txtLog);
		
		txtSend = new JTextField();
		txtSend.setColumns(10);
		txtSend.setBounds(778, 366, 164, 29);
		contentPane.add(txtSend);
		
		btnSend = new JButton("\u804A\u5929");
		btnSend.addActionListener(new BtnSendActionListener());
		btnSend.setToolTipText("");
		btnSend.setMargin(new Insets(2, 2, 2, 2));
		btnSend.setFont(new Font("宋体", Font.PLAIN, 12));
		btnSend.setBounds(946, 366, 45, 29);
		contentPane.add(btnSend);
		
		btnStart = new JButton("\u5F00\u59CB\u6E38\u620F");
		btnStart.setBounds(24, 422, 116, 47);
		contentPane.add(btnStart);
		btnStart.addActionListener(new BtnStartActionListener());
		btnStart.setEnabled(false);
		btnStart.setFont(new Font("宋体", Font.PLAIN, 12));
		
		if (isMeachine) {//������˻�����ģʽ���� ����ʼ��ť��
			btnStart.setEnabled(true);
		}
	}
	
	public void setBtnStartStat(){
		if (!isMeachine) {
			if(!lbNames[0].getText().trim().equals("") && !lbNames[1].getText().trim().equals("")){	
				btnStart.setEnabled(true);
			}
			else{
				btnStart.setEnabled(false);
			}
		}else {
			btnStart.setEnabled(true);
		}
		
	}
	private class PanelDrawMouseListener extends MouseAdapter {
		
		int count=0;
		int i,j; 
		
		 public void mouseClicked(MouseEvent e) {
			
			if(!isStart)
				return; 
			if(isClick){//��ȡ�����λ�õ�����
				
				count++;
				//int i,j;
					int x=e.getX();
					int y=e.getY();
					//ͨ��������ӻ�ȡ��������(ͨ��������ӻ�ȡ���ӵ�x,y����,��gamedata�л�ȡ��������)
					int gamedata[][]=ClientService.getClientService().getGameData();//��ȡ��Ϸ���� 
					//setTitle(x+"|"+y);
					//�����ĵ�ǰ����ת����GameData������±�
					//��ǰ������ֵ-���̵ı߿�Ľ���������̸��ӿ�Ȼ�߶�
					
				if(count%2!=0){//count%2!=0 �����һ��ѡ����������
					  i=Math.round((x-40)/60f);//��һ�����ӵ�λ��
					  j=Math.round((y-45)/60f); 
				}
				 
				if(i>9||j>10){return;}//ѡ�����򳬳���Χ �ͷ�������ѡ��
				if(i>=0 && i<9 && j>=0 && j<10){
					int currenttype=gamedata[i][j];//���ӵ�ǰ������
					if(currenttype==0){
						return;//���ѡ������Ϊ�շ���
					}
					if(side==0&&currenttype>170){
						return;//����ڷ�ѡ��췽�����ӷ���
					}
					if(side==1&&currenttype<=170){
						return;//����췽ѡ��ڷ������ӷ���
					}
					if(count%2!=0){
						if (side==0) {
							System.out.println("黑方"+currenttype+"  "+j+"  "+i);//�����ǰѡ�������
							txtLog.append("黑方"+currenttype+"  "+j+"  "+i+"\r\n");
						}else{
							System.out.println("红方"+currenttype+"  "+j+"  "+i);//�����ǰѡ�������
							txtLog.append("红方"+currenttype+"  "+j+"  "+i+"\r\n");
						}
						
					}
					
					
					ChessType=currenttype; 
					if(side==0&&currenttype<=170&&count%2==0){//����Ǻڷ�����Ϸ�����е�ֵ����С��170
					  
							int i2=Math.round((x-40)/60f);
							int j2=Math.round((y-45)/60f);
							if(i2>9||i2<0||j2>10||j2<0){return;}//ѡ�����򳬳���Χ �ͷ�������ѡ��
							System.out.println("中国象棋"+currenttype+"  "+j2+" "+i2);
							txtLog.append("中国象棋"+currenttype+"  "+j2+" "+i2+"\r\n");
							
							int chess1,chess2;
							int chessdata[][]=ClientService.getClientService().getGameData();
							chess1=chessdata[i][j]+10/100;
							chess2=chessdata[i2][j2]+10/100;
							if(i2==i&&j2==j||i2<0||i2>8||j2<0||j2>9||chess1==chess2){//�жϵڶ���ѡ����Ƿ���ԭλ�������ԭλ������ѡ�� ���߳�����Χ
								ClientService.getClientService().setGameData(i, j, currenttype);//����ѡ�е����ӵ�ԭ����������Ϊ0
								panelDraw.repaint();//�ػ�����
								if(!isMeachine){//�ж��Ƿ����˻�ģʽ
									String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
									ClientService.getClientService().getClientGame().sendMSG(str);
								}
								
								return ;
							}else{
								ClientService.getClientService().setGameData(i, j, 0);//����ѡ�е����ӵ�ԭ����������Ϊ0
								panelDraw.repaint();//�ػ�����
								if(!isMeachine){//�ж��Ƿ����˻�ģʽ
									String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+0;
									ClientService.getClientService().getClientGame().sendMSG(str);
								}
								
							}
							if(i2>=0&&i2<9&&j2>=0&&j2<10){
								 
								switch (ChessType) {
									case 111:	//�ж�  �� ���ƶ�λ���Ƿ�Ϊ 1��
									case 112:
									case 113:
									case 114:
									case 115:
										int data[][]=ClientService.getClientService().getGameData();
										if(((i2==i+1&&j==j2&&i+1<=8&&j>=5)||(i2==i&&j2==j+1&&j+1<=9&&j>=3)||(i2==i-1&&j2==j&&i-1>=0&&j>=5))&&(data[i2][j2]>200||data[i2][j2]==0)){
											
											i=i2;//������ߵķ��ϵĹ���
											j=j2;
										}else{
											ClientService.getClientService().setGameData(i, j, currenttype);//����ѡ�е����ӵ�ԭ����������Ϊ0
											panelDraw.repaint();//�ػ�����
											if (!isMeachine) {//�ж��Ƿ����˻�ģʽ
												String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
												ClientService.getClientService().getClientGame().sendMSG(str);
											}
											
											return;
										}
										break;
									case 121://�ж�  ��  �ߵ��Ƿ�Ϸ� ���ܹ���
									case 122: 
										
										int count=0;
										int data1[][]=ClientService.getClientService().getGameData();
										if(i==i2){
											if(j2>j){
												for(int j1=j+1;j1<=j2;j1++ ){
													if(data1[i][j1]!=0){
														count++;
													}
												}
											}else if (j>j2) {
												for(int j1=j-1;j1>=j2;j1--){
													if(data1[i][j1]!=0){
														count++;
													}
												}
											}
											if((count==0||count==2)&&(data1[i2][j2]>200||data1[i2][j2]==0)){
												i=i2;
												j=j2;
											}else{
												ClientService.getClientService().setGameData(i, j, currenttype);//����ѡ�е����ӵ�ԭ����������Ϊ0
												panelDraw.repaint();//�ػ�����
												if (!isMeachine) {//�ж��Ƿ����˻�ģʽ
													String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
													ClientService.getClientService().getClientGame().sendMSG(str);
												}
												
												return;
											}
										}else if (j==j2) {
											if(i2>i){
												for(int i1=i+1;i1<=i2;i1++ ){
													if(data1[i1][j]!=0){
														count++;
													}
												}
											}else if (i>i2) {
												for(int i1=i-1;i1>=i2;i1--){
													if(data1[i1][j]!=0){
														count++;
													}
												}
											}
											if((count==0||count==2)&&(data1[i2][j2]>200||data1[i2][j2]==0)){
												i=i2;
												j=j2;
											}else{
												ClientService.getClientService().setGameData(i, j, currenttype);//����ѡ�е����ӵ�ԭ����������Ϊ0
												panelDraw.repaint();//�ػ�����
												if (!isMeachine) {//�ж��Ƿ����˻�ģʽ
													String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
													ClientService.getClientService().getClientGame().sendMSG(str);
												}
												
												return;
											}
										}
										//if((i==i2)||(j==j2)){
										///	i=i2;
										//	j=j2;
										//}else{
										//	ClientService.getClientService().setGameData(i, j, currenttype);//����ѡ�е����ӵ�ԭ����������Ϊ0
										//	panelDraw.repaint();//�ػ�����
										//	String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
										//	ClientService.getClientService().getClientGame().sendMSG(str);
										//	return;
										//}
										break;
									case 131://�ж�܇�ߵ��Ƿ�Ϸ� һ��ֻ����һ���������ƶ�
									case 132:
										int count1=0;
										int data2[][]=ClientService.getClientService().getGameData();
										if(i==i2){
											if(j2>j){
												for(int j1=j+1;j1<j2;j1++ ){
													if(data2[i][j1]!=0){
														count1++;
													}
												}
											}else if (j>j2) {
												for(int j1=j2+1;j1<j;j1++){
													if(data2[i][j1]!=0){
														count1++;
													}
												}
											}
											if(count1==0&&(data2[i2][j2]>200||data2[i2][j2]==0)){
												i=i2;
												j=j2;
											}else{
												ClientService.getClientService().setGameData(i, j, currenttype);//����ѡ�е����ӵ�ԭ����������Ϊ0
												panelDraw.repaint();//�ػ�����
												if (!isMeachine) {//�ж��Ƿ����˻�ģʽ
													String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
													ClientService.getClientService().getClientGame().sendMSG(str);
												}
												
												return;
											}
										}else if (j==j2) {
											if(i2>i){
												for(int i1=i+1;i1<i2;i1++ ){
													if(data2[i1][j]!=0){
														count1++;
													}
												}
											}else if (i>i2) {
												for(int i1=i2+1;i1<i;i1++){
													if(data2[i][j]!=0){
														count1++;
													}
												}
											}
											if(count1==0&&(data2[i2][j2]>200||data2[i2][j2]==0)){
												i=i2;
												j=j2;
											}else{
												ClientService.getClientService().setGameData(i, j, currenttype);//����ѡ�е����ӵ�ԭ����������Ϊ0
												panelDraw.repaint();//�ػ�����
												if (!isMeachine) {//�ж��Ƿ����˻�ģʽ
													String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
													ClientService.getClientService().getClientGame().sendMSG(str);
												}
												
												return;
											}
										}										
										break;
									case 141://�ж�  ��  �ߵ��Ƿ���ȷ����ֻ��������    
									case 142:
										int data3[][]=ClientService.getClientService().getGameData();
										int chess3=-1;
										if(i2==i-1&&j2==j-2&&i-1>=0&&j-2>=0||i2==i+1&&j2==j-2&&i+1<=8&&j-2>=0||i2==i+2&&j2==j-1&&i+2<=8&&j-1>=0||i2==i+2&&j2==j+1&&j+1<=9&&i+2<=8||i2==i+1&&j2==j+2&&i+1<=8&&j+2<=9||i2==i-1&&j2==j+2&&i-1>=0&&j+2<=9||i2==i-2&&j2==j+1&&j+1<=9&&i-2>=0||i2==i-2&&j2==j-1&&i-2>=0&&j-1>=0){
											if(i2-i==-1&&j2-j==-2){
												chess3=data3[i][j-1];//1
											}else if (i2-i==1&&j2-j==-2) {
												chess3=data3[i][j-1];//2
											}else if (i2-i==2&&j2-j==-1) {
												chess3=data3[i+1][j];//3
											}else if (i2-i==2&&j2-j==1) {
												chess3=data3[i+1][j];//4
											}else if (i2-i==1&&j2-j==2) {
												chess3=data3[i][j+1];//5
											}else if (i2-i==-1&&j2-j==2) {
												chess3=data3[i][j+1];//6
											}else if (i2-i==-2&&j2-j==1) {
												chess3=data3[i-1][j];//7
											}else if (i2-i==-2&&j2-j==-1) {
												chess3=data3[i-1][j];//8
											}
											if(chess3==0&&(data3[i2][j2]>200||data3[i2][j2]==0)){
												i=i2;
												j=j2;
											
											}else{
												ClientService.getClientService().setGameData(i, j, currenttype);//����ѡ�е����ӵ�ԭ����������Ϊ0
												panelDraw.repaint();//�ػ�����
												if (!isMeachine) {//�ж��Ƿ����˻�ģʽ
													String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
													ClientService.getClientService().getClientGame().sendMSG(str);
												}
												
												return;
											}
											
										}else{
											ClientService.getClientService().setGameData(i, j, currenttype);//����ѡ�е����ӵ�ԭ����������Ϊ0
											panelDraw.repaint();//�ػ�����
											if (!isMeachine) {//�ж��Ƿ����˻�ģʽ
												String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
												ClientService.getClientService().getClientGame().sendMSG(str);
													
											}
											return;
										}
										break;
									case 151://�ж� ��   �ߵ��Ƿ���ȷ
									case 152:
										int data4[][]=ClientService.getClientService().getGameData();
										int chess=data4[(i+i2)/2][(j+j2)/2];//�ж��Ƿ�������
										if(i2==i-2&&j2==j-2&&i-2>=0&&j-2>=0||i2==i+2&&j2==j-2&&i+2<=8&&j-2>=0||i2==i+2&&j2==j+2&&i+2<=8&&j+2<=4||i2==i-2&&j2==j+2&&i-2>=0&&j+2<=4){
											if(chess==0&&(data4[i2][j2]>200||data4[i2][j2]==0)){
												i=i2;//���λ�úϷ����ڶ���ѡ�е�ֵ����i 
												j=j2; //���λ�úϷ����ڶ���ѡ�е�ֵ����j
											}else{
												ClientService.getClientService().setGameData(i, j, currenttype);//����ѡ�е����ӵ�ԭ����������Ϊ0
												panelDraw.repaint();//�ػ�����
												if (!isMeachine) {//�ж��Ƿ����˻�ģʽ
													String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
													ClientService.getClientService().getClientGame().sendMSG(str);
														
												}
												return;
											}
											
										}else{
											ClientService.getClientService().setGameData(i, j, currenttype);//����ѡ�е����ӵ�ԭ����������Ϊ0
											panelDraw.repaint();//�ػ�����
											if (!isMeachine) {//�ж��Ƿ����˻�ģʽ
												String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
												ClientService.getClientService().getClientGame().sendMSG(str);
											
											}
											return;
										}
										break;
									case 161://�ж�  ʿ  �ߵ��Ƿ���ȷ
									case 162:
										int data5[][]=ClientService.getClientService().getGameData();
										if((i2==i-1&&j2==j-1&&j-1>=0&&i-1>=3||i2==i+1&&j2==j-1&&i+1<=5&&j-1>=0||i2==i+1&&j2==j+1&&i+1<=5&&j+1<=2||i2==i-1&&j2==j+1&&i-1>=3&&j+1<=2)&&(data5[i2][j2]>200||data5[i2][j2]==0)){
											i=i2;///���λ�úϷ����ڶ���ѡ�е�ֵ����i  
											j=j2;//���λ�úϷ����ڶ���ѡ�е�ֵ����j
										}else{
											ClientService.getClientService().setGameData(i, j, currenttype);//����ѡ�е����ӵ�ԭ����������Ϊ0
											panelDraw.repaint();//�ػ�����
											if (!isMeachine) {//�ж��Ƿ����˻�ģʽ
												String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
												ClientService.getClientService().getClientGame().sendMSG(str);
											
											}
											return;
										}
										break;
									case 170://�жϽ��ߵ��Ƿ���ȷ
										int data6[][]=ClientService.getClientService().getGameData();
										int count4=0;
										if(j2>j){
											for(int j1=j+1;j1<=j2;j1++){
												if(data6[i][j1]!=0){
													count4++;
													if((count4==1&&data6[i][j1]==270||j2<=2)){
														i=i2;//���λ�úϷ����ڶ���ѡ�е�ֵ����i  
														j=j2;//���λ�úϷ����ڶ���ѡ�е�ֵ����j
													}else{
														ClientService.getClientService().setGameData(i, j, currenttype);//����ѡ�е����ӵ�ԭ����������Ϊ0
														panelDraw.repaint();//�ػ�����
														if (!isMeachine) {//�ж��Ƿ����˻�ģʽ
															String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
															ClientService.getClientService().getClientGame().sendMSG(str);
														
														}
														return;
													}
												}
											}
										}
										if((i2==i&&j2==j+1&&j+1<=2 ||i2==i+1&&j2==j&&i+1<=5||i2==i-1&&j2==j&&i-1>=3||i2==i&&j2==j-1&&j-1>=0)&&(data6[i2][j2]>200||data6[i2][j2]==0)){
											
											i=i2;//���λ�úϷ����ڶ���ѡ�е�ֵ����i  
											j=j2;//���λ�úϷ����ڶ���ѡ�е�ֵ����j
										}else {
											ClientService.getClientService().setGameData(i, j, currenttype);//����ѡ�е����ӵ�ԭ����������Ϊ0
											panelDraw.repaint();//�ػ�����
											if(!isMeachine){//�ж��Ƿ����˻�ģʽ
												String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
												ClientService.getClientService().getClientGame().sendMSG(str);
											}
											
											return;
										}
										break;
									default:
										break;
								} 
							//������Ϸ����
							ClientService.getClientService().setGameData(i, j, ChessType);//�������ӵ�λ��
							panelDraw.repaint();//���»�ͼ
							if(count%2==0){
								isClick=false;
							//	count++;//ֻ�ܵȴ��Է�����
							}
							 
							// ���͸�ʽ��SETPOS|����|��λ��|��|��|��ɫ	
							if (!isMeachine) {//�ж��Ƿ����˻�ģʽ
								String  str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
								ClientService.getClientService().getClientGame().sendMSG(str);
						 
							}
						}
					}else if(side==1&&currenttype>170&&count%2==0){//������Ǻ췽 
						  
							int i2=Math.round((x-40)/60f);
							int j2=Math.round((y-45)/60f);
							if(i2>9||i2<0||j2>10||j2<0){return;}//ѡ�����򳬳���Χ �ͷ�������ѡ��
							System.out.println("红方 当前位置"+currenttype+" "+j2+" "+i2 );
							txtLog.append("红方 当前位置"+currenttype+"  "+j2+" "+i2+"\r\n");
							int chess1,chess2;
							int chessdata[][]=ClientService.getClientService().getGameData();
							chess1=chessdata[i][j]+10/100;
							chess2=chessdata[i2][j2]+10/100;
							if(i2==i&&j2==j||i2<0||i2>8||j2<0||j2>9||chess1==chess2){//���ѡ��Ĳ���ԭλ�ã��ͽ�ԭλ����Ϊ0
								ClientService.getClientService().setGameData(i, j, currenttype);//��ԭ���췽����Ϊλ����Ϊ0
								panelDraw.repaint();//�ػ�����
								if (!isMeachine) {//�ж��Ƿ����˻�ģʽ
									String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
									ClientService.getClientService().getClientGame().sendMSG(str);
								
								}
								return;
							}else{
								ClientService.getClientService().setGameData(i, j, 0);//��ԭ���췽����Ϊλ����Ϊ0
								panelDraw.repaint();//�ػ�����
								if (!isMeachine) {//�ж��Ƿ����˻�ģʽ
									String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+0;
									ClientService.getClientService().getClientGame().sendMSG(str); 
								}
							}
							
							if(i2>=0&&i2<9&&j2>=0&&j2<10){
								 
								switch (ChessType) {
									case 211:	//�ж�  �� ���ƶ�λ���Ƿ�Ϊ 1��
									case 212:
									case 213:
									case 214:
									case 215:
										int data[][]=ClientService.getClientService().getGameData();
										if(((i2==i+1&&j==j2&&i+1<=8&&j<=4&&i>=0)||(i2==i&&j2==j-1&&j-1>=0&&j<=6&&i>=0)||(i2==i-1&&j2==j&&i-1>=0&&j<=4&&i>=0))&&data[i2][j2]<200){
											i=i2;//���λ�úϷ����ڶ���ѡ�е�ֵ����i  
											j=j2;//���λ�úϷ����ڶ���ѡ�е�ֵ����j
										}else {
											ClientService.getClientService().setGameData(i, j, currenttype);//����ѡ�е����ӵ�ԭ����������Ϊ0
											panelDraw.repaint();//�ػ�����
											if (!isMeachine) {//�ж��Ƿ����˻�ģʽ
												String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
												ClientService.getClientService().getClientGame().sendMSG(str);
											}
											return;
										}
										break;
									case 221://�ж�  ��  �ߵ��Ƿ�Ϸ� ���ܹ���
									case 222: 
										int count=0;
										int data1[][]=ClientService.getClientService().getGameData();
										if(i==i2){
											if(j2>j){
												for(int j1=j+1;j1<=j2;j1++ ){
													if(data1[i][j1]!=0){
														count++;
													}
												}
											}else if (j>j2) {
												for(int j1=j-1;j1>=j2;j1--){
													if(data1[i][j1]!=0){
														count++;
													}
												}
											}
											if((count==0||count==2)&&data1[i2][j2]<200){
												i=i2;//���λ�úϷ����ڶ���ѡ�е�ֵ����i  
												j=j2;//���λ�úϷ����ڶ���ѡ�е�ֵ����j
											}else{
												ClientService.getClientService().setGameData(i, j, currenttype);//����ѡ�е����ӵ�ԭ����������Ϊ0
												panelDraw.repaint();//�ػ�����
												if (!isMeachine) {//�ж��Ƿ����˻�ģʽ
													String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
													ClientService.getClientService().getClientGame().sendMSG(str);
												
												}
												return;
											}
										}else if (j==j2) {
											if(i2>i){
												for(int i1=i+1;i1<=i2;i1++ ){
													if(data1[i1][j]!=0){
														count++;
													}
												}
											}else if (i>i2) {
												for(int i1=i-1;i1>=i2;i1--){
													if(data1[i1][j]!=0){
														count++;
													}
												}
											}
											if((count==0||count==2)&&data1[i2][j2]<200){
												i=i2;//���λ�úϷ����ڶ���ѡ�е�ֵ����i 
												j=j2; //���λ�úϷ����ڶ���ѡ�е�ֵ����j
											}else{
												ClientService.getClientService().setGameData(i, j, currenttype);//����ѡ�е����ӵ�ԭ����������Ϊ0
												panelDraw.repaint();//�ػ�����
												if (!isMeachine) {//�ж��Ƿ����˻�ģʽ
													String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
													ClientService.getClientService().getClientGame().sendMSG(str);
												}
												return;
											}
										}
										//if((i==i2)||(j==j2)){
										//	i=i2;
										//	j=j2;
										//}else {
										//	ClientService.getClientService().setGameData(i, j, currenttype);//����ѡ�е����ӵ�ԭ����������Ϊ0
										//	panelDraw.repaint();//�ػ�����
										//	String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
										//	ClientService.getClientService().getClientGame().sendMSG(str);
										//	return;
										//}
										break;
									case 231://�ж�܇�ߵ��Ƿ�Ϸ� һ��ֻ����һ���������ƶ�
									case 232:
										int count1=0;
										int data2[][]=ClientService.getClientService().getGameData();
										if(i==i2){
											if(j2>j){
												for(int j1=j+1;j1<j2;j1++ ){
													if(data2[i][j1]!=0){
														count1++;
													}
												}
											}else if (j>j2) {
												for(int j1=j2+1;j1<j;j1++){
													if(data2[i][j1]!=0){
														count1++;
													}
												}
											}
											if((count1==0)&&data2[i2][j2]<200){
												i=i2;//���λ�úϷ����ڶ���ѡ�е�ֵ����i  
												j=j2;//���λ�úϷ����ڶ���ѡ�е�ֵ����j
											}else{
												ClientService.getClientService().setGameData(i, j, currenttype);//����ѡ�е����ӵ�ԭ����������Ϊ0
												panelDraw.repaint();//�ػ�����
												if (!isMeachine) {//�ж��Ƿ����˻�ģʽ
													String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
													ClientService.getClientService().getClientGame().sendMSG(str);
												
												}
												return;
											}
										}else if (j==j2) {
											if(i2>i){
												for(int i1=i+1;i1<i2;i1++ ){
													if(data2[i1][j]!=0){
														count1++;
													}
												}
											}else if (i>i2) {
												for(int i1=i2+1;i1<i;i1++){
													if(data2[i][j]!=0){
														count1++;
													}
												}
											}
											if((count1==0)&&data2[i2][j2]<200){
												i=i2;//���λ�úϷ����ڶ���ѡ�е�ֵ����i 
												j=j2; //���λ�úϷ����ڶ���ѡ�е�ֵ����j
											}else{
												ClientService.getClientService().setGameData(i, j, currenttype);//����ѡ�е����ӵ�ԭ����������Ϊ0
												panelDraw.repaint();//�ػ�����
												if (!isMeachine) {//�ж��Ƿ����˻�ģʽ
													String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
													ClientService.getClientService().getClientGame().sendMSG(str);
												}
												return;
											}
										} 
									//	if (i==i2||j==j2) {
									//		i=i2;
									//		j=j2;
									//	}else{
									//		ClientService.getClientService().setGameData(i, j, currenttype);//����ѡ�е����ӵ�ԭ����������Ϊ0
									//		panelDraw.repaint();//�ػ�����
									//		String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
									//		ClientService.getClientService().getClientGame().sendMSG(str);
									//		return;
									//	}
										break;
									case 241://�ж�  ��  �ߵ��Ƿ���ȷ����ֻ��������    
									case 242:
										int data3[][]=ClientService.getClientService().getGameData();
										int chess3=-1;
										if(i2==i-1&&j2==j-2&&i-1>=0&&j-2>=0||i2==i+1&&j2==j-2&&i+1<=8&&j-2>=0||i2==i+2&&j2==j-1&&i+2<=8&&j-1>=0||i2==i+2&&j2==j+1&&j+1<=9&&i+2<=8||i2==i+1&&j2==j+2&&i+1<=8&&j+2<=9||i2==i-1&&j2==j+2&&i-1>=0&&j+2<=9||i2==i-2&&j2==j+1&&j+1<=9&&i-2>=0||i2==i-2&&j2==j-1&&i-2>=0&&j-1>=0){
											if(i2-i==-1&&j2-j==-2){
												chess3=data3[i][j-1];//1
											}else if (i2-i==1&&j2-j==-2) {
												chess3=data3[i][j-1];//2
											}else if (i2-i==2&&j2-j==-1) {
												chess3=data3[i+1][j];//3
											}else if (i2-i==2&&j2-j==1) {
												chess3=data3[i+1][j];//4
											}else if (i2-i==1&&j2-j==2) {
												chess3=data3[i][j+1];//5
											}else if (i2-i==-1&&j2-j==2) {
												chess3=data3[i][j+1];//6
											}else if (i2-i==-2&&j2-j==1) {
												chess3=data3[i-1][j];//7
											}else if (i2-i==-2&&j2-j==-1) {
												chess3=data3[i-1][j];//8
											}
											if((chess3==0)&&data3[i2][j2]<200){
												i=i2;
												j=j2;
											
											}else{
												ClientService.getClientService().setGameData(i, j, currenttype);//����ѡ�е����ӵ�ԭ����������Ϊ0
												panelDraw.repaint();//�ػ�����
												if (!isMeachine) {//�ж��Ƿ����˻�ģʽ
													String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
													ClientService.getClientService().getClientGame().sendMSG(str);
												}
												return;
											}
											
										}else{
											ClientService.getClientService().setGameData(i, j, currenttype);//����ѡ�е����ӵ�ԭ����������Ϊ0
											panelDraw.repaint();//�ػ�����
											if (!isMeachine) {//�ж��Ƿ����˻�ģʽ
												String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
												ClientService.getClientService().getClientGame().sendMSG(str);
											}
											return;
										}
										break;
									case 251://�ж�  ��  �ߵ��Ƿ���ȷ
									case 252:
										int data4[][]=ClientService.getClientService().getGameData();
										int chess=data4[(i+i2)/2][(j+j2)/2];
										if(i2==i-2&&j2==j-2&&i-2>=0&&j-2>=5||i2==i+2&&j2==j-2&&i+2<=8&&j-2>=5||i2==i+2&&j2==j+2&&i+2<=8&&j+2<=9||i2==i-2&&j2==j+2&&i-2>=0&&j+2<=9){
											if((chess==0)&&data4[i2][j2]<200){
												i=i2;
												j=j2;
											}else{
												ClientService.getClientService().setGameData(i, j, currenttype);//����ѡ�е����ӵ�ԭ����������Ϊ0
												panelDraw.repaint();//�ػ�����
												if (!isMeachine) {//�ж��Ƿ����˻�ģʽ
													String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
													ClientService.getClientService().getClientGame().sendMSG(str);
												}
												return;
											}
											
										}else {
											ClientService.getClientService().setGameData(i, j, currenttype);//����ѡ�е����ӵ�ԭ����������Ϊ0
											panelDraw.repaint();//�ػ�����
											if (!isMeachine) {//�ж��Ƿ����˻�ģʽ
												String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
												ClientService.getClientService().getClientGame().sendMSG(str);
											}
											return;
										}
										break;
									case 261://�ж�  ʿ  �ߵ��Ƿ���ȷ
									case 262:
										int data5[][]=ClientService.getClientService().getGameData();
										if((i2==i-1&&j2==j-1&&j-1>=7&&i-1>=3||i2==i+1&&j2==j-1&&i+1<=5&&j-1>=7||i2==i+1&&j2==j+1&&i+1<=5&&j+1<=9||i2==i-1&&j2==j+1&&i-1>=3&&j+1<=9)&&data5[i2][j2]<200){
											i=i2;
											j=j2;
										}else {
											ClientService.getClientService().setGameData(i, j, currenttype);//����ѡ�е����ӵ�ԭ����������Ϊ0
											panelDraw.repaint();//�ػ�����
											if (!isMeachine) {//�ж��Ƿ����˻�ģʽ
												String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
												ClientService.getClientService().getClientGame().sendMSG(str);
											}
											return;
										}
										break;
									case 270://�ж�  ˧  �ߵ��Ƿ���ȷ 
										int data6[][]=ClientService.getClientService().getGameData();
										int count4=0;
										if(j2<j){
											for(int j1=j-1;j1>=j2;j1--){
												if(data6[i][j1]!=0){
													count4++;
													if((count4==1&&data6[i][j1]==170||j2>=7)&&data6[i2][j2]<200){
														i=i2;
														j=j2;
													}else{
														ClientService.getClientService().setGameData(i, j, currenttype);//����ѡ�е����ӵ�ԭ����������Ϊ0
														panelDraw.repaint();//�ػ�����
														if (!isMeachine) {//�ж��Ƿ����˻�ģʽ
															String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
															ClientService.getClientService().getClientGame().sendMSG(str);
														}
														return;
													}
												}
											}
										}
										if((i2==i&&j2==j+1&&j+1<=9 ||i2==i+1&&j2==j&&i+1<=5||i2==i-1&&j2==j&&i-1>=3||i2==i&&j2==j-1&&j-1>=7)&&data6[i2][j2]<200){
											i=i2;
											j=j2;
										}else{
											ClientService.getClientService().setGameData(i, j, currenttype);//����ѡ�е����ӵ�ԭ����������Ϊ0
											panelDraw.repaint();//�ػ�����
											if (!isMeachine) {//�ж��Ƿ����˻�ģʽ
												String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
												ClientService.getClientService().getClientGame().sendMSG(str);
											}
											return;
										}
										break;
									default:
										break;
								} 
							//������Ϸ����
							ClientService.getClientService().setGameData(i,j, ChessType);//�������ӵ�λ��
							panelDraw.repaint();//���»�ͼ
							if(count%2==0){
								isClick=false; 
								//count++;
							}
							 //ֻ�ܵȴ��Է�����
							
							// ���͸�ʽ��SETPOS|����|��λ��|��|��|��ɫ	
							if (!isMeachine) {//�ж��Ƿ����˻�ģʽ
								String  str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
								ClientService.getClientService().getClientGame().sendMSG(str);
							}
						 }
					}
					
				/*	//������Ϸ����
					ClientService.getClientService().setGameData(i, j, ChessType);//�������ӵ�λ��
					panelDraw.repaint();//���»�ͼ
					isClick=false;  //ֻ�ܵȴ��Է�����
					
					// ���͸�ʽ��SETPOS|����|��λ��|��|��|��ɫ		
					String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
					ClientService.getClientService().getClientGame().sendMSG(str);
				*/
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "��ȴ��Է����壡");
			}//����������Ĳ�����ÿһ�β�����ı���ֵ�ֵ��ͨ���ı�����ֵ������ ��������
			
			if (isMeachine) {//������˻�ģʽ �����˻����ĺ��� ******��
				//�˻����ĺ���������ֵ�ֵ�����ж�,��������ֱ�Ӹı���ֵ�ֵ
				int game_data[][]=ClientService.getClientService().getGameData();
			/*	for(){
					
				}*/
	
				//ClientService.getClientService().setGameData(i, j, posValue);
			}
				
		}
		
		 
		 
	}
	private class BtnStartActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			isStart=true;
			if (isMeachine) {//������˻��ʹ� isclick
				isClick=true;
			}
			//GAMESTART|tableindex|side
			if (!isMeachine) {//�ж��Ƿ����˻�ģʽ
				String str="GAMESTART|"+gametableIndex+"|"+side;
				ClientService.getClientService().getClientGame().sendMSG(str);
			}
			txtLog.append(" 准备好了\r\n");
		}
	}
	
	//�˳���Ϸ��ť
	private class BtnCloseActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			//�˳���Ϸ
			//GAMEOVER@TABLEINDEX@SIDE
			if (!isMeachine) {//�ж��Ƿ����˻�ģʽ
				String  str="GAMEOVER|"+gametableIndex+"|"+side;
				ClientService.getClientService().getClientGame().sendMSG(str);
				//���±��û�����Ϸ��ռ�����
				ClientService.getClientService().updateGameTable(gametableIndex, side, "0");
			}
			//�����Ϸ����
			ClientService.getClientService().resetData();
			dispose();//�رյ�ǰ����
		}
	}
	
	//���찴ť
	private class BtnSendActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			//���죺   MSG|Tableindex|side|essagecontent
			if (!isMeachine) {//�ж��Ƿ����˻�ģʽ
				String sMsg="MSG|"+gametableIndex+"|"+side+"|"+txtSend.getText().trim();
				ClientService.getClientService().getClientGame().sendMSG(sMsg);
			
			}
			txtLog.append("��˵��"+txtSend.getText().trim()+"\r\n");
			
			txtSend.setText("");
		}
	}
}
