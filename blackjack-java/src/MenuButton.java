package Happy;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class MenuButton implements ActionListener {
	private MenuFrame b;

	public MenuButton(MenuFrame b) {
		this.b = b;
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == b.getButtonSignup()) {
			new LoginFrame("Sign Up");

		} else if (e.getSource() == b.getButtonLogin()) {
			new LoginFrame("Log In");
			b.dispose();
		}

		else if (e.getSource() == b.getButtonRules()) {
			JFrame ruleFrame = new JFrame("RULES");
			ruleFrame.setSize(690, 560);
			ruleFrame.setLayout(null);
			ruleFrame.setLocationRelativeTo(null);
			ruleFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			ruleFrame.setResizable(false);

			JEditorPane label = new JEditorPane("text/html", "<html><body>"
					+ "<font face='Arial, sans-serif' size='5'>블랙잭: 딜러와 플레이어가 함께 카드의 숫자를 겨루는 것으로 2장 이상의 카드를 뽑아 그 합계를 21점에 가깝도록 만들어 승부하는 카드게임.</font><br><br>"
					+ "Rules<br>" + "1. 처음 회원가입한 모든 회원들에게 칩 10개를 부여한다.<br>"
					+ "2. 자신이 가지고 있는 칩 갯수 이내에서 1개 이상의 칩을 배팅한다.<br>"
					+ "3. 시작하고 딜러와 플레이어는 각각 2장의 카드를 받는다. 그 중 딜러의 카드는 한 장만 공개된다.<br>"
					+ "4. 플레이어는 카드의 합이 21에 도달하기 전까지 카드를 더 뽑을지 선택할 수 있다.<br>"
					+ "5. 플레이어의 카드 뽑기가 끝나면 딜러의 카드 뽑기가 시작된다. <br>" + "6. 딜러는 카드 합가 16을 넘을 때까지 카드를 뽑는다.<br>"
					+ "7. 플레이어와 플레이어의 카드 합을 비교해서 21에 가장 가까운 이가 승리한다.<br>"
					+ "8. 합이 21이 된다면 Blackjack으로 플레이어는 배팅한 칩 갯수의 2배를 얻는다.<br>"
					+ "   - 단, 플레이어와 딜러 모두  합이 21이라면 플레이어가 블랙잭으로 승리한다.<br>"
					+ "9. 21 미만이지만 딜러보다 카드 합이 높다면 배팅한 만큼의 칩을 얻는다.<br>" + "10. 카드의 합이 21을 넘는다면 배팅한 만큼 칩을 잃는다.<br>"
					+ "11. 플레이어와 딜러의 점수가 같다면 비긴 것으로 배팅한 칩은 무효가 된다.<br>" + "12. 칩의 개수가 다 떨어지면 자동 퇴출되어 아이디가 삭제된다.<br><br>"
					+ "카드 별 점수<br>" + "Spades, Hearts, Clubs, Diamonds<br>" + "Ace: 1<br>" + "2: 2<br>" + "3: 3<br>"
					+ "4: 4<br>" + "5: 5<br>" + "6: 6<br>" + "7: 7<br>" + "8: 8<br>" + "9: 9<br>" + "10: 10<br>"
					+ "Jack, Queen, King: 10" + "</body></html>");

			label.setEditable(false); // 편집 불가능으로 설정
			label.setBounds(0, 0, 660, 450);
			label.setBackground(new Color(238, 238, 238));
			label.setFocusable(false);
			ruleFrame.add(label);

			JScrollPane scrollPane = new JScrollPane(label, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(10, 10, 660, 450);
			scrollPane.setFocusable(false);
			ruleFrame.add(scrollPane);

			JButton closeButton = new JButton("CLOSE");
			closeButton.setBounds(270, 470, 130, 40);
			ruleFrame.getRootPane().setDefaultButton(closeButton);
			closeButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ruleFrame.dispose();
				}
			});
			ruleFrame.add(closeButton);

			ruleFrame.setVisible(true);
		}

		else if (e.getSource() == b.getButtonRanking()) {
			new RankingFrame();
		}
	}

}
