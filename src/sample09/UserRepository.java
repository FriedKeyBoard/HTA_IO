package sample09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

	// users.txt파일에 기록된 사용자 정보가 저장되는 객체
	private List<User> users = new ArrayList<>();
	
	public UserRepository() {
		try {
			String path = "src/sample09/users.txt";
			BufferedReader br = new BufferedReader(new FileReader(path));
			String text = null;
			while((text = br.readLine()) != null) {
				if(text.isBlank()) {
					break;
				}
				
				User user = User.createUser(text);
				users.add(user);
			}
			br.close();
		}catch(IOException ex) {
			throw new RuntimeException("users.txt 파일 읽기 오류", ex);
		}
	
	}
	
	/*
	 * 아이디를 전달받아서 아이디에 해당하는 사용자정보를 반환한다.
	 * 	반환타입 : User
	 * 	메소드이름 : getUserById
	 * 	매개변수 : String id
	 */
	
	public User getUserById(String id) {
		for(User user : users) {
			if(user.getId().equals(id)) {
				return user;
			}
		}
		return null;
	}
}
