public class ArtificialPlayer {
	Logic getInfo = new Logic();

	void takeMove() {
		int index;
		do {
			index = ((int) Math.random() * 9);
		} while (!getInfo.availableMove(index));
		System.out.println(index);
		getInfo.replaceCoordinate(index);
	}
}
