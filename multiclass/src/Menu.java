import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Menu implements ActionListener {
	Field field = new Field();
	JFrame frame;
	JButton modeBtn[] = new JButton[3];

	void start(JFrame frm) {
		frame = frm;
		addButtons();
	}

	void addButtons() {
		for (int a = 0; a < modeBtn.length; a++) {
			modeBtn[a] = new JButton(
					new ImageIcon("D:/pics/menu/" + a + ".png"));
			modeBtn[a].setActionCommand("" + a);
			setButtons(modeBtn[a]);
		}
	}

	void hideButtons() {
		for (int a = 0; a < modeBtn.length; a++) {
			modeBtn[a].setVisible(false);
		}
	}

	void setButtons(JButton btn) {
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		btn.setFocusPainted(false);
		btn.setBorder(new EmptyBorder(0, 0, 0, 0));
		btn.addActionListener(this);
		frame.add(btn);
	}

	public void actionPerformed(ActionEvent ae) {
		String tmp = ae.getActionCommand();
		if (tmp.equals("0")) {
			hideButtons();
			field.start(frame);
		}
	}
}