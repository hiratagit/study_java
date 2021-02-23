public class Player {

	private Master master;
	private Table table;
	private Hand  myHand = new Hand();
	private String name;
	/*
	 * コンストラクタ
	 *
	 * @param name 名前
	 * @param master 進行役
	 * @param table テーブル
	 */
	public Player(String name, Master master, Table table) {
		this.name = name;
		this.master = master;
		this.table = table;
	}

	/*
	 * 順番を指名する
	 * @param nextPlayer 次にプレイヤー
	 */
	public void play(Player nextPlayer) {
		//次のプレイヤーから手札を出してもらう
		Hand nextHand = nextPlayer.showHand();
		//相手の手札からカードを一枚引く
		Card pickedCard = nextHand.pickCard();
		//引いた結果を表示
		System.out.println(this + ":" + nextPlayer + "さんから" + pickedCard + "を引きました");
		//引いたカードを自分の手札に加え、同じ数のカードがあったら捨てる
		dealCard(pickedCard);

		if(this.myHand.getNumberOfCards() == 0) {
			this.master.declareWin(this);
		}else {
			System.out.println(this + ":残りの手札は" + myHand + "です");
		}
	}

	/*
	 * 手札を見せる
	 * @param Hand 自分の手札
	 */
	public Hand showHand() {
		if(this.myHand.getNumberOfCards() == 1) {
			//この時点で手札が矩り１枚ならば上がりとなるので宣言する
			this.master.declareWin(this);
		}

		//見せる前にシャッフルする
		this.myHand.shuffle();
		return this.myHand;

	}

	/*
	 * カードを受け取る
	 * @param card 受け取ったカード
	 */

	public void receiveCard(Card card) {
		//引いたカードを自分の手配に加え、同じカードがあったら捨てる
		dealCard(card);
	}

	/*
	 * カードを自分の手札に加え、同じカードがあったら捨てる
	 */

	private void dealCard(Card card) {

		this.myHand.addCard(card);

		Card[] sameCards = this.myHand.findSameNumberCard();

		if(sameCards != null) {
			System.out.print(this + "：");
			this.table.disposeCard(sameCards);
		}
	}

	/*
	 * プレイヤーの名前を返す
	 */
	public String toString() {
		return this.name;
	}



























}