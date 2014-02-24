class Logic {
	char used[] = new char[9];
	char figure;
	int isMove = 1;

	String currentFigure() {
		String path = "";
		if (isMove % 2 == 0) {
			path = "D:/pics/o.png";
			figure = 'o';
		} else {
			path = "D:/pics/x.png";
			figure = 'x';
		}
		isMove++;
		return path;
	}

	void replaceCoordinate(int index) {
		used[index] = figure;
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
