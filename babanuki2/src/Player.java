public class Player {

	private Master master;
	private Table table;
	private Hand myHand = new Hand();
	private String name;

	public Player(String name, Master master, Table table) {
		this.name = name;
		this.master = master;
		this.table = table;
	}

	public void play(Player nextPlayer) {

		Hand nextHand = nextPlayer.showHand();
		Card pickedCard = nextHand.pickCard();

		System.out.println(this + ":" + nextPlayer + "さんから" + pickedCard + "を引きました");
		dealCard(pickedCard);
		if(this.myHand.getNumberOfCards() == 0) {
			this.master.declareWin(this);
		} else {
			System.out.println(this + "残りの手札は" + myHand + "です");
		}
	}

	public Hand showHand() {

		if(this.myHand.getNumberOfCards() == 1) {
			this.master.declareWin(this);
		}

		this.myHand.shuffle();
		return this.myHand;
	}

	public void receiveCard(Card card) {
		dealCard(card);
	}

	private void dealCard(Card card) {
		this.myHand.addCard(card);
		Card[] sameCards = this.myHand.findSameNumberCard();

		if(sameCards != null) {
			System.out.println(this + " ");
			this.table.disposeCard(sameCards);
		}
	}

	public String toString() {
		return this.name;
	}

}