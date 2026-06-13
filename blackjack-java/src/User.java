package Happy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class User {
	private String id;
	private String password;
	private int chips; // 칩의 개수

	/* 생성자 */
	public User(String id, String password, int chips) {
		this.id = id;
		this.password = password;
		this.chips = chips;
	}

	/* 칩의 개수를 반환 */
	public int getChips() {
		return chips;
	}

	/* 아이디를 반환 */
	public String getId() {
		return id;
	}

	/* 비밀번호를 반환 */
	public String getPassword() {
		return password;
	}

	/* 새로운 칩의 개수 설정 */
	public void setChips(int a) {
		this.chips = a;
		updateChipsInFile();
	}

	/* 파일에 칩의 개수 업데이트하는 메소드*/
	private void updateChipsInFile() {
		try {
			// 파일을 읽어와서
			List<String> lines = Files.readAllLines(Paths.get(LoginFrame.FILE_PATH));
			for (int i = 0; i < lines.size(); i++) {
				String[] parts = lines.get(i).split(" "); // 아이디 비밀번호 칩의 개수 parts에 각각 배정
				// parts 길이가 3이고, 아이디랑 비밀번호가 일피하는 줄의 chip을 parts[2]대신 chips로 변경
				if (parts.length == 3 && parts[0].equals(id) && parts[1].equals(password)) {
					lines.set(i, id + " " + password + " " + chips);
					// 만약 칩의 개수가 0개가 되면 정보 전체를 삭제
					if (chips == 0) {
						lines.remove(i);
					}
					break;
				}
			}

			// 파일에 내용 추가 및 덮어쓰기
			Files.write(Paths.get(LoginFrame.FILE_PATH), lines, StandardOpenOption.WRITE,
					StandardOpenOption.TRUNCATE_EXISTING);
		} catch (IOException e) { // 파일이 존재하지 않거나 손상되는 등의 문제가 발생할 경우를 위한 예외처리
			System.err.println("Error updating chips in file: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
