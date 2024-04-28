package Client;

import javax.lang.model.element.Element;
class point{
	int x[]={-1,-1,-1,-1,-1,-1,-1,-1,-1};//????¦Ë???????
	int y[]={-1,-1,-1,-1,-1,-1,-1,-1,-1};
	int length=0;//?????????????
}

public class Meachine {

	int data[][];//????????
	int x;//x????
	int y;//y????
	int value;//??????
		//???????????????????????????????
		int x_bing[]={-1,-1,-1,-1,-1};
		int y_bing[]={-1,-1,-1,-1,-1};
		int bing_length=0;
	
	
		int x_zu[]={-1,-1,-1,-1,-1};
		int y_zu[]={-1,-1,-1,-1,-1};
		int zu_length=0;
	
	
		int x_pao[]={-1,-1,-1,-1};
		int y_pao[]={-1,-1,-1,-1};
		int pao_length=0;
	
	
		int x_ju[]={-1,-1,-1,-1};
		int y_ju[]={-1,-1,-1,-1};
		int ju_length=0;
	
	
		int x_ma[]={-1,-1,-1,-1};
		int y_ma[]={-1,-1,-1,-1};
		int ma_length=0;
	
	
		int x_xiang[]={-1,-1,-1,-1};
		int y_xiang[]={-1,-1,-1,-1};
		int xiang_length=0;
	
	
		int x_shi[]={-1,-1,-1,-1};
		int y_shi[]={-1,-1,-1,-1};
		int shi_length=0;
	
	
		int x_shuai;
		int y_shuai;
		int shuai_length=0;
	
	
		int x_jiang;
		int y_jiang;
		int jiang_length=0;
		
	void setInitia(){//?????????????
		for(int a=0;a<5;a++){
			x_bing[a]=-1;
			y_bing[a]=-1;
			x_zu[a]=-1;
			y_zu[a]=-1;
		}
		bing_length=0;
		zu_length=0;
		for(int a=0;a<4;a++){
			x_pao[a]=-1;
			y_pao[a]=-1;
			
			x_ju[a]=-1;
			y_ju[a]=-1;
			
			x_ma[a]=-1;
			y_ma[a]=-1;
			 
			x_xiang[a]=-1;
			y_xiang[a]=-1;
			
			x_shi[a]=-1;
			y_shi[a]=-1;
		}
		x_shuai=-1;
		y_shuai=-1;
		x_jiang=-1;
		y_jiang=-1;
		
		pao_length=0;
		ju_length=0;
		ma_length=0;
		xiang_length=0;
		shi_length=0;
		shuai_length=0;
		jiang_length=0;
		
	}
	void getchess_X_Y(){//??????????¦Ë????????¦Ë??????????
		setInitia();
		data=ClientService.getClientService().getGameData();
		for (int i = 0; i < data.length; i++) {//??????????§Ö?????¦Ë?????
			for (int j = 0; j < data[0].length; j++) {//??????????§Ö????????
				switch (data[i][j]) {
				case 111://?§Ø?  ??
					x_zu[0]=i;
					y_zu[0]=j;
					zu_length++;
					break;
				case 112:
					x_zu[1]=i;
					y_zu[1]=j;
					zu_length++;
					break;
				case 113:
					x_zu[2]=i;
					y_zu[2]=j;
					zu_length++;
					break;
				case 114:
					x_zu[3]=i;
					y_zu[3]=j;
					zu_length++;
					break;
				case 115:
					x_zu[4]=i;
					y_zu[4]=j;
					zu_length++;
					break;
					
				case 121:	//?§Ø?  ??
					x_pao[0]=i;
					y_pao[0]=j;
					pao_length++;
					break;
				case 122:
					x_pao[1]=i;
					y_pao[1]=j;
					pao_length++;
					break;
					
				case 131:	//	?
					x_ju[0]=i;
					y_ju[0]=j;
					ju_length++;
					break;
				case 132:
					x_ju[1]=i;
					y_ju[1]=j;
					ju_length++;
					break;
					
				case 141:	//	??
					x_ma[0]=i;
					y_ma[0]=j;
					ma_length++;
					break;
				case 142:
					x_ma[1]=i;
					y_ma[1]=j;
					ma_length++;
					break;
				
				case 151:	//??
					x_xiang[0]=i;
					y_xiang[0]=j;
					xiang_length++;
					break;
				case 152:
					x_xiang[1]=i;
					y_xiang[1]=j;
					xiang_length++;
					break;
					
				case 161:	//?
					x_shi[0]=i;
					y_shi[0]=j;
					shi_length++;
					break;
				case 162:
					x_shi[1]=i;
					y_shi[1]=j;
					shi_length++;
					break;
				case 170:	//??
					x_jiang=i;
					y_jiang=j;
					break;
				//???	
				case 211:	//?§Ø?  ??
					x_bing[0]=i;
					y_bing[0]=j;
					bing_length++;
					break;
				case 212:
					x_bing[1]=i;
					y_bing[1]=j;
					bing_length++;
					break;
				case 213:
					x_bing[2]=i;
					y_bing[2]=j;
					bing_length++;
					break;
				case 214: 
					x_bing[3]=i;
					y_bing[3]=j;
					bing_length++;
					break;
				case 215:
					x_bing[4]=i;
					y_bing [4]=j;
					bing_length++;
					break;
					
				case 221:	//?§Ø?  ??
					x_pao[2]=i;
					y_pao[2]=j;
					break;
				case 222:
					x_pao[3]=i;
					y_pao[3]=j;
					break;
					
				case 231:	//	?
					x_ju[2]=i;
					y_ju[2]=j;
					break;
				case 232:
					x_ju[3]=i;
					y_ju[3]=j;
					break;					
				case 241:	//	??
					x_ma[2]=i;
					y_ma[2]=j;
					break;
				case 242:
					x_ma[3]=i;
					y_ma[3]=j;
					break;
					
				case 251:	//??
					x_xiang[2]=i;
					y_xiang[2]=j;
					break;
				case 252:
					x_xiang[3]=i;
					y_xiang[3]=j;
					break;
					
				case 261:	//?
					x_shi[2]=i;
					y_shi[2]=j;
					break;
				case 262:
					x_shi[3]=i;
					y_shi[3]=j;
					break;
					
				case 270:	//?
					x_shuai=i;
					y_shuai=j;
					break;
				default:
					break;
				}
			}
		}
	}
	int getchessValue(int type){//??????????????
		int value=0;
		int data[][]=ClientService.getClientService().getGameData();
		for (int i = 0; i < data.length; i++) {//??????????§Ö?????¦Ë?????
			for (int j = 0; j < data[0].length; j++) {//??????????§Ö????????
				if(type==0){
					if (data[i][j]<200) {
						value=value+data[i][j];
					}
				}else{
					if (data[i][j]>200) {
						value=value+data[i][j];
					}
				}
			}
		}
		return value;
	}
	point bing(int x1,int y1){//????????????¦¶????????????????????¦¶
		int i=x1;//i,j?????????¦Ë??????
		int j=y1;
		int i2;//i2,j2??????????????¦Ë??????
		int j2;
		point p=new point();
		
		//?????????????????????????????????????????????????
		i2=i+1;
		j2=j;

		if(((i2==i+1&&j==j2&&i+1<=8&&j<=4&&i>=0)||(i2==i&&j2==j-1&&j-1>=0&&j<=6&&i>=0)||(i2==i-1&&j2==j&&i-1>=0&&j<=4&&i>=0))&&i2>=0&&i2<9&&j2>=0&&j2<10){
			//i=i2;//???¦Ë?¨²???????????§Ö??????i  
			//j=j2;//???¦Ë?¨²???????????§Ö??????j
			p.x[p.length]=i2;
			p.y[p.length]=j2;
			p.length++;
		}
			
		
		i2=i-1;
		j2=j;
		
		if(((i2==i+1&&j==j2&&i+1<=8&&j<=4&&i>=0)||(i2==i&&j2==j-1&&j-1>=0&&j<=6&&i>=0)||(i2==i-1&&j2==j&&i-1>=0&&j<=4&&i>=0))&&i2>=0&&i2<9&&j2>=0&&j2<10){
			//i=i2;//???¦Ë?¨²???????????§Ö??????i  
			//j=j2;//???¦Ë?¨²???????????§Ö??????j
			p.x[p.length]=i2;
			p.y[p.length]=j2;
			p.length++;
		}
		
		j2=j-1;
		i2=i;
	
		if(((i2==i+1&&j==j2&&i+1<=8&&j<=4&&i>=0)||(i2==i&&j2==j-1&&j-1>=0&&j<=6&&i>=0)||(i2==i-1&&j2==j&&i-1>=0&&j<=4&&i>=0))&&i2>=0&&i2<9&&j2>=0&&j2<10){
			//i=i2;//???¦Ë?¨²???????????§Ö??????i  
			//j=j2;//???¦Ë?¨²???????????§Ö??????j
			p.x[p.length]=i2;
			p.y[p.length]=j2;
			p.length++;;
		}
		return p;
	}
	
