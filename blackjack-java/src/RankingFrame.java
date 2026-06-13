package Happy;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class RankingFrame {
	private static JLabel startTitle;
	private static JLabel line;
	private static JLabel line2;
	private static JButton closeButton;

	/* 생성자 */
	public RankingFrame() {
		showRankingFrame();
	}

	/* 파일 경로 로그인에서 생성한 파일이랑 이어주기 */
	public static final String FILE = LoginFrame.FILE_PATH;

	public void showRankingFrame() {
		User[] sortedUsers = listUsersByChipsDescending();

		JFrame rf = new JFrame("RANKING");
		rf.setSize(540, 500);
		rf.setLayout(null);
		rf.setLocationRelativeTo(null); // 프레임을 중앙에 배치합니다.
		rf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 프레임 닫기
		rf.setResizable(false);

		startTitle = new JLabel("TOP 5");
		startTitle.setBounds(170, 10, 200, 100); // 600, 350 300
		Font sTfont = new Font("Arial", Font.BOLD, 60);
		startTitle.setFont(sTfont);
		rf.add(startTitle);

		line = new JLabel("------------------------");
		line.setBounds(20, 30, 540, 150); // 600, 350 300
		Font sTfont2 = new Font("Arial", Font.BOLD, 60);
		line.setFont(sTfont2);
		rf.add(line);

		line2 = new JLabel("------------------------");
		line2.setBounds(20, 300, 540, 150); // 600, 350 300
		Font sTfont3 = new Font("Arial", Font.BOLD, 60);
		line2.setFont(sTfont3);
		rf.add(line2);

		/* 플레이어의 점수 출력 */
		for (int i = 0; i < Math.min(5, sortedUsers.length); i++) { // 등록된 이용자가 5명보다 적을 경우를 대비한 예외처리
			User user = sortedUsers[i];

			JLabel label = new JLabel((i + 1) + "    " + user.getId() + " - " + user.getChips());
			Font font = new Font("Arial", Font.PLAIN, 30);
			label.setFont(font);
			label.setBounds(50, 40 * i + 150, 10000000, 30);
			rf.add(label);
		}

		/* CLOSE 버튼 */
		closeButton = new JButton("CLOSE");
		closeButton.setBounds(205, 400, 130, 40);

		rf.getRootPane().setDefaultButton(closeButton);
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rf.dispose();
			}
		});
		rf.add(closeButton);

		rf.setVisible(true);

	}

	/* 파일의 칩 수를 내림차순으로 나열하는 메소드 */
	public static User[] listUsersByChipsDescending() {
		User[] users = readUserDataFromFile();
		Arrays.sort(users, Comparator.comparingInt(User::getChips).reversed());

		return users;
	}

	/* 파일에서 사용자 정보를 읽어와 User 객체 배열로 반환하는 메서드 */
	private static User[] readUserDataFromFile() {
		User[] users = new User[0];

		try (BufferedReader br = new BufferedReader(new FileReader(FILE))) { // 파일 읽어와서
			String line;
			while ((line = br.readLine()) != null) { // 한 문장씩 line에 읽어오고
				String[] userData = line.split(" "); // 아이디 비밀번호 칩의 개수 userData 배열에 각각 배정
				if (userData.length >= 3) {
					String id = userData[0];
					String password = userData[1];
					int chips = Integer.parseInt(userData[2]);
					users = Arrays.copyOf(users, users.length + 1); // User 배열 크기를 확장하고 새로운 User 객체 추가
					users[users.length - 1] = new User(id, password, chips);
				}
			}
		} catch (IOException e) { // 파일이 존재하지 않거나 손상되는 등의 문제가 발생할 경우를 위한 예외처리
			e.printStackTrace();
		}
		return users;
	}
}