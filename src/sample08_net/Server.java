package sample08_net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException{
		
		// 클라이언트의 연결요청을 청취하는 ServerSocket객체를 생성함
		// ServerSocket객체 생성시 자신이 사용할 포트번호를 지정함.
		ServerSocket serverSocket = new ServerSocket(3000);
		
		// ServerSocket의 accpet() 메소드는 클라이언트의 연결요청을 기다린다.
		// 클라이언트의 요청이 점수되면 accpet()메소드가 실행되고, 해당 클라이언트와
		// 통신을 담당하는 Socket객체를 생성해서 반환한다.
		Socket socket = serverSocket.accept();
		
		// Socket객체의 getInputStream(), getOutputStream() 메소드를 실행해서
		// 이 Socket객체와 연결된 클라이언트의 Socket객체와 데이터를 송수신할 수 있는(읽고 쓸수 있는) 스트림을 획득한다.
		// 획득한 스트림을 텍스트 전송에 편리한 BufferedReader와 PrintWriter를 연결한다.
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		
		// BufferedReader의 readLine()메소드는 클라이언트가 보내는 메세지가 수신될 때까지 대기한다.
		// 클아이언트가 보내는 메세지가 수신되면 메세지를 읽어서 반환한다.
		String text = in.readLine();
		System.out.println("클라이언트가 보낸 메세지 -> " + text);
		
		// PrintWriter의 println()메소드를 사용해서 클라이언트에게 메세지를 송신한다.
		out.println("메세지를 정상적으로 수신하였습니다.");
		
		
		serverSocket.close();
	}
}