	point zu(int x1,int y1){//???????????¦¶??????????????????¦¶
		int i=x1;//i,j?????????¦Ë??????
		int j=y1;
		int i2;//i2,j2??????????????¦Ë??????
		int j2;
		point p=new point();
		//?????????????????????????????????????????????????
		i2=i+1;
		j2=j;
		if(((i2==i+1&&j==j2&&i+1<=8&&j>=5)||(i2==i&&j2==j+1&&j+1<=9&&j>=3)||(i2==i-1&&j2==j&&i-1>=0&&j>=5))&&i2>=0&&i2<9&&j2>=0&&j2<10){
			
			p.x[p.length]=i2;
			p.y[p.length]=j2;
			p.length++;
		}
		
		i2=i-1;
		j2=j;
		if(((i2==i+1&&j==j2&&i+1<=8&&j>=5)||(i2==i&&j2==j+1&&j+1<=9&&j>=3)||(i2==i-1&&j2==j&&i-1>=0&&j>=5))&&i2>=0&&i2<9&&j2>=0&&j2<10){
			
			p.x[p.length]=i2;
			p.y[p.length]=j2;
			p.length++;
		}
		
		j2=j+1;
		i2=i;
		if(((i2==i+1&&j==j2&&i+1<=8&&j>=5)||(i2==i&&j2==j+1&&j+1<=9&&j>=3)||(i2==i-1&&j2==j&&i-1>=0&&j>=5))&&i2>=0&&i2<9&&j2>=0&&j2<10){
			
			p.x[p.length]=i2;
			p.y[p.length]=j2;
			p.length++;
		}
		return p;
	}
	
