
public class RandomTactics implements Tactics {

	public int readTactics() {

		int hand = 0;
		double random = Math.random() * 3;

		if(random < 1) {
			hand = Player.STONE;
		}else if(random < 2) {
			hand = Player.SCISSOR;
		}else if (random < 3) {
			hand = Player.PAPPER;
		}

		return hand;
	}
}
