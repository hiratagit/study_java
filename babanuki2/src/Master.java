import java.util.ArrayList;
public class Master {

	private ArrayList<Player> players = new ArrayList<Player>();

	public void prepareGame(Hand cards) {
		System.out.println("【カードを配ります】");

		cards.shuffle();

		int numberOfCards = cards.getNumberOfCards();
		int numberOfPlayers = this.players.size();

		for(int index = 0; index < numberOfCards; index++) {
			Card card = cards.pickCard();
			Player player = (Player) this.players.get(index % numberOfPlayers);
			player.receiveCard(card);
		}
	}

	public void startGame() {
		System.out.println("\n 【ばば抜きをします】");

		for(int count = 0; this.players.size() > 1; count ++) {
			int playerIndex = count % this.players.size();
			int nextPlayerIndex = (count + 1) % this.players.size();

			Player player = (Player) this.players.get(playerIndex);
			Player nextPlayer = (Player) this.players.get(nextPlayerIndex);

			System.out.println("\n" + player + "さんの番です");
			player.play(nextPlayer);
		}

		System.out.println("【ばば抜きを終了しました】");
	}

	public void declareWin(Player winner) {

		System.out.println(winner + "さんが上がりました！");

		this.players.remove(this.players.indexOf(winner));

		if(this.players.size() == 1) {
			Player loser = (Player) this.players.get(0);
			System.out.println(loser + "さんの負けです");
		}
	}

	public void registerPlayer(Player player) {
		this.players.add(player);
	}
}