	point pao(int x1,int y1){//???????????¦¶??????????????????¦¶
		int count=0;
		int i=x1;//??????i,j
		int j=y1;
		int i2=i;//????????i2??j2
		int j2=j;
		point p=new point();
		int data[][]=ClientService.getClientService().getGameData();
		value=data[i][j];
		
		
			if (value<200) {//???
				if(i==i2){//???????
				//???????
					for(int j1=j+1;j1<9;j1++ ){ //???????
						if(data[i][j1]!=0){
							count++;
						}
						if (count==2) {
							break;
						}
					}
					if(count==0||count==2){
						if((data[i][j]==0||data[i][j]>200)&&i2>=0&&i2<9&&j2>=0&&j2<10){
							//????????????????
							p.x[p.length]=i2;
							p.y[p.length]=j2;
							p.length++;
						}
						count=0;
					}
				//???????
					for(int j1=j-1;j1>0;j1--){//???????
						if(data[i][j1]!=0){
							count++;
						}
						if (count==2) {
							break;
						}
					}
					if(count==0||count==2){
						
						if((data[i][j]==0||data[i][j]>200)&&i2>=0&&i2<9&&j2>=0&&j2<10){
							//????????????????
							p.x[p.length]=i2;
							p.y[p.length]=j2;
							p.length++;
						}
						count=0;
					}
				}
				 if (j==j2) {//???????
					 
				 //???????
					for(int i1=i+1;i1<8;i1++ ){//???????
						if(data[i1][j]!=0){
							count++;
						}
						if (count==2) {
							break;
						}
					}
					if(count==0||count==2){
						if((data[i][j]==0||data[i][j]>200)&&i2>=0&&i2<9&&j2>=0&&j2<10){
							//????????????????
							p.x[p.length]=i2;
							p.y[p.length]=j2;
							p.length++;
						}
						count=0;
					}
				//???????
					for(int i1=i-1;i1>0;i1--){//???????
						if(data[i1][j]!=0){
							count++;
						}
						if (count==2) {
							break;
						}
					}
					if(count==0||count==2){
						if((data[i][j]==0||data[i][j]>200)&&i2>=0&&i2<9&&j2>=0&&j2<10){
							//????????????????
							p.x[p.length]=i2;
							p.y[p.length]=j2;
							p.length++;
						}
					}

				}
			}else{//??
				if(i==i2){//???????
				//???????
					for(int j1=j+1;j1<9;j1++ ){ //???????
						if(data[i][j1]!=0){
							count++;
						}
						if (count==2) {
							break;
						}
					}
					if(count==0||count==2){
						if((data[i][j]==0||data[i][j]<200)&&i2>=0&&i2<9&&j2>=0&&j2<10){
							//????????????????
							p.x[p.length]=i2;
							p.y[p.length]=j2;
							p.length++;
						}
						count=0;
					}
				//???????
					for(int j1=j-1;j1>0;j1--){//???????
						if(data[i][j1]!=0){
							count++;
						}
						if (count==2) {
							break;
						}
					}
					if(count==0||count==2){
						
						if((data[i][j]==0||data[i][j]<200)&&i2>=0&&i2<9&&j2>=0&&j2<10){
							//????????????????
							p.x[p.length]=i2;
							p.y[p.length]=j2;
							p.length++;
						}
						count=0;
					}
				}
			if (j==j2) {//???????
					 
				 //???????
					for(int i1=i+1;i1<8;i1++ ){//???????
						if(data[i1][j]!=0){
							count++;
						}
						if (count==2) {
							break;
						}
					}
					if((count==0||count==2)&&i2>=0&&i2<9&&j2>=0&&j2<10){
						if(data[i][j]==0||data[i][j]<200){
							//????????????????
							p.x[p.length]=i2;
							p.y[p.length]=j2;
							p.length++;
						}
						count=0;
					}
				//???????
					for(int i1=i-1;i1>0;i1--){//???????
						if(data[i1][j]!=0){
							count++;
						}
						if (count==2) {
							break;
						}
					}
					if(count==0||count==2){
						if((data[i][j]==0||data[i][j]<200)&&i2>=0&&i2<9&&j2>=0&&j2<10){
							//????????????????
							p.x[p.length]=i2;
							p.y[p.length]=j2;
							p.length++;
						}
					}

				}
			}
			return p;
	}
	
	point ju(int x1,int y1){//???????????¦¶??????????????????¦¶
		int i=x1;
		int j=y1;
		int i2=i;
		int j2=j;
		point p=new point();
		int data[][]=ClientService.getClientService().getGameData();
		int count=0;
		if (data[i][j]<200) {//???
			
		}else{//??
			
		}
		if(i==i2){//???????
			//???????
				for(int j1=j+1;j1<9;j1++ ){
					if(data[i][j1]!=0){
						count++;
					}
					if(count<1&&(data[i][j]==0||data[i][j]>200)&&i2>=0&&i2<9&&j2>=0&&j2<10){
						p.x[p.length]=i2;
						p.y[p.length]=j2;
						p.length++;
					}
				}
				
			//???????
				for(int j1=j2-1;j1>0;j1--){
					if(data[i][j1]!=0){
						count++;
					}
					if(count<1&&(data[i][j]==0||data[i][j]>200)&&i2>=0&&i2<9&&j2>=0&&j2<10){
						p.x[p.length]=i2;
						p.y[p.length]=j2;
						p.length++;
					}
				}
		}else if (j==j2) {//???????
			//???????
				for(int i1=i+1;i1<8;i1++ ){
					if(data[i1][j]!=0){
						count++;
					}
					if(count<1&&(data[i][j]==0||data[i][j]>200)&&i2>=0&&i2<9&&j2>=0&&j2<10){
						p.x[p.length]=i2;
						p.y[p.length]=j2;
						p.length++;
					}
				}
				
			//???????
				for(int i1=i-1;i1>0;i1--){
					if(data[i][j]!=0){
						count++;
					}
					if(count<1&&(data[i][j]==0||data[i][j]>200)&&i2>=0&&i2<9&&j2>=0&&j2<10){
						p.x[p.length]=i2;
						p.y[p.length]=j2;
						p.length++;
					}
				}
		}
		return p;
	}
	
