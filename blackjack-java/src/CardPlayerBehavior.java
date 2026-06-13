package Happy;

/* 카드 플레이어의 예상되는 동작을 정의하는 인터페이스 */
public interface CardPlayerBehavior {

	/* 플레이어가 카드를 원하는지 여부를 물어봄 */
	public boolean wantsACard();

	/* 카드 c를 받아 플레이어의 손에 추가 */
	public void receiveCard(Card c);
}