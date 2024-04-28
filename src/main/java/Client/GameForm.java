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

	
	JLabel [] lbNames=new JLabel[2]; //黑方或白方的游戏者名称 0：黑方名称，1：红方名称
	public JPanel panelDraw;
	public JButton btnStart;
	public JButton btnClose;

	int gametableIndex;  //记录游戏桌的编号
	int side;            //游戏桌的座位号
	public JScrollPane scrollPane;
	public JTextArea txtLog;
	public JTextField txtSend;
	public JButton btnSend;
	
	boolean isMeachine;//人机对弈标志
	boolean isStart; //开始游戏的标记
	boolean isClick;  //交替出子的开关变量
	int ChessType; //棋子类型  1：黑方；2：红方    
					//黑方1-红方2-
					//1,兵、卒  
					//2炮  3俥 4马 5相 6仕7将、帅	
	
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
			setTitle("当前选择为：【黑方】");
			ChessType=1;
		}
			
		else{
			setTitle("当前选择为：【红方】");
			ChessType=2;
		}
		if(!isMeachine){//side=3 代表人机对弈模式
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
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "红方", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
		
		if (isMeachine) {//如果是人机对弈模式，打开 “开始按钮”
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
			if(isClick){//获取鼠标点击位置的坐标
				
				count++;
				//int i,j;
					int x=e.getX();
					int y=e.getY();
					//通过点击棋子获取棋子类型(通过点击棋子获取棋子的x,y坐标,从gamedata中获取棋子类型)
					int gamedata[][]=ClientService.getClientService().getGameData();//获取游戏数据 
					//setTitle(x+"|"+y);
					//从鼠标的当前坐标转换成GameData数组的下标
					//当前的坐标值-棋盘的边框的结果除以棋盘格子宽度或高度
					
				if(count%2!=0){//count%2!=0 代表第一次选择棋子类型
					  i=Math.round((x-40)/60f);//第一次棋子的位置
					  j=Math.round((y-45)/60f); 
				}
				 
				if(i>9||j>10){return;}//选择区域超出范围 就返回重新选择
				if(i>=0 && i<9 && j>=0 && j<10){
					int currenttype=gamedata[i][j];//棋子当前的类型
					if(currenttype==0){
						return;//如果选择棋子为空返回
					}
					if(side==0&&currenttype>170){
						return;//如果黑方选择红方的棋子返回
					}
					if(side==1&&currenttype<=170){
						return;//如果红方选择黑方的棋子返回
					}
					if(count%2!=0){
						if (side==0) {
							System.out.println("黑方 选择棋子 ："+currenttype+"  "+j+"  "+i);//输出当前选择的棋子
							txtLog.append("黑方 选择棋子 ："+currenttype+"  "+j+"  "+i+"\r\n");
						}else{
							System.out.println("红方 选择棋子 ："+currenttype+"  "+j+"  "+i);//输出当前选择的棋子
							txtLog.append("红方 选择棋子 ："+currenttype+"  "+j+"  "+i+"\r\n");
						}
						
					}
					
					
					ChessType=currenttype; 
					if(side==0&&currenttype<=170&&count%2==0){//如果是黑方，游戏数据中的值必须小于170
					  
							int i2=Math.round((x-40)/60f);
							int j2=Math.round((y-45)/60f);
							if(i2>9||i2<0||j2>10||j2<0){return;}//选择区域超出范围 就返回重新选择
							System.out.println("黑方 选择落子方位："+currenttype+"  "+j2+" "+i2);
							txtLog.append("黑方 选择落子方位："+currenttype+"  "+j2+" "+i2+"\r\n");
							
							int chess1,chess2;
							int chessdata[][]=ClientService.getClientService().getGameData();
							chess1=chessdata[i][j]+10/100;
							chess2=chessdata[i2][j2]+10/100;
							if(i2==i&&j2==j||i2<0||i2>8||j2<0||j2>9||chess1==chess2){//判断第二次选择的是否是原位置如果是原位置重新选择 或者超出范围
								ClientService.getClientService().setGameData(i, j, currenttype);//将被选中的棋子的原来的坐标置为0
								panelDraw.repaint();//重画棋盘
								if(!isMeachine){//判断是否是人机模式
									String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
									ClientService.getClientService().getClientGame().sendMSG(str);
								}
								
								return ;
							}else{
								ClientService.getClientService().setGameData(i, j, 0);//将被选中的棋子的原来的坐标置为0
								panelDraw.repaint();//重画棋盘
								if(!isMeachine){//判断是否是人机模式
									String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+0;
									ClientService.getClientService().getClientGame().sendMSG(str);
								}
								
							}
							if(i2>=0&&i2<9&&j2>=0&&j2<10){
								 
								switch (ChessType) {
									case 111:	//判断  卒 的移动位置是否为 1步
									case 112:
									case 113:
									case 114:
									case 115:
										int data[][]=ClientService.getClientService().getGameData();
										if(((i2==i+1&&j==j2&&i+1<=8&&j>=5)||(i2==i&&j2==j+1&&j+1<=9&&j>=3)||(i2==i-1&&j2==j&&i-1>=0&&j>=5))&&(data[i2][j2]>200||data[i2][j2]==0)){
											
											i=i2;//如果兵走的符合的规则
											j=j2;
										}else{
											ClientService.getClientService().setGameData(i, j, currenttype);//将被选中的棋子的原来的坐标置为0
											panelDraw.repaint();//重画棋盘
											if (!isMeachine) {//判断是否是人机模式
												String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
												ClientService.getClientService().getClientGame().sendMSG(str);
											}
											
											return;
										}
										break;
									case 121://判断  炮  走的是否合法 不能拐弯
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
												ClientService.getClientService().setGameData(i, j, currenttype);//将被选中的棋子的原来的坐标置为0
												panelDraw.repaint();//重画棋盘
												if (!isMeachine) {//判断是否是人机模式
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
												ClientService.getClientService().setGameData(i, j, currenttype);//将被选中的棋子的原来的坐标置为0
												panelDraw.repaint();//重画棋盘
												if (!isMeachine) {//判断是否是人机模式
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
										//	ClientService.getClientService().setGameData(i, j, currenttype);//将被选中的棋子的原来的坐标置为0
										//	panelDraw.repaint();//重画棋盘
										//	String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
										//	ClientService.getClientService().getClientGame().sendMSG(str);
										//	return;
										//}
										break;
									case 131://判断車走的是否合法 一步只能在一个方向上移动
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
												ClientService.getClientService().setGameData(i, j, currenttype);//将被选中的棋子的原来的坐标置为0
												panelDraw.repaint();//重画棋盘
												if (!isMeachine) {//判断是否是人机模式
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
												ClientService.getClientService().setGameData(i, j, currenttype);//将被选中的棋子的原来的坐标置为0
												panelDraw.repaint();//重画棋盘
												if (!isMeachine) {//判断是否是人机模式
													String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
													ClientService.getClientService().getClientGame().sendMSG(str);
												}
												
												return;
											}
										}										
										break;
									case 141://判断  马  走的是否正确，马只能走日字    
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
												ClientService.getClientService().setGameData(i, j, currenttype);//将被选中的棋子的原来的坐标置为0
												panelDraw.repaint();//重画棋盘
												if (!isMeachine) {//判断是否是人机模式
													String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
													ClientService.getClientService().getClientGame().sendMSG(str);
												}
												
												return;
											}
											
										}else{
											ClientService.getClientService().setGameData(i, j, currenttype);//将被选中的棋子的原来的坐标置为0
											panelDraw.repaint();//重画棋盘
											if (!isMeachine) {//判断是否是人机模式
												String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
												ClientService.getClientService().getClientGame().sendMSG(str);
													
											}
											return;
										}
										break;
									case 151://判断 象   走的是否正确
									case 152:
										int data4[][]=ClientService.getClientService().getGameData();
										int chess=data4[(i+i2)/2][(j+j2)/2];//判断是否塞象眼
										if(i2==i-2&&j2==j-2&&i-2>=0&&j-2>=0||i2==i+2&&j2==j-2&&i+2<=8&&j-2>=0||i2==i+2&&j2==j+2&&i+2<=8&&j+2<=4||i2==i-2&&j2==j+2&&i-2>=0&&j+2<=4){
											if(chess==0&&(data4[i2][j2]>200||data4[i2][j2]==0)){
												i=i2;//如果位置合法将第二次选中的值赋给i 
												j=j2; //如果位置合法将第二次选中的值赋给j
											}else{
												ClientService.getClientService().setGameData(i, j, currenttype);//将被选中的棋子的原来的坐标置为0
												panelDraw.repaint();//重画棋盘
												if (!isMeachine) {//判断是否是人机模式
													String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
													ClientService.getClientService().getClientGame().sendMSG(str);
														
												}
												return;
											}
											
										}else{
											ClientService.getClientService().setGameData(i, j, currenttype);//将被选中的棋子的原来的坐标置为0
											panelDraw.repaint();//重画棋盘
											if (!isMeachine) {//判断是否是人机模式
												String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
												ClientService.getClientService().getClientGame().sendMSG(str);
											
											}
											return;
										}
										break;
									case 161://判断  士  走的是否正确
									case 162:
										int data5[][]=ClientService.getClientService().getGameData();
										if((i2==i-1&&j2==j-1&&j-1>=0&&i-1>=3||i2==i+1&&j2==j-1&&i+1<=5&&j-1>=0||i2==i+1&&j2==j+1&&i+1<=5&&j+1<=2||i2==i-1&&j2==j+1&&i-1>=3&&j+1<=2)&&(data5[i2][j2]>200||data5[i2][j2]==0)){
											i=i2;///如果位置合法将第二次选中的值赋给i  
											j=j2;//如果位置合法将第二次选中的值赋给j
										}else{
											ClientService.getClientService().setGameData(i, j, currenttype);//将被选中的棋子的原来的坐标置为0
											panelDraw.repaint();//重画棋盘
											if (!isMeachine) {//判断是否是人机模式
												String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
												ClientService.getClientService().getClientGame().sendMSG(str);
											
											}
											return;
										}
										break;
									case 170://判断将走的是否正确
										int data6[][]=ClientService.getClientService().getGameData();
										int count4=0;
										if(j2>j){
											for(int j1=j+1;j1<=j2;j1++){
												if(data6[i][j1]!=0){
													count4++;
													if((count4==1&&data6[i][j1]==270||j2<=2)){
														i=i2;//如果位置合法将第二次选中的值赋给i  
														j=j2;//如果位置合法将第二次选中的值赋给j
													}else{
														ClientService.getClientService().setGameData(i, j, currenttype);//将被选中的棋子的原来的坐标置为0
														panelDraw.repaint();//重画棋盘
														if (!isMeachine) {//判断是否是人机模式
															String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
															ClientService.getClientService().getClientGame().sendMSG(str);
														
														}
														return;
													}
												}
											}
										}
										if((i2==i&&j2==j+1&&j+1<=2 ||i2==i+1&&j2==j&&i+1<=5||i2==i-1&&j2==j&&i-1>=3||i2==i&&j2==j-1&&j-1>=0)&&(data6[i2][j2]>200||data6[i2][j2]==0)){
											
											i=i2;//如果位置合法将第二次选中的值赋给i  
											j=j2;//如果位置合法将第二次选中的值赋给j
										}else {
											ClientService.getClientService().setGameData(i, j, currenttype);//将被选中的棋子的原来的坐标置为0
											panelDraw.repaint();//重画棋盘
											if(!isMeachine){//判断是否是人机模式
												String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
												ClientService.getClientService().getClientGame().sendMSG(str);
											}
											
											return;
										}
										break;
									default:
										break;
								} 
							//更新游戏数据
							ClientService.getClientService().setGameData(i, j, ChessType);//设置棋子的位置
							panelDraw.repaint();//重新画图
							if(count%2==0){
								isClick=false;
							//	count++;//只能等待对方出子
							}
							 
							// 发送格式：SETPOS|桌号|座位号|行|列|颜色	
							if (!isMeachine) {//判断是否是人机模式
								String  str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
								ClientService.getClientService().getClientGame().sendMSG(str);
						 
							}
						}
					}else if(side==1&&currenttype>170&&count%2==0){//否则就是红方 
						  
							int i2=Math.round((x-40)/60f);
							int j2=Math.round((y-45)/60f);
							if(i2>9||i2<0||j2>10||j2<0){return;}//选择区域超出范围 就返回重新选择
							System.out.println("红方 选择落子位置："+currenttype+" "+j2+" "+i2 );
							txtLog.append("红方 选择落子位置："+currenttype+"  "+j2+" "+i2+"\r\n");
							int chess1,chess2;
							int chessdata[][]=ClientService.getClientService().getGameData();
							chess1=chessdata[i][j]+10/100;
							chess2=chessdata[i2][j2]+10/100;
							if(i2==i&&j2==j||i2<0||i2>8||j2<0||j2>9||chess1==chess2){//如果选择的不是原位置，就将原位置置为0
								ClientService.getClientService().setGameData(i, j, currenttype);//将原来红方棋子为位置置为0
								panelDraw.repaint();//重画棋盘
								if (!isMeachine) {//判断是否是人机模式
									String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
									ClientService.getClientService().getClientGame().sendMSG(str);
								
								}
								return;
							}else{
								ClientService.getClientService().setGameData(i, j, 0);//将原来红方棋子为位置置为0
								panelDraw.repaint();//重画棋盘
								if (!isMeachine) {//判断是否是人机模式
									String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+0;
									ClientService.getClientService().getClientGame().sendMSG(str); 
								}
							}
							
							if(i2>=0&&i2<9&&j2>=0&&j2<10){
								 
								switch (ChessType) {
									case 211:	//判断  卒 的移动位置是否为 1步
									case 212:
									case 213:
									case 214:
									case 215:
										int data[][]=ClientService.getClientService().getGameData();
										if(((i2==i+1&&j==j2&&i+1<=8&&j<=4&&i>=0)||(i2==i&&j2==j-1&&j-1>=0&&j<=6&&i>=0)||(i2==i-1&&j2==j&&i-1>=0&&j<=4&&i>=0))&&data[i2][j2]<200){
											i=i2;//如果位置合法将第二次选中的值赋给i  
											j=j2;//如果位置合法将第二次选中的值赋给j
										}else {
											ClientService.getClientService().setGameData(i, j, currenttype);//将被选中的棋子的原来的坐标置为0
											panelDraw.repaint();//重画棋盘
											if (!isMeachine) {//判断是否是人机模式
												String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
												ClientService.getClientService().getClientGame().sendMSG(str);
											}
											return;
										}
										break;
									case 221://判断  炮  走的是否合法 不能拐弯
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
												i=i2;//如果位置合法将第二次选中的值赋给i  
												j=j2;//如果位置合法将第二次选中的值赋给j
											}else{
												ClientService.getClientService().setGameData(i, j, currenttype);//将被选中的棋子的原来的坐标置为0
												panelDraw.repaint();//重画棋盘
												if (!isMeachine) {//判断是否是人机模式
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
												i=i2;//如果位置合法将第二次选中的值赋给i 
												j=j2; //如果位置合法将第二次选中的值赋给j
											}else{
												ClientService.getClientService().setGameData(i, j, currenttype);//将被选中的棋子的原来的坐标置为0
												panelDraw.repaint();//重画棋盘
												if (!isMeachine) {//判断是否是人机模式
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
										//	ClientService.getClientService().setGameData(i, j, currenttype);//将被选中的棋子的原来的坐标置为0
										//	panelDraw.repaint();//重画棋盘
										//	String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
										//	ClientService.getClientService().getClientGame().sendMSG(str);
										//	return;
										//}
										break;
									case 231://判断車走的是否合法 一步只能在一个方向上移动
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
												i=i2;//如果位置合法将第二次选中的值赋给i  
												j=j2;//如果位置合法将第二次选中的值赋给j
											}else{
												ClientService.getClientService().setGameData(i, j, currenttype);//将被选中的棋子的原来的坐标置为0
												panelDraw.repaint();//重画棋盘
												if (!isMeachine) {//判断是否是人机模式
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
												i=i2;//如果位置合法将第二次选中的值赋给i 
												j=j2; //如果位置合法将第二次选中的值赋给j
											}else{
												ClientService.getClientService().setGameData(i, j, currenttype);//将被选中的棋子的原来的坐标置为0
												panelDraw.repaint();//重画棋盘
												if (!isMeachine) {//判断是否是人机模式
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
									//		ClientService.getClientService().setGameData(i, j, currenttype);//将被选中的棋子的原来的坐标置为0
									//		panelDraw.repaint();//重画棋盘
									//		String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
									//		ClientService.getClientService().getClientGame().sendMSG(str);
									//		return;
									//	}
										break;
									case 241://判断  马  走的是否正确，马只能走日字    
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
												ClientService.getClientService().setGameData(i, j, currenttype);//将被选中的棋子的原来的坐标置为0
												panelDraw.repaint();//重画棋盘
												if (!isMeachine) {//判断是否是人机模式
													String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
													ClientService.getClientService().getClientGame().sendMSG(str);
												}
												return;
											}
											
										}else{
											ClientService.getClientService().setGameData(i, j, currenttype);//将被选中的棋子的原来的坐标置为0
											panelDraw.repaint();//重画棋盘
											if (!isMeachine) {//判断是否是人机模式
												String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
												ClientService.getClientService().getClientGame().sendMSG(str);
											}
											return;
										}
										break;
									case 251://判断  象  走的是否正确
									case 252:
										int data4[][]=ClientService.getClientService().getGameData();
										int chess=data4[(i+i2)/2][(j+j2)/2];
										if(i2==i-2&&j2==j-2&&i-2>=0&&j-2>=5||i2==i+2&&j2==j-2&&i+2<=8&&j-2>=5||i2==i+2&&j2==j+2&&i+2<=8&&j+2<=9||i2==i-2&&j2==j+2&&i-2>=0&&j+2<=9){
											if((chess==0)&&data4[i2][j2]<200){
												i=i2;
												j=j2;
											}else{
												ClientService.getClientService().setGameData(i, j, currenttype);//将被选中的棋子的原来的坐标置为0
												panelDraw.repaint();//重画棋盘
												if (!isMeachine) {//判断是否是人机模式
													String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
													ClientService.getClientService().getClientGame().sendMSG(str);
												}
												return;
											}
											
										}else {
											ClientService.getClientService().setGameData(i, j, currenttype);//将被选中的棋子的原来的坐标置为0
											panelDraw.repaint();//重画棋盘
											if (!isMeachine) {//判断是否是人机模式
												String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
												ClientService.getClientService().getClientGame().sendMSG(str);
											}
											return;
										}
										break;
									case 261://判断  士  走的是否正确
									case 262:
										int data5[][]=ClientService.getClientService().getGameData();
										if((i2==i-1&&j2==j-1&&j-1>=7&&i-1>=3||i2==i+1&&j2==j-1&&i+1<=5&&j-1>=7||i2==i+1&&j2==j+1&&i+1<=5&&j+1<=9||i2==i-1&&j2==j+1&&i-1>=3&&j+1<=9)&&data5[i2][j2]<200){
											i=i2;
											j=j2;
										}else {
											ClientService.getClientService().setGameData(i, j, currenttype);//将被选中的棋子的原来的坐标置为0
											panelDraw.repaint();//重画棋盘
											if (!isMeachine) {//判断是否是人机模式
												String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
												ClientService.getClientService().getClientGame().sendMSG(str);
											}
											return;
										}
										break;
									case 270://判断  帅  走的是否正确 
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
														ClientService.getClientService().setGameData(i, j, currenttype);//将被选中的棋子的原来的坐标置为0
														panelDraw.repaint();//重画棋盘
														if (!isMeachine) {//判断是否是人机模式
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
											ClientService.getClientService().setGameData(i, j, currenttype);//将被选中的棋子的原来的坐标置为0
											panelDraw.repaint();//重画棋盘
											if (!isMeachine) {//判断是否是人机模式
												String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
												ClientService.getClientService().getClientGame().sendMSG(str);
											}
											return;
										}
										break;
									default:
										break;
								} 
							//更新游戏数据
							ClientService.getClientService().setGameData(i,j, ChessType);//设置棋子的位置
							panelDraw.repaint();//重新画图
							if(count%2==0){
								isClick=false; 
								//count++;
							}
							 //只能等待对方出子
							
							// 发送格式：SETPOS|桌号|座位号|行|列|颜色	
							if (!isMeachine) {//判断是否是人机模式
								String  str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
								ClientService.getClientService().getClientGame().sendMSG(str);
							}
						 }
					}
					
				/*	//更新游戏数据
					ClientService.getClientService().setGameData(i, j, ChessType);//设置棋子的位置
					panelDraw.repaint();//重新画图
					isClick=false;  //只能等待对方出子
					
					// 发送格式：SETPOS|桌号|座位号|行|列|颜色		
					String str="SETPOS|"+gametableIndex+"|"+side+"|"+i+"|"+j+"|"+ChessType;
					ClientService.getClientService().getClientGame().sendMSG(str);
				*/
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "请等待对方出棋！");
			}//以上是人类的操作，每一次操作会改变棋局的值，通过改变的棋局值来进行 机器操作
			
			if (isMeachine) {//如果是人机模式 调用人机对弈函数 ******、
				//人机对弈函数根据棋局的值做出判断,输出结果会直接改变棋局的值
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
			if (isMeachine) {//如果是人机就打开 isclick
				isClick=true;
			}
			//GAMESTART|tableindex|side
			if (!isMeachine) {//判断是否是人机模式
				String str="GAMESTART|"+gametableIndex+"|"+side;
				ClientService.getClientService().getClientGame().sendMSG(str);
			}
			txtLog.append(" 游戏已经开始！\r\n");
		}
	}
	
	//退出游戏按钮
	private class BtnCloseActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			//退出游戏
			//GAMEOVER@TABLEINDEX@SIDE
			if (!isMeachine) {//判断是否是人机模式
				String  str="GAMEOVER|"+gametableIndex+"|"+side;
				ClientService.getClientService().getClientGame().sendMSG(str);
				//更新本用户的游戏桌占有情况
				ClientService.getClientService().updateGameTable(gametableIndex, side, "0");
			}
			//清空游戏数据
			ClientService.getClientService().resetData();
			dispose();//关闭当前窗体
		}
	}
	
	//聊天按钮
	private class BtnSendActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			//聊天：   MSG|Tableindex|side|essagecontent
			if (!isMeachine) {//判断是否是人机模式
				String sMsg="MSG|"+gametableIndex+"|"+side+"|"+txtSend.getText().trim();
				ClientService.getClientService().getClientGame().sendMSG(sMsg);
			
			}
			txtLog.append("我说："+txtSend.getText().trim()+"\r\n");
			
			txtSend.setText("");
		}
	}
}