	point ma(int x1,int y1){//???????????¦¶??????????????????¦¶
		int i=x1;
		int j=y1;
		int i2=i;
		int j2=j;
		point p=new point();
		int data[][]=ClientService.getClientService().getGameData();//??????????
		int value;//????????
		
		if (data[i][j]<200) {//???
			//1
			i2=i+1;
			j2=j-2;
			if (data[i][j-1]==0&&(data[i2][j2]>200||data[i2][j2]==0)&&i2>=0&&i2<9&&j2>=0&&j2<10) {
				//????????›¥????
				p.x[p.length]=i2;
				p.y[p.length]=j2;
				p.length++;
			}
			
			//2
			i2=i+2;
			j2=j-1;
			if (data[i+1][j]==0&&(data[i2][j2]>200||data[i2][j2]==0)&&i2>=0&&i2<9&&j2>=0&&j2<10) {
				//????????›¥????
				p.x[p.length]=i2;
				p.y[p.length]=j2;
				p.length++;
			}
			//3
			i2=i+2;
			j2=j+1;
			if (data[i+1][j]==0&&(data[i2][j2]>200||data[i2][j2]==0)&&i2>=0&&i2<9&&j2>=0&&j2<10) {
				//????????›¥????
				p.x[p.length]=i2;
				p.y[p.length]=j2;
				p.length++;
			}
			//4
			i2=i+1;
			j2=j+2;
			if (data[i][j-1]==0&&(data[i2][j2]>200||data[i2][j2]==0)&&i2>=0&&i2<9&&j2>=0&&j2<10) {
				//????????›¥????
				p.x[p.length]=i2;
				p.y[p.length]=j2;
				p.length++;
			}
			//5
			i2=i-1;
			j2=j+2;
			if (data[i][j-1]==0&&(data[i2][j2]>200||data[i2][j2]==0)&&i2>=0&&i2<9&&j2>=0&&j2<10) {
				//????????›¥????
				p.x[p.length]=i2;
				p.y[p.length]=j2;
				p.length++;
			}
			//6
			i2=i-2;
			j2=j+1;
			if (data[i-1][j]==0&&(data[i2][j2]>200||data[i2][j2]==0)&&i2>=0&&i2<9&&j2>=0&&j2<10) {
				//????????›¥????
				p.x[p.length]=i2;
				p.y[p.length]=j2;
				p.length++;
			}
			//7
			i2=i-2;
			j2=j-1;
			if (data[i-1][j]==0&&(data[i2][j2]>200||data[i2][j2]==0)&&i2>=0&&i2<9&&j2>=0&&j2<10) {
				//????????›¥????
				p.x[p.length]=i2;
				p.y[p.length]=j2;
				p.length++;
			}
			//8
			i2=i-1;
			j2=j-2;
			if (data[i][j-1]==0&&(data[i2][j2]>200||data[i2][j2]==0)&&i2>=0&&i2<9&&j2>=0&&j2<10) {
				//????????›¥????
				p.x[p.length]=i2;
				p.y[p.length]=j2;
				p.length++;
			}
			
		}else{//??
			//1
			i2=i+1;
			j2=j-2;
			if (data[i][j-1]==0&&(data[i2][j2]<200||data[i2][j2]==0)&&i2>=0&&i2<9&&j2>=0&&j2<10) {
				//????????›¥????
				p.x[p.length]=i2;
				p.y[p.length]=j2;
				p.length++;
			}
			
			//2
			i2=i+2;
			j2=j-1;
			if (data[i+1][j]==0&&(data[i2][j2]<200||data[i2][j2]==0)&&i2>=0&&i2<9&&j2>=0&&j2<10) {
				//????????›¥????
				p.x[p.length]=i2;
				p.y[p.length]=j2;
				p.length++;
			}
			//3
			i2=i+2;
			j2=j+1;
			if (data[i+1][j]==0&&(data[i2][j2]<200||data[i2][j2]==0)&&i2>=0&&i2<9&&j2>=0&&j2<10) {
				//????????›¥????
				p.x[p.length]=i2;
				p.y[p.length]=j2;
				p.length++;
			}
			//4
			i2=i+1;
			j2=j+2;
			if (data[i][j-1]==0&&(data[i2][j2]<200||data[i2][j2]==0)&&i2>=0&&i2<9&&j2>=0&&j2<10) {
				//????????›¥????
				p.x[p.length]=i2;
				p.y[p.length]=j2;
				p.length++;
			}
			//5
			i2=i-1;
			j2=j+2;
			if (data[i][j-1]==0&&(data[i2][j2]<200||data[i2][j2]==0)&&i2>=0&&i2<9&&j2>=0&&j2<10) {
				//????????›¥????
				p.x[p.length]=i2;
				p.y[p.length]=j2;
				p.length++;
			}
			//6
			i2=i-2;
			j2=j+1;
			if (data[i-1][j]==0&&(data[i2][j2]<200||data[i2][j2]==0)&&i2>=0&&i2<9&&j2>=0&&j2<10) {
				//????????›¥????
				p.x[p.length]=i2;
				p.y[p.length]=j2;
				p.length++;
			}
			//7
			i2=i-2;
			j2=j-1;
			if (data[i-1][j]==0&&(data[i2][j2]<200||data[i2][j2]==0)&&i2>=0&&i2<9&&j2>=0&&j2<10) {
				//????????›¥????
				p.x[p.length]=i2;
				p.y[p.length]=j2;
				p.length++;
			}
			//8
			i2=i-1;
			j2=j-2;
			if (data[i][j-1]==0&&(data[i2][j2]<200||data[i2][j2]==0)&&i2>=0&&i2<9&&j2>=0&&j2<10) {
				//????????›¥????
				p.x[p.length]=i2;
				p.y[p.length]=j2;
				p.length++;
			}
			
		}
		return p;	
			
		
	}
	
