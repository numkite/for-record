package Happy;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame {
	// 경고 떠서 자동으로 해결
	private static final long serialVersionUID = 1L;
	public static final String FILE_PATH = "user_data.txt"; // 아이디 기록하는 파일
	public static User iris;
	public static JFrame f;
	public static JPasswordField inputPW2;
	public static JTextField inputID2;
	public static JCheckBox showPW2;
	public static JButton button;
	public static JButton button2;
	public static JLabel startTitle3;
	public static JLabel outputID2;
	public static JLabel outputPW2;

	public LoginFrame(String pencil) {
		showLoginFrame(pencil);
	}

	// 회원가입 또는 로그인 버튼을 눌렀을 떄 뜨는 창 설정
	public void showLoginFrame(String pencil) {
		f = new JFrame(pencil);
		f.setSize(600, 350);
		f.setLayout(null);
		f.setLocationRelativeTo(null); // 프레임을 중앙에 배치합니다.
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 프레임 닫기
		// f.setResizable(false);

		startTitle3 = new JLabel("BLACKJACK");
		startTitle3.setBounds(105, 10, 390, 100);
		Font sT3font = new Font("Arial", Font.BOLD, 60);
		startTitle3.setFont(sT3font);
		f.add(startTitle3);

		outputID2 = new JLabel(" ID ");
		outputID2.setBounds(80, 140, 70, 25);
		Font a2font = new Font("Arial", Font.PLAIN, 25);
		outputID2.setFont(a2font);
		f.add(outputID2);

		inputID2 = new JTextField();
		inputID2.setBounds(170, 140, 230, 30);
		f.add(inputID2);

		outputPW2 = new JLabel(" PW ");
		outputPW2.setBounds(80, 200, 70, 25);
		Font b2font = new Font("Arial", Font.PLAIN, 25);
		outputPW2.setFont(b2font);
		f.add(outputPW2);

		// 비밀번호 입력 받기 (***로 보이게 하고 싶어서 JPasswordField 시용했음
		inputPW2 = new JPasswordField();
		inputPW2.setBounds(170, 200, 230, 30);
		f.add(inputPW2);

		// 보기 체크박스 (비밀번호 표시/가리기)
		JCheckBox showPW2 = new JCheckBox("Show");
		showPW2.setBounds(350, 230, 70, 25);

		/* 체크박스 클릭 시 비밀번호 보이기/가리기 */
		showPW2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (showPW2.isSelected()) {
					inputPW2.setEchoChar((char) 0); // 0은 문자를 보여줌
				} else {
					inputPW2.setEchoChar('*');
				}
			}
		});
		f.add(showPW2);

		LoginButton han = new LoginButton(this);

		/* Sign up 버튼 */
		if (pencil.equals("Sign Up")) {
			button = new JButton("Sign up");
			button.setBounds(420, 140, 100, 90);
			f.getRootPane().setDefaultButton(button);
			button.addActionListener(han);
			f.add(button);
		}

		/* Login 버튼 */
		else if (pencil.equals("Log In")) {
			button2 = new JButton("Log In");
			button2.setBounds(420, 140, 100, 90);
			f.getRootPane().setDefaultButton(button2);
			button2.addActionListener(han);
			f.add(button2);
			/* GO BACK 라벨 */
			JLabel moreLabel = new JLabel("<html><u>GO BACK ☞</u></html>");
			moreLabel.setBounds(430, 260, 150, 30);
			moreLabel.setForeground(Color.BLUE); // 글씨 색상을 파란색으로 설정
			moreLabel.setFont(new Font("Arial", Font.BOLD, 16));

			moreLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					f.dispose();
					MenuFrame menuFrame = new MenuFrame();
					menuFrame.gameMenu();
				}
			});

			f.add(moreLabel);

		}

		f.setVisible(true);
	}

	public JButton getButton() {
		return button;
	}

	public JButton getButton2() {
		return button2;
	}

	public JTextField getInputID2() {
		return inputID2;
	}

	public JPasswordField getInputPW2() {
		return inputPW2;
	}

	public JFrame getLoginFrame() {
		return f;
	}

	public void dispose() {
		f.dispose();
	}

}