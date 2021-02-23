
public class CyclicTactics implements Tactics{

	private static int count = 0;

	public CyclicTactics() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public int readTactics() {

		int hand = 0;

		int cycleNum = count % 3;

		if(cycleNum == 0) {
			hand = Player.STONE;
		}else if(cycleNum == 1) {
			hand = Player.SCISSOR;
		}else if(cycleNum == 2) {
			hand = Player.PAPPER;
		}

		count ++;

		return hand;
	}
}