	point xiang(int x1,int y1){//???????????¦¶??????????????????¦¶
		int i=x1;
		int j=y1;
		int i2=i;
		int j2=j;
		point p=new point();
		int data[][]=ClientService.getClientService().getGameData();
		
		if (data[i][j]<200) {//???
			//1
			i2=i+2;
			j2=j-2;
			if (data[i+1][j-1]==0&&data[i2][j2]>200&&i2>=0&&i2<9&&j2>=0&&j2<10) {
				//???????????????????
				p.x[p.length]=i2;
				p.y[p.length]=j2;
				p.length++;
			}
			//2
			i2=i+2;
			j2=j+2;
			if (data[i+1][j+1]==0&&data[i2][j2]>200&&i2>=0&&i2<9&&j2>=0&&j2<10) {
				//???????????????????
				p.x[p.length]=i2;
				p.y[p.length]=j2;
				p.length++;
			}
			//3
			i2=i-2;
			j2=j+2;
			if (data[i-1][j+1]==0&&data[i2][j2]>200&&i2>=0&&i2<9&&j2>=0&&j2<10) {
				//???????????????????
				p.x[p.length]=i2;
				p.y[p.length]=j2;
				p.length++;
			}
			//4
			i2=i-2;
			j2=j-2;
			if (data[i-1][j-1]==0&&data[i2][j2]>200&&i2>=0&&i2<9&&j2>=0&&j2<10) {
				//???????????????????
				p.x[p.length]=i2;
				p.y[p.length]=j2;
				p.length++;
			}
		}else{//??
			//1
			i2=i+2;
			j2=j-2;
			if (data[i+1][j-1]==0&&data[i2][j2]<200&&i2>=0&&i2<9&&j2>=0&&j2<10) {
				//???????????????????
				p.x[p.length]=i2;
				p.y[p.length]=j2;
				p.length++;
			}
			//2
			i2=i+2;
			j2=j+2;
			if (data[i+1][j+1]==0&&data[i2][j2]<200&&i2>=0&&i2<9&&j2>=0&&j2<10) {
				//???????????????????
				p.x[p.length]=i2;
				p.y[p.length]=j2;
				p.length++;
			}
			//3
			i2=i-2;
			j2=j+2;
			if (data[i+1][j+1]==0&&data[i2][j2]<200&&i2>=0&&i2<9&&j2>=0&&j2<10) {
				//???????????????????
				p.x[p.length]=i2;
				p.y[p.length]=j2;
				p.length++;
			}
			//4
			i2=i-2;
			j2=j-2;
			if (data[i-1][j-1]==0&&data[i2][j2]<200&&i2>=0&&i2<9&&j2>=0&&j2<10) {
				//???????????????????
				p.x[p.length]=i2;
				p.y[p.length]=j2;
				p.length++;
			}
		}
		return p;
		
	}
	
	point shi(int x1,int y1){//???????????¦¶??????????????????¦¶
		int i=x1;
		int j=y1;
		int i2;
		int j2;
		point p=new point();
		int data[][]=ClientService.getClientService().getGameData();
	    int value=data[i][j];
		if (value<200) {//???
			//1
			i2=i+1;
			j2=j-1;
			if ((data[i2][j2]==0||data[i2][j2]>200)&&i2>=0&&i2<9&&j2>=0&&j2<10) {
				//?????????????›¥????
				p.x[p.length]=i2;
				p.y[p.length]=j2;
				p.length++;
			}
			//2
			i2=i+1;
			j2=j+1;
			if ((data[i2][j2]==0||data[i2][j2]>200)&&i2>=0&&i2<9&&j2>=0&&j2<10) {
				//?????????????›¥????
				p.x[p.length]=i2;
				p.y[p.length]=j2;
				p.length++;
			}
			//3
			i2=i-1;
			j2=j+1;
			if ((data[i2][j2]==0||data[i2][j2]>200)&&i2>=0&&i2<9&&j2>=0&&j2<10) {
				//?????????????›¥????
				p.x[p.length]=i2;
				p.y[p.length]=j2;
				p.length++;
			}
			//4
			i2=i-1;
			j2=j-1;
			if ((data[i2][j2]==0||data[i2][j2]>200)&&i2>=0&&i2<9&&j2>=0&&j2<10) {
				//?????????????›¥????
				p.x[p.length]=i2;
				p.y[p.length]=j2;
				p.length++;
			}
			
		}else{//??
			//1
			i2=i+1;
			j2=j-1;
			if ((data[i2][j2]==0||data[i2][j2]>200)&&i2>=0&&i2<9&&j2>=0&&j2<10) {
				p.x[p.length]=i2;
				p.y[p.length]=j2;
				p.length++;
			}
			//2
			i2=i+1;
			j2=j+1;
			if ((data[i2][j2]==0||data[i2][j2]>200)&&i2>=0&&i2<9&&j2>=0&&j2<10) {
				//?????????????›¥????
				p.x[p.length]=i2;
				p.y[p.length]=j2;
				p.length++;
			}
			//3
			i2=i-1;
			j2=j+1;
			if ((data[i2][j2]==0||data[i2][j2]>200)&&i2>=0&&i2<9&&j2>=0&&j2<10) {
				//?????????????›¥????
				p.x[p.length]=i2;
				p.y[p.length]=j2;
				p.length++;
			}
			//4
			i2=i-1;
			j2=j-1;
			if ((data[i2][j2]==0||data[i2][j2]>200)&&i2>=0&&i2<9&&j2>=0&&j2<10) {
				//?????????????›¥????
				p.x[p.length]=i2;
				p.y[p.length]=j2;
				p.length++;
			}
			
		}
		return p;
	}
	
