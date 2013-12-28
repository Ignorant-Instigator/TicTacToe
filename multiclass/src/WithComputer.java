import java.io.IOException;

class WithComputer extends TicTacToe {
	void launch() throws IOException {
		while (winningConditions()) {
			currentFigure();
			if (figure == 'x') {
				showField();
				input();
			} else
				easy();
		}
		showField();
		clearUp();
	}

	void easy() {
		int randomPosition = (int) (Math.random() * 8);
		char coordinate = (char) ('a' + randomPosition);
		for (int a = 0; a < field.length; a++)
			for (int b = 0; b < field[0].length; b++)
				if (field[a][b] == coordinate) {
					field[a][b] = figure;
					return;
				}
		easy();
	}
}
