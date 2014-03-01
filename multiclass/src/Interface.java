import java.awt.*;
import javax.swing.*;

public class Interface {
	Field show;
	Menu open = new Menu();
	JFrame frame;
	JLabel bground;

	Interface() {
		setUpFrame();
		open.start(frame);

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
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Interface();
			}
		});

	}

}
