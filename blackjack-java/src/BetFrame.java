package Happy;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BetFrame {
	private static JLabel Label1;
	private static JLabel betLabel;
	public static JTextField betAmountField;
	private static JButton betButton;
	private static int currentChips; // 현재 칩의 개수
	private static boolean possible = false; // 배팅 성공 여부
	public static int chips;
	public static LoginFrame info;
	public static GameFrame a;
	public static JFrame betFrame;
	public static MenuFrame menuFrame; // = new MenuFrame();

	/* 생성자 */
	public BetFrame() {
		currentChips = LoginFrame.iris.getChips();
		if (currentChips == 0) { // 칩 개수가 0개가 되면 탈퇴됨을 안내하고 퇴출, 새 게임창 뜨게 함
			JOptionPane.showMessageDialog(null, "Since you do not have a chip, you will be automatically cancelled.");
			MenuFrame menuFrame = new MenuFrame();
			menuFrame.gameMenu();
		} else {
			showBetFrame();
		}
	}

	public void showBetFrame() {
		betFrame = new JFrame("Bet");
		betFrame.setSize(470, 250);
		betFrame.setLayout(null);
		betFrame.setLocationRelativeTo(null);
		betFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		betFrame.setResizable(false);

		Label1 = new JLabel("Your current chip count: " + currentChips);
		Label1.setBounds(110, 10, 250, 30);
		Font font1 = new Font("Arial", Font.PLAIN, 20);
		Label1.setFont(font1);
		betFrame.add(Label1);

		betLabel = new JLabel("Enter your bet:");
		betLabel.setBounds(170, 60, 100, 30);
		Font betFont = new Font("Arial", Font.PLAIN, 15);
		betLabel.setFont(betFont);
		betFrame.add(betLabel);

		betAmountField = new JTextField();
		betAmountField.setBounds(120, 110, 200, 30);
		betFrame.add(betAmountField);

		BetButton han = new BetButton(this); // 리스너클래스 생성

		/* Bet 버튼*/
		betButton = new JButton("Bet");
		betButton.setBounds(170, 160, 100, 30);
		betFrame.getRootPane().setDefaultButton(betButton);

		betButton.addActionListener(han);
		betFrame.add(betButton);

		betFrame.setVisible(true);
	}

	/* 배팅 가능한 금액이 들어오면 True 반환 */
	public static boolean betSuccess(int amount) {
		if (currentChips >= amount && amount > 0)
			possible = true;
		return possible;
	}

	/* 현재 칩의 개수를 반환 */
	public int getCurrentChips() {
		return currentChips;
	}

	/* 칩 개수를 새로 설정 */
	public void setCurrentChips(int currentChip) {
		currentChips = currentChip;
	}

	public void dispose() {
		betFrame.dispose();
	}

	public JFrame getBetFrame() {
		return betFrame;
	}
}