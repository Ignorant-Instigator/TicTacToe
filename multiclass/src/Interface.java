import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class Interface implements ActionListener {
	Field show = new Field();
	Interface() {

	}

	public void actionPerformed(ActionEvent ae) {

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Interface();
			}
		});

	}

}
