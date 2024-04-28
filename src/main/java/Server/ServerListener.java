package Server;
import java.net.*;
import java.io.*;

public class ServerListener extends Thread {
	ServerSocket server;
	volatile boolean listenFlag;
	public ServerListener(ServerSocket s) {
		listenFlag=true;
		server=s;
	}
	
	public void stopListener(){
		listenFlag=false;
	}
	
	public void run() {

		while(listenFlag){
			try {
				Socket socket=server.accept();
				new SocketGame(socket).start();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}
