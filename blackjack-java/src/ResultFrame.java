package Happy;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/* 결과 프레임 */
public class ResultFrame extends JFrame {
	/* 경고 떠서 자동으로 해결됨 */
	private static final long serialVersionUID = 1L;

	private static JFrame rf;
	private static JLabel dealerSumLabel;
	private static JLabel playerSumLabel;
	private static JLabel resultLabel;
	private static JLabel moreLabel;
	private static JButton moreButton;
	private static JButton exitButton;
	private int dealerSum;
	private int playerSum;
	private String result;
	public User iris;

	/* 생성자 */
	public ResultFrame(int dealerSum, int playerSum, String result) {
		this.dealerSum = dealerSum;
		this.playerSum = playerSum;
		this.result = result;

		showResultFrame();
	}

	private void showResultFrame() {
		rf = new JFrame("Result");

		rf.setTitle("Game Result");
		rf.setSize(400, 300);
		rf.setLayout(null);
		rf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rf.setLocationRelativeTo(null);
		rf.setResizable(false);

		dealerSumLabel = new JLabel("Dealer's Sum: " + dealerSum);
		dealerSumLabel.setBounds(115, 40, 200, 30);
		Font font1 = new Font("Arial", Font.BOLD, 20);
		dealerSumLabel.setFont(font1);
		rf.add(dealerSumLabel);

		playerSumLabel = new JLabel("Player's Sum: " + playerSum);
		playerSumLabel.setBounds(115, 80, 200, 30);
		Font font2 = new Font("Arial", Font.BOLD, 20);
		playerSumLabel.setFont(font2);
		rf.add(playerSumLabel);

		resultLabel = new JLabel(result);
		resultLabel.setBounds(50, 130, 300, 30);
		Font font3 = new Font("Arial", Font.BOLD, 20);
		resultLabel.setFont(font3);
		rf.add(resultLabel);
		resultLabel.setHorizontalAlignment(JLabel.CENTER);

		moreLabel = new JLabel("Do you want some more?");
		moreLabel.setBounds(120, 160, 200, 30);
		rf.add(moreLabel);

		/* More 버튼 */
		moreButton = new JButton("More");
		moreButton.setBounds(80, 200, 80, 30);

		ResultButton more = new ResultButton(this);

		moreButton.addActionListener(more);
		rf.add(moreButton);

		/* Exit 버튼 */
		exitButton = new JButton("Exit");
		exitButton.setBounds(220, 200, 80, 30);

		ResultButton exit = new ResultButton(this);

		exitButton.addActionListener(exit); // "Exit" 버튼 클릭 시 나가지기);
		rf.add(exitButton);

		rf.setVisible(true);
	}

	public void dispose() {
		rf.dispose();
	}

	public JButton getButtonMore() {
		return moreButton;
	}

	public JButton getButtonExit() {
		return exitButton;
	}

	public void setUser(User iris) {
		this.iris = iris;
	}

}
