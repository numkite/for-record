package Happy;

import java.util.Random;

public class Card {
	public static final String SPADES = "spades";
	public static final String HEARTS = "hearts";
	public static final String DIAMONDS = "diamonds";
	public static final String CLUBS = "clubs";

	public static final int SIZE_OF_ONE_SUIT = 13;

	public static final int ACE = 1;
	public static final int JACK = 10;
	public static final int QUEEN = 10;
	public static final int KING = 10;

	/* 카드 모양 */
	private String suit;

	/* 카드의 값 */
	private int count;

	/* 생성자 */
	public Card(String s, int c) {
		suit = s;
		count = c;
	}

	/* 카드 모양을 반환 */
	public String getSuit() {
		return suit;
	}

	/* 카드의 값이 10일때 카드 모양을 반환하는 메소드 */
	/* 값이 10일 때 Jack, Queen, King 중 무작위로 모양을 선택 */
	public String getCountAsString() {
		if (count == JACK || count == QUEEN || count == KING) {
			Random random = new Random();
			int randomNumber = random.nextInt(3);

			switch (randomNumber) {
			case 0:
				return "Jack";
			case 1:
				return "Queen";
			case 2:
				return "King";
			default:
				return "Jack"; /* 무작위 선택이 실패하면 기본값은 Jack */
			}
		} else
			return String.valueOf(count);
	}

	/* 카드의 값을 반환 */
	public int getCount() {
		return count;
	}
}
