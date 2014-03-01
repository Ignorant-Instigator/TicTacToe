import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Field implements ActionListener {
	JFrame frame;
	JButton buttons[] = new JButton[9];
	JLabel bground;
	Logic access = new Logic();

	Field() {
		setUpFrame();
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

	void setUpFrame() {
		frame = new JFrame("TicTacToe");
		frame.setSize(252, 273);
		frame.setLayout(new BorderLayout());
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bground = new JLabel(new ImageIcon("D:/pics/bg.png"));
		frame.setContentPane(new JLabel(new ImageIcon("D:/pics/bgb.png")));
		frame.setLayout(new FlowLayout());
		addButtons();
		frame.setVisible(true);
	}

	void addButtons() {
		for (int a = 0; a < buttons.length; a++) {
			buttons[a] = new JButton(new ImageIcon("D:/pics/empty.png"));
			buttons[a].setActionCommand("" + a);
			setUpButton(buttons[a]);
		}
	}

	public void actionPerformed(ActionEvent ae) {
		if (!ae.getActionCommand().equals("begin")) {
			String tmp = ae.getActionCommand();
			int index = Integer.parseInt(tmp);
			buttons[index].setIcon(new ImageIcon(access.currentFigure()));
			buttons[index].removeActionListener(this);
			access.replaceCoordinate(index);
			if (!access.winningConditions()) {
				for (int a = 0; a < buttons.length; a++) {
					buttons[a].removeActionListener(this);
				}
				JOptionPane.showMessageDialog(frame, access.winnerMsg()
						+ " Wait 3 sec to play again");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				clearUp();
				access.clearUp();
			}
		} else
			setUpFrame();
	}
}
