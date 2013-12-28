import java.io.IOException;

class TicTacToe {
	char field[][] = { { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' } };
	char figure;
	int isMove = 1;

	void launch() throws java.io.IOException {
		showField();
		while (winningConditions()) {
			currentFigure();
			input();
			showField();
		}
		clearUp();
	}

	void showField() {
		for (int a = 0; a < field.length; a++)
			for (int b = 0; b < field[0].length; b++) {
				System.out.print(field[a][b] + "|");
				if (b == 2)
					System.out.println(" ");
			}
	}

	void clearUp() {
		char letter = 'a';
		for (int a = 0; a < field.length; a++)
			for (int b = 0; b < field[0].length; b++) {
				field[a][b] = letter;
				letter++;
			}
		isMove = 1;
	}

	void currentFigure() {
		if (isMove % 2 == 0)
			figure = 'o';
		else
			figure = 'x';
		isMove++;
	}

	void input() throws IOException {
		char input, ignore;
		boolean forbidden = true;
		do {
			input = (char) System.in.read();
			do {
				ignore = (char) System.in.read();
			} while (ignore != '\n');
			for (char a[] : field)
				for (char b : a)
					if (b == input)
						forbidden = false;
			if (input < 'a' || input > 'i' || forbidden)
				System.out.println("Wrong coordinate!");
		} while (input < 'a' || input > 'i' || forbidden);
		replaceCoordinate(input);
	}

	void replaceCoordinate(char input) throws IOException {
		for (int a = 0; a < field.length; a++)
			for (int b = 0; b < field[0].length; b++) {
				if (field[a][b] == input) {
					field[a][b] = figure;
				}
			}
	}

	boolean winningConditions() {
		boolean gameLasts = true;
		int counter = 0;
		for (int a = 0; a < field.length; a++) {
			for (int b = 0; b < field[0].length; b++) {
				if (field[a][b] == figure)
					counter++;
				if (counter == 3) {
					System.out.println(figure + " have won!");
					return false;
				}
			}
			counter = 0;
		}
		for (int a = 0; a < field[0].length; a++) {
			for (int b = 0; b < field.length; b++) {
				if (field[b][a] == figure)
					counter++;
				if (counter == 3) {
					System.out.println(figure + " have won!");
					return false;
				}
			}
			counter = 0;
		}
		for (int a = field[0].length - 1; a >= 0; a--) {
			if (field[a][field[0].length - a - 1] == figure)
				counter++;
			if (counter == 3) {
				System.out.println(figure + " have won!");
				return false;
			}
		}
		counter = 0;
		for (int a = 0; a < field.length; a++) {
			if (field[a][a] == figure)
				counter++;
			if (counter == 3) {
				System.out.println(figure + " have won!");
				return false;
			}
		}
		counter = 0;
		for (char a[] : field)
			for (char b : a) {
				if (b == 'x' || b == 'o')
					counter++;
				if (counter == 9) {
					System.out.println("Draw!");
					return false;
				}
			}
		return gameLasts;
	}
}
