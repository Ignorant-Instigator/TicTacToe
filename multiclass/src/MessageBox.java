import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MessageBox implements ActionListener {
	JFrame frame;
	JButton back, again;
	Logic tmp = new Logic();
	JLabel msg;

	MessageBox(JFrame frm) {
		frame = frm;
		frm.setLayout(new FlowLayout());
		back = new JButton(new ImageIcon("D:/pics/back.png"));
		again = new JButton(new ImageIcon("D:/pics/again.png"));
		msg = new JLabel(tmp.winnerMsg());
		frame.add(msg);
		setUpButton(back);
		setUpButton(again);
		back.setActionCommand("back");
		again.setActionCommand("again");
	}

	void setUpButton(JButton btn) {
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		btn.setFocusPainted(false);
		btn.setBorder(new EmptyBorder(0, 0, 0, 0));
		btn.addActionListener(this);
		frame.add(btn);
	}

	void showBox() {
		back.setVisible(true);
		again.setVisible(true);
	}

	void hideBox() {
		back.setVisible(false);
		again.setVisible(false);
		msg.setVisible(false);
	}

	public void actionPerformed(ActionEvent ae) {
		Menu one = new Menu();
		Field two = new Field();
		String tmp = ae.getActionCommand();
		if (tmp.equals("back")) {
			hideBox();
			one.start(frame);
		}
		if (tmp.equals("again")) {
			hideBox();
			two.start(frame);
		}
	}
}