	point jiang(int x1,int y1){//????????????¦¶???????????????????¦¶
		int i=x1;
		int j=y1;
		int i2;
		int j2;
		point p=new point();
		int data[][]=ClientService.getClientService().getGameData();
		//1
		i2=i;
		j2=j-1;
		if ((data[i2][j2]==0||data[i2][j2]>200)&&i2>=3&&i2<=5&&j2>=0&j2<=2) {
			//??›¥?????????
			p.x[p.length]=i2;
			p.y[p.length]=j2;
			p.length++;
		}
		//2
		i2=i;
		j2=j+1;
		if ((data[i2][j2]==0||data[i2][j2]>200)&&i2>=3&&i2<=5&&j2>=0&j2<=2) {
			//??›¥?????????
			p.x[p.length]=i2;
			p.y[p.length]=j2;
			p.length++;
		}
		//3
		i2=i-1;
		j2=j;
		if ((data[i2][j2]==0||data[i2][j2]>200)&&i2>=3&&i2<=5&&j2>=0&j2<=2) {
			//??›¥?????????
			p.x[p.length]=i2;
			p.y[p.length]=j2;
			p.length++;
		}
		//4
		i2=i+1;
		j2=j;
		if ((data[i2][j2]==0||data[i2][j2]>200)&&i2>=3&&i2<=5&&j2>=0&j2<=2) {
			//??›¥?????????
			p.x[p.length]=i2;
			p.y[p.length]=j2;
			p.length++;
		}
		return p;
	}
	
	point shuai(int x1,int y1){//???????????¦¶??????????????????¦¶
		int i=x1;
		int j=y1;
		int i2;
		int j2;
		point p=new point();
		
		int data[][]=ClientService.getClientService().getGameData();
		//1
		i2=i;
		j2=j-1;
		if ((data[i2][j2]==0||data[i2][j2]<200)&&i2>=3&&i2<=5&&j2>=7&j2<=9) {
			//??›¥?????????
			p.x[p.length]=i2;
			p.y[p.length]=j2;
			p.length++;
		}
		//2
		i2=i;
		j2=j+1;
		if ((data[i2][j2]==0||data[i2][j2]<200)&&i2>=3&&i2<=5&&j2>=7&j2<=9) {
			//??›¥?????????
			p.x[p.length]=i2;
			p.y[p.length]=j2;
			p.length++;
		}
		//3
		i2=i-1;
		j2=j;
		if ((data[i2][j2]==0||data[i2][j2]<200)&&i2>=3&&i2<=5&&j2>=7&j2<=9) {
			//??›¥?????????
			p.x[p.length]=i2;
			p.y[p.length]=j2;
			p.length++;
		}
		//4
		i2=i+1;
		j2=j;
		if ((data[i2][j2]==0||data[i2][j2]<200)&&i2>=3&&i2<=5&&j2>=7&j2<=9) {
			//??›¥?????????
			p.x[p.length]=i2;
			p.y[p.length]=j2;
			p.length++;
		}
		return p;
	}
	boolean isAttacked(int i,int j,int type){//????????§Ø????¦Ë?????????
		
		int data[][]=ClientService.getClientService().getGameData();
		getchess_X_Y();//??????????????????¦Ë??
		if (type==0) {//???
			//?§Ø?????? ???????????¦Ë??
			
			for(int a=0;a<5;a++){
				point point=bing(x_bing[a], y_bing[a]);
				for(int b=0;b<point.length;b++){
					if (point.x[b]==i&&point.y[b]==j) {
						return true;
					}
				}
				
			}
			//?§Ø?????? ??????????¦¶?? 
			for(int a=0;a<2;a++){
				point point=pao(x_pao[a], y_pao[a]);
				for(int b=0;b<point.length;b++){
					if (point.x[b]==i&&point.y[b]==j) {
						return true;
					}
				}
				
			}
			//?§Ø?????? ??????????¦¶??
			for(int a=0;a<2;a++){
				point point=ju(x_ju[a], y_ju[a]);
				for(int b=0;b<point.length;b++){
					if (point.x[b]==i&&point.y[b]==j) {
						return true;
					}
				}
				
			}
			//?§Ø?????? ??????????¦¶??
			for(int a=0;a<2;a++){
				point point=ma(x_ma[a], y_ma[a]);
				for(int b=0;b<point.length;b++){
					if (point.x[b]==i&&point.y[b]==j) {
						return true;
					}
				}
				
			}
			//?§Ø?????? ??????????¦¶??
			for(int a=0;a<2;a++){
				point point=xiang(x_xiang[a], y_xiang[a]);
				for(int b=0;b<point.length;b++){
					if (point.x[b]==i&&point.y[b]==j) {
						return true;
					}
				}
				
			}
			//?§Ø?????? ??????????¦¶??
			for(int a=0;a<2;a++){
				point point=shi(x_shi[a], y_shi[a]);
				for(int b=0;b<point.length;b++){
					if (point.x[b]==i&&point.y[b]==j) {
						return true;
					}
				}
				
			}
			//?§Ø?????? ??????????¦¶??
			point point=shuai(x_shuai, y_shuai);
			for(int b=0;b<point.length;b++){
				if (point.x[b]==i&&point.y[b]==j) {
					return true;
				}
			}
		}else{//??
			//?§Ø?????? ???????????¦Ë??
			for(int a=0;a<5;a++){
				point point=bing(x_zu[a], y_zu[a]);
				for(int b=0;b<point.length;b++){
					if (point.x[b]==i&&point.y[b]==j) {
						return true;
					}
				}
				
			}
			//?§Ø?????? ???????????¦¶??
			for(int a=0;a<2;a++){
				point point=pao(x_pao[a+2], y_pao[a+2]);
				for(int b=0;b<point.length;b++){
					if (point.x[b]==i&&point.y[b]==j) {
						return true;
					}
				}
				
			}
			//?§Ø?????? ???????????¦¶??
			for(int a=0;a<2;a++){
				point point=ju(x_ju[a+2], y_ju[a+2]);
				for(int b=0;b<point.length;b++){
					if (point.x[b]==i&&point.y[b]==j) {
						return true;
					}
				}
				
			}
			//?§Ø?????? ???????????¦¶??
			for(int a=0;a<2;a++){
				point point=ma(x_ma[a+2], y_ma[a+2]);
				for(int b=0;b<point.length;b++){
					if (point.x[b]==i&&point.y[b]==j) {
						return true;
					}
				}
				
			}
			//?§Ø?????? ???????????¦¶??
			for(int a=0;a<2;a++){
				point point=xiang(x_xiang[a+2], y_xiang[a+2]);
				for(int b=0;b<point.length;b++){
					if (point.x[b]==i&&point.y[b]==j) {
						return true;
					}
				}
				
			}
			//?§Ø?????? ???????????¦¶??
			for(int a=0;a<2;a++){
				point point=shi(x_shi[a+2], y_shi[a+2]);
				for(int b=0;b<point.length;b++){
					if (point.x[b]==i&&point.y[b]==j) {
						return true;
					}
				}
				
			}
			//?§Ø?????? ????????????¦¶??
			point point=jiang(x_jiang, y_jiang);
			for(int b=0;b<point.length;b++){
				if (point.x[b]==i&&point.y[b]==j) {
					return true;
				}
			}
		}
		return false;
	}
	boolean isProtected(int i,int j,int type){//type???????????????
		
		int data[][]=ClientService.getClientService().getGameData();
		getchess_X_Y();//??????????????????¦Ë??
		if (type==1) {//??
			//?§Ø?????? ???????????¦Ë??
			
			for(int a=0;a<5;a++){
				point point=bing(x_bing[a], y_bing[a]);
				for(int b=0;b<point.length;b++){
					if (point.x[b]==i&&point.y[b]==j) {
						return true;
					}
				}
				
			}
			//?§Ø?????? ??????????¦¶?? 
			for(int a=0;a<2;a++){
				point point=pao(x_pao[a], y_pao[a]);
				for(int b=0;b<point.length;b++){
					if (point.x[b]==i&&point.y[b]==j) {
						return true;
					}
				}
				
			}
			//?§Ø?????? ??????????¦¶??
			for(int a=0;a<2;a++){
				point point=ju(x_ju[a], y_ju[a]);
				for(int b=0;b<point.length;b++){
					if (point.x[b]==i&&point.y[b]==j) {
						return true;
					}
				}
				
			}
			//?§Ø?????? ??????????¦¶??
			for(int a=0;a<2;a++){
				point point=ma(x_ma[a], y_ma[a]);
				for(int b=0;b<point.length;b++){
					if (point.x[b]==i&&point.y[b]==j) {
						return true;
					}
				}
				
			}
			//?§Ø?????? ??????????¦¶??
			for(int a=0;a<2;a++){
				point point=xiang(x_xiang[a], y_xiang[a]);
				for(int b=0;b<point.length;b++){
					if (point.x[b]==i&&point.y[b]==j) {
						return true;
					}
				}
				
			}
			//?§Ø?????? ??????????¦¶??
			for(int a=0;a<2;a++){
				point point=shi(x_shi[a], y_shi[a]);
				for(int b=0;b<point.length;b++){
					if (point.x[b]==i&&point.y[b]==j) {
						return true;
					}
				}
				
			}
			//?§Ø?????? ??????????¦¶??
			point point=shuai(x_shuai, y_shuai);
			for(int b=0;b<point.length;b++){
				if (point.x[b]==i&&point.y[b]==j) {
					return true;
				}
			}
		}else{//???
			//?§Ø?????? ???????????¦Ë??
			for(int a=0;a<5;a++){
				point point=bing(x_zu[a], y_zu[a]);
				for(int b=0;b<point.length;b++){
					if (point.x[b]==i&&point.y[b]==j) {
						return true;
					}
				}
				
			}
			//?§Ø?????? ???????????¦¶??
			for(int a=0;a<2;a++){
				point point=pao(x_pao[a+2], y_pao[a+2]);
				for(int b=0;b<point.length;b++){
					if (point.x[b]==i&&point.y[b]==j) {
						return true;
					}
				}
				
			}
			//?§Ø?????? ???????????¦¶??
			for(int a=0;a<2;a++){
				point point=ju(x_ju[a+2], y_ju[a+2]);
				for(int b=0;b<point.length;b++){
					if (point.x[b]==i&&point.y[b]==j) {
						return true;
					}
				}
				
			}
			//?§Ø?????? ???????????¦¶??
			for(int a=0;a<2;a++){
				point point=ma(x_ma[a+2], y_ma[a+2]);
				for(int b=0;b<point.length;b++){
					if (point.x[b]==i&&point.y[b]==j) {
						return true;
					}
				}
				
			}
			//?§Ø?????? ???????????¦¶??
			for(int a=0;a<2;a++){
				point point=xiang(x_xiang[a+2], y_xiang[a+2]);
				for(int b=0;b<point.length;b++){
					if (point.x[b]==i&&point.y[b]==j) {
						return true;
					}
				}
				
			}
			//?§Ø?????? ???????????¦¶??
			for(int a=0;a<2;a++){
				point point=shi(x_shi[a+2], y_shi[a+2]);
				for(int b=0;b<point.length;b++){
					if (point.x[b]==i&&point.y[b]==j) {
						return true;
					}
				}
				
			}
			//?§Ø?????? ????????????¦¶??
			point point=jiang(x_jiang, y_jiang);
			for(int b=0;b<point.length;b++){
				if (point.x[b]==i&&point.y[b]==j) {
					return true;
				}
			}
		}
		return false;
	}
	
