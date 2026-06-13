package Happy;

public class HumanPlayer extends CardPlayer { // CardPlayer의 자식 클래스
	private boolean wantsCard;

	/* 생성자 */
	public HumanPlayer(int max_cards) {
		super(max_cards);
	}

	/* 플레이어가 카드를 원하는지 여부를 물어봄 */
	public boolean wantsACard() {
		return wantsCard;
	}

	/* 플레이어가 카드를 원하는지 여부를 설정하는 메서드 */
	public void setWantsCard(boolean wantsCard) {
		this.wantsCard = wantsCard;
	}
}