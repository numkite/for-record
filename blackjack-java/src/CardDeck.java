package Happy;

public class CardDeck {
	private Card[] deck = new Card[4 * Card.SIZE_OF_ONE_SUIT];
	private int card_count; // how many cards remain in the deck

	/* 카드덱을 생성 */
	public CardDeck() {
		createSuit(Card.SPADES);
		createSuit(Card.HEARTS);
		createSuit(Card.CLUBS);
		createSuit(Card.DIAMONDS);
	}

	/* 카드덱 한 세트 생성, 모양이랑 값 섷정 */
	/* 킹, 퀸, 잭의 값은 10으로 하기로 함, ACE의 값는 1로 하기로 함 */
	private void createSuit(String which_suit) {
		for (int i = 1; i <= Card.SIZE_OF_ONE_SUIT; i++) {
			if (i >= 11) {
				deck[card_count] = new Card(which_suit, 10);
			} else {
				deck[card_count] = new Card(which_suit, i);
				card_count = card_count + 1;
			}

		}
	}

	/* 새로운 카드를 만드는 메소든 */
	public Card newCard() {
		Card next_card = null;
		// 카드덱에 남은 카드가 한 장도 없을 경우를 대비한 예외 처리
		if (card_count == 0) {
			System.out.println("CardDeck error: no more cards");
		} else {
			int index = (int) (Math.random() * card_count); // 현재 남은 카드의 개수를 기반으로 무작위 인덱스 하나 골라서
			next_card = deck[index]; // 새 카드에 넣기
			deck[index] = deck[card_count - 1]; // 추출된 카드 자리에 덱의 마지막 카드를 이동
			card_count = card_count - 1; // 남은 카드 개수 감소
		}
		return next_card;
	}

	/* 카드덱의 현재 남은 카드 수를 확인하는 메소드 */
	/* 한 장 이상 남아있으면 true, 아니면 false */
	public boolean moreCards() {
		return (card_count > 0);
	}

}
