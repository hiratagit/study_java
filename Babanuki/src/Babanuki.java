public class Babanuki {

	public static void main(String[] args) {

		Master master = new Master();

		Table field = new Table();

		Player murata = new Player("村田", master, field);
		Player yamada = new Player("山田", master, field);
		Player saito = new Player("斎藤", master, field);

		master.registerPlayer(murata);
		master.registerPlayer(yamada);
		master.registerPlayer(saito);

		Hand trump = createTrump();

		master.prepareGame(trump);

		master.startGame();

	}

	private static Hand createTrump() {

		Hand trump = new Hand();

		for(int number = 1; number <= 13; number++) {
			trump.addCard(new Card(Card.SUIT_CLUB, number));
			trump.addCard(new Card(Card.SUIT_DIAMOND, number));
			trump.addCard(new Card(Card.SUIT_HEART, number));
			trump.addCard(new Card(Card.SUIT_SPADE,number));
		}

		trump.addCard(new Card(0, Card.JOKER));

		return trump;
	}
}