
package Happy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameButton implements ActionListener {
	private GameFrame gameFrame;

	CardDeck cd = new CardDeck();
	CardPlayer player = new HumanPlayer(20);
	CardPlayer dealer = new ComputerPlayer(20);
	boolean player_wants_card = true;
	boolean dealer_wants_card = false;
	private int place = 0;
	private String result;
	Card[] player_cards = GameFrame.player_cards; // 1,1,1,1,2,2,2,2,3,3,3 총 11장이면 21 만들 수 있음

	public GameButton(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == gameFrame.getButtonHit()) {
			forHitButton();
		}

		else if (e.getSource() == gameFrame.getButtonStand()) {
			standRes();
			gameFrame.dispose();
		}
	}

	public void forHitButton() {
		Card newCard = cd.newCard();
		player.receiveCard(newCard);
		player_cards[place + 2] = newCard;
		GameFrame.setPlayerSum(GameFrame.getPlayerSum() + newCard.getCount());

		place++;
		updatePlayerLabel();
		// 이 부분이 안 돼애애애ㅐ애ㅐㅐㅐ
		GameFrame.getPlayerSumLabel().setText("The sum of your cards is: " + GameFrame.getPlayerSum());

		if (GameFrame.getPlayerSum() >= 21) {
			hitRes();
			gameFrame.dispose();
		}
	}

	public ResultFrame hitRes() {

		if (GameFrame.getPlayerSum() == 21) {
			if (GameFrame.getDealerSum() > 21) {
				result = "Your Blackjack! You win! \n";
				betResult(2);
			} else if (GameFrame.getDealerSum() == 21) {
				result = "We draw. \n";
			} else if (GameFrame.getDealerSum() < 21) {
				result = "Your Blackjack! You win! \n";
				betResult(2);
			}

		} else if (GameFrame.getPlayerSum() > 21) {
			if (GameFrame.getDealerSum() > 21) {
				result = "We bust! We draw. \n";
			} else if (GameFrame.getDealerSum() == 21) {
				result = "My Blackjack! You lose... \n";
				betResult(0);
			} else if (GameFrame.getDealerSum() < 21) {
				result = "You bust! I win \n";
				betResult(0);
			}
		}

		return new ResultFrame(GameFrame.getDealerSum(), GameFrame.getPlayerSum(), result);
	}

	public ResultFrame standRes() {
		/* stand를 누를 수 있는 거 자체가 무조건 playerSum 은 21보다 작음 
		 * 
		 * 1. 한 번도 뽑지 않은 상황 즉, 처음 두 장을 받았을 때는 최대가 20이어서 
		 * 2. hit을 눌러서 playerSum 21보다 크거나 같아졌다면 hitRes() 에서 이미 걸러짐
		 * 
		 * */
		if (GameFrame.getDealerSum() > 21) {
			result = "I bust! You win \n";
			betResult(1);
		}

		if (GameFrame.getDealerSum() == 21) {
			result = "My Blackjack! You lose... \n";
			betResult(0);
		}

		if (GameFrame.getDealerSum() < 21) {
			if (GameFrame.getPlayerSum() == GameFrame.getDealerSum()) {
				result = "We draw. \n";
			} else if (GameFrame.getPlayerSum() > GameFrame.getDealerSum()) {
				result = "You win! I lose...\n";
				betResult(1);
			} else {
				result = "I win! You lose... \n";
				betResult(0);
			}
		}

		return new ResultFrame(GameFrame.getDealerSum(), GameFrame.getPlayerSum(), result);
	}

	/* 배팅 결과에 따라 칩 수를 변경하는 메소드 */
	public void betResult(int result) {
		if (result == 1) { // 플레이어가 이겼을 때
			GameFrame.setInitialChips(GameFrame.getInitialChips() + GameFrame.getAmount());
		} else if (result == 0) { // 플레이어가 졌을 떄
			GameFrame.setInitialChips(GameFrame.getInitialChips() - GameFrame.getAmount());
		} else if (result == 2) { // 플레이어의 블랙잭일 때
			GameFrame.setInitialChips(GameFrame.getInitialChips() + 2 * GameFrame.getAmount());
		} // 무승부일 때는 칩 수 변화 없음
		LoginFrame.iris.setChips(GameFrame.getInitialChips()); // 변경된 칩 파일에 저장
	}

	/* HIT 버튼으로 새 카드를 뽑았을 때 플레이어의 결과를 업데이트하는 메소드 */
//	private void updatePlayerLabel() {
//		StringBuilder playerLabelText = new StringBuilder("<html>&nbsp;&nbsp;&nbsp;플레이어:<br>");
//		for (int i = 0; i < player_cards.length; i++) {
//			if (player_cards[i] != null) {
//				playerLabelText.append(
//						"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Your card is:&nbsp;&nbsp; ")
//						.append(player_cards[i].getSuit()).append(": ").append(player_cards[i].getCountAsString())
//						.append("<br>");
//			}
//		}
//		playerLabelText.append("</html>");
//
//		GameFrame.updatePlayerLabel(playerLabelText.toString());
//	
	private void updatePlayerLabel() {
		StringBuilder playerLabelText = new StringBuilder("<html>&nbsp;&nbsp;&nbsp;플레이어:<br>");
		for (int i = 0; i < player_cards.length; i++) {
			if (player_cards[i] != null) {
				playerLabelText.append(
						"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Your card is:&nbsp;&nbsp; ")
						.append(player_cards[i].getSuit()).append(": ").append(player_cards[i].getCountAsString())
						.append("<br>");
			}
		}
		playerLabelText.append("</html>");

		// 기존의 playerLabel에 HTML 형식의 텍스트를 직접 설정
		GameFrame.getPlayerLabel().setText(playerLabelText.toString());

		GameFrame.getPlayerSumLabel().setText(playerLabelText.toString());
	}

}
