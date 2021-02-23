/**
 *
 */

/**
 * @author dzdq8
 *
 */
public class ObjectJanken {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		Player h = new Player("ポン助");
		Player s = new Player("パー子");


		Tactics m = new CyclicTactics();
		h.setTacics(m);

		Tactics n = new RandomTactics();
		s.setTacics(n);

		Judge saito = new Judge();

		saito.startJanken(h, s);

	}

}