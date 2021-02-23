import java.util.ArrayList;
public class Master {

	private ArrayList<Player> players = new ArrayList<>();


	public void prepareGame(Hand cards) {

		System.out.println("【カードを配ります】");

		cards.shuffle();

		int numberOfCards = cards.getNumberOfCards();

		int numberOfPlayers = this.players.size();

		for(int index = 0; index < numberOfCards; index++) {

			//カードから一枚引く
			Card card = cards.pickCard();
			//各プレイヤーに順番にカードを配る
			Player player = (Player) this.players.get(index % numberOfPlayers);
			player.receiveCard(card);
		}
	}

	/*
	 * ゲームを開始する
	 */
	public void startGame() {

		System.out.println("\n 【ばば抜きを開始します】");

		for(int count = 0; this.players.size() > 1; count++) {

			int playerIndex = count % this.players.size();
			int nextPlayerIndex = (count + 1) % this.players.size();

			//指名するプレイヤーの取得
			Player player = (Player) this.players.get(playerIndex);
			//次のプレイヤーの取得
			Player nextPlayer = (Player) this.players.get(nextPlayerIndex);

			//プレイヤーを指名する
			System.out.println("\n" + player + "さんの番です");
			player.play(nextPlayer);
		}

		//プレイヤーが上がって残り１名になるとループを抜ける

		System.out.println("\n【ばば抜きを終了しました】");

	}

	/*
	 * 上がりを宣言する
	 * @param winner 上がったプレイヤー
	 */
	public void declareWin(Player winner) {
		System.out.println(winner + "さんが上がりました！");

		//上がったプレイヤーをリストから外す
		this.players.remove(this.players.indexOf(winner));

		if(this.players.size() == 1) {
			Player loser = (Player) this.players.get(0);
			System.out.println("");
			System.out.println(loser + "さんの負けです");
		}
	}

	/*
	 * ゲームに参加するプレイヤーを登録する
	 */
	public void registerPlayer(Player player) {
		this.players.add(player);
	}
}