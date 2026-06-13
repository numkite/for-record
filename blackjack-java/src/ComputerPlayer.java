package Happy;

public class ComputerPlayer extends CardPlayer { // CardPlayer의 자식 클래스

	/* 생성자 */
	public ComputerPlayer(int max_cards) {
		super(max_cards);
	}

	/* 플레이어가 카드를 원하는지 여부를 물어봄 */
	public boolean wantsACard() {
		int sum = 0;
		// 딜러의 카드 합이 17 미만의 수일 경우 딜러 추가 카드 배부
		for (int i = 0; i < card_count; i++)
			sum += my_hand[i].getCount();
		return sum < 17;
	}
}