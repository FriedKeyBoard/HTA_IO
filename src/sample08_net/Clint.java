package sample08_net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Clint {

	public static void main(String[] args) throws IOException{
		
		System.out.println("클라이언트 프로그램이 시작됨...");
		
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		
		// 서버로 접속요청을 보내고, 접속된서버와 데이터 토잇ㄴ을 담당하는 Socket객체를 생성한다.
		// Socket객체에는 Server의 ip주소와 port 번호를 지정한다.
		Socket socket = new Socket("192.168.50.98", 3000);
		System.out.println("서버로 접속요청을 보냈음...");
		
		// Socket객체의 getInputStream(), getOutputStream() 메소드를 실행해서
		// 이 Socket객체와 연결된 서버의 Socket객체와 데이터를 송수신할 수 있는(읽고 쓸수 있는) 스트림을 획득한다.
		// 획득한 스트림을 텍스트 전송에 편리한 BufferedReader와 PrintWriter를 연결한다.
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		System.out.println("서버와 데이터를 주고받을 준비가 되었음...");
		
		System.out.println("내용을 입력하세요 : ");
		// 키보드와 연결된 스트림으로 입력값을 읽어온다.
		String text = keyboard.readLine();
		
		// PrintWriter의 println()메소드를 사용해서 서버에게 메세지를 송신한다.
		out.println(text);
		System.out.println("서버로 메세지를 전송함...");
		
		// BufferedReader의 readLine() 메소드는 서버가 보내는 메세지가 수신될 때까지 대기한다.
		// 서버가 보내는 메세지가 수신되면 메세지를 읽어서 반환한다.
		String receiveText = in.readLine();
		System.out.println("서버의 응답메세지 : " + receiveText);
		
		socket.close();
		System.out.println("클라이언트 프로그램이 종료됨");
	}
}
