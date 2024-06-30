package Client;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class picPanel extends JPanel {

	int [][]gamedata;   //0:??????; 1:?????2??????  
	//???? rb1 rb2 rb3 rb4 rb5  2 11~2 15
	//???? rp2 rp2 2 21~2 22
	//???? rj1 rj2 2 31~2 32	
	//???? rm1 rm2	2 41~2 42	
	//???? rx1 rx2 2 51~2 52 	
	//???rs 2 61~2 62 		
	//???rss 2 7
	
	//????? Bz1 Bz2 Bz3 Bz4 Bz5  1 11~1 15
	//????? Bp2 Bp2 1 21~1 22
	//????? Bju1 Bju2 1 31~1 32	
	//????? rm1 rm2	1 41~1 42	
	//????? rx1 rx2 1 51~1 52 	
	//????rs 1 61~1 62 		
	//????rss 1 7
	
	
	
	Image imgBoard;
	//?? ??5
	Image imgRb1;
	Image imgRb2;
	Image imgRb3;
	Image imgRb4;
	Image imgRb5;
	//??
	Image imgRju1;
	Image imgRju2;
	//??
	Image imgRm1;
	Image imgRm2;
	//??
	Image imgRp1;
	Image imgRp2;
	//??
	Image imgRx1;
	Image imgRx2;
	//?
	Image imgRs1;
	Image imgRs2;
	//?
	Image imgRss;
	
	//??? ??5
	Image imgBzu1;
	Image imgBzu2;
	Image imgBzu3;
	Image imgBzu4;
	Image imgBzu5;
	//??
	Image imgBju1;
	Image imgBju2;
	//??
	Image imgBm1;
	Image imgBm2;
	//??
	Image imgBp1;
	Image imgBp2;
	//??
	Image imgBx1;
	Image imgBx2;
	//?
	Image imgBs1;
	Image imgBs2;

	//??
	Image imgBj;
	
	//????????????  ??�??????? 60
	int iLeft=40;
	int iTop=45;
	/**
	 * Create the panel.
	 */
	public picPanel() {
		//????????????????????
		
		//??ClientService???gamedata???????
		gamedata=ClientService.getClientService().getGameData();
		//????
		imgBoard=new ImageIcon("img/board.jpg").getImage();
		
		//?? ??5
		 imgRb1=new ImageIcon("img/rb.jpg").getImage();
		 imgRb2=new ImageIcon("img/rb.jpg").getImage();
		 imgRb3=new ImageIcon("img/rb.jpg").getImage();
		 imgRb4=new ImageIcon("img/rb.jpg").getImage();
		 imgRb5=new ImageIcon("img/rb.jpg").getImage();
		//??
		 imgRju1=new ImageIcon("img/rj.jpg").getImage();
		 imgRju2=new ImageIcon("img/rj.jpg").getImage();
		//??
		 imgRm1=new ImageIcon("img/rm.jpg").getImage();
		 imgRm2=new ImageIcon("img/rm.jpg").getImage();
		//??
		 imgRp1=new ImageIcon("img/rp.jpg").getImage();
		 imgRp2=new ImageIcon("img/rp.jpg").getImage();
		//??
		 imgRx1=new ImageIcon("img/rx.jpg").getImage();
		 imgRx2=new ImageIcon("img/rx.jpg").getImage();
		//?
		 imgRs1=new ImageIcon("img/rs.jpg").getImage();
		 imgRs2=new ImageIcon("img/rs.jpg").getImage();
		 //?
		 imgRss=new ImageIcon("img/rss.jpg").getImage();
		
		//??? ??5
		 imgBzu1=new ImageIcon("img/bz.jpg").getImage();
		 imgBzu2=new ImageIcon("img/bz.jpg").getImage();
		 imgBzu3=new ImageIcon("img/bz.jpg").getImage();
		 imgBzu4=new ImageIcon("img/bz.jpg").getImage();
		 imgBzu5=new ImageIcon("img/bz.jpg").getImage();
		//??
		 imgBju1=new ImageIcon("img/bju.jpg").getImage();
		 imgBju2=new ImageIcon("img/bju.jpg").getImage();
		//??
		 imgBm1=new ImageIcon("img/bm.jpg").getImage();
		 imgBm2=new ImageIcon("img/bm.jpg").getImage();
		//??
		 imgBp1=new ImageIcon("img/bp.jpg").getImage();
		 imgBp2=new ImageIcon("img/bp.jpg").getImage();
		//??
		 imgBx1=new ImageIcon("img/bx.jpg").getImage();
		 imgBx2=new ImageIcon("img/bx.jpg").getImage();
		//?
		 imgBs1=new ImageIcon("img/bs.jpg").getImage();
		 imgBs2=new ImageIcon("img/bs.jpg").getImage();
		 //??
		 imgBj=new ImageIcon("img/bj.jpg").getImage();
		
		
	}
	
	@Override
	public void paint(Graphics g) {		
		super.paint(g);
		//???????
		
		//???????? ???? left40 top45
		//?????? 
		//??5 ??????  left40 top45+60*60
		/*g.drawImage(imgRb1, 40-30, 45+60*6-30, null);//????????1
		g.drawImage(imgRb2, 40+60*2-30,45+60*6-30, null);//????????2
		g.drawImage(imgRb3, 40+60*4-30,45+60*6-30, null);//????????3
		g.drawImage(imgRb4, 40+60*6-30,45+60*6-30, null);//????????4
		g.drawImage(imgRb5, 40+60*8-30,45+60*6-30, null);//????????5
		//??2 ?????? left 40+60 top45+60*7
		g.drawImage(imgRp1, 40+60-30,45+60*7-30, null);//????????1
		g.drawImage(imgRp2, 40+60*7-30, 45+60*7-30, null);//????????2
		//??2?????? left 40 top45+60*9
		g.drawImage(imgRju1, 40-30, 45+60*9-30, null);//????????1
		g.drawImage(imgRju2, 40+60*8-30,45+60*9-30, null);//????????2
		//??2 ?????? left 40+60 top45+60*9
		g.drawImage(imgRm1, 40+60-30, 45+60*9-30, null);//????????1
		g.drawImage(imgRm2, 40+60*7-30, 45+60*9-30, null);//????????2
		//??2 left40+60*2 top45+60*9
		g.drawImage(imgRx1, 40+60*2-30, 45+60*9-30, null);//????????1
		g.drawImage(imgRx2, 40+60*6-30, 45+60*9-30, null);//????????2
		//?2 letf40+60*3 top45+60*9
		g.drawImage(imgRs1, 40+60*3-30, 45+60*9-30, null);//???????1
		g.drawImage(imgRs2, 40+60*5-30, 45+60*9-30, null);//???????2
		//? left40+60*4 top45+60*9
		g.drawImage(imgRss, 40+60*4-30, 45+60*9-30, null);//???????
		
		
		//???????
		//??5 ???????  left40 top45+60*3
		g.drawImage(imgBzu1, 40-30, 45+60*3-30, null);//?????????1
		g.drawImage(imgBzu2, 40+60*2-30,45+60*3-30, null);//?????????2
		g.drawImage(imgBzu3, 40+60*4-30,45+60*3-30, null);//?????????3
		g.drawImage(imgBzu4, 40+60*6-30,45+60*3-30, null);//?????????4
		g.drawImage(imgBzu5, 40+60*8-30,45+60*3-30, null);//?????????5
		//??2 ??????? left 40+60 top45+60*2
		g.drawImage(imgBp1, 40+60-30,45+60*2-30, null);//?????????1
		g.drawImage(imgBp2, 40+60*7-30, 45+60*2-30, null);//?????????2
		//??2??????? left 40 top45
		g.drawImage(imgBju1, 40-30, 45, null);//????=?????1
		g.drawImage(imgBju2, 40+60*8-30,45, null);//?????????2
		//??2 ??????? left 40+60 top45
		g.drawImage(imgBm1, 40+60-30, 45, null);//?????????1
		g.drawImage(imgBm2, 40+60*7-30, 45, null);//?????????2
		//??2 left40+60*2 top45
		g.drawImage(imgBx1, 40+60*2-30, 45, null);//????????1
		g.drawImage(imgBx2, 40+60*6-30, 45, null);//????????2
		//?2 letf40+60*3 top45
		g.drawImage(imgBs1, 40+60*3-30, 45, null);//???????1
		g.drawImage(imgBs2, 40+60*5-30, 45, null);//???????2
		//?? left40+60*4 top45
		g.drawImage(imgBj, 40+60*4-30, 45, null);//???????
		*/
		g.drawImage(imgBoard, 0, 0, null);
		
		for (int i = 0; i < gamedata.length; i++) {//???????�??????????????
			for (int j = 0; j < gamedata[0].length; j++) {//???????�???????????
				int xx=i*60+iLeft-30;//????x????
				int yy=j*60+iTop-30;//????y????
				
				//???�?????????????????
				switch(gamedata[i][j]){
				//????? 111-115
					case 111:
						g.drawImage(imgBzu1, xx, yy, null);
						break;
					case 112:
						g.drawImage(imgBzu2, xx, yy, null);
						break;
					case 113:
						g.drawImage(imgBzu3, xx, yy, null);
						break;
					case 114:
						g.drawImage(imgBzu4, xx, yy, null);
						break;
					case 115:
						g.drawImage(imgBzu5, xx, yy, null);
						break;
					//?????121-122
					case 121:
						g.drawImage(imgBp1, xx, yy, null);
						break;
					case 122:
						g.drawImage(imgBp2, xx, yy, null);
						break;
					//????e131-132
					case 131:
						g.drawImage(imgBju1, xx, yy, null);
						break; 
					case 132:
						g.drawImage(imgBju2, xx, yy, null);
						break;
					//?????141-142
					case 141:
						g.drawImage(imgBm1, xx, yy, null);
						break;
					case 142:
						g.drawImage(imgBm2, xx, yy, null);
						break;
					//?????151-152
					case 151:
						g.drawImage(imgBx1, xx, yy, null);
						break;
					case 152:
						g.drawImage(imgBx2, xx, yy, null);
						break;
					//?????161-162
					case 161:
						g.drawImage(imgBs1, xx, yy, null);
						break;
					case 162:
						g.drawImage(imgBs2, xx, yy, null);
						break;
					//????17
					case 170:
						g.drawImage(imgBj, xx, yy, null);
						break;
						
						//???? 211-215
					case 211:
						g.drawImage(imgRb1, xx, yy, null);
						break;
					case 212:
						g.drawImage(imgRb2, xx, yy, null);
						break;
					case 213:
						g.drawImage(imgRb3, xx, yy, null);
						break;
					case 214:
						g.drawImage(imgRb4, xx, yy, null);
						break;
					case 215:
						g.drawImage(imgRb5, xx, yy, null);
						break;
					//????221-222
					case 221:
						g.drawImage(imgRp1, xx, yy, null);
						break;
					case 222:
						g.drawImage(imgRp2, xx, yy, null);
						break;
					//???e231-232
					case 231:
						g.drawImage(imgRju1, xx, yy, null);
						break; 
					case 232:
						g.drawImage(imgRju2, xx, yy, null);
						break;
					//????241-242
					case 241:
						g.drawImage(imgRm1, xx, yy, null);
						break;
					case 242:
						g.drawImage(imgRm2, xx, yy, null);
						break;
					//????251-252
					case 251:
						g.drawImage(imgRx1, xx, yy, null);
						break;
					case 252:
						g.drawImage(imgRx2, xx, yy, null);
						break;
					//????261-262
					case 261:
						g.drawImage(imgRs1, xx, yy, null);
						break;
					case 262:
						g.drawImage(imgRs2, xx, yy, null);
						break;
					//???27
					case 270:
						g.drawImage(imgRss, xx, yy, null);
						break;
				}
				
			}
		}
		
	}

}
