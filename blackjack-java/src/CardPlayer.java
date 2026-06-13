package Happy;

/*  CardPlayerBehavior 인터페이스를 구현합니다. */
public abstract class CardPlayer implements CardPlayerBehavior {
	Card[] my_hand; // 플레이어의 카드
	int card_count; // 플레이어가 들고 있는 카드의 수

	/* 생성자, 플레이어가 가질 수 있는 최대 카드의 수 설정 */
	public CardPlayer(int max_cards) {
		my_hand = new Card[max_cards];
		card_count = 0;
	}

	/* 플레이어가 카드를 원하는지 여부를 물어봄 */
	public abstract boolean wantsACard(); // 나중에 구현될 추상메소드임

	/* 카드 c를 받아 플레이어의 손에 추가 */
	public void receiveCard(Card c) {
		my_hand[card_count] = c;
		card_count = card_count + 1;
	}

	/* 플레이어의 손에 있는 카드 배열을 표시 */
	public Card[] showCards() {
		Card[] answer = new Card[card_count];
		for (int i = 0; i != card_count; i++) {
			answer[i] = my_hand[i];
		}
		return answer;
	}
}