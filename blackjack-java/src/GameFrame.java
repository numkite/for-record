package Happy;

import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameFrame extends JFrame {
	/* 경고 떠서 자동으로 해결 */
	private static final long serialVersionUID = 1L;

	private static JButton hitButton;
	private static JButton standButton;
	private static JLabel playerLabel;

	private static JLabel dealerLabel;
	private static JLabel playerSumLabel;
	private JFrame gameFrame;

	CardDeck cd = new CardDeck();
	CardPlayer player = new HumanPlayer(20);
	CardPlayer dealer = new ComputerPlayer(20);
	boolean player_wants_card = true;
	boolean dealer_wants_card = false;
	private static int playerSum;
	private static int dealerSum;
	private static int initialChips;
	private static int amount;
	static Card[] player_cards = new Card[11]; // 1,1,1,1,2,2,2,2,3,3,3 총 11장이면 21 만들 수 있음
	Card[] dealer_cards;

	/* 생성자 */
	public GameFrame(int betAmount) {
		amount = betAmount;
		setInitialChips(LoginFrame.iris.getChips());
		playerSum = 0;
		dealerSum = 0;
		showGameFrame();
		dealer_cards = null;
		player_cards = new Card[11];
	}

	public void showGameFrame() {
		gameFrame = new JFrame("BLACKJACK");
		gameFrame.setSize(400, 450);
		gameFrame.setLayout(null);
		gameFrame.setLocationRelativeTo(null);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		gameFrame.setResizable(false);

		/* 딜러 카드 */
		dealer.receiveCard(cd.newCard());
		dealer.receiveCard(cd.newCard());

		Card[] dealer_cards = dealer.showCards();

		Random random = new Random();
		int ran = random.nextInt(2);
		dealerLabel = new JLabel(
				"<html>&nbsp;&nbsp;&nbsp;딜러:<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;My card is:&nbsp;&nbsp;****:** <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;My card is:&nbsp;&nbsp;<html>"
						+ dealer_cards[ran].getSuit() + ":" + dealer_cards[ran].getCountAsString());

		dealerLabel.setBounds(5, 10, 400, 50);
		gameFrame.add(dealerLabel);

		/* 플레이어 카드 */
		for (int i = 0; i < 2; i++) {
			Card newCard = cd.newCard();
			player.receiveCard(newCard);
			player_cards[i] = newCard;
			playerSum += newCard.getCount();
		}

		playerLabel = new JLabel(
				"<html>&nbsp;&nbsp;&nbsp;플레이어:<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Your card is:&nbsp;&nbsp; "
						+ player_cards[0].getSuit() + ": " + player_cards[0].getCountAsString()
						+ "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Your card is:&nbsp;&nbsp; "
						+ player_cards[1].getSuit() + ": " + player_cards[1].getCountAsString());

		playerLabel.setBounds(5, 30, 400, 300);
		gameFrame.add(playerLabel);

		/* 딜러 카드 합 계산하기 */
		for (int i = 0; i < dealer_cards.length; i++) {
			dealerSum += dealer_cards[i].getCount();
		}

		/* 딜러의 카드 합이 17보다 작으면 새 카드를 딜러의 손에 추가 */
		while (dealerSum < 17) {
			Card c;
			c = cd.newCard();
			dealer.receiveCard(c);
			dealerSum += c.getCount();
		}

		/* 플레이어 카드 합 보여주기 */
		playerSumLabel = new JLabel("The sum of your cards is: " + playerSum);
		playerSumLabel.setBounds(10, 300, 200, 20);
		gameFrame.add(playerSumLabel);

		/* HIT 버튼 */
		hitButton = new JButton("HIT");
		GameButton hit = new GameButton(this);

		hitButton.addActionListener(hit);

		hitButton.setBounds(100, 350, 80, 30);
		gameFrame.add(hitButton);

		/* STAND 버튼*/
		standButton = new JButton("STAND");
		GameButton stand = new GameButton(this);

		standButton.addActionListener(stand);
		standButton.setBounds(200, 350, 80, 30);
		gameFrame.add(standButton);

		gameFrame.setVisible(true);
	}

	public static JLabel getPlayerSumLabel() {
		return playerSumLabel;
	}

	public static JLabel getPlayerLabel() {
		return playerLabel;
	}

	public static int getAmount() {
		return amount;
	}

	public static int getPlayerSum() {
		return playerSum;
	}

	public static int getDealerSum() {
		return dealerSum;
	}

	public static void setPlayerSum(int playerSum2) {
		playerSum = playerSum2;
	}

	public static int getInitialChips() {
		return initialChips;
	}

	public static void setInitialChips(int initialChip) {
		initialChips = initialChip;
	}

	public static void updatePlayerLabel(String string) {
		playerLabel.setText(string);
	}

	public JButton getButtonHit() {
		return hitButton;
	}

	public JButton getButtonStand() {
		return standButton;
	}

	public void dispose() {
		gameFrame.dispose();
	}

}