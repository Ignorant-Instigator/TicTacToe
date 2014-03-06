import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Field implements ActionListener {
	JButton buttons[] = new JButton[9];
	Logic access = new Logic();
	JFrame frame;

	void start(JFrame frm) {
		frame = frm;
		addButtons();
	}

	void clearUp() {
		for (JButton tmp : buttons) {
			tmp.addActionListener(this);
			tmp.setIcon(new ImageIcon("D:/pics/empty.png"));
		}
	}

	void setUpButton(JButton btn) {
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		btn.setFocusPainted(false);
		btn.setBorder(new EmptyBorder(0, 0, 0, 0));
		btn.addActionListener(this);
		frame.add(btn);
	}

	void addButtons() {
		for (int a = 0; a < buttons.length; a++) {
			buttons[a] = new JButton(new ImageIcon("D:/pics/empty.png"));
			buttons[a].setActionCommand("" + a);
			setUpButton(buttons[a]);
		}

	}

	void makeMove(int index) {
		buttons[index].setIcon(new ImageIcon(access.currentFigure()));
		buttons[index].removeActionListener(this);
		access.replaceCoordinate(index);
	}

	void hideField() {
		for (int a = 0; a < buttons.length; a++) {
			buttons[a].setVisible(false);
		}
	}

	public void actionPerformed(ActionEvent ae) {
		int index = Integer.parseInt(ae.getActionCommand());
		makeMove(index);
		if (!access.winningConditions()) {
			for (int a = 0; a < buttons.length; a++) {
				buttons[a].removeActionListener(this);
			}
			hideField();
			MessageBox qw = new MessageBox(frame);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			clearUp();
			access.clearUp();

		}

	}
}
