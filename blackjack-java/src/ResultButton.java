package Happy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* ResultFrame 버튼 기능 */
public class ResultButton implements ActionListener {
	private ResultFrame b;

	public ResultButton(ResultFrame b) {
		this.b = b;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b.getButtonMore()) {
			b.dispose(); // 현재 창 닫기
			new BetFrame();
		}

		else if (e.getSource() == b.getButtonExit()) {
			System.exit(0);
		}
	}
}
