package Happy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JOptionPane;

public class LoginButton implements ActionListener {
	private static final int MIN = 4; // 비밀번호 최소 길이
	private static final int MAX = 20; // 비밀번호 최대 길이

	private LoginFrame f;

	public LoginButton(LoginFrame f) {
		this.f = f;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == f.getButton()) {

			String id = f.getInputID2().getText();

			char[] passwordChars = f.getInputPW2().getPassword();
			String password = new String(passwordChars);

			// 아이디와 비밀번호의 길이가 유효한지 확인
			if (isValidId(id) && isValidPassword(password)) {
				// 이미 파일에 아이디가 있을 때 이미 있는 아이디입니다. 라는 팝업이 뜨게 함
				if (isExistingId(id)) {
					JOptionPane.showMessageDialog(f.getLoginFrame(), "This ID already exists..");
				}

				else { // 파일에 없는 아이디일 때 회원가입이 완료되었습니다. 라는 팝업이 뜨게 함
					int initialChips = 10;
					saveUserData(id, password, initialChips);
					JOptionPane.showMessageDialog(f.getLoginFrame(), "Sign up is complete.");
					f.dispose();
				}

			} else { // 비밀번호의 길이가 유효하지 않을 때 에러 메시지를 띄움
				JOptionPane.showMessageDialog(f.getLoginFrame(),
						"The ID and Password must each be " + MIN + " to " + MAX + " digits long.");
			}

		}

		else {
			String id = f.getInputID2().getText();

			String password = new String(f.getInputPW2().getPassword());

			if (!doesFileExist()) {
				JOptionPane.showMessageDialog(f.getLoginFrame(), "Sign up first!");
				f.dispose();
				MenuFrame menuFrame = new MenuFrame();
				menuFrame.gameMenu();

			} else {
				// 파일에 있는 아이디랑 비밀번호가 일치한다면 로그인 성공! 이라는 팝업과 함계 게임 실행
				if (isExistingIdAndPassword(id, password)) {
					JOptionPane.showMessageDialog(f.getLoginFrame(), "LOG IN SUCCEED!");
					LoginFrame.iris = new User(id, password, getChipsForUser(id, password));
					f.dispose();
					new BetFrame();
				}

				// 파일에 아이디와 비밀번호가 없거나, 비밀번호가 틀렸을 경우 로그인 실패! 라는 팝업이 뜨게 함
				else {
					JOptionPane.showMessageDialog(f.getLoginFrame(), "LOG IN FAILED!");
				}
			}

		}

	}

	/* 아이디의 길이가 유효한지 확인하는 메서드 */
	private static boolean isValidId(String id) {
		int length = id.length();
		return length >= MIN && length <= MAX;
	}

	/* 비밀번호의 길이가 유효한지 확인하는 메서드 */
	private static boolean isValidPassword(String password) {
		int length = password.length();
		return length >= MIN && length <= MAX;
	}

	/* 아이디의 유무 확인하는 메소드 */
	private static boolean isExistingId(String id) {
		try {
			// 파일에서 모든 줄을 읽어와서 각 줄의 첫 단어가 입력한 아이디와 같은지 확인
			return Files.lines(Paths.get(LoginFrame.FILE_PATH)).anyMatch(line -> line.startsWith(id + " ")); // 요거 잘
																												// 모르겠음
		} catch (IOException e) { // 예외가 발생했을 때 예외를 e에 저장
			e.printStackTrace(); // 예외정보를 출력해라
			JOptionPane.showMessageDialog(null, "Loading");
		}
		return false;
	}

	/* 아이디가 없다면 파일에 아이디, 비밀번호, 칩의 개수를 추가하는 메소드 */
	private static void saveUserData(String id, String password, int chips) {
		try (FileWriter writer = new FileWriter(new File(LoginFrame.FILE_PATH), true)) {
			// 파일에 아이디, 비밀번호, 칩의 개수를 추가
			writer.write(id + " " + password + " " + chips + System.lineSeparator());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* 아이디와 비밀번호의 유무 확인 및 칩 개수를 반환하는 메소드 */
	private static int getChipsForUser(String id, String password) {
		try {
			// 파일에서 모든 줄을 읽어와서 각 줄의 아이디와 비밀번호가 입력한 것과 일치하는지 확인
			// 일치하는 경우 해당 행의 칩 개수를 반환
			return Files.lines(Paths.get(LoginFrame.FILE_PATH)).filter(line -> {
				String[] parts = line.split(" ");
				return parts.length == 3 && parts[0].equals(id) && parts[1].equals(password);
			}).map(line -> Integer.parseInt(line.split(" ")[2])).findFirst().orElse(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/* 파일이 존재하는지 여부를 확인하는 메서드 */
	private static boolean doesFileExist() {
		File file = new File(LoginFrame.FILE_PATH);
		return file.exists();
	}

	/* 아이디와 비밀번호의 유무를 확인하는 메소드 */
	private static boolean isExistingIdAndPassword(String id, String password) {
		try {
			// 파일에서 모든 줄을 읽어와서 각 줄의 아이디와 비밀번호가 입력한 것과 일치하는지 확인
			return Files.lines(Paths.get(LoginFrame.FILE_PATH)).anyMatch(line -> {
				String[] parts = line.split(" ");
				return parts.length == 3 && parts[0].equals(id) && parts[1].equals(password);
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}