	void xiaqi(){
		getchess_X_Y();
		int type=0;
		int max_x;
		int max_y;
		int xx;
		int yy;
		int x=-1;
		int y=-1;
		int value=0;//??????
		int chessvalue=0;//?§Ù????????
		//??
		for(int a=0;a<5;a++){
			point point=zu(x_zu[a], y_zu[a]);
			for(int b=0;b<point.length;b++){
				x=point.x[b];
				y=point.y[b];
				if(isAttacked(x, y, 0)&&!isProtected(x, y, 0))
					continue;
				if (data[x][y]>value) {
					max_x=x;
					max_y=y;
					xx=x_zu[a];
					yy=y_zu[a];
				}
			}
		}
		
		//??
		for(int a=0;a<2;a++){
			point point=pao(x_pao[a], y_pao[a]);
			for(int b=0;b<point.length;b++){
				x=point.x[b];
				y=point.y[b];
				if(isAttacked(x, y, 0)&&!isProtected(x, y, 0))
					continue;
				if (data[x][y]>value) {
					max_x=x;
					max_y=y;
					xx=x_pao[a];
					yy=y_pao[a];
				}
			}
		}
		//?
		for(int a=0;a<2;a++){
			point point=zu(x_ju[a], y_ju[a]);
			for(int b=0;b<point.length;b++){
				x=point.x[b];
				y=point.y[b];
				if(isAttacked(x, y, 0)&&!isProtected(x, y, 0))
					continue;
				if (data[x][y]>value) {
					max_x=x;
					max_y=y;
					xx=x_ju[a];
					yy=y_ju[a];
				}
			}
		}
		//??
		for(int a=0;a<2;a++){
			point point=zu(x_ma[a], y_ma[a]);
			for(int b=0;b<point.length;b++){
				x=point.x[b];
				y=point.y[b];
				if(isAttacked(x, y, 0)&&!isProtected(x, y, 0))
					continue;
				if (data[x][y]>value) {
					max_x=x;
					max_y=y;
					xx=x_ma[a];
					yy=y_ma[a];
				}
			}
		}
		//??
		for(int a=0;a<2;a++){
			point point=zu(x_xiang[a], y_xiang[a]);
			for(int b=0;b<point.length;b++){
				x=point.x[b];
				y=point.y[b];
				if(isAttacked(x, y, 0)&&!isProtected(x, y, 0))
					continue;
				if (data[x][y]>value) {
					max_x=x;
					max_y=y;
					xx=x_xiang[a];
					yy=y_xiang[a];
				}
			}
		}
		//??
		for(int a=0;a<2;a++){
			point point=zu(x_shi[a], y_shi[a]);
			for(int b=0;b<point.length;b++){
				x=point.x[b];
				y=point.y[b];
				if(isAttacked(x, y, 0)&&!isProtected(x, y, 0))
					continue;
				if (data[x][y]>value) {
					max_x=x;
					max_y=y;
					xx=x_shi[a];
					yy=y_shi[a];
				}
			}
		}
		//??
			point point=jiang(x_jiang, y_jiang);
			for(int b=0;b<point.length;b++){
				x=point.x[b];
				y=point.y[b];
				if(isAttacked(x, y, 0)&&!isProtected(x, y, 0))
					continue;
				if (data[x][y]>value) {
					max_x=x;
					max_y=y;
					xx=x_jiang;
					yy=y_jiang;
				}
			}
		if (value==0) {//??????????
			
		}else{//????????
			
		}
	}
}
