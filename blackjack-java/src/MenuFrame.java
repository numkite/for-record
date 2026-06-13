package Happy;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuFrame {
	private static JLabel startTitle;
	private static JLabel welcome;
	private static JLabel noti;
	private static JButton signup;
	private static JButton login;
	private static JButton button;
	private static JButton rankButton;
	JFrame startFrame;

	/* 기본 생성자 */
	public MenuFrame() {
	}

	// 첫 프레임
	public void gameMenu() {
		startFrame = new JFrame("BLACKJACK");
		startFrame.setSize(600, 350);
		startFrame.setLayout(null);
		startFrame.setLocationRelativeTo(null);
		startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startFrame.setResizable(false);

		startTitle = new JLabel("BLACKJACK");
		startTitle.setBounds(105, 20, 390, 100);
		Font sTfont = new Font("Arial", Font.BOLD, 60);
		startTitle.setFont(sTfont);
		startFrame.add(startTitle);

		welcome = new JLabel("Welcome to Casino!");
		welcome.setBounds(140, 60, 390, 100); // 600, 350 300
		Font welfont = new Font("Arial", Font.BOLD, 30);
		welcome.setFont(welfont);
		startFrame.add(welcome);

		noti = new JLabel("If this is your first visit, please SIGN UP first.");
		noti.setBounds(170, 240, 390, 100);
		startFrame.add(noti);

		/* SIGN UP 버튼 */
		signup = new JButton("SIGN UP");
		signup.setBounds(130, 240, 100, 30);

		MenuButton sign = new MenuButton(this);

		signup.addActionListener(sign);

		startFrame.add(signup);

		/* login 버튼 */
		login = new JButton("ENTER THE CASINO");
		login.setBounds(130, 190, 320, 40);

		MenuButton log = new MenuButton(this);

		login.addActionListener(log);
		startFrame.add(login);

		/* RULES 버튼*/
		button = new JButton("RULES");
		button.setBounds(240, 240, 100, 30);
		startFrame.add(button);

		MenuButton rules = new MenuButton(this);

		button.addActionListener(rules);

		/* RANKING 버튼 */
		rankButton = new JButton("RANKING");
		rankButton.setBounds(350, 240, 100, 30);

		MenuButton ranking = new MenuButton(this);

		rankButton.addActionListener(ranking);
		startFrame.add(rankButton);

		startFrame.setVisible(true);
	}

	public JButton getButtonSignup() {
		return signup;
	}

	public JButton getButtonLogin() {
		return login;
	}

	public JButton getButtonRules() {
		return button;
	}

	public JButton getButtonRanking() {
		return rankButton;
	}

	public void dispose() {
		startFrame.dispose();
	}
}