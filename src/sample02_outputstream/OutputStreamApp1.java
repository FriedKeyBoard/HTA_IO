package sample02_outputstream;

import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStreamApp1 {
	
	public static void main(String[] args) throws IOException{
		FileOutputStream out = new FileOutputStream("src/sample02_outputstream/sample.txt");
		
//		out.write(65);		// A
//		out.write(66);		// B
//		out.write(67);		// C
//		out.write('a');
//		out.write('b');
//		out.write('c');
//		out.write('d');
//		out.write('가');
//		out.write('나');
//		out.write('다');
		String text = "안녕하세요. 반갑습니다.";
		byte[] bytes = text.getBytes();
		out.write(bytes);
		
		out.close();
	}
}
