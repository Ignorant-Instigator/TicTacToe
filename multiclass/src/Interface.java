import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Interface implements ActionListener {
	JFrame frame;
	JButton buttons[] = new JButton[9];
	JLabel bground;

	void setUp(JButton btn) {
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		btn.setFocusPainted(false);
		btn.setBorder(new EmptyBorder(0, 0, 0, 0));
		btn.addActionListener(this);
		frame.add(btn);
	}

	void setUpFrame() {
		frame = new JFrame("Testing");
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
			setUp(buttons[a]);
		}
	}

	Interface() {
		setUpFrame();
	}

	public void actionPerformed(ActionEvent ae) {
		String tmp = ae.getActionCommand();
		System.out.println(tmp);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Interface();
			}
		});

	}
}
