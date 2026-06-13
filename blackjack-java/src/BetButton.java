package Happy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class BetButton implements ActionListener {
	private BetFrame f;

	public BetButton(BetFrame f) {
		this.f = f;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			int betAmount = Integer.parseInt(BetFrame.betAmountField.getText());
			// 배팅 성공한 경우
			if (BetFrame.betSuccess(betAmount)) {
				JOptionPane.showMessageDialog(f.getBetFrame(), "Betting success!");
				f.dispose();
				new GameFrame(betAmount);
			} else { // 배팅 실패한 경우
				JOptionPane.showMessageDialog(f.getBetFrame(), "Invalid bet amount. Please enter a valid number.");
			}
		} catch (NumberFormatException ex) { // 다른 타입의 것을 입력받아 오류가 발생할 때를 대비한 예외처리
			JOptionPane.showMessageDialog(f.getBetFrame(), "Invalid bet amount. Please enter a valid number.");
		}
	}

}
