import java.io.IOException;

public class Game {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		WithComputer onePlayer = new WithComputer();
		TicTacToe twoPlayers = new TicTacToe();
		char choise, ignore;
		do {
			System.out.println("One or Two players?");
			do {
				choise = (char) System.in.read();
				do {
					ignore = (char) System.in.read();
				} while (ignore != '\n');
				if (choise < '1' || choise > '3')
					System.out.println("One or Two?");
			} while (choise < '1' || choise > '3');
			switch (choise) {
			case '1':
				onePlayer.launch();
				break;
			case '2':
				twoPlayers.launch();
				break;
			case '3':
				System.out.println("Let's play again sometime.");
			}
		} while (choise != '3');
	}